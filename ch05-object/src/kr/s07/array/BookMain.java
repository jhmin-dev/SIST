package kr.s07.array;

public class BookMain {
	public static void main(String[] args) {
		// Book ��ü�� ��ҷ� ���� �迭 ���� �� ����
		Book[] bookArray = new Book[3]; // ���� 3�� �迭�� �����ǰ�, �� ��Ҵ� null�� �ʱ�ȭ��; ��ü�� ���� �������� �ʾ� �ּҰ� ���ٴ� �ǹ�
		int total = 0;
		
		// Book ��ü�� 3�� �����Ͽ� �迭�� ����
		bookArray[0] = new Book("IT", "Java", 5000, 0.05); // ������ ��ü�� �ּҰ� �迭�� 0�� �ε����� �����
		bookArray[1] = new Book("�̼�", "����", 4000, 0.03);
		bookArray[2] = new Book("����", "�Ƹ���", 6000, 0.06);
		
		// �迭�� ��� ���; �������� ��µ�
		System.out.println(bookArray[0]);
		System.out.println(bookArray[1]);
		System.out.println(bookArray[2]);
		
		// �ݺ����� �̿��� �迭�� �����ؼ� ��ü�� ȣ���ϰ� ��ü�� ��� ������ ����� ������ ���
		for(int i=0;i<bookArray.length;i++) {
			System.out.print(bookArray[i].getCategory() + "\t"); // ��ü�� ��� ������ private�̶� ���� ���� �Ұ�
			System.out.print(bookArray[i].getName() + "\t");
			System.out.printf("%,d��\t", bookArray[i].getPrice());
			System.out.printf("%.2f%%\n", bookArray[i].getDiscount()); // printf���� %�� �Ϲݹ��ڷ� ����Ϸ��� %% ���
		}
		
		System.out.println();
		
		// Ȯ�� for��
		for(Book book : bookArray) { // ���� �ڷ����� Ŭ������ Book�� ���� ���� ���� book�� ����
			System.out.printf("%s\t", book.getCategory());
			System.out.printf("%s\t", book.getName());
			System.out.printf("%,d��\t", book.getPrice());
			System.out.printf("%.2f%%\n", book.getDiscount());
			// �հ�
			total += book.getPrice();
		}
		// �հ� ���
		System.out.printf("������ �� : %,d��", total);
	}
}