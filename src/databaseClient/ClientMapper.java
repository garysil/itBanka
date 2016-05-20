package databaseClient;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import types.Client;

public class ClientMapper implements RowMapper<Client> {
   public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
      Client client = new Client();
      client.setId(rs.getInt("id"));
      client.setFirstname(rs.getString("firstname"));
      client.setLastname(rs.getString("lastname"));
      client.setDob(rs.getDate("dateofbirth"));
      client.setUsername(rs.getString("username"));
      client.setPassword(rs.getString("password"));
      return client;
   }
}