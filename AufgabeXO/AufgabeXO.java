import java.util.Random;

public class AufgabeXO {

	int verfuegbarX;

	public static void main(String[] args) {
		for (int zeileCount = 1; zeileCount <= 10; zeileCount++) {
			Random ZUFALL = new Random();
			int anzahlX = ZUFALL.nextInt(4) + 1;

			System.out.println("Zeile " + zeileCount + ";" + "Zufahlszahl: " + anzahlX 
					+ " " + generateXO(anzahlX));
		}
	}

	public static String generateXO(int nummer) {

		char[] raster = { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' };
		int interval = 10 / nummer;
		int verfuegbarX = nummer;
		for (int i = 0; i < 10; i = i + interval) {
			if (verfuegbarX != 0) {
				raster[i] = 'X';
				verfuegbarX--;
			}
		}
		return String.valueOf(raster);
	}
}
