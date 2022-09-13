package kr.co.greenart.controller;

import javax.jws.HandlerChain;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//()안 - ① annotations : 해당 annotation이 붙어있는 controller에만 동작
//② : controller class 지정 ③ : 패키지 써두면 그 패키지 안 controller 만
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다. 죄송합니다. " + ex.getMessage());
		return "errorpage";
	}
	
}
