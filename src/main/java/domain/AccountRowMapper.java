package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements  RowMapper {
	

	public Object mapRow(ResultSet set, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAge(set.getInt("age"));
		account.setId(set.getInt("id"));
		account.setName(set.getString("name"));
        return account;
	}
}
