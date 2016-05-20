package databaseHistoryLogin;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import types.HistoryLogin;

public interface HistoryLoginDAO {
	public void setDataSource(DataSource ds);
	public void create(Integer clientId, String date);
	public HistoryLogin getHistoryLogin(Integer clientId);
	public List<HistoryLogin> listHistoryLogin();
}
