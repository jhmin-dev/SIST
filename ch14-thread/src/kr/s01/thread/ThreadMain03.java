package kr.s01.thread;

public class ThreadMain03 implements Runnable {
	// Runnable �������̽��� run() �޼��� ����
	@Override public void run() {
		System.out.println("run() �޼���, ������ �̸� : " + Thread.currentThread().getName());
	}
	public static void main(String[] args) { // main() �޼��嵵 Thread ���·� �����Ǿ� �޸𸮿� �ö󰡸� ������ �����ϸ�, ���� ���� ����
		System.out.println("main �޼���, ������ �̸� : " + Thread.currentThread().getName());
		// Ÿ�� ��ü ����
		ThreadMain03 tm = new ThreadMain03();
		// Thread ��ü ����
		Thread t = new Thread(tm); // Ÿ�� ��ü ����
		t.start(); // ThreadMain03 ��ü�� run() �޼��� ����
	}
}
