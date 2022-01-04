package kr.web.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	/*
	 * [실습 문제] 전송된 두 개의 정수를 덧셈하여 결과 값을 표시하시오.
	 * [출력 예시] 5 + 6 = 11
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>덧셈 결과</title></head>");
		out.println("<body>");
		out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		out.println("</body>");
		out.println("</html>");		
		out.close();
	}
}