package kr.co.greenart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("mylist") // bean으로 관리하고 싶으므로 annotation 붙이기!
public class MyListRepository implements MyDataRepository {
	@Autowired
	private List<Integer> list;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		// Iterable : 여러 개의 객체가 iterator를 통해 가져올 수 있도록 하는 것, iterator를 반환
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
		
		return list;
	}
	
}
