public class ArrayMain09 {
	public static void main(String[] args) {
		/*
		 * [�ǽ�]
		 * 1) 10, 20, 30, 40, 50�� �ʱⰪ���� ���� 1���� �迭�� test �̸����� ����, ����, �ʱ�ȭ�Ͻÿ�.
		 * 2) �ݺ����� �̿��Ͽ� ����Ͻÿ�.
		 * 3) Ȯ�� for���� �̿��Ͽ� ����Ͻÿ�.
		 * 4) �ε��� 3�� �����͸� 100���� �����Ͻÿ�.
		 * 5) ������ ����� ���� 200���� �����Ͻÿ�.
		 * 6) �ݺ����� ����Ͽ� ��� ����� ���� 0���� �ʱ�ȭ�Ͻÿ�.
		 * 7) Ȧ�� �ε����� 10, ¦�� �ε����� 20�� �����Ͻÿ�.
		 * 8) ��� ����� ���հ� ���(������ ����� ���� ����) ���ϰ� ����Ͻÿ�.
		 */
		// 1
		int[] test={10, 20, 30, 40, 50};
		// 2
		for(int i=0;i<test.length;i++) {
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 3
		for(int num:test) {
			System.out.print(num+"\t");
		}
		System.out.println("\n========");
		// 4
		test[3]=100;
		// 5
		test[test.length-1]=200;
		for(int num:test) {
			System.out.print(num+"\t");
		}
		System.out.println("\n========");
		// 6
		for(int i=0;i<test.length;i++) {
			test[i]=0;
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 7
		for(int i=0;i<test.length;i++) {
			if(i%2==0) {
				test[i]=20;
			}
			else {
				test[i]=10;
			}
			System.out.println(test[i]);
		}
		System.out.println("========");
		// 8
		int sum=0;
		float avg=0.0f;
		for(int num:test) {
			sum+=num;
		}
		avg=sum/(float)test.length;
		System.out.printf("���� = %d\n��� = %.2f", sum, avg);
	}
}