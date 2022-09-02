package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	@Autowired // 필드 위에 써주면 알아서 의존성 넣어줌
	// 의존성이 필요한 객체에 필요한 객체를 bean으로 등록해뒀으면 필드에 @autowired 가능
	private FirstcComponent need;
	
	// @Autowired  생성자 위에 써주어서 의존성 넣어줌
	public SecondComponent(FirstcComponent need) {
		super();
		this.need = need;
	}
	// @Autowired setter 위에 써주어서 의존성 넣어줌
	public void setNeed(FirstcComponent need) {
		this.need = need;
	}

	// 메소드에 붙이면 먼저 실행되므로 x -> 필드, 생성자, setter에 @Autowired 설정
	public void myServiceMethod() {
		System.out.println("의존성이 필요함.");
		need.hello();
	}
}
