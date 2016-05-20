package types;

public class HistoryLogin {
	private Integer clientid;
	private String date;
	
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String sqlDate) {
		this.date = sqlDate;
	}
}
