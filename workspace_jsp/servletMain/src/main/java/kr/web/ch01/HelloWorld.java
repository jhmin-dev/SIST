package kr.web.ch01;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

// HttpServlet 클래스를 상속시키면 클라이언트가 주소를 통해 해당 서블릿을 호출하고, 호출된 서블릿은 HTML을 생성해서 클라이언트로 전송
// @WebServlet("/helloworld") // 주소 매핑; 기본적으로는 가상 폴더 servlet 하위에 패키지명.클래스명 형식으로 HTML이 생성되는데, 이러한 기본 주소는 보안에 취약하여 Tomcat에서 호출을 허용하지 않음
// web.xml에 주소 매핑하고 @WebServlet으로 주소 매핑하면 이중으로 주소가 매핑되기 때문에 오류 발생
public class HelloWorld extends HttpServlet {
	
	// HTML을 생성하는 메서드 정의
	@Override public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Tomcat의 웹 컨테이너가 객체를 생성하여 인자로 전달
		// 문서 타입 및 캐릭터셋 지정
		response.setContentType("text/html;charset=utf-8");
		
		// HTML 출력을 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet!</title></head>");
		out.println("<body>");
		out.println("처음 작성하는 Servlet입니다.");
		out.println("</body>");
		out.println("</html>");
		out.close(); // 자원 정리
	}
}