package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet {
	/*
	 * [실습 문제] 이름과 선택한 여행지를 출력
	 * [출력 예시]
	 * 이름 : 홍길동
	 * 선택한 여행지 : 서울, 뉴욕
	 * 				선택한 여행지가 없습니다! 
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>여행지 선택</title></head>");
		out.println("<body>");
		out.println("이름 : " + req.getParameter("name") + "<br>");
		out.println("선택한 여행지 : ");
		String[] cities = req.getParameterValues("city");
		if(cities!=null) {
			for(int i=0;i<cities.length;i++) {
				out.print(cities[i]);
				if(i<cities.length-1) out.print(", ");
			}
		}
		else {
			out.println("선택한 여행지가 없습니다!");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}