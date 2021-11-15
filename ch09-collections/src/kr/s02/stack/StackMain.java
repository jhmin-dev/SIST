package kr.s02.stack;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		String[] array = {"���޷�", "����", "������", "����", "���"};
		Stack<String> stk = new Stack<String>();
		
		// stk�� push() �޼���� �����͸� ����
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);
		}
		System.out.println(stk);
		
		// stk���� pop() �޼���� �����͸� ����(=stk ���� �����ʹ� ������)
		while(!stk.isEmpty()) { // stk�� ��� ���� ���� ���� ����
			System.out.print(stk.pop() + "\t");
		}
		System.out.println("\n"+stk);
	}
}