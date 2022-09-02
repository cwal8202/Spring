package mybeans;

import org.springframework.stereotype.Component;

@Component(value = "firstComp")
// value : id값 부여 가능, value 생략 가능 그냥 "firstComp"이렇게만 써도 됨
public class FirstcComponent {
	public void hello() {
		System.out.println("어노테이션으로 Bean 설정하기 연습");
	}
}
