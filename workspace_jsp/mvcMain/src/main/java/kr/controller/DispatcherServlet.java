package kr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	// 클라이언트가 GET 방식으로 요청하건 POST 방식으로 요청하건 에러가 발생하지 않도록 doGet() 메서드와 doPost() 메서드를 모두 Override하되, 작업은 한 번만 하기 위해 별도의 메서드 requestPro()를 만들어 해당 메서드로 request와 response를 전달
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward 방식으로 JSP(View) 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/messageView.jsp");
		dispatcher.forward(request, response);
	}
}