package kr.spring.main.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonController {
	@RequestMapping("/common/imageUploader.do") // uploadAdapter.js와 통신하는 경로
	@ResponseBody
	public Map<String, Object> uploadImage(MultipartFile upload, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 업로드할 폴더 경로
		String realFolder = session.getServletContext().getRealPath("/resources/image_upload");
		
		// 업로드할 파일명
		String org_filename = upload.getOriginalFilename();
		String str_filename = System.currentTimeMillis() + org_filename; // 파일명 중복 방지
		
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		String filepath = realFolder + "\\" + user_num + "\\" + str_filename;
		
		File f = new File(filepath);
		if(!f.exists()) {
			f.mkdirs(); // mkdir()은 상위 경로가 없으면 에러, mkdirs()는 상위 경로가 없으면 경로 생성
		}
		upload.transferTo(f);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uploaded", true);
		map.put("url", request.getContextPath() + "/resources/image_upload/" + user_num + "/" + str_filename);
		
		return map;
	}
}