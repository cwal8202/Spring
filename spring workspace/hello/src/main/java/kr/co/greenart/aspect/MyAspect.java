package kr.co.greenart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	// 포인트컷 작성 문법 : 접근 제한자, 리턴타입, 패키지, 클래스, 메소드(파라미터)

	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {}
	
	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repository() {}
	
	@Around("repository()")  // 전으로 하고싶으면 Around
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable {
		// 저장소 시작 전에 메소드 실행 시간 확인 하고 메소드 실행시간 얼마나 걸렸는지 확인함
		long start = System.nanoTime();
		logger.info("시작 시간: " + start);
		Object proceed = jp.proceed();
		long end = System.nanoTime();
		logger.info("종료 시간 : " + end);
		
		logger.info(jp.getSignature().getName() + "메소드의 실행시간 : " + (end - start));
		return proceed;
	}
	
	@Before("print()")
	public void printBefore() {
		
	}
	
	@After("print()")
	public void printAfter() {
		
	}
	
//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printBefore() {
//		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
//	}
//	
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printAfter() {
//		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
//	}
}
