package databaseInvalidAccess;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import types.InvalidAccess;

public class InvalidAccessJDBCTemplate implements InvalidAccessDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String username, String date) {		
		String SQL = "insert into invalidaccess (username, date) values (?, ?)";
	    jdbcTemplateObject.update( SQL, username, date);
	    System.out.println("Created InvalidAccess Name = " + username + "  Date = " + date);
	    return;
	}

	@Override
	public List<InvalidAccess> getListOfUsername(String username) {
		String SQL = "select * from invalidaccess where username = ?";
	    List <InvalidAccess> invalidAccess = jdbcTemplateObject.query(SQL,new Object[]{username},new InvalidAccessMapper());
	    return invalidAccess;
	}

	@Override
	public void delete(String username) {
		String SQL = "delete from invalidaccess where username = ?";
	    jdbcTemplateObject.update(SQL, username);
	    System.out.println("Deleted InvalidAccess with Name = " + username );
	    return;
	}

}
