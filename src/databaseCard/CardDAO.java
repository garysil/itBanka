package databaseCard;

import java.util.List;

import javax.sql.DataSource;

import types.Card;

public interface CardDAO {
	public void setDataSource(DataSource ds);
	public void create(String active, Integer accountid);
	public Card getCard(Integer id);
	public List<Card> listCards();
	public List<Card> getCardsOf(Integer id);
	public void delete(Integer id);
	public void update(Integer id, String active);
}
