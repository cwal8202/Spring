package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

// mapper가 복잡해서 mapper를 안쓰고 하는 방법
@Repository	//bean 등록해서 
@Primary	// 먼저 쓸려고
public class CarRepositoryNamed implements CarRepository{
	@Autowired	//객체 의존성을 config에서 바로 줄려고
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public List<Car> getAll() {
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}
	// BeanPropertyRowMapper<Car>(Car.class))
	// column이름, 넘겨준 class랑 필드 이름이 같고 그에 해당하는 getter, setter가 존재하면
    // 알아서 setter를 불러와줌

	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id"
				, map
				, new BeanPropertyRowMapper<Car>(Car.class));
		// paramMap 자리에는 이름 가지는 map을 하나 넣는다.
		// ?대신 이름을 부여(:이름) -> 이름값을 가지는 map을 넘겨주면 됨
	    // map에서 id를 찾아서 value 넣어줌
	}

	@Override
	public int add(Car car) {
		return jdbc.update("INSERT INTO cars (model, price) VALUES (:model, price)"
				, new BeanPropertySqlParameterSource(car));
					// 알아서 map형태로 값을 넣어준다.
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("INSERT INTO cars (model,price) VALUES (:model, :price)"
				, SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price WHERE id=:id"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.update("DELETE FROM cars WHERE id=:id", map);
	}
}
