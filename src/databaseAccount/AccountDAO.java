package databaseAccount;

import java.util.List;

import javax.sql.DataSource;

import databaseCard.CardDAO;
import types.Account;

public interface AccountDAO {
	public void setDataSource(DataSource ds);
	public void setCardSource(CardDAO cardDAO);
	public void create(Double balance, Integer clientid);
	public Account getAccount(Integer id);
	public List<Account> listAccounts();
	public List<Account> getAccountsOf(Integer id);
	public void delete(Integer id);
	public void update(Integer id, Double balance);
}
