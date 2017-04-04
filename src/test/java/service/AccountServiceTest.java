package service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Account;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service/Spring-db1.xml")

public class AccountServiceTest {
	

	@Autowired
	private AccountService accountService;

	@Test
	public void testGetAcccountById() {
		Account acct2 = Account.getAccount(3, "user03", 18, "F");

		accountService.saveAccount(acct2);
		
		Account acct1 = accountService.getAccountById(2);
		assertEquals(acct2.getId(), acct1.getId());
	}

}
