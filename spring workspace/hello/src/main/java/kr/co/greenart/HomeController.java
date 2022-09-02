package kr.co.greenart;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 컴포넌트의 다른 이름, 컨트롤러의 역할을 함
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// RequestMapping : 핸들러 역할을 하는 메소드, 핸들러 매핑시켜줌
	@RequestMapping(value = "/", method = RequestMethod.GET) // 사용자가 get방식의 요청을 주소로 보내면
	public String home(Locale locale, Model model) {	// 아래 흐름대로 흘러감, 반환값으로 문자열 반환
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // return값 = view 이름
		// view resolver에서 반환값을 보고 view가 있는지 찾아봄, 있으면 forward 시킴
	}
	
}
