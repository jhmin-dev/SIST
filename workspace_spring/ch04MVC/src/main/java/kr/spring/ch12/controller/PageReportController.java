package kr.spring.ch12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageReportController {
	@RequestMapping("/pageJsonReport.do")
	@ResponseBody // @ResponseBody 어노테이션은 응답 화면을 생성
	public List<PageRank> jsonReport() { // 잭슨 라이브러리 사용시 메서드가 반환한 List나 Map, 자바빈 객체를 JSON 문자열로 변환
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/board/list.do"));
		pageRanks.add(new PageRank(2, "/board/detail.do"));
		pageRanks.add(new PageRank(3, "/board/write.do"));
		pageRanks.add(new PageRank(4, "/board/update.do"));
		
		return pageRanks;
	}
}