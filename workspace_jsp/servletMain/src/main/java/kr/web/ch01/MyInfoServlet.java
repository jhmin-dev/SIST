package kr.web.ch01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/myInfo")
public class MyInfoServlet extends HttpServlet { // HttpServlet을 상속받아야 서블릿이 됨(=요청을 받아 HTML을 생성)
	// HttpServlet의 doGet() 메서드를 재정의
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "너굴";
		int age = 20;
		String job = "학생";
		String address = "서울시";
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 생성을 위해 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>개인 정보</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("직업 : " + job + "<br>");
		out.println("주소 : " + address);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}