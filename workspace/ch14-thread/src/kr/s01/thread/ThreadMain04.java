package kr.s01.thread;

public class ThreadMain04 implements Runnable {
	@Override public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("스레드 이름 : " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ThreadMain04 tm = new ThreadMain04();
		Thread t1 = new Thread(tm, "첫 번째***");
		t1.start(); // ThreadMain04 객체의 run() 메서드 호출
		Thread t2 = new Thread(tm, "두 번째~~~");
		t2.start(); // ThreadMain04 객체의 run() 메서드 호출
		Thread t3 = new Thread(tm, "세 번째===");
		t3.start(); // ThreadMain04 객체의 run() 메서드 호출
	}
}
