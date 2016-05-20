package databaseCard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import types.Card;

public class CardMapper implements RowMapper<Card>{
	public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Card card = new Card();
	      card.setId(rs.getInt("id"));
	      card.setActive(rs.getString("active"));
	      card.setAccountId(rs.getInt("accountid"));
	      return card;
	   }
}
