package kr.spring.ch10.controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {
	private WebApplicationContext context;
	
	@RequestMapping("/file.do")
	public ModelAndView download() throws Exception {
		// 상대 경로를 통해서 절대 경로 구하기
		String path = context.getServletContext().getRealPath("/WEB-INF/file.txt");
		
		File downloadFile = new File(path);
		
		return new ModelAndView("download", "downloadFile", downloadFile); // view 이름, 속성명, 속성값을 생성자 인자로 전달
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext)applicationContext;
	}
}