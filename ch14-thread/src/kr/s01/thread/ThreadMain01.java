package kr.s01.thread;

public class ThreadMain01 extends Thread {
	// ������
	public ThreadMain01(String threadname) {
		super(threadname);
	}
	// Thread�� run() �޼��� ������
	@Override public void run() {
		Thread t = currentThread(); // ���� ����Ǵ� Thread ��ü�� ��ȯ
		System.out.println("���� ������ : " + t);
		
		for(int i=0;i<10;i++) {
			try {
				sleep(1000); // ������ �ð�(����: �и�������)��ŭ ������ ����
			}
			catch(InterruptedException e) { // sleep() �޼��� ���� �ǹ������� ó���ؾ� �ϴ� ����
				e.printStackTrace();
			}
			System.out.printf("������ �̸� : %s, ", currentThread().getName()); // getName() �޼���� Thread ��ü�� �̸��� ��ȯ
			System.out.printf("temp value : %d%n", i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain01 tm = new ThreadMain01("ù ��°");
		tm.start(); // start() �޼��带 �����ϸ� run() �޼��带 �����ϰ� ���� �۾��� �����ϰԲ� ��; run() �޼��带 �ܵ� �����ϸ� ���� �۾� �Ұ�
	}
}
