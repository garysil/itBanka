package databaseHistoryLogin;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import types.HistoryLogin;

public class HistoryLoginJDBCTemplate implements HistoryLoginDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(Integer clientId, String date) {
		String SQL = "insert into history_login (clientid, date) values (?, ?)";
	    jdbcTemplateObject.update( SQL, clientId, date);
	    System.out.println("Created History_login ID = " + clientId + "  Date = " + date);
	    return;
	}

	@Override
	public HistoryLogin getHistoryLogin(Integer clientId) {
		String SQL = "select * from history_login where clientid = ?";
	    HistoryLogin historyLogin = jdbcTemplateObject.queryForObject(SQL,new Object[]{clientId}, new HistoryLoginMapper());
	    return historyLogin;
	}

	@Override
	public List<HistoryLogin> listHistoryLogin() {
		String SQL = "select * from history_login";
	    List <HistoryLogin> historyLogins = jdbcTemplateObject.query(SQL,new HistoryLoginMapper());
	    return historyLogins;
	}

}
