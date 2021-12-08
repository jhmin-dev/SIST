package miniproject;

import java.sql.Date;

public class MovieVO {
	private int mo_num;
	private String mo_title;
	private Date mo_date;
	private int mo_seats;
	private int mo_ban;
	
	public int getMo_num() {
		return mo_num;
	}
	public void setMo_num(int mo_num) {
		this.mo_num = mo_num;
	}
	public String getMo_title() {
		return mo_title;
	}
	public void setMo_title(String mo_title) {
		this.mo_title = mo_title;
	}
	public Date getMo_date() {
		return mo_date;
	}
	public void setMo_date(Date mo_date) {
		this.mo_date = mo_date;
	}
	public int getMo_seats() {
		return mo_seats;
	}
	public void setMo_seats(int mo_seats) {
		this.mo_seats = mo_seats;
	}
	public int getMo_ban() {
		return mo_ban;
	}
	public void setMo_ban(int mo_ban) {
		this.mo_ban = mo_ban;
	}
}
