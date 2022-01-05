package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=UTF-8");
		
		// HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>회원 가입</title></head>");
		out.println("<body>");
		out.println("회원 가입을 축하합니다.<br>====회원 정보====</br>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("직업 : " + job + "<br>");
		
		String[] phones = request.getParameterValues("phone"); // <input> 태그 type 중 checkbox, radio는 선택하지 않으면 아예 파라미터가 전송되지 않지만(getParamterValeus() 메서드는 파라미터가 존재하지 않으면 null 반환), 그 외의 type은 입력하지 않아도 빈 문자열이 전송됨
		if(!phones[0].equals("") && !phones[1].equals("") && !phones[2].equals("")) {
			for(int i=0;i<phones.length;i++) {
				if(i>0) out.println("-");
				out.println(phones[i]);
			}
		}
		else { // 전화번호 3개 칸 중 하나라도 입력하지 않은 경우
			out.println("잘못 명시했습니다!");
		}

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}