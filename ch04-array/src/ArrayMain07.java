public class ArrayMain07 {
	public static void main(String[] args) { // main 함수가 동작하면 Program arguments에 입력된 데이터를 배열 args에 전달
		if(args.length>0) { // Program arguments에 데이터 입력하지 않은 경우 main 함수가 동작하면서 배열은 생성되나 배열의 length는 0이 됨
			for(int i=0;i<args.length;i++) {
				System.out.print(args[i]+"\t");
			}
		}
		else {
			System.out.println("args.length = " + args.length);
			System.out.println("입력한 내용이 없습니다!");
		}
	}
}