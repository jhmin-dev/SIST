package kr.s01.a;
class Worker {
	/*
	 * [실습] 
	 * Worker
	 * 1) 멤버 변수 : 직원 이름(name), 급여(money), 계좌 잔고(balance)
	 * 2) 멤버 메서드 : work(실행하면 money에 1,000원 누적), deposit(실행하면 money의 돈을 balance로 누적시키고 money는 0으로 처리)
	 * MethodMain04
	 * 1) Worker 객체 생성
	 * 2) 직원의 이름 지정
	 * 3) 10번 일하는데 번 돈이 3,000원일 때마다 계좌에 저축
	 * 4) 직원 이름, 현재 계좌에 입금되지 않고 남아 있는 급여(money), 계좌 잔고(balance)를 출력
	 */
	String name;
	int money, balance;
	
	public void work() {
		money+=1000; // 처음 생성시 0으로 초기화되기 때문에 문제 발생하지 않고 누적됨
	}
	
	public void deposit() {
		balance+=money;
		money=0;
	}
}

public class MethodMain04 {
	public static void main(String[] args) {
		Worker w = new Worker();
		w.name = "너굴";
		for(int i=0;i<10;i++) {
			w.work();
			if(w.money>=3000) { // w.money%3000==0도 가능
				w.deposit();
			}
		}
		System.out.println("이름 : " + w.name);
		System.out.printf("남아 있는 급여 : %,d원\n", w.money);
		System.out.printf("계좌 잔고 : %,d원", w.balance);
	}
}