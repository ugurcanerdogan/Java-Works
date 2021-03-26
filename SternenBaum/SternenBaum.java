public class SternenBaum {

	public static void main(String[] args) {

		int anzahlZeilen = 10;
		for (int i = 1; i <= anzahlZeilen; i++) {

			for (int l = 0; l < i; l++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
