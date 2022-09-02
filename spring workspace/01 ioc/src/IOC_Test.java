import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		// bean에 접근하기 위해 context 잠시 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		// 설정을 xml로 만들어서 IOC에 만들어서 보관해뒀다 달라고 할 때 주는 것, new 객체 생성 없이(개발자 관리x) 라이브러리가 객체를 관리
		
		// 같은 class의 bean이 두 개 등록되어있으면 예외를 던져줌 -> id값 이용
		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString());
		
		MyStatefulObj third = context.getBean(MyStatefulObj.class);
		System.out.println(third.toString());
		// xml에서 설정한 생성자 값이 있을 때, set을 이용해 name, number 값 설정해보기
		third.setName("new-name");
		third.setNumber(200);
		
		MyStatefulObj oneMoretime = context.getBean(MyStatefulObj.class);
		System.out.println(oneMoretime.toString());
		System.out.println(third == oneMoretime); 
		
		// context로 bean 생성
		MyLogic logic = context.getBean(MyLogic.class);
		// MyBean 의존성이 잘들어가있음
		logic.someMethod();
		
		// context로 bean 생성
		MyBean b = context.getBean(MyBean.class);
		
		// bean객체 안의 메소드 호출
		b.hello();
		
		// bean에 설정한 id 값으로 호출하기
		MyBean b2 = (MyBean) context.getBean("first"); // getBean : object형으로 줌, 다운캐스팅
//		MyBean b2 = context.getBean("first", MyBean.class); // getBean : object형으로 줌, 인자로 넘겨서 형 맞추기
		b2.hello();
		
		System.out.println(b == b2); // 참조가 같은지 여부 => true (같은 인스턴스, 참조만 여러개인 것)
	}
}
