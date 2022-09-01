import org.omg.CORBA.BAD_POLICY_TYPE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.FirstComponent;
import mybeans.SecondComponent;
import mybeans.ThirdComponent;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		ThirdComponent third =context.getBean(ThirdComponent.class);
		// 어노테이션으로 값 설정한게 나온다.
		third.printValue();
		
		
//		SecondComponent second = context.getBean(SecondComponent.class);
//		System.out.println(second);
//		
//		second.myServiceMethod();
//		
		
//		FirstComponent comp = context.getBean(FirstComponent.class);
//		comp.hello();
//		
//		FirstComponent byName = context.getBean("firstComp", FirstComponent.class);
//		byName.hello();
//		
//		System.out.println(comp == byName);
	}
}
