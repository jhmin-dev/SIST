package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * [실습 문제] 전송된 국어, 영어, 수학 점수를 이용해서 총점과 평균(정수), 등급을 구하고 출력하시오.
		 * [출력 예시]
		 * 국어 : 90
		 * 영어 : 90
		 * 수학 : 90
		 * 총점 : 270
		 * 평균 : 90
		 * 등급 : A
		 */

		req.setCharacterEncoding("utf-8"); // 전송받은 데이터가 영문과 숫자로만 구성되어 있는 경우 생략 가능
		
		int korean = Integer.parseInt(req.getParameter("korean"));
		int english = Integer.parseInt(req.getParameter("english"));
		int math = Integer.parseInt(req.getParameter("math"));
		
		// 서블릿에서 만든 메서드는 다른 서블릿에서 호출할 수 없기 때문에, 재사용성을 높이기 위해 메서드를 만들고자 한다면 별도의 클래스에 만들어야 함
		int sum = korean + english + math;		
		int avg = sum / 3;
		String grade = "";
		if(avg>=90) grade = "A";
		else if(avg>=80) grade = "B";
		else if(avg>=70) grade = "C";
		else if(avg>=60) grade = "D";
		else grade = "F";
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>성적 처리 결과</title></head>");
		out.println("<body>");
		out.println("국어 : " + korean + "<br>");
		out.println("영어 : " + english + "<br>");
		out.println("수학 : " + math + "<br>");
		out.println("총점 : " + sum + "<br>");
		out.println("평균 : " + avg + "<br>");
		out.println("등급 : " + grade);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}