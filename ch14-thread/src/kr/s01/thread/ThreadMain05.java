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
		
		// 타겟 객체 생성
		MyRunnableTwo mt = new MyRunnableTwo();
		// Thread 객체 생성
		Thread myThread = new Thread(mt);
		myThread.start(); // MyRunnableTwo 객체의 run() 메서드 실행
		
		try {
			myThread.join(); // join() 메서드를 호출한 Thread가 종료할 때까지 현재 Thread는 기다리게 함; myThread가 join()을 호출하지 않으면 main이 myThread보다 먼저 종료될 수 있음; 여러 Thread 동시 수행시에 순서를 프로그래머가 원하는 대로 지정 가능
		}
		catch (InterruptedException e) { // join() 메서드 사용시 의무적으로 처리해야 하는 예외
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
