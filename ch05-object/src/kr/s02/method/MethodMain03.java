package kr.s02.method;

public class MethodMain03 {
	// Variable Arguments
	public void argTest(int ... n) { // �ڷ����� ����ϰ� ... �Ŀ� ���ڸ� ����ϸ� ���� ���ڰ� ��
		for(int i=0;i<n.length;i++) {
			System.out.println("n[" + i + "] : " + n[i]);
		}
		System.out.println("========");
	}
	
	public static void main(String[] args) {
		MethodMain03 me = new MethodMain03();
		me.argTest(); // ���ڸ� �Է����� ���� ���, ���� 0�� �� �迭�� �����Ǿ� for���� �������� ����
		me.argTest(10); // 10�� n�� ���� ���޵Ǵ� ���� �ƴ϶�, n�� ����Ű�� ���� 1�� �迭�� ��Ұ� ��
		me.argTest(20, 30);
		me.argTest(40, 50, 60);
	}
}