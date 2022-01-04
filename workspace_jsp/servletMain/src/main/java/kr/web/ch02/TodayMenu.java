package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todayMenu")
public class TodayMenu extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 생성을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Lunch Menu</title></head>");
		out.println("<body>");
		out.println("<h3>오늘의 점심</h3>");
		
		String[] values = request.getParameterValues("lunch"); // 체크박스의 경우 복수의 값이 전송될 수 있으므로 getParameterValues() 메서드를 이용해 배열로 반환받음
		if(values!=null) {
			for(int i=0;i<values.length;i++) {
				out.println(values[i] + "<br>");
			}
		}
		else {
			out.println("점심 메뉴를 선택하지 않았습니다. 3초 후 이전 페이지로 돌아갑니다.");
			out.println("<script type=\"text/javascript\">setTimeout(function() {history.back();}, 3000);</script>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}