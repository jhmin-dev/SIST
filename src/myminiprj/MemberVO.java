package myminiprj;

import java.sql.Date;

public class MemberVO { // my_member
	private int me_num; // 회원 번호
	private String me_id; // 아이디
	private String me_pw; // 비밀번호
	private String me_name; // 이름
	private Date me_birthdate; // 생년월일
	private Date me_regdate; // 가입일
	private String me_access; // 권한

	public MemberVO() {}
	public MemberVO(int me_num) {
		this.me_num=me_num;
	}

	public int getMe_num() {
		return me_num;
	}
	public void setMe_num(int me_num) {
		this.me_num = me_num;
	}
	public String getMe_id() {
		return me_id;
	}
	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	public String getMe_pw() {
		return me_pw;
	}
	public void setMe_pw(String me_pw) {
		this.me_pw = me_pw;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public Date getMe_birthdate() {
		return me_birthdate;
	}
	public void setMe_birthdate(Date me_birthdate) {
		this.me_birthdate = me_birthdate;
	}
	public Date getMe_regdate() {
		return me_regdate;
	}
	public void setMe_regdate(Date me_regdate) {
		this.me_regdate = me_regdate;
	}
	public String getMe_access() {
		return me_access;
	}
	public void setMe_access(String me_access) {
		this.me_access = me_access;
	}
}