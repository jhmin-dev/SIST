package myminiprj;

public class MovieVO { // my_movie
	private int mo_num; // 영화 번호
	private String mo_title; // 제목
	private int mo_ban; // 관람가

	public MovieVO() {}
	public MovieVO(int mo_num) {
		this.mo_num=mo_num;
	}

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
	public int getMo_ban() {
		return mo_ban;
	}
	public void setMo_ban(int mo_ban) {
		this.mo_ban = mo_ban;
	}
}