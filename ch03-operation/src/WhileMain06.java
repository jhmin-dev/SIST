public class WhileMain06 {
	public static void main(String[] args) {
		// ���� ���α׷�
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int balance = 0; // �ܰ� ����
		
		while(true) {
			System.out.println("========");
			System.out.println("1. ���� | 2. ��� | 3. �ܱ� | 4. ����"); // �޴� ���
			System.out.println("========");
			
			System.out.print("�޴� ���� > ");
			int num = input.nextInt(); // while�� �� �������� �����ϴ� ���� ������, �ݺ� ����Ǵ��� �� ���� ������ ������ �ν���
			if(num == 1) {
				System.out.print("���ݾ� > ");
				balance += input.nextInt();
			}
			else if(num == 2) {
				while(true) {
					System.out.print("��ݾ� > ");
					int withdraw = input.nextInt();
					if(withdraw>balance) {
						System.out.println("�ܱݺ��� �� ���� ����� �� �����ϴ�.");
					}
					else {
						balance -= withdraw;
						break;
					}
				}
			}
			else if(num == 3) {
				System.out.printf("�ܰ� : %,d��\n", balance);
			}
			else if(num == 4) {
				System.out.println("���α׷� ����");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
		
		input.close();
	}
}