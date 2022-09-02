package kr.co.greenart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("component-scan.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		
		MyService service = context.getBean(MyService.class);
		System.out.println(service.numberService());
		
		MyDataRepository repo = context.getBean("myset", MyDataRepository.class); // interface의 구현체를 찾아서 bean화하고 그 구현체를 줌 
		// 구현체가 2개 이상이면 error가 나므로 @Primary나 id값 설정해주기
		
		System.out.println(repo.getMyNumbers());
	}
}
