package kr.s06.score;

public class Score {
	/*
	 * [�ǽ�] �̸�(name), ����(korean), ����(english), ����(math)
	 * ���� ���ϱ�(int makeSum), ��� ���ϱ�(double makeAvg), ��� ���ϱ�(String makeGrade)
	 */
	// ��� ����
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
	// ��� �޼���
	public int makeSum() {
		return korean+english+math;
	}
	public double makeAvg() {
		return makeSum()/3d;
	}
	public String makeGrade() {
		switch((int)(makeAvg()/10)) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
	@Override
	public String toString() {
		return "Score [name=" + name + ", korean=" + korean + ", english=" + english + ", math=" + math + "]";
	}
}