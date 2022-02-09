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
						output += ' <input type="button" data-renum="' + item.re_num + '" value="수정" class="modify-btn">';
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

	// 수정 폼에서 취소 버튼 클릭시 수정 폼 초기화

	// 댓글 수정 폼 초기화

	// 댓글 수정

	// 댓글 삭제

	// 초기 데이터 호출
	selectData(1);
});