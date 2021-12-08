package miniproject;

import java.util.StringTokenizer;
import java.util.Calendar;

public class MemberVO {
	private int me_num; 
	private String me_id; 
	private String me_passwd; 
	private String me_name; 
	private int me_age; 
	private String me_phone; 
	
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
	public String getMe_passwd() {
		return me_passwd;
	}
	public void setMe_passwd(String me_passwd) {
		this.me_passwd = me_passwd;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public int getMe_Age() {
		return me_age;
	}
	public void setMe_Age(int me_age) {
		this.me_age = me_age;
	}
	public String getMe_phone() {
		return me_phone;
	}
	public void setMe_phone(String me_phone) {
		this.me_phone = me_phone;
	}

	public int getAge(String brithday) { //�� �߰������� ����ɾ���Ѵ�.
		Calendar today = Calendar.getInstance();
		StringTokenizer st = new StringTokenizer(brithday,"/ -");
		int age_year = Integer.parseInt(st.nextToken());
		int age_month = Integer.parseInt(st.nextToken());
		int age_day = Integer.parseInt(st.nextToken());
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1; // Calendar�� MONTH�� ���� 0~11�� ó��
		int day = today.get(Calendar.DATE);
		int me_age = 0;

		if(age_month>month) { //������ �� ����
			me_age = (year-age_year);
		}else if (age_month<month){//������ ����
			me_age = (year-age_year)+1;
		}else if(age_month == month) {
			if(age_day<=day) {
				me_age = (year-age_year)+1;
			}else {
				me_age = (year-age_year);
			}
		}else {
			System.out.println("��������� �ٽ� �Է����ּ���");
		}

		return me_age;
	}
}