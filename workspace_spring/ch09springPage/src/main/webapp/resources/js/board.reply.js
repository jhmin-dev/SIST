$(function() {
	let currentPage;
	let count;
	let rowCount;
	
	// 댓글 목록
	function selectData(pageNum, board_num) {
	
	} // end of selectData

	// 다음 댓글 보기 버튼 클릭시 데이터 추가

	// 댓글 등록
	$('#re_form').submit(function(event) {

	}); // end of submit

	// 댓글 작성 폼 초기화

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

	// 수정 폼에서 취소 버튼 클릭시 수정 폼 초기화

	// 댓글 수정 폼 초기화

	// 댓글 수정

	// 댓글 삭제

	// 초기 데이터(목록) 호출
	selectData(1, $('#board_num').val());
});