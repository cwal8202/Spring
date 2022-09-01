package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	private FirstComponent need;
	
	@Autowired	// 알아서 의존성을 넣어준다.의존성 필요한 객체의 의존성을 미리 bean으로 등록했다면 
				// autowired를 넣어서 알아서 값을 찾아준다.
	public SecondComponent(FirstComponent need) {
		super();
		this.need = need;
	}

	public void setNeed(FirstComponent need) {
		this.need = need;
	}

	public void myServiceMethod() {
		System.out.println("의존성이 필요함");
		need.hello();
	}
}
