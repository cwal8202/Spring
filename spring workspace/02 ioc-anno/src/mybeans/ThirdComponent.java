package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 프로토타입임을 상수로 지정해줌 
@Primary
public class ThirdComponent {
	private String value;
	private int num;
	
	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int num) {
		super();
		this.value = value;
		this.num = num;
	}

	public void printValue() { 
	// 파라미터에 특정값 넣고 싶으면 value annotation에 값 넣어주면 됨
		System.out.println(value);
		System.out.println(num);
	}
}
