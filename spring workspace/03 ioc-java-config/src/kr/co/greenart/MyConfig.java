package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//xml을 삭제하고 만든 클래스
@Configuration // @Component인데 설정을 가지고 있는 component, xml에 했던 설정을 여기서 할 수 있음
@ComponentScan(value = "kr.co.greenart") // component scan해라!
public class MyConfig {
	@Bean // 메소드 형식으로 bean 등록하기
	public List<Integer> myList() {
		return new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}
	
	@Bean
	public Set<Integer> mySet() { // 메소드 이름 = bean 이름 (Bean 옆에 ()로 value 값으로도 이름 지정 가능)
		return new HashSet<>(Arrays.asList(1,2,3,4,5)); // bean 타입 = return값 타입
		// 등록하고자하는 형태의 객체 = 반환값
	}
}
