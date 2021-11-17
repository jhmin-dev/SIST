package kr.s01.thread;

public class ThreadMain02 implements Runnable {
	// Runnable �������̽��� �߻� �޼��� ����
	@Override public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000); // Thread Ŭ������ ��ӹ��� �ʾ����Ƿ� static �޼����� sleep() �޼��带 ȣ���Ϸ��� Ŭ�������� ����ؾ� ��
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("������ �̸� : %s, ", Thread.currentThread().getName()); // Thread Ŭ������ ��ӹ��� �ʾ����Ƿ� static �޼����� currentThread() �޼��带 ȣ���Ϸ��� Ŭ�������� ����ؾ� ��
			System.out.printf("temp value : %d%n", i);
		}
	}
	
	public static void main(String[] args) {
		// run() �޼��带 ���� �ִ� Ÿ�� ��ü ����
		ThreadMain02 tm = new ThreadMain02();
		// Thread ��ü ����
		Thread t = new Thread(tm, "ù ��°"); // Ÿ�� ��ü�� Thread �̸��� ���ڷ� �����Ͽ� Thread ��ü ����
		t.start(); // ������ Ÿ�� ��ü�� run() �޼��� ȣ��
	}
}
