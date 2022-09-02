package kr.co.greenart;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger  = LoggerFactory.getLogger(RequestHandling.class);
	
//	@RequestMapping(value="/req", method=RequestMethod.GET)
//	public String req(HttpServletRequest request) { // 요청값을 파라미터로 받아옴, 필요로 하는 값을 파라미터로 담으면 dispatcher servlet이  값을 담아줌
//		// 요청을 처리한다면, 뭘 요청했는지를 알아야함 -> servlet에서 뭘 요청했는지 알려면 HttpServletRequest 요청에 담긴 값 확인
//		String param = request.getParameter("param");
//		// http://localhost:8080/greenart/req?param=vvv 이렇게 치면 콘솔에 vvv까지 출력
//		String param2 = request.getParameter("param2");
//		
//		logger.info(param);
//		
//		return "뷰이름"; // view 이름을 return
//	}
	
	@RequestMapping(value="/req", method=RequestMethod.GET)
	public String req(@RequestParam int param, @RequestParam int param2, Model model) { // String 값을 바로 int화
		// @RequestParam : 사용자 요청에 해당 이름을 가지는 parameter값이 있으면 자동으로 값을 넣어주고, type도 써놓은대로 casting 해줌 -> parameter 매핑
		// @RequestParam() int param 이렇게 쓰면 ()은 파라미터명, int 뒤는 메소드에서 쓸 파라미터 이름
		// Model : attribute 값들을 가지고 있는 하나의 map, attribute와 관련된 행동을 이 객체로 처리할 수 있음
		
		logger.info(String.valueOf(param + param2));
		model.addAttribute("result", param + param2); // attribute 추가
		
		return "plusresult"; // view 이름을 return
	}
}
