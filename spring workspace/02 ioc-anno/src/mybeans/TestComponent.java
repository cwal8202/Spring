package mybeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		
		ThirdComponent third = context.getBean(ThirdComponent.class);
		// annotaion으로 설정한 value 값 나옴
		third.printValue();
		
		SecondComponent second = context.getBean(SecondComponent.class);
		System.out.println(second);
		
		second.myServiceMethod();
		
		
		FirstcComponent comp = context.getBean(FirstcComponent.class);
		comp.hello();
		
		FirstcComponent byName = context.getBean("firstComp", FirstcComponent.class);
		byName.hello();
		
		System.out.println(comp == byName);
	}
}
