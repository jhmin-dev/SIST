package myminiprj;

import java.sql.Date;

public class ReservationVO { // my_reservation
	private int re_num; // 예매 번호
	private int me_num; // 회원 번호
	private int mo_num; // 영화 번호
	private int th_num; // 상영관 번호
	private Date th_date; // 상영 날짜 및 시간
	private int re_seats; // 예매한 좌석 수

	public ReservationVO() {}
	public ReservationVO(int re_num) {
		this.re_num=re_num;
	}

	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public int getMe_num() {
		return me_num;
	}
	public void setMe_num(int me_num) {
		this.me_num = me_num;
	}
	public int getMo_num() {
		return mo_num;
	}
	public void setMo_num(int mo_num) {
		this.mo_num = mo_num;
	}
	public int getTh_num() {
		return th_num;
	}
	public void setTh_num(int th_num) {
		this.th_num = th_num;
	}
	public Date getTh_date() {
		return th_date;
	}
	public void setTh_date(Date th_date) {
		this.th_date = th_date;
	}
	public int getRe_seats() {
		return re_seats;
	}
	public void setRe_seats(int re_seats) {
		this.re_seats = re_seats;
	}
}