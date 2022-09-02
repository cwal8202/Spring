import mybeans.MyBean;
import mybeans.MyLogic;

// 기존의 개발자가 객체 관리할 때
public class Main {
	public static void main(String[] args) {
		MyBean obj = new MyBean();
		obj.hello();
		
		MyLogic logic = new MyLogic(new MyBean());
		logic.someMethod();
	}
}
