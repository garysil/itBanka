package databaseInvalidAccess;

import java.util.List;
import javax.sql.DataSource;
import types.InvalidAccess;

public interface InvalidAccessDAO {
	public void setDataSource(DataSource ds);
	public void create(String username, String date);
	public List<InvalidAccess> getListOfUsername(String username);
	public void delete(String username);
}
