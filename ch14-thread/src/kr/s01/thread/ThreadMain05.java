package kr.s01.thread;

class MyRunnableTwo implements Runnable {
	@Override public void run() {
		System.out.println("run");
		first();
	}
	public void first() {
		System.out.println("first");
		second();
	}
	public void second() {
		System.out.println("second");
	}	
}

public class ThreadMain05 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " start");
		
		// Ÿ�� ��ü ����
		MyRunnableTwo mt = new MyRunnableTwo();
		// Thread ��ü ����
		Thread myThread = new Thread(mt);
		myThread.start(); // MyRunnableTwo ��ü�� run() �޼��� ����
		
		try {
			myThread.join(); // join() �޼��带 ȣ���� Thread�� ������ ������ ���� Thread�� ��ٸ��� ��; myThread�� join()�� ȣ������ ������ main�� myThread���� ���� ����� �� ����; ���� Thread ���� ����ÿ� ������ ���α׷��Ӱ� ���ϴ� ��� ���� ����
		}
		catch (InterruptedException e) { // join() �޼��� ���� �ǹ������� ó���ؾ� �ϴ� ����
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
