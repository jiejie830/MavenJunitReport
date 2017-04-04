package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import domain.Account;
import domain.AccountRowMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class AccountDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveAccount(Account account) {
		String sql = "insert into test.tbl_account values(?,?,?,?)";

		jdbcTemplate.update(sql, new Object[]{account.getId(),account.getName(),account.getAge(), account.getSex()});
	}

	public Account getAccountById(int id) {
		String sql = "select * from test.tbl_account where id =? " ;
		Account account = (Account)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new AccountRowMapper());
		return account;
			
	}

}
