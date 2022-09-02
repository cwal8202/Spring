package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // 부가 설명을 위해 Component 이름만 변경 
public class MyService {
	@Autowired // 의존성 부여
	@Qualifier(value = "mylist") // 특정한 객체를 찾기 위한 이름 지정, @Autowired가 있는 곳에 사용 가능
	// 동일한 타입을 가진 bean객체가 두 개 이상 있을 때 객체를 찾기 위해 이름 지정하는 것이 @Qualifier
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
