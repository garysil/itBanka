package types;

public class Card {
	private Integer id;
	private String active;
	private Integer accountId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String string) {
		this.active = string;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}
