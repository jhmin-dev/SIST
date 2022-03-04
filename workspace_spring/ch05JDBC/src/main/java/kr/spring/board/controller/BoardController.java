package kr.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.validator.BoardValidator;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;

@Controller // @Controller, @Service, @Repository는 @Component가 확장된 어노테이션이라 자동 스캔 설정했을 때 별도로 @Component 어노테이션 추가할 필요 없음
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 로그 처리(로그 대상 지정)
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/*
	 * 로그 레벨
	 * FATAL : 가장 심각한 오류
	 * ERROR : 일반적인 오류
	 * WARN : 주의를 요하는 경우
	 * INFO : 런타임시 관심 있는 내용
	 * DEBUG : 시스템 흐름과 관련된 상세 정보
	 * TRACE : 가장 상세한 정보
	 */
	
	// 자바빈 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	// 글쓰기 폼 호출
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}

	// 글쓰기 폼에서 전송된 데이터 처리
	@PostMapping("/insert.do")
	public String submit(BoardVO boardVO, BindingResult result) {
		logger.info("BoardVO : " + boardVO);
		
		// 유효성 검증
		new BoardValidator().validate(boardVO, result);
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		// 글 등록
		boardService.insertBoard(boardVO);
		
		return "redirect:/list.do";
	}

	// 목록
	@RequestMapping("/list.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {		
		int count = boardService.getBoardCount();
		
		logger.info("pageNum : " + currentPage);
		logger.info("count : " + count);
		
		// 페이지 처리
		PagingUtil page = new PagingUtil(currentPage, count, 10, 10, "/list.do");
		
		List<BoardVO> list = null;
		if(count>0) {
			list = boardService.getBoardList(page.getStartCount(), page.getEndCount());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	// 상세
	@RequestMapping("/detail.do")
	public ModelAndView detail(@RequestParam int num) {
		BoardVO board = boardService.getBoard(num);
		
		return new ModelAndView("selectDetail", "board", board); // view 이름, 속성명, 속성값
	}
	
	// 수정 폼 호출
	@GetMapping("/update.do")
	public String formUpdate(@RequestParam int num, Model model) {
		BoardVO vo = boardService.getBoard(num);
		
		model.addAttribute("boardVO", vo);
		
		return "updateForm";
	}
	
	// 수정 폼에서 전송된 데이터 처리
	@PostMapping("/update.do")
	public String submitUpdate(BoardVO boardVO, BindingResult result) {
		logger.info("BoardVO : " + boardVO);
		
		// 유효성 검증
		new BoardValidator().validate(boardVO, result);
		// 유효성 검증 결과 오류가 있으면 수정 폼 호출
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		// DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.getBoard(boardVO.getNum());
		// 비밀번호 검증
		if(!db_board.getPasswd().equals(boardVO.getPasswd())) { // DB에 저장된 비밀번호와 사용자가 입력한 비밀번호가 불일치하면
			result.rejectValue("passwd", "invalidPassword");
			return "updateForm";
		}
		
		// 글 수정
		boardService.updateBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	// 삭제 폼 호출
	@GetMapping("/delete.do")
	public String formDelete(@RequestParam int num, Model model) {
		model.addAttribute("boardVO", boardService.getBoard(num));
		
		return "deleteForm";
	}
	
	// 삭제 폼에서 전송된 데이터 처리
	@PostMapping("/delete.do")
	public String submitDelete(BoardVO boardVO, BindingResult result) {
		// 유효성 검증
		new BoardValidator().validate(boardVO, result);
		// 유효성 검증 결과 비밀번호 필드에 오류가 있으면 삭제 폼 호출
		if(result.hasFieldErrors("passwd")) { // hasErrors() 메서드는 모든 필드를 검사하고, hasFieldErros() 메서드는 지정한 필드만 검사
			return "deleteForm";
		}
		
		// DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.getBoard(boardVO.getNum());
		// 비밀번호 검증
		if(!db_board.getPasswd().equals(boardVO.getPasswd())) { // DB에 저장된 비밀번호와 사용자가 입력한 비밀번호가 불일치하면
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		
		// 글 삭제
		boardService.deleteBoard(boardVO.getNum());		
		
		return "redirect:/list.do";
	}
	
}