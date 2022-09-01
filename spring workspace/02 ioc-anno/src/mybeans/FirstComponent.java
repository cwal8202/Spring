package mybeans;

import org.springframework.stereotype.Component;

@Component(value = "firstComp") // value= 생략가능//이 클래스를 bean으로 등록할꺼라고 표시
public class FirstComponent {
	public void hello() {
		System.out.println("어노테이션으로 Bean 설정하기 연습");
	}
}
