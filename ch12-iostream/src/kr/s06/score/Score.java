package kr.s06.score;

public class Score {
	/*
	 * [실습] 이름(name), 국어(korean), 영어(english), 수학(math)
	 * 총점 구하기(int makeSum), 평균 구하기(double makeAvg), 등급 구하기(String makeGrade)
	 */
	private String name;
	private int korean;
	private int english;
	private int math;

	// 총점 구하기
	public int makeSum() {
		return korean + english + math;
	}
	// 평균 구하기
	public double makeAvg() {
		return makeSum() / 3.0;
	}
	// 등급 구하기
	public String makeGrade() {
		String str;
		switch((int)(makeAvg()/10)) {
		case 10:
		case 9: str = "A"; break;
		case 8: str = "B"; break;
		case 7: str = "C"; break;
		case 6: str = "D"; break;
		default: str = "F";
		}
		return str;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() { // 성적 출력 및 파일 생성에 활용할 수 있도록 toString() 메서드를 재정의
		return String.format("%s\t%d\t%d\t%d\t%d\t%.2f\t%s%n", name, korean, english, math, makeSum(), makeAvg(), makeGrade()); // String의 static 메서드인 format() 메서드를 이용하여 printf() 메서드처럼 포맷문자를 적용한 문자열 반환
	}
}