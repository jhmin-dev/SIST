package kr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.action.DeleteAction;
import kr.board.action.DetailAction;
import kr.board.action.ListAction;
import kr.board.action.UpdateAction;
import kr.board.action.WriteAction;

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
		
		Action com = null;
		String view = null;
		
		// 요청 URI 반환; /mvcMain/list.do 형식
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath())==0) { // URI가 Context Path로 시작하면
			command = command.substring(request.getContextPath().length()); // URI에서 Context Path 이후의 문자열을 추출
		}
		
		if(command.equals("/list.do")) {
			com = new ListAction();	
		}
		else if(command.equals("/write.do")) {
			com = new WriteAction();
		}
		else if(command.equals("/detail.do")) {
			com = new DetailAction();
		}
		else if(command.equals("/update.do")) {
			com = new UpdateAction();
		}
		else if(command.equals("/delete.do")) {
			com = new DeleteAction();
		}
		
		try {
			// 모델 클래스의 execute() 메서드를 호출하고 JSP 경로를 반환받음
			view = com.execute(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// forward 방식으로 JSP(View) 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}