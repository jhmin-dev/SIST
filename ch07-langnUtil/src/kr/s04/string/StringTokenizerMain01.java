package kr.s04.string;

import java.util.StringTokenizer;

public class StringTokenizerMain01 {
	public static void main(String[] args) {
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ","); // ���ڿ��� �����ڸ� ���ڷ� �ް�, �����ڸ� ���� ������� ���ڿ��� ���ο� �����ϴ� ��ü ����; ��ȯ���� �迭�� �ƴϹǷ� for������ �������� ����
		while(st.hasMoreTokens()) { // hasMoreTokens() �޼���� �����ڸ� ���� ������� ���ڿ��� �ִ��� ����
			System.out.println(st.nextToken()); // nextToken() �޼���� �����ڸ� ���� ������� ���ڿ��� �ϳ��� ��ȯ
		}
	}
}