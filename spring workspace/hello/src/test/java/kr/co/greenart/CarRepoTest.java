package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CarRepoTest {
	@Autowired
	private CarRepository repository;
	
	@Test
	public void initTest() {
		assertNotNull(repository);
	}
	
	@BeforeClass	//static 메소드로 만들어야 함. 자료에 값 없을때 먼저 값 넣어주기 위함.	실행되기 전에 먼저 실행되게 하는 어노테이션이다.
	public static void addTestData() {
	}
	
	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car();
		car.setModel("새모델" + r.nextInt(10000));
		car.setPrice(1000);
		
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		
		System.out.println(list);
		assertNotNull(list);
	}
	
	@Test
	public void update() {
		int result = repository.update(new Car(1, "변경", 300));
		
		assertEquals(1, result);
	}
}
