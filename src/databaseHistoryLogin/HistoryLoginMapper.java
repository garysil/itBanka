package databaseHistoryLogin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import types.HistoryLogin;

public class HistoryLoginMapper implements RowMapper<HistoryLogin> {

	@Override
	public HistoryLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistoryLogin historyLogin = new HistoryLogin();
	      historyLogin.setClientid(rs.getInt("clientid"));
	      historyLogin.setDate(rs.getString("date"));
	      return historyLogin;
	}

}
