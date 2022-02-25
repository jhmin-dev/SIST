package kr.spring.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * <context:component-scan/> 태그를 추가하면 Spring은 지정한 패키지에서 @Component 어노테이션이 적용된 클래스를 검색하여 bean으로 등록
 * 자동 등록된 bean의 id는 클래스 이름의 첫 글자를 소문자로 변경하여 부여됨
 * bean의 이름을 지정하고 싶으면 @Component("home")과 같이 명시하거나, 또는 @Component @Named("home")과 같이 명시함
 */
@Component
public class HomeController {
	@Autowired
	private Camera camera;

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "HomeController [camera=" + camera + "]";
	}
}