package kr.s01.list;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProductMain {
	// ��� ����; list�� br�� �����ڻӸ� �ƴ϶� ��� �޼���鿡�� ����� ���̹Ƿ� ��� ������ �����ؾ� ��
	ArrayList<Product> list;
	BufferedReader br;
	
	// ������
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			// �޴� �޼��� ȣ�� ���� �Է� ���� �� �־�� ��
			br = new BufferedReader(new InputStreamReader(System.in));
			// ��ü�� �����Ǹ� �ٷ� �޴� �޼��� ȣ��
			callMenu();
		}
		catch(Exception e) {
			// �ֿܼ� ���� ���� ǥ��
			e.printStackTrace();
		}
		finally {
			// �ڿ� ����; try~catch�� �� �ٷ� �ν��ϹǷ� if�� ���� ������ �ʾƵ� ��
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}

	// �޴�
	public void callMenu() throws IOException { // �Է� ��ü�� �Ұ����� ���� ����
		while(true) {
			try {
				System.out.println("�޴� : 1. ��ǰ �Է�, 2. ��ǰ ��� ����, 3. ����");
				System.out.print("�޴� > ");
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					// ��ǰ �Է� �޼��� ȣ��
					input();
				}
				else if(num == 2) {
					// ��ǰ ��� ���� �޼��� ȣ��
					output();
				}
				else if(num == 3) {
					System.out.println("���α׷� ����");
					break;
				}
				else {
					System.out.println("�޴� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}
			}
			catch(NumberFormatException e) { // ���ڸ� �Է����� ���� ���� while���� �ݺ��Ͽ� �ٽ� �Է��ϰ� ��
				System.out.println("���ڸ� ���˴ϴ�.");
			}
		}
	}
	
	// ��ǰ �Է�
	public void input() throws IOException {
		Product p = new Product();
		System.out.print("��ǰ�� > ");
		p.setName(br.readLine());
		System.out.print("��ǰ ��ȣ > ");
		p.setNum(br.readLine());
		System.out.print("��ǰ ���� > ");
		p.setPrice(Integer.parseInt(br.readLine())); // ������ ��� ���� ���ɼ��� �����Ƿ� String�� �ƴ϶� int�� �Է¹���
		System.out.print("������ > ");
		p.setMaker(br.readLine());
		System.out.print("��� > ");
		p.setStock(Integer.parseInt(br.readLine()));
		
		// Product�� ArrayList�� ����
		list.add(p);
	}
	
	// ��ǰ ��� ����
	public void output() {
		System.out.println("��ǰ��\t��ȣ\t����\t������\t���");
		// ArrayList�� 2���� �迭ó�� Ȱ��
		for(Product p : list) {
			System.out.printf("%s\t%s\t%,d��\t%s\t%,d��\n", p.getName(), p.getNum(), p.getPrice(), p.getMaker(), p.getStock());
		}
	}
	
	public static void main(String[] args) {
		// ��ü�� �����Ǹ� �޴� �޼��忡�� �۾��� �����ϹǷ�, main���� �۾��� �������� ������ ���� ������ �ʿ䵵 ����
		new ProductMain();
	}
}