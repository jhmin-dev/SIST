package kr.s07.array;

public class ScoreMain {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 배열 생성, 배열의 길이 4
		 * 자료형이 int인 반 전체의 총점(total), 반 전체의 평균(avg) 변수 생성
		 * Score 객체를 4개 생성해서 배열에 저장
		 * 반복문을 이용하여 배열에 접근해서 객체의 데이터를 읽기
		 * 반 전체의 총점과 평균 출력
		 */
		Score[] scoreArray=new Score[4];

		int total=0;
		int avg=0 ;
		/* 입력을 받아 객체를 생성
		java.util.Scanner input = new java.util.Scanner(System.in);
		for(int i=0;i<scoreArray.length;i++) {
			System.out.print("이름 > ");
			String name = input.nextLine();
			System.out.print("국어 > ");
			int korean = input.nextInt();
			System.out.print("영어 > ");
			int english = input.nextInt();
			System.out.print("수학 > ");
			int math = input.nextInt();
			input.nextLine(); // 수학 점수를 입력하면서 친 엔터(\n)를 흡수하는 용도; 없을 경우 루프를 돌 때 이름이 \n으로 입력됨
			scoreArray[i] = new Score(name, korean, english, math);
		}
		input.close();
		*/
		scoreArray[0]=new Score("홍길동", 98, 96, 88);
		scoreArray[1]=new Score("이순신", 99, 72, 82);
		scoreArray[2]=new Score("장영실", 97, 83, 81);
		scoreArray[3]=new Score("김유신", 86, 66, 83);
		
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
		System.out.println("반 전체의 총점 : "+total+"\t반 전체의 평균 : "+avg);
	}
}