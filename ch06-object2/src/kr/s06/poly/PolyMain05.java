package kr.s06.poly;
// �θ� Ŭ����
class Product {
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ ���Ž� �����ϴ� ���ʽ� ����
	public Product(int price) {
		this.price = price;
		this.bonusPoint = price/10; // ���ʽ� ������ ��ǰ ������ 10%
	}
	public String getName() {
		return "��ǰ";
	}
}
// �ڽ� Ŭ����
class Tv extends Product {
	public Tv() {
		super(200);
	}
	@Override public String getName() {
		return "Tv";
	}
}
// �ڽ� Ŭ����
class Computer extends Product {
	public Computer() {
		super(300);
	}
	@Override public String getName() {
		return "Computer";
	}
}

class Buyer {
	int money = 1000; // ���� �ݾ�
	int bonusPoint; // ���� ���ʽ� ����
	public void buy(Product p) { // ��ü�� �ּҸ� �������� �ڷ����� ����ؾ� �ϴµ�, ��ǰ ������ ���� ��� �ڷ������� �޼��� �����ε��ϴ� ���� ���ŷο�; ���� �ڷ����� �θ� Ŭ���� Ÿ������ ������, Tv ��ü�� Computer ��ü ���޹��� �� Product Ŭ���� Ÿ������ �ڵ� ����ȯ�� �Ͼ
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ ������ �� �����ϴ�.");
			return; // buy �޼��带 ��������; �⺻������ return�� ������ �޼��� ���� ���� �����Ϸ��� ���� �ڵ����� ���ԵǾ� �޼��� ���� ����; void�� �޼��忡���� if�� ���� return�� ����Ͽ� if~else�� ȿ���� �� �� ����
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p.getName() + "��/�� �����߽��ϴ�."); // getName�� �����ǵ� �޼����̱� ������ �ٽ� ����ȯ�� �ʿ� ����
		System.out.println("���� ���� ���� " + money + "�����Դϴ�.");
		System.out.println("���� ���ʽ� ������ " + bonusPoint + "���Դϴ�.");
	}
}

public class PolyMain05 {
	public static void main(String[] args) {
		Buyer b = new Buyer(); // �� ��ü ����
		Tv tv = new Tv(); // Tv ��ü ����
		Computer pc = new Computer(); // Computer ��ü ����
		b.buy(tv); // Tv Ŭ���� Ÿ�Կ��� Product Ŭ���� Ÿ������ ����ȯ(=��ĳ����)
		b.buy(pc); // Computer Ŭ���� Ÿ�Կ��� Product Ŭ���� Ÿ������ ����ȯ(=��ĳ����)
		Audio au = new Audio(); // Audio ��ü ����
		b.buy(au);
	}
}
//�ڽ� Ŭ����
class Audio extends Product { // �� Ŭ������ �߰��ص� Product�� ��ӹޱ⸸ �ϸ� ���� ���� �޼��带 ������ ���� �ʿ� ����
	public Audio() {
		super(400);
	}
	@Override
	public String getName() {
		return "Audio";
	}
}