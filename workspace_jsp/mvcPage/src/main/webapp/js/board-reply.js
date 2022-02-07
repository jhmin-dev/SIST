$(function() {
    let currentPage;
    let count;
    let rowCount;

    // 댓글 목록
    function selectData(pageNum) {

    }

    // 페이지 처리 이벤트 연결(다음 댓글 보기 버튼 클릭시 데이터 추가)

    // 댓글 등록

    // 댓글 작성 폼 초기화

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