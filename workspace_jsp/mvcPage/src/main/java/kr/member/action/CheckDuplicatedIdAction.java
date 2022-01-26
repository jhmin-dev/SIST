package kr.member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class CheckDuplicatedIdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 전송된 데이터 반환
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember(id);
		
		Map<String, String> mapAjax = new HashMap<String, String>();
		if(member==null) { // 아이디가 중복되지 않은 경우
			mapAjax.put("result", "idNotFound");
		}
		else { // 아이디가 중복된 경우
			mapAjax.put("result", "idDuplicated");
		}
		
		/*
		 * JSON 형식으로 변환하기를 원하는 문자열을 HashMap에 key와 value의 쌍으로 저장하고, 
		 * ObjectMapper의 writeValueAsString() 메서드에 Map 객체를 전달하여 
		 * 일반 문자열 데이터를 JSON 형식의 데이터로 변환 후 반환
		 */
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		// JSP 경로 반환
		return "/WEB-INF/views/common/ajax_view.jsp"; // 모델 클래스가 직접 Ajax 데이터를 전송할 수 없으므로 JSP 필요; Ajax 데이터를 전송하는 JSP의 경우, 별도의 가공을 하지 않기 때문에 여러 모델 클래스에서 공유 가능
	}

}