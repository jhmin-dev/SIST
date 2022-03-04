package kr.board.vo;

import java.sql.Date;

public class BoardVO {
	private int board_num; // 글 번호
	private String title; // 제목
	private String content; // 내용
	private int hit; // 조회수
	private Date reg_date; // 등록일
	private Date modify_date; // 수정일
	private String filename; // 파일명
	private String ip; // IP 주소
	private int mem_num; // 작성자 회원 번호
	private String id; // 작성자 아이디; 테이블에는 없지만 회원 번호 대신 화면에 표시할 것이므로 프로퍼티에 포함
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}