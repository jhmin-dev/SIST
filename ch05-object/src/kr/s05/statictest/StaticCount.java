package kr.s05.statictest;

public class StaticCount {
	int c; // �ν��Ͻ� ����; ��ü ������ �޸𸮿� �ö�
	static int count; // static(Ŭ����) ����; ��ü ������ �����ϰ� ȣ��Ǹ� �޸𸮿� �ö�

	public StaticCount() { // ������
		c++;
		count++;
	}
}