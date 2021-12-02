package kr.s01.list;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProductMain {
	// 멤버 변수; list와 br을 생성자뿐만 아니라 멤버 메서드들에서 사용할 것이므로 멤버 변수로 선언해야 함
	ArrayList<Product> list;
	BufferedReader br;
	
	// 생성자
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			// 메뉴 메서드 호출 전에 입력 받을 수 있어야 함
			br = new BufferedReader(new InputStreamReader(System.in));
			// 객체가 생성되면 바로 메뉴 메서드 호출
			callMenu();
		}
		catch(Exception e) {
			// 콘솔에 예외 문구 표시
			e.printStackTrace();
		}
		finally {
			// 자원 정리; try~catch를 한 줄로 인식하므로 if문 블럭을 만들지 않아도 됨
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}

	// 메뉴
	public void callMenu() throws IOException { // 입력 자체가 불가능한 경우는 종료
		while(true) {
			try {
				System.out.println("메뉴 : 1. 상품 입력, 2. 상품 목록 보기, 3. 종료");
				System.out.print("메뉴 > ");
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					// 상품 입력 메서드 호출
					input();
				}
				else if(num == 2) {
					// 상품 목록 보기 메서드 호출
					output();
				}
				else if(num == 3) {
					System.out.println("프로그램 종료");
					break;
				}
				else {
					System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
				}
			}
			catch(NumberFormatException e) { // 숫자를 입력하지 않은 경우는 while문을 반복하여 다시 입력하게 함
				System.out.println("숫자만 허용됩니다.");
			}
		}
	}
	
	// 상품 입력
	public void input() throws IOException {
		Product p = new Product();
		System.out.print("상품명 > ");
		p.setName(br.readLine());
		System.out.print("상품 번호 > ");
		p.setNum(br.readLine());
		System.out.print("상품 가격 > ");
		p.setPrice(Integer.parseInt(br.readLine())); // 가격의 경우 연산 가능성이 있으므로 String이 아니라 int로 입력받음
		System.out.print("제조사 > ");
		p.setMaker(br.readLine());
		System.out.print("재고 > ");
		p.setStock(Integer.parseInt(br.readLine()));
		
		// Product를 ArrayList에 저장
		list.add(p);
	}
	
	// 상품 목록 보기
	public void output() {
		System.out.println("상품명\t번호\t가격\t제조사\t재고");
		// ArrayList를 2차원 배열처럼 활용
		for(Product p : list) {
			System.out.printf("%s\t%s\t%,d원\t%s\t%,d개\n", p.getName(), p.getNum(), p.getPrice(), p.getMaker(), p.getStock());
		}
	}
	
	public static void main(String[] args) {
		// 객체가 생성되면 메뉴 메서드에서 작업을 수행하므로, main에서 작업을 진행하지 않으니 변수 선언할 필요도 없음
		new ProductMain();
	}
}