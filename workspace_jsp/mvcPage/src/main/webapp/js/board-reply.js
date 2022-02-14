$(function() {
	let currentPage;
	let count;
	let rowCount;

	// 댓글 목록
	function selectData(pageNum) {
		currentPage = pageNum;

		// 로딩 이미지 노출
		$('#loading').show();

		$.ajax({
			type:'post',
			data:{pageNum:pageNum,board_num:$('#board_num').val()},
			url:'listReply.do',
			dataType:'json',
			cache:false,
			timeout:3000,
			success:function(param) {
				// 로딩 이미지 감추기
				$('#loading').hide();

				count = param.count;
				rowCount = param.rowCount;

				if(pageNum==1) {
					// 처음 호출시는 해당 ID의 div 내부 내용물을 제거
					$('#output').empty();
				}

				$(param.list).each(function(index, item) {
					let output = '<div class="item">';
					output += '<h4>' + item.id + '</h4>';
					output += '<div class="sub-item">'
					output += '<p>' + item.re_content + '</p>';

					output += '<span class="modify-date">';
					if(item.re_modifydate) {
						output += '최근 수정일 : ' + item.re_modifydate;
					}
					else {
						output += '등록일 : ' + item.re_date;
					}
					output += '</span>';

					if(param.user_num == item.mem_num) { // 로그인한 회원 번호와 작성자 회원 번호 일치
						output += ' <input type="button" data-renum="' + item.re_num + '" value="수정" class="modify-btn">'; // 수정, 삭제시 re_num 값이 필요하므로 버튼에 보관
						output += ' <input type="button" data-renum="' + item.re_num + '" value="삭제" class="delete-btn">';
					}

					output += '<hr size="1" noshade width="100%">';
					output += '</div>';
					output += '</div>';

					// 문서 객체에 추가
					$('#output').append(output);
				}); // end of each

				// 다음 댓글 보기 버튼 처리
				if(currentPage>=Math.ceil(count/rowCount)) {
					// 다음 페이지가 없음
					$('.paging-button').hide();
				}
				else {
					// 다음 페이지가 존재
					$('.paging-button').show();
				}
			},
			error:function() { // JSON 형식에 맞지 않는 데이터가 전송된 경우, 서버 에러
				alert('네트워크 오류 발생!');
			}
		}); // end of ajax
	}

	// 페이지 처리 이벤트 연결(다음 댓글 보기 버튼 클릭시 데이터 추가)
	$('.paging-button input').click(function() {
		selectData(currentPage + 1);
	});

	// 댓글 등록
	$('#re_form').submit(function(event) {
		if($('#re_content').val().trim()=='') {
			alert('내용을 입력하세요!');
			$('#re_content').val('').focus();
			return false;
		}

		// <form> 태그 내 필드에 입력한 데이터를 모두 읽어옴
		let form_data = $(this).serialize();

		// 데이터 전송
		$.ajax({
			url:'writeReply.do',
			type:'post',
			data:form_data,
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param) {
				if(param.result=='logout') {
					alert('로그인해야 작성할 수 있습니다.');
				}
				else if(param.result=='success') {
					// 폼 초기화
					initForm();
					// 댓글 작성이 성공하면 새로 입력한 댓글을 포함해서 첫 번째 페이지의 댓글들을 다시 호출
					selectData(1);
				}
				else {
					alert('등록시 오류 발생!');
				}
			},
			error:function() {
				alert('네트워크 오류 발생!');
			}
		}); // end of ajax

		// 기본 이벤트 제거
		event.preventDefault();
	});

	// 댓글 작성 폼 초기화
	function initForm() {
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300')
	}

	// <textarea>에 내용 입력시 글자 수 체크
	$(document).on('keyup', 'textarea', function() { // 동적으로 생성되는 미래 태그에도 이벤트 연결하기 위해 $(document).on() 사용
		// 입력한 글자 수 구하기
		let inputLength = $(this).val().length;
		 if(inputLength>300) { // 300자 초과
			$(this).val($(this).val().substring(0, 300));
		}
		else { // 300자 이하
			let remain = 300 - inputLength;
			remain += '/300';
			if($(this).attr('id')=='re_content') { // 등록 폼 글자 수
				$('#re_first .letter-count').text(remain);
			}
			else { // 수정 폼 글자 수
				$('#mre_first .letter-count').text(remain);
			}
		}
	});

	// 댓글 수정 버튼 클릭시 수정 폼 노출
	$(document).on('click', '.modify-btn', function() {
		// 댓글 번호
		let re_num = $(this).attr('data-renum');
		// 댓글 내용
		let content = $(this).parent().find('p').html().replace(/<br>/gi, '\n'); // g: 지정 문자열 모두; i: 대소문자 무시

		// 댓글 수정 폼 UI
		let modifyUI = '<form id="mre_form">';
			modifyUI += '	<input type="hidden" name="re_num" id="mre_num" value="' + re_num + '">';
			modifyUI += '	<textarea rows="3" cols="50" name="re_content" id="mre_content" class="rep-content">' + content + '</textarea>';
			modifyUI += '	<div id="mre_first"><span class="letter-count">300/300</span></div>';
			modifyUI += '	<div id="mre-second" class="align-right">';
			modifyUI += '		<input type="submit" value="수정">';
			modifyUI += '		<input type="button" value="취소" class="re-reset">';
			modifyUI += '	</div>';
			modifyUI += '	<hr size="1" noshade width="96%">';
			modifyUI += '</form>';

		// 수정 버튼을 클릭하면 (이전에 수정 중이던) 다른 댓글의 수정 폼은 숨김; sub-item을 환원시키고 수정 폼 초기화
		initModifyForm();
		// 지금 클릭해서 수정하고자 하는 데이터(=수정 버튼을 감싸고 있는 <div> 태그) 감추기
		$(this).parent().hide();
		// 수정 폼을 수정하고자 하는 데이터가 있는 <div> 태그(=수정 버튼을 감싸고 있는 태그들 중 클래스가 item인 태그)에 노출
		$(this).parents('.item').append(modifyUI);

		// 입력한 글자 수 세팅
		let inputLength = $('#mre_content').val().length;
		let remain = 300 - inputLength;
		remain += '/300';
		// 문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
	});

	// 수정 폼에서 취소 버튼 클릭시 수정 폼 초기화
	$(document).on('click', '.re-reset', function() {
		initModifyForm();
	});

	// 댓글 수정 폼 초기화
	function initModifyForm() {
		$('.sub-item').show();
		$('#mre_form').remove(); // <form> 태그는 id가 부여되어 있으므로 삭제하지 않고 단순히 숨기기만 하면 중복 문제가 발생
	}

	// 댓글 수정
	$(document).on('submit', '#mre_form', function(event) {
		if($('#mre_content').val().trim()=='') {
			alert('내용을 입력하세요!');
			$('#re_content').val('').focus();
			return false;
		}

		// 폼에 입력한 데이터 반환
		let form_data = $(this).serialize();

		// 서버와 통신
		$.ajax({
			url:'updateReply.do',
			type:'post',
			data:form_data,
			dataType:'json',
			cache:false,
			tiemout:30000,
			success:function(param) {
				if(param.result=='logout') {
					alert('로그인해야 수정할 수 있습니다.');
				}
				else if(param.result=='success') {
					$('#mre_form').parent().find('p').html($('#mre_content').val().replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/\n/g, '<br>'));
					$('#mre_form').parent().find('.modify-date').text('최근 수정일 : 5초 미만');

					// 수정 폼 삭제 및 초기화
					initModifyForm();
				}
				else if(param.result=='wrongAccess') {
					alert('타인의 댓글을 수정할 수 없습니다.');
				}
				else {
					alert('수정시 오류 발생!');
				}
			},
			error:function() {
				alert('네트워크 오류 발생!');
			}
		}); // end of ajax

		// 기본 이벤트 제거
		event.preventDefault();
	});

	// 댓글 삭제
	$(document).on('click', '.delete-btn', function() {
		// 댓글 번호
		let re_num = $(this).attr('data-renum');

		$.ajax({
			url:'deleteReply.do',
			type:'post',
			data:{re_num:re_num},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(param) {
				if(param.result=='logout') {
					alert('로그인해야 삭제할 수 있습니다.');
				}
				else if(param.result=='success') {
					alert('삭제 완료!');
					selectData(1);
				}
				else if(param.result=='wrongAccess') {
					alert('타인의 댓글을 삭제할 수 없습니다.');
				}
				else {
					alert('삭제시 오류 발생!');
				}
			},
			error:function() {
				alert('네트워크 오류 발생!');
			}
		});
	});

	// 초기 데이터 호출
	selectData(1);
});