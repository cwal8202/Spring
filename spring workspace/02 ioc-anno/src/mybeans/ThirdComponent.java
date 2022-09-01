package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Primary
public class ThirdComponent {
	private String value;
	private int name;
	
	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int name) {
		this.value = value;
		this.name = name;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(name);
	}
	
}
