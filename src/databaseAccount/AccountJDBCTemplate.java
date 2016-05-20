package databaseAccount;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import databaseCard.CardDAO;
import types.Account;
import types.Card;

public class AccountJDBCTemplate implements AccountDAO{
	private DataSource dataSource;
	private CardDAO cardDAO;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Double balance, Integer clientid) {
		// TODO Auto-generated method stub
		String SQL = "insert into Accounts (balance, clientid) values (?, ?)";
	    jdbcTemplateObject.update( SQL, balance, clientid);
	    System.out.println("Created Account Balance = " + balance);
	    return;
	}

	@Override
	public Account getAccount(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Accounts where id = ?";
	    Account account = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new AccountMapper());
	    return account;
	}

	@Override
	public List<Account> listAccounts() {
		// TODO Auto-generated method stub
		String SQL = "select * from Accounts";
	    List <Account> accounts = jdbcTemplateObject.query(SQL,new AccountMapper());
	    return accounts;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Accounts where id = ?";
	    jdbcTemplateObject.update(SQL, id);
	    System.out.println("Deleted Account with ID = " + id );
	    return;
	}

	@Override
	public void update(Integer id, Double balance) {
		// TODO Auto-generated method stub
		String SQL = "update Accounts set balance = ? where id = ?";
	    jdbcTemplateObject.update(SQL, balance, id);
	    System.out.println("Updated Account with ID = " + id );
	    return;
	}
	
	@Override
	public void setCardSource(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

	@Override
	public List<Account> getAccountsOf(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Accounts where clientid = ?";
	    List <Account> accounts = jdbcTemplateObject.query(SQL,new Object[]{id},new AccountMapper());
	    
	    for (Account s : accounts){
	    	List<Card> cards = cardDAO.getCardsOf(s.getId());
		    s.setCards(cards);
	    }
	    
	    return accounts;
	}

}
