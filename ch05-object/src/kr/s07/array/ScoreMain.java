package kr.s07.array;

public class ScoreMain {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * �迭 ����, �迭�� ���� 4
		 * �ڷ����� int�� �� ��ü�� ����(total), �� ��ü�� ���(avg) ���� ����
		 * Score ��ü�� 4�� �����ؼ� �迭�� ����
		 * �ݺ����� �̿��Ͽ� �迭�� �����ؼ� ��ü�� �����͸� �б�
		 * �� ��ü�� ������ ��� ���
		 */
		Score[] scoreArray=new Score[4];

		int total=0;
		int avg=0 ;
		/* �Է��� �޾� ��ü�� ����
		java.util.Scanner input = new java.util.Scanner(System.in);
		for(int i=0;i<scoreArray.length;i++) {
			System.out.print("�̸� > ");
			String name = input.nextLine();
			System.out.print("���� > ");
			int korean = input.nextInt();
			System.out.print("���� > ");
			int english = input.nextInt();
			System.out.print("���� > ");
			int math = input.nextInt();
			input.nextLine(); // ���� ������ �Է��ϸ鼭 ģ ����(\n)�� ����ϴ� �뵵; ���� ��� ������ �� �� �̸��� \n���� �Էµ�
			scoreArray[i] = new Score(name, korean, english, math);
		}
		input.close();
		*/
		scoreArray[0]=new Score("ȫ�浿", 98, 96, 88);
		scoreArray[1]=new Score("�̼���", 99, 72, 82);
		scoreArray[2]=new Score("�念��", 97, 83, 81);
		scoreArray[3]=new Score("������", 86, 66, 83);
		
		for(Score score : scoreArray) {
			System.out.print(score.getName()+"\t");
			System.out.print(score.getKorean()+"\t");
			System.out.print(score.getEnglish()+"\t");
			System.out.print(score.getMath()+"\t");
			System.out.print(score.makeSum()+"\t");
			System.out.print(score.makeAvg()+"\t");
			System.out.print(score.makeGrade()+"\n");
			total += score.makeSum();
		}
		avg = total / (scoreArray.length * 3);
		System.out.println("�� ��ü�� ���� : "+total+"\t�� ��ü�� ��� : "+avg);
	}
}