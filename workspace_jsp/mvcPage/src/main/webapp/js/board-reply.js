$(function() {
	let currentPage;
	let count;
	let rowCount;

	// 댓글 목록
	function selectData(pageNum) {

	}

	// 페이지 처리 이벤트 연결(다음 댓글 보기 버튼 클릭시 데이터 추가)

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