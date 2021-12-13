package myminiprj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaDAO {
	// 로그인
	public int getLogin(String me_id, String me_pw) {
		int me_num = 0;

		return me_num;
	}

	// 관리자 검사
	public String checkAdmin(String me_id, String me_pw) {
		String me_access = "USER";

		return me_access;
	}

	// 회원 가입
	public void insertMember(MemberVO vo) {

	}

	// 관리자 등록
	public void registerAdmin() {

	}

	// 아이디 중복 검사
	public int checkID(MemberVO vo) {
		int check=0;

		return check;
	}
}