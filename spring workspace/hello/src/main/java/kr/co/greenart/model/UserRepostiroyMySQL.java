package kr.co.greenart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserRepostiroyMySQL implements UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private UserRowMapper mapper = new UserRowMapper();
	
	private class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			return new User(id, name, age);
		}
	}
	
	@Override
	public int add(User user) {
		return jdbcTemplate.update("insert into users (name, age) values (?, ?)"
				, user.getName()
				, user.getAge());
	}

	@Override
	public List<User> list() {
		return jdbcTemplate.query("select * from users", mapper);
	}
}