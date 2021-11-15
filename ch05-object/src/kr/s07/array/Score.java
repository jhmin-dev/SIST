package kr.s07.array;

public class Score { // Ŭ�������� �빮�ڷ� �����ؾ� ������� �򰥸��� ����
	/*
	 * [�ǽ�]
	 * ��� ���� �̸�(name), ����(korean), ����(english), ����(math) ����
	 * ��ȯ���� int�� ������ ���ϴ� �޼���(makeSum), ����� ���ϴ� �޼���(makeAvg) ����
	 * ��ȯ���� String�� ����� ���ϴ� �޼���(makeGrade) ����
	 * ���ڰ� ���� ������, ���ڰ� �ִ� ������ ���
	 */
	// ����ȭ
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
	// ����, ���, ����� ���ϴ� �޼���
	public int makeSum() { // �޼���� ������ �ǹ��ϹǷ� �޼������ �������� ���
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
	// ������
	Score(){}
	Score(String name, int korean, int english, int math){
		this.name=name;
		this.korean=korean;
		this.english=english;
		this.math=math;
	}
}