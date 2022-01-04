package kr.web.ch01;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	// HttpServlet의 doGet() 메서드를 재정의
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전송한 데이터 반환
		int dan = Integer.parseInt(request.getParameter("dan")); // getParameter() 메서드는 인자로 전달된 식별자에 대응하는 값을 문자열로 반환
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 생성을 위해서 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>구구단</title></head");
		out.println("<body>");
		out.println(dan + "단<br>");
		for(int i=1;i<=9;i++) {
			out.println(dan + " * " + i + " = " + dan * i + "<br>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}