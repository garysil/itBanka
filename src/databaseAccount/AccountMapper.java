package databaseAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import types.Account;

public class AccountMapper implements RowMapper<Account>{
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Account account = new Account();
	      account.setId(rs.getInt("id"));
	      account.setBalance(rs.getDouble("balance"));
	      account.setClientId(rs.getInt("clientid"));
	      return account;
	   }
}
