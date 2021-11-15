package kr.s01.exception;

public class ExceptionMain06 {
	// throw�� �̿��� ������ ���� �߻�
	public void methodA(String[] n) throws Exception {
		if(n.length>0) { // �Է��� ���� �ִ� ���
			for(String s : n) {
				System.out.println(s);
			}
		}
		else { // �Է��� ���� ���� ���
			throw new Exception("�Է��� �����Ͱ� �����ϴ�."); // ���� ��ü�� �����Ͽ� ����(=������ �������� �ʴ� ��쿡 catch ������ �̵���Ŵ); throw�� ������� ������ ������ ���� ��ü�� �޼���� ���� ����(=���� �߻��� �ƴ�) ������ �νĵ�
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain06 ex = new ExceptionMain06();
		try {
			ex.methodA(args);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); // ���� ��ü�� ����� �޽����� ���
		}
	}
}