import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStateFulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		MyStateFulObj fourth = context.getBean("fourth", MyStateFulObj.class);
		System.out.println(fourth.toString());
		
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		MyStateFulObj third = context.getBean(MyStateFulObj.class);
//		System.out.println(third.toString());
//		third.setName("new-name");
//		third.setNumber(200);
//		
//		MyStateFulObj oneMoretime = context.getBean(MyStateFulObj.class);
//		System.out.println(oneMoretime.toString());
//		System.out.println(third == oneMoretime);	// scope prototype설정해서 참조가 달라짐
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		MyLogic logic = context.getBean(MyLogic.class);
//		logic.someMethod();
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		MyBean b = context.getBean(MyBean.class);
//		
//		b.a = 2;
//		b.hello();
//		
//		MyBean b2 = (MyBean) context.getBean("first");
//		b2.hello();
//		System.out.println(b2.a);
//		System.out.println(b == b2);
		
	}
}
