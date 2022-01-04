package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	// 클라이언트가 데이터 전송 방식을 post로 지정하고 데이터를 전송할 경우, 서블릿에서 doPost() 메서드를 재정의해야 메서드가 구동됨
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8"); // (get 방식과 달리) post 방식의 경우 명시적으로 인코딩 처리를 하지 않으면 한글이 깨짐
		
		String name = request.getParameter("name");
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 생성을 위해서 출력 스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Greeting</title></head>");
		out.println("<body>");
		out.println(name + "님의 방문을 환영합니다.");
		out.println("</body>");
		out.println("</html>");		
		out.close();
	}
}