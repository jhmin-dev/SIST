package kr.spring.member.controller;

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
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	// 자바빈 초기화
	@ModelAttribute
	private MemberVO initCommand() {
		return new MemberVO();
	}
	
	// 회원 가입 폼 호출
	@GetMapping("/member/registerUser.do")
	public String form() {
		// Tiles 설정 반환
		return "memberRegister";
	}
	
	// 회원 가입 처리
	@PostMapping("/member/registerUser.do")
	public String submit(@Valid MemberVO memberVO, BindingResult result) {
		logger.info("<<회원 가입>> : " + memberVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		// 회원 가입
		memberService.insertMember(memberVO);
		
		return "redirect:/main/main.do";
	}
	
	// 로그인 폼
	@GetMapping("/member/login.do")
	public String formLogin() {
		// Tiles 설정 반환
		return "memberLogin";
	}
	
	// 로그인 처리
	@PostMapping("/member/login.do")
	public String submitLogin(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		logger.info("<<회원 로그인>> : " + memberVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		// id와 passwd 필드만 검증
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}
		
		// 아이디와 비밀번호 일치 여부 검증
		try {
			MemberVO member = memberService.selectCheckMember(memberVO.getId());
			boolean check = false;
			if(member!=null) { // 존재하는 아이디면
				// 비밀번호 일치 여부 검증
				check = member.isCheckedPassword(memberVO.getPasswd());
			}
			if(check) { // 인증 성공시
				// 로그인 처리
				session.setAttribute("user_num", member.getMem_num());
				session.setAttribute("user_id", member.getId());
				session.setAttribute("user_auth", member.getAuth());
				session.setAttribute("user_photo", member.getPhoto());
				
				return "redirect:/main/main.do";
			}
			// 인증 실패시
			throw new AuthCheckException();
		}
		catch(AuthCheckException e) {
			// 폼에서 보여질 메시지 생성
			result.reject("invalidIdOrPassword");
			
			// 폼 호출
			return formLogin();
		}
	}
	
	// 로그아웃
	@RequestMapping("/member/logout.do")
	public String processLogout(HttpSession session) {
		// 로그아웃 처리
		session.invalidate();
		
		return "redirect:/main/main.do";
	}
	
	// MY 페이지
	@RequestMapping("/member/myPage.do")
	public String process(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		MemberVO member = memberService.selectMember(user_num);
		
		logger.info("<<회원 상세 정보>> : " + member);
		
		model.addAttribute("member", member);
		
		// Tiles 설정 반환
		return "memberView";
	}
	
	// 회원 정보 수정 폼
	@GetMapping("/member/update.do")
	public String formUpdate(HttpSession session, Model model) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		MemberVO memberVO = memberService.selectMember(user_num);
		
		model.addAttribute("memberVO", memberVO);
		
		// Tiles 설정 반환
		return "memberModify";
	}
	
	// 회원 정보 수정 처리
	@PostMapping("/member/update.do")
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		logger.info("<<회원 정보 수정>> : " + memberVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return "memberModify";
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		memberVO.setMem_num(user_num);
		
		// 회원 정보 수정
		memberService.updateMember(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	// 비밀번호 변경 폼
	@GetMapping("/member/changePassword.do")
	public String formChangePassword() {
		// Tiles 설정 반환
		return "memberChangePassword";
	}
	
	// 비밀번호 변경 처리
	@PostMapping("/member/changePassword.do")
	public String submitChangePassword(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		logger.info("<<비밀번호 변경 처리>> : " + memberVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasFieldErrors("now_passwd") || result.hasFieldErrors("passwd")) {
			return formChangePassword();
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		memberVO.setMem_num(user_num);
		
		// 세션에 저장된 회원 번호를 이용해 회원 정보를 자바빈에 담아 반환
		MemberVO db_member = memberService.selectMember(user_num);
		// DB에서 읽어온 비밀번호와 사용자가 입력한 비밀번호가 불일치하면 폼 호출
		if(!db_member.getPasswd().equals(memberVO.getNow_passwd())) {
			result.rejectValue("now_passwd", "invalidPassword");
			return formChangePassword();
		}
		
		// 비밀번호 수정
		memberService.updatePassword(memberVO);
		
		return "redirect:/member/myPage.do";
	}
	
	// 회원 탈퇴 폼
	@GetMapping("/member/delete.do")
	public String formDelete() {
		// Tiles 설정 반환
		return "memberDelete";
	}
	
	// 회원 탈퇴 처리
	@PostMapping("/member/delete.do")
	public String submitDelete(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {
		logger.info("<<회원 탈퇴>> : " + memberVO);
		
		// 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formDelete();
		}
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		memberVO.setMem_num(user_num);
		
		// 아이디와 비밀번호 일치 여부 검증
		try {
			// 세션에 저장된 회원 번호를 이용해서 DB에 저장된 회원 정보를 자바빈에 담아 반환
			MemberVO db_member = memberService.selectMember(memberVO.getMem_num());
			boolean check = false;
			
			if(db_member!=null && memberVO.getId().equals(db_member.getId())) { // DB에서 읽어온 아이디와 사용자가 입력한 아이디가 일치하면
				// 비밀번호 일치 여부 검증
				check = db_member.isCheckedPassword(memberVO.getPasswd());
			}
			if(check) { // 인증에 성공하면
				// 회원 탈퇴
				memberService.deleteMember(memberVO.getMem_num());
				// 로그아웃
				session.invalidate();
				
				return "redirect:/main/main.do";
			}
			// 인증 실패시
			throw new AuthCheckException();
		}
		catch(AuthCheckException e) {
			result.reject("invalidIdOrPassword");
			
			return formDelete();
		}
	}
	
	// 이미지 출력
	@RequestMapping("/member/photoView.do")
	public ModelAndView viewImage(HttpSession session) {
		Integer user_num = (Integer)session.getAttribute("user_num");
		MemberVO memberVO = memberService.selectMember(user_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", memberVO.getPhoto());
		mav.addObject("filename", memberVO.getPhoto_name());
		
		return mav;
	}
}