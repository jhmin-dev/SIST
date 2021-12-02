package kr.s01.thread;

public class ThreadMain03 implements Runnable {
	// Runnable 인터페이스의 run() 메서드 구현
	@Override public void run() {
		System.out.println("run() 메서드, 스레드 이름 : " + Thread.currentThread().getName());
	}
	public static void main(String[] args) { // main() 메서드도 Thread 형태로 구현되어 메모리에 올라가면 스스로 동작하며, 동시 실행 가능
		System.out.println("main 메서드, 스레드 이름 : " + Thread.currentThread().getName());
		// 타겟 객체 생성
		ThreadMain03 tm = new ThreadMain03();
		// Thread 객체 생성
		Thread t = new Thread(tm); // 타겟 객체 지정
		t.start(); // ThreadMain03 객체의 run() 메서드 수행
	}
}
