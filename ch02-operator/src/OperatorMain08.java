public class OperatorMain08 {
	public static void main(String[] args) {
		System.out.println("====Á¶°Ç(»ïÇ×) ¿¬»êÀÚ====");
		int a = 5, b = 10;
		int max, min;
		
		max = a > b ? a : b;
		min = a < b ? a : b;
		
		System.out.println(a + "¿Í " + b + "ÀÇ ÃÖ´ñ°ªÀº " + max);
		System.out.println(a + "¿Í " + b + "ÀÇ ÃÖ¼Ú°ªÀº " + min);
	}
}