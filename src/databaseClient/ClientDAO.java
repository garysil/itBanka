package databaseClient;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import databaseAccount.AccountDAO;
import databaseHistoryLogin.HistoryLoginDAO;
import types.Client;

public interface ClientDAO {
	public void setDataSource(DataSource ds);
	public void setAccountSource(AccountDAO accountDAO);
	public void setHistoryLoginSource(HistoryLoginDAO historyLoginDAO);
	public void create(String firstname, String lastname, Date date);
	public Client getClient(Integer id);
	public Integer getLoginClient(String username);
	public String getPassword(Integer id);
	public List<Client> listClients();
	public void delete(Integer id);
	public void update(Integer id, String firstname);
}
