package kr.s01.basic;

public class DriverMain {
	public static void main(String[] args) {
		try {
			// JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver"); // �Է��� ���ڿ��� �̸����� ���� Ŭ������ ã�� �޸𸮿� �ε�
			System.out.println("����̹��� ���������� ��ġ�Ǿ����ϴ�.");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}