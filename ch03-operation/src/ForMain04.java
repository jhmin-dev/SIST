public class ForMain04 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int dan = input.nextInt();
		
		System.out.println(dan + "��");
		System.out.println("========");
		
		if(dan<=9&&dan>=1) {
			for(int i=1;i<=9;i++) {
				System.out.println(dan + " * " + i + " = " + dan * i); // ������ �������� �켱������ ���� ������ �Ұ�ȣ ��� ���� ���� �����ϰ� ���ڿ��� ������
			}
		}
		else if(dan>9){
			for(int i=1;i<=dan;i++) {
				System.out.println(dan + " * " + i + " = " + dan * i);
			}
		}
		else {
			System.out.println("���� ������ �Է��ϼ���.");
		}
		input.close();
	}
}