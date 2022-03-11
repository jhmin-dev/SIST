package kr.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;
import kr.spring.util.StringUtil;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}

	// 글 등록 폼
	@GetMapping("/board/write.do")
	public String form() {
		// Tiles 설정 반환
		return "boardWrite";
	}
	
	// 글 등록 폼에서 전송된 데이터 처리
	@PostMapping("/board/write.do")
	public String submit(@Valid BoardVO boardVO, BindingResult result, HttpSession session, HttpServletRequest request) {
		logger.info("<<게시판 글 저장>> : " + boardVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		// 작성자 회원 번호 세팅
		boardVO.setMem_num(user_num);
		// IP 주소 세팅
		boardVO.setIp(request.getRemoteAddr());
		// 글쓰기
		boardService.insertBoard(boardVO);
		
		return "redirect:/board/list.do";
	}
	
	// 게시판 글 목록
	@RequestMapping("/board/list.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam(value="keyfield", defaultValue="") String keyfield,
			@RequestParam(value="keyword", defaultValue="") String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		// 총 게시글 수 또는 검색된 게시글 수
		int count = boardService.selectRowCount(map);
		
		// 페이지 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 20, 10, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BoardVO> list = null;
		if(count>0) {
			list = boardService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardList"); // Tiles 설정명을 view명으로 지정
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	// 게시판 글 상세
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam int board_num) {
		logger.info("<<게시판 글 상세 : 글 번호 >> : " + board_num);
		
		// 해당 글의 조회수 증가
		boardService.updateHit(board_num);
		
		BoardVO board = boardService.selectBoard(board_num);
		// 타이틀 HTML 불허
		board.setTitle(StringUtil.useNoHtml(board.getTitle()));
		
		return new ModelAndView("boardView", "board", board); // Tiles 설정명, 속성명, 속성값을 저장해 반환
	}
	
	// 이미지 출력
	@RequestMapping("/board/imageView.do")
	public ModelAndView viewImage(@RequestParam int board_num) {
		BoardVO board = boardService.selectBoard(board_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", board.getUploadfile());
		mav.addObject("filename", board.getFilename());
		
		return mav;
	}
	
	// 파일 다운로드
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam int board_num) {
		BoardVO board = boardService.selectBoard(board_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile", board.getUploadfile());
		mav.addObject("filename", board.getFilename());
		
		return mav;
	}
	
	// 수정 폼
	@GetMapping("/board/update.do")
	public String formUpdate(@RequestParam int board_num, Model model) {
		BoardVO boardVO = boardService.selectBoard(board_num);
		
		model.addAttribute("boardVO", boardVO);
		
		return "boardModify";
	}
	
	// 수정 폼에서 전송된 데이터 처리
	@PostMapping("/board/update.do")
	public String submitUpdate(@Valid BoardVO boardVO, BindingResult result, HttpServletRequest request, Model model) {
		logger.info("<<글 정보 수정>> : " + boardVO);
		
		// 유효성 검증 결과에 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "boardModify";
		}
		
		// ip 세팅
		boardVO.setIp(request.getRemoteAddr());
		
		// 글 수정
		boardService.updateBoard(boardVO);
		
		// view에 표시할 메시지
		model.addAttribute("message", "글 수정 완료!");
		model.addAttribute("url", request.getContextPath() + "/board/list.do");
		
		return "common/resultView"; // JSP 반환
	}
	
	// 게시판 글 삭제
	@RequestMapping("/board/delete.do")
	public String submitDelete(@RequestParam int board_num) {
		boardService.deleteBoard(board_num);
		
		return "redirect:/board/list.do";
	}
}