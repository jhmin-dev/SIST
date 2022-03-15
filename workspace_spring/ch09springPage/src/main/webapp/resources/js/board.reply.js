$(function() {
	let currentPage;
	let count;
	let rowCount;
	
	// 댓글 목록
	function selectData(pageNum, board_num) {
		currentPage = pageNum;

		// 로딩 이미지 노출
		$('#loading').show();

		$.ajax({
			url:'listReply.do',
			type:'post',
			data:{pageNum:pageNum, board_num:board_num},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param) {
				// 로딩 이미지 감추기
				$('#loading').hide();

				count = param.count;
				rowCount = param.rowCount;

				if(pageNum==1) { // 처음 호출시에는 해당 ID의 div 내용물 제거
					$('#output').empty();
				}

				// 댓글 목록 작업
				$(param.list).each(function(index, item) {
					let output = '<div class="item">';
					output += '<h4>' + item.id + '</h4>';
					output += '<div class="sub-item">';
					output += '<p>' + item.re_content.replace(/\r\n/g, '<br>') + '</p>';

					if(item.re_mdate) {
						output += '<span class="modify-date">최근 수정일 : ' + item.re_mdate + '</span>';
					}
					else {
						output += '<span class="modify-date">등록일 : ' + item.re_date + '</span>'
					}

					if(param.user_num==item.mem_num) {
						output += '	<input type="button" data-num="' + item.re_num + '" value="수정" class="modify-btn">';
						output += '	<input type="button" data-num="' + item.re_num + '" value="삭제" class="delete-btn">';
					}

					output += '<hr size="1" noshade>';
					output += '</div>'
					output += '</div>'

					// 문서 객체에 추가
					$('#output').append(output);
				}); // end of each

				// paging button 처리
				if(currentPage>=Math.ceil(count/rowCount)) { // 다음 페이지가 없음
					$('.paging-button').hide();
				}
				else { // 다음 페이지가 존재
					$('.paging-button').show();
				}
			},
			error:function() {
				// 로딩 이미지 감추기
				$('#loading').hide();

				alert('네트워크 오류 발생!');
			}
		}); // end of ajax
	} // end of selectData

	// 다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging-button input').click(function() {
		let pageNum = currentPage+1;
		selectData(pageNum, $('#board_num').val());
	})

	// 댓글 등록
	$('#re_form').submit(function(event) {
		if($('#re_content').val().trim()=='') {
			alert('내용을 입력하세요!');
			$('#re_content').val('').focus();
			return false;
		}

		// 폼에 입력한 데이터 반환
		let data = $(this).serialize();

		// 데이터 전송
		$.ajax({
			url:'writeReply.do',
			type:'post',
			data:data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param) {
				if(param.result=='logout') {
					alert('로그인해야 작성할 수 있습니다!');
				}
				else if(param.result=='success') {
					// 폼 초기화
					initForm();
					// 댓글 작성이 성공하면 새로 삽입한 댓글을 포함해서 첫 번째 페이지의 댓글을 다시 호출
					selectData(1, $('#board_num').val());
				}
				else {
					alert('댓글 등록시 오류 발생!');
				}
			},
			error:function() {
				alert('네트워크 오류 발생!');
			}
		}); // end of ajax

		// 기본 이벤트 제거
		event.preventDefault();
	}); // end of submit

	// 댓글 작성 폼 초기화
	function initForm() {
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300');
	} // end of initForm

	// textarea에 내용 입력시 글자 수 체크
	$(document).on('keyup', 'textarea', function() {
		// 남은 글자 수 구하기
		let inputLength = $(this).val().length;

		if(inputLength>300) { // 300자를 초과한 경우
			$(this).val($(this).val().substring(0, 300));
		}
		else { // 300자 이하인 경우
			let remain = 300 - inputLength;
			remain += '/300';
			if($(this).attr('id')=='re_content') { // 등록 폼인 경우
				$('#re_first .letter-count').text(remain);
			}
			else { // 수정 폼인 경우
				$('#mre_first .letter-count').text(remain);
			}
		}
	}); // end of on

	// 댓글 수정 버튼 클릭시 수정 폼 노출
	$(document).on('click', '.modify-btn', function() {
		// 댓글 글 번호
		let re_num = $(this).attr('data-num');
		// 댓글 내용
		let content = $(this).parent().find('p').html().replace(/<br>/gi, '\r\n');
		// 댓글 수정 폼 UI
		let modifyUI = '<form id="mre_form">';
		modifyUI += '<input type="hidden" name="re_num" id="mre_num" value="' + re_num + '">';
		modifyUI += '<textarea rows="3" cols="50" name="re_content" id="mre_content" class="rep-content">' + content + '</textarea>';
		modifyUI += '<div id="mre_first"><span class="letter-count">300/300</span></div>';
		modifyUI += '<div id="mre_second" class="align-right">';
		modifyUI += '<input type="submit" value="수정">';
		modifyUI += '<input type="button" value="취소" class="re-reset">';
		modifyUI += '</div>';
		modifyUI += '<hr size="1" width="96%" noshade>';
		modifyUI += '</form>';

		// 이전에 이미 수정 중인 댓글이 있을 경우 수정 버튼을 클릭하면 숨겨둔 sub-item을 노출시키고 수정 폼을 초기화
		initModifyForm();

		// 지금 클릭해서 수정하려는 데이터는 감추기
		$(this).parent().hide(); // 수정 버튼을 감싸고 있는 div

		// 수정 폼을 수정하고자 하는 데이터가 있는 div에 노출
		$(this).parents('.item').append(modifyUI);

		// 입력한 글자 수 세팅
		let inputLength = $('#mre_content').val().length;
		let remain = 300 - inputLength;
		remain += '/300';

		// 문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
	}); // end of on

	// 수정 폼에서 취소 버튼 클릭시 수정 폼 초기화
	$(document).on('click', '.re-reset', function() {
		initModifyForm();
	}); // end of on

	// 댓글 수정 폼 초기화
	function initModifyForm() {
		$('.sub-item').show();
		$('#mre_form').remove();
	}

	// 댓글 수정
	$(document).on('submit', '#mre_form', function(event) {
		if($('#mre_content').val().trim()=='') {
			alert('내용을 입력하세요!');
			$('#mre_content').val('').focus();
			return false;
		}

		// 폼에 입력한 데이터 반환
		let data = $(this).serialize();

		// 데이터 전송
		$.ajax({
			url:'updateReply.do',
			type:'post',
			data:data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param) {
				if(param.result=='logout') {
					alert('로그인해야 수정할 수 있습니다!');
				}
				else if(param.result=='success') {
					// 수정 데이터 표시
					$('#mre_form').parent().find('p').html($('#mre_content').val().replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/\r\n/g, '<br>').replace(/\r/g, '<br>').replace(/\n/g, '<br>'));
					// 최근 수정일 처리
					$('#mre_form').parent().find('.modify-date').text('최근 수정일 : 5초 미만');

					// 수정 폼 초기화
					initModifyForm();
				}
				else if(param.result=='wrongAccess') {
					alert('다른 사람의 댓글은 수정할 수 없습니다!');
				}
				else {
					alert('댓글 수정시 오류 발생!');
				}
			},
			error:function() {
				alert('네트워크 오류 발생!');
			}
		}); // end of ajax

		// 기본 이벤트 제거
		event.preventDefault();
	}); // end of on

	// 댓글 삭제

	// 초기 데이터(목록) 호출
	selectData(1, $('#board_num').val());
});