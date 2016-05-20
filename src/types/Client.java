package types;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import databaseHistoryLogin.HistoryLoginDAO;
import databaseHistoryLogin.HistoryLoginJDBCTemplate;

public class Client {
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private Date dob;
	
	private List<Account> accounts;
	private List<HistoryLogin> historyLogins;
	
	private void log(String s){
		System.out.println(s);
	}
	
	public List<HistoryLogin> getHistoryLogins() {
		return historyLogins;
	}

	public void setHistoryLogins(List<HistoryLogin> historyLogins) {
		if (this.historyLogins == null){
			this.historyLogins = historyLogins;
		}
		else{
			this.historyLogins.addAll(historyLogins);
		}
		
	}
	
	public void addToHistoryLogin(){
		HistoryLogin his = new HistoryLogin();
		his.setClientid(id);
		Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String sqlDate = formatter.format(now);
		log(sqlDate);
		his.setDate(sqlDate);
	}
	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
