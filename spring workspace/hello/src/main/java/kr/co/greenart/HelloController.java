package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 컨트롤러로 사용될 @Component, 기본 템플릿에서 사용하는 annotation이라 bean으로 자동 등록
// 여러 개의 servlet을 만들어서 mapping해주지 않고, 관련 있는 주소는 하나의 controller에서 mapping이 가능해짐(method의 형태로)
public class HelloController {
	// 사용자가 hello라는 주소를 요청하면, mapping을 통해서 특정한 view를 보여주도록 응답 보내기
	@RequestMapping(value = "/hello", method = RequestMethod.GET) // value값에 사용자 요청의 주소값을 mapping
	// method = 요청 방식 지정(get일 때로 지정해둔 것), {RequestMethod.GET, RequestMethod.POST}처럼 배열 형식으로 넘겨주면 여러 요청방식 처리 가능
	public String hello() {
		return "hello"; //hello값으로 주소
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET) // 위와 같은 주소로 mapping
	public String hi() {
		return "hello";
	}
}
