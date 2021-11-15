package kr.s01.string;

public class StringMain05 {
	public static void main(String[] args) {
		String str = "abcMDye-4W?EWzz";
		String result = ""; // �� ���ڿ��� �ʱ�ȭ
		/*
		 * [�ǽ�] str�� ����� ���ڿ����� �ҹ��ڴ� �빮�ڷ� ����, �빮�ڴ� �ҹ��ڷ� �����ؼ� ����Ͻÿ�.
		 * ABCmdYE-4w?ewZZ
		 * (��Ʈ: ASCII �ڵ忡�� 65~90�� �빮��, 97~122�� �ҹ���)
		 */
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>=65&&c<=90) { // �빮��
				result+=(char)(c+97-65); // �빮�ڸ� �ҹ��ڷ� �����ϰ� result�� ����
				// result+=String.valueOf(c).toLowerCase();
			}
			else if(c>=97&&c<=122) { // �ҹ���
				result+=(char)(c-97+65); // �ҹ��ڸ� �빮�ڷ� �����ϰ� result�� ����
				// result+=String.valueOf(c).toUpperCase();
			}
			else {
				result+=c;
			}
		}
		System.out.println(result);
	}
}