package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;

@Controller
public class MemberAjaxController {
	private static final Logger logger = LoggerFactory.getLogger(MemberAjaxController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam String id) {
		logger.info("<<id>> : " + id);
		
		Map<String, String> map = new HashMap<String, String>();
		
		MemberVO member = memberService.selectCheckMember(id);
		
		if(member!=null) { // 아이디가 중복된 경우
			map.put("result", "idDuplicated");
		}
		else { // 아이디가 중복되지 않은 경우
			if(!Pattern.matches("^[A-Za-z0-9]{4,12}$", id)) { // 패턴 불일치
				map.put("result", "notMatchPattern");
			}
			else { // 패턴 일치
				map.put("result", "idNotFound");
			}
		}
		
		return map;
	}
}