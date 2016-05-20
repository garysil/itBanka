package databaseCard;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import types.Card;

public class CardJDBCTemplate implements CardDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String active, Integer accountid) {
		// TODO Auto-generated method stub
		String SQL = "insert into Cards (active, accountid) values (?, ?)";
	    jdbcTemplateObject.update( SQL, active, accountid);
	    System.out.println("Created Card Active = " + active);
	    return;
	}

	@Override
	public Card getCard(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Card where id = ?";
	    Card card = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new CardMapper());
	    return card;
	}

	@Override
	public List<Card> listCards() {
		// TODO Auto-generated method stub
		String SQL = "select * from Cards";
	    List <Card> cards = jdbcTemplateObject.query(SQL,new CardMapper());
	    return cards;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from Cards where id = ?";
	    jdbcTemplateObject.update(SQL, id);
	    System.out.println("Deleted Card with ID = " + id );
	    return;
	}

	@Override
	public void update(Integer id, String active) {
		// TODO Auto-generated method stub
		String SQL = "update Cards set active= ? where id = ?";
	    jdbcTemplateObject.update(SQL, active, id);
	    System.out.println("Updated Card with ID = " + id );
	    return;
	}

	@Override
	public List<Card> getCardsOf(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Cards where accountid = ?";
	    List <Card> cards = jdbcTemplateObject.query(SQL,new Object[]{id},new CardMapper());
	    return cards;
	}

}
