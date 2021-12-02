package kr.s07.array;

public class Score { // 클래스명을 대문자로 시작해야 변수명과 헷갈리지 않음
	/*
	 * [실습]
	 * 멤버 변수 이름(name), 국어(korean), 영어(english), 수학(math) 생성
	 * 반환형이 int인 총점을 구하는 메서드(makeSum), 평균을 구하는 메서드(makeAvg) 생성
	 * 반환형이 String인 등급을 구하는 메서드(makeGrade) 생성
	 * 인자가 없는 생성자, 인자가 있는 생성자 명시
	 */
	// 은닉화
	private String name;
	private int korean;
	private int english;
	private int math;
	// Getters and Setters
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
	// 총점, 평균, 등급을 구하는 메서드
	public int makeSum() { // 메서드는 동작을 의미하므로 메서드명은 동사형을 사용
		return korean+english+math;
	}
	public int makeAvg() {
		return makeSum()/3;
	}
	public String makeGrade() {
		String grade;
		switch(makeAvg()/10) {
		case 10:
		case 9:
			grade = "A"; break;
		case 8:
			grade = "B"; break;
		case 7:
			grade = "C"; break;
		case 6:
			grade = "D"; break;
		default:
			grade = "F";
		}
		return grade;
	}
	// 생성자
	Score(){}
	Score(String name, int korean, int english, int math){
		this.name=name;
		this.korean=korean;
		this.english=english;
		this.math=math;
	}
}