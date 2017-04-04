package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AccountDAO;
import domain.Account;


public class AccountService {
	private static final Log log = LogFactory.getLog(AccountService.class);

	@Autowired
	private AccountDAO accountDao;

	public Account getAccountById(int id) {
		return accountDao.getAccountById(id);
	}

	@Transactional()
	public void saveAccount(Account account) {

		accountDao.saveAccount(account);
	}

	public void insertIfNotExist(Account account) {
		Account acct = accountDao.getAccountById(account.getId());
		if (acct == null) {
			log.debug("No " + account + " found,would insert it.");
			accountDao.saveAccount(account);
		}
		acct = null;
	}

}
