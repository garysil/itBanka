package databaseInvalidAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import types.InvalidAccess;

public class InvalidAccessMapper implements RowMapper<InvalidAccess>{
	@Override
	public InvalidAccess mapRow(ResultSet rs, int rowNum) throws SQLException {
		InvalidAccess invalidAccess = new InvalidAccess();
	      invalidAccess.setUsername(rs.getString("username"));
	      invalidAccess.setDate(rs.getString("date"));
	      return invalidAccess;
	}
}
