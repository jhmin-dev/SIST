package myminiprj;

public class TheaterVO { // my_theater
	private int th_num; // 상영관 번호
	private String th_date; // 상영 날짜 및 시간
	private int mo_num; // 영화 번호
	private int th_seats_total; // 총 좌석 수
	private int th_seats; // 잔여 좌석 수

	public TheaterVO() {}
	public TheaterVO(int th_num, String th_date) {
		this.th_num=th_num;
		this.th_date=th_date;
	}

	public int getTh_num() {
		return th_num;
	}
	public void setTh_num(int th_num) {
		this.th_num = th_num;
	}
	public String getTh_date() {
		return th_date;
	}
	public void setTh_date(String th_date) {
		this.th_date = th_date;
	}
	public int getMo_num() {
		return mo_num;
	}
	public void setMo_num(int mo_num) {
		this.mo_num = mo_num;
	}
	public int getTh_seats_total() {
		return th_seats_total;
	}
	public void setTh_seats_total(int th_seats_total) {
		this.th_seats_total = th_seats_total;
	}
	public int getTh_seats() {
		return th_seats;
	}
	public void setTh_seats(int th_seats) {
		this.th_seats = th_seats;
	}
}