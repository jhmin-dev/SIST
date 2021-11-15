package kr.s06.poly;
// 부모 클래스
class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품 구매시 제공하는 보너스 점수
	public Product(int price) {
		this.price = price;
		this.bonusPoint = price/10; // 보너스 점수는 제품 가격의 10%
	}
	public String getName() {
		return "상품";
	}
}
// 자식 클래스
class Tv extends Product {
	public Tv() {
		super(200);
	}
	@Override public String getName() {
		return "Tv";
	}
}
// 자식 클래스
class Computer extends Product {
	public Computer() {
		super(300);
	}
	@Override public String getName() {
		return "Computer";
	}
}

class Buyer {
	int money = 1000; // 보유 금액
	int bonusPoint; // 보유 보너스 점수
	public void buy(Product p) { // 객체의 주소를 받으려면 자료형을 명시해야 하는데, 제품 종류가 많을 경우 자료형마다 메서드 오버로딩하는 것은 번거로움; 인자 자료형을 부모 클래스 타입으로 지정시, Tv 객체나 Computer 객체 전달받을 때 Product 클래스 타입으로 자동 형변환이 일어남
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 구매할 수 없습니다.");
			return; // buy 메서드를 빠져나감; 기본적으로 return은 생략시 메서드 제일 끝에 컴파일러에 의해 자동으로 포함되어 메서드 종료 역할; void형 메서드에서는 if문 내에 return을 명시하여 if~else문 효과를 낼 수 있음
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p.getName() + "을/를 구매했습니다."); // getName은 재정의된 메서드이기 때문에 다시 형변환할 필요 없음
		System.out.println("현재 남은 돈은 " + money + "만원입니다.");
		System.out.println("현재 보너스 점수는 " + bonusPoint + "점입니다.");
	}
}

public class PolyMain05 {
	public static void main(String[] args) {
		Buyer b = new Buyer(); // 고객 객체 생성
		Tv tv = new Tv(); // Tv 객체 생성
		Computer pc = new Computer(); // Computer 객체 생성
		b.buy(tv); // Tv 클래스 타입에서 Product 클래스 타입으로 형변환(=업캐스팅)
		b.buy(pc); // Computer 클래스 타입에서 Product 클래스 타입으로 형변환(=업캐스팅)
		Audio au = new Audio(); // Audio 객체 생성
		b.buy(au);
	}
}
//자식 클래스
class Audio extends Product { // 새 클래스를 추가해도 Product를 상속받기만 하면 구매 행위 메서드를 별도로 만들 필요 없음
	public Audio() {
		super(400);
	}
	@Override
	public String getName() {
		return "Audio";
	}
}