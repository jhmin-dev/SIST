package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	// HttpServlet의 doPost() 메서드를 재정의
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 생성을 위해 출력 스트림을 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>글쓰기 완료</title></head>");
		out.println("<body>");
		out.println("이름 : " + name + "<br>");
		out.println("제목 : " + title + "<br>");
		content = content.replaceAll("\n", "<br>"); // 전송받은 문자열의 줄바꿈을 유지한 채 출력하기
		out.println("내용 : " + content);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}