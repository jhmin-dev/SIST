public class IfMain07 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * ��������� �Է��ϰ� �� ���̸� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 * �� ���� = (���� ���� - ����) - (������ �������� 0, ������ ������ �ʾ����� 1)
		 * 
		 * [��� ����]
		 * ���� �Է� : 2001
		 * �� �Է� : 10
		 * �� �Է� : 20
		 * �� ���̴� ?
		 */
		int thisYear = 2021;
		int thisMonth = 11;
		int thisDate = 1;
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("��������� �Է��ϼ���.");
		
		int year, month, date;
		
		while(true) { // ���� ����
			System.out.print("���� �Է� : ");
			year = input.nextInt();
			if(year>1900) {
				while(true) { // �� ����
					System.out.print("�� �Է� : ");
					month = input.nextInt();
					if(month>=1&&month<=12) {
						while(true) { // �� ����
							System.out.print("�� �Է� : ");
							date = input.nextInt();
							if(month==2){
								if(date>=1&&date<=28) {
									break;	
								}
								else {
									System.out.println("���� 1���� 28������ �����մϴ�.");
								}
							}
							else if((month%2==0&&month<=6)||(month%2==1&&month>=9)) {
								if(date>=1&&date<=30) {
									break;	
								}
								else {
									System.out.println("���� 1���� 30������ �����մϴ�.");
								}
							}
							else {
								if(date>=1&&date<=31) {
									break;	
								}
								else {
									System.out.println("���� 1���� 31������ �����մϴ�.");
								}
							}
						}
						break; // �� ���� Ż��
					}
					else {
						System.out.println("���� 1���� 12������ �����մϴ�.");
					}
				}
				break; // ���� ���� Ż��
			}
			else {
				System.out.println("������ �߸� �Է��ϼ̽��ϴ�");
			}
		}
		
		int age=thisYear-year;
		if(thisMonth<month) { // ���� ������ ����(��)
			age-=1;
		}
		else if(thisMonth==month) {
			if(thisDate<date) { // ���� ������ ����(��)
				age-=1;
			}
		}
		System.out.println("�� ���̴� ? "+age);
		
		input.close();
	}
}