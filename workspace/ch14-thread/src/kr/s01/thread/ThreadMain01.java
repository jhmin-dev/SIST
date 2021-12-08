package kr.s01.thread;

public class ThreadMain01 extends Thread {
	// 생성자
	public ThreadMain01(String threadname) {
		super(threadname);
	}
	// Thread의 run() 메서드 재정의
	@Override public void run() {
		Thread t = currentThread(); // 현재 수행되는 Thread 객체를 반환
		System.out.println("실행 스레드 : " + t);
		
		for(int i=0;i<10;i++) {
			try {
				sleep(1000); // 지정된 시간(단위: 밀리세컨드)만큼 수행을 멈춤
			}
			catch(InterruptedException e) { // sleep() 메서드 사용시 의무적으로 처리해야 하는 예외
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s, ", currentThread().getName()); // getName() 메서드는 Thread 객체의 이름을 반환
			System.out.printf("temp value : %d%n", i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain01 tm = new ThreadMain01("첫 번째");
		tm.start(); // start() 메서드를 실행하면 run() 메서드를 실행하고 동시 작업이 가능하게끔 함; run() 메서드를 단독 실행하면 동시 작업 불가
	}
}
