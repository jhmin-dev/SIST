package kr.order.vo;

import java.sql.Date;

public class OrderVO {
	private int order_num; // 주문 번호
	private String item_name; // 주문 상품명
	private int order_total; // 총 구매 금액
	private int payment; // 지불 방식; 1. 통장 입금, 2. 카드 결제
	private int status; // 배송 상태; 1. 배송 대기, 2. 배송 준비 중, 3. 배송 중, 4. 배송 완료, 5. 배송 취소
	private String receive_name; // 받는 사람 이름
	private String receive_post; // 받는 사람 우편번호
	private String receive_address1; // 받는 사람 주소
	private String receive_address2; // 받는 사람 상세 주소
	private String receive_phone; // 받는 사람 전화번호
	private String notice; // 남길 말
	private Date reg_date; // 주문일
	private Date modify_date; // 배송 상태 수정일
	private int mem_num; // 구매자 회원 번호
	private String id; // 구매자 아이디
	
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getOrder_total() {
		return order_total;
	}
	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getReceive_post() {
		return receive_post;
	}
	public void setReceive_post(String receive_post) {
		this.receive_post = receive_post;
	}
	public String getReceive_address1() {
		return receive_address1;
	}
	public void setReceive_address1(String receive_address1) {
		this.receive_address1 = receive_address1;
	}
	public String getReceive_address2() {
		return receive_address2;
	}
	public void setReceive_address2(String receive_address2) {
		this.receive_address2 = receive_address2;
	}
	public String getReceive_phone() {
		return receive_phone;
	}
	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
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