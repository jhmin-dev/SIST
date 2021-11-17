package kr.s01.thread;

public class ThreadMain02 implements Runnable {
	// Runnable 인터페이스의 추상 메서드 구현
	@Override public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000); // Thread 클래스를 상속받지 않았으므로 static 메서드인 sleep() 메서드를 호출하려면 클래스명을 명시해야 함
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s, ", Thread.currentThread().getName()); // Thread 클래스를 상속받지 않았으므로 static 메서드인 currentThread() 메서드를 호출하려면 클래스명을 명시해야 함
			System.out.printf("temp value : %d%n", i);
		}
	}
	
	public static void main(String[] args) {
		// run() 메서드를 갖고 있는 타겟 객체 생성
		ThreadMain02 tm = new ThreadMain02();
		// Thread 객체 생성
		Thread t = new Thread(tm, "첫 번째"); // 타겟 객체와 Thread 이름을 인자로 전달하여 Thread 객체 생성
		t.start(); // 지정한 타겟 객체의 run() 메서드 호출
	}
}
