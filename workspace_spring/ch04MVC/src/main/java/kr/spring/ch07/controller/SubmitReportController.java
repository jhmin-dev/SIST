package kr.spring.ch07.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch07.validator.SubmitReportValidator;
import kr.spring.ch07.vo.SubmitReportVO;

@Controller
public class SubmitReportController {
	// 파일 업로드 경로 읽기
	@Value("${file_path}")
	private String path;
	
	// 자바빈 초기화
	@ModelAttribute("report")
	public SubmitReportVO initCommand() {
		return new SubmitReportVO();
	}
	
	// 폼 호출
	@GetMapping("/report/submitReport.do")
	public String form() {
		return "report/submitReportForm";
	}
	
	// 폼에서 전송된 데이터 처리
	@PostMapping("/report/submitReport.do")
	public String submit(@ModelAttribute("report") SubmitReportVO vo, BindingResult result) throws IllegalStateException, IOException {
		// 전송된 데이터 유효성 검증
		new SubmitReportValidator().validate(vo, result);
		// 전송된 데이터 유효성 검증 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		// 전송된 파일을 업로드 경로에 저장
		File file = new File(path + "/" + vo.getReportFile().getOriginalFilename()); // 업로드할 경로 정보를 담은 File 객체 생성
		vo.getReportFile().transferTo(file); // File 객체가 지시하는 경로에 전송된 파일을 저장; transferTo() 메서드는 에러가 발생할 수 있어 transferTo()가 실행되는 메서드의 선언부에 throws를 추가하거나 또는 transferTo()를 try~catch문으로 감싸야 함
		
		System.out.println("주제 : " + vo.getSubject());
		System.out.println("업로드한 파일 : " + vo.getReportFile().getOriginalFilename());
		System.out.println("파일 크기 : " + vo.getReportFile().getSize());
		
		return "report/submittedReport";
	}
}