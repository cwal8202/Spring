package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
	@Autowired
	private CarRepository repo;
	
	public List<Car> list() {
		return repo.getAll();
	}
	
	public Car getById(int id) {
		return repo.getById(id);
	}
	
	public int add(Car car) {
		return repo.add(car);
	}
	
	public int update(Car car) {
		return repo.update(car);
	}
	
	// 자동차 목록을 전달받아 추가
	@Transactional		// Unique 컬럼을 작성할때 예외가 발생한다
						// 이전에는 Connection 객체를 우리가 관리했다. setAutoCommit을 false로
						// 만들고 수행이 끝나면 Commit을 했지만 Spring에선 @Transactional 을 사용하면 알아서 해준다.
	public int[] bulkInsert(List<Car> list) {
//		int[] results = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			results[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list);
		return results;
	}
	
	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
}









