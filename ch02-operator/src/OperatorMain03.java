public class OperatorMain03 {
	public static void main(String[] args) {
		int korean = 90;
		int english = 95;
		int math = 88;
		
		// ÃÑÁ¡ ±¸ÇÏ±â
		int sum = korean + english + math;
		// Æò±Õ ±¸ÇÏ±â
		int avg = sum / 3;
		
		System.out.printf("±¹¾î : %dÁ¡\n¿µ¾î : %dÁ¡\n¼öÇÐ : %dÁ¡\nÃÑÁ¡ : %dÁ¡\nÆò±Õ : %dÁ¡\n", korean, english, math, sum, avg);
	}
}