package databaseClient;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import databaseAccount.AccountDAO;
import databaseCard.CardDAO;
import databaseHistoryLogin.HistoryLoginDAO;
import types.Account;
import types.Card;
import types.Client;

public class ClientJDBCTemplate implements ClientDAO{
	private DataSource dataSource;
	private AccountDAO accountDAO;
	private HistoryLoginDAO historyLoginDAO;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(ds);
	}
	
	@Override
	public void create(String firstname, String lastname, Date date) {
		String SQL = "insert into Client (firstname, lastname, dateofbirth) values (?, ?, ?)";
	    jdbcTemplateObject.update( SQL, firstname, lastname, date);
	    System.out.println("Created Record Name = " + firstname + " " + lastname + " Dob = " + date);
	    return;
	}

	@Override
	public Client getClient(Integer id) {
		String SQL = "select * from Client inner join Client_login on Client.id=client_login.clientid where id = ?";
	    Client client = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new ClientMapper());
	    
	    List<Account> accounts = accountDAO.getAccountsOf(id);
	    client.setAccounts(accounts);
	    
	    return client;
	}

	@Override
	public List<Client> listClients() {
		String SQL = "select * from Client inner join Client on Client.id=client_login.clientid";
	    List <Client> clients = jdbcTemplateObject.query(SQL,new ClientMapper());
	    return clients;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Client inner join Client on Client.id=client_login.clientid where id = ?";
	    jdbcTemplateObject.update(SQL, id);
	    System.out.println("Deleted Record with ID = " + id );
	    return;
	}

	@Override
	public void update(Integer id, String firstname) {
		String SQL = "update Client set firstname = ? where id = ?";
	    jdbcTemplateObject.update(SQL, firstname, id);
	    System.out.println("Updated Record with ID = " + id );
	    return;
	}

	@Override
	public Integer getLoginClient(String username) {
		String SQL = "select * from Client_login inner join Client on Client.id=client_login.clientid where username = ?";
		Client client;
		try{
			client = jdbcTemplateObject.queryForObject(SQL,new Object[]{username}, new ClientMapper());
		}
		catch (EmptyResultDataAccessException e) {
			return 0;
		}	
	    return client.getId();
	}

	@Override
	public void setAccountSource(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@Override
	public void setHistoryLoginSource(HistoryLoginDAO historyLoginDAO) {
		this.historyLoginDAO = historyLoginDAO;
	}
	
	@Override
	public String getPassword(Integer id) {
		String SQL = "select * from Client_login inner join Client on Client.id=client_login.clientid where client.id = ?";
		Client client = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new ClientMapper());
		return client.getPassword();
	}

	

}
