import java.util.Random; // Importing essential packages.
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {

		char[] codeCharacter = { 'r', 'g', 'b', 'y', 's', 'w' }; // Buchstaben für geheimCode.
		String geheimCode = ""; // Leeres String, es wird später einzufüllen.
		String versuchsCode; // Leeres String, es wird später gelesen.
		int versuchsZahl = 0;
		int anzahlLives = 5;

		for (int i = 0; i < 4; i++) { // Eine For Schleife für eine 4 stellige random geheimCode.

			Random geheimCodeRandom = new Random();
			int codeCharacterStelle = geheimCodeRandom.nextInt(6);
			geheimCode += codeCharacter[codeCharacterStelle]; // Erstellt vier stellige geheimCode.

		}

		Scanner versuchsCodeObjekt = new Scanner(System.in); // versuchsCode lesen.
		System.out.println(
				"Gib einen Versuchscode mit vier Buchstaben aus der Menge {r, g, b, y, s, w} ein. " + (geheimCode));

		while (versuchsZahl < anzahlLives) {
			versuchsCode = versuchsCodeObjekt.nextLine(); // Read user input

			if (versuchsCode.equals("") || versuchsCode.length() != geheimCode.length()) { // Kontrollieren die Gültigkeit des geheimCodes.
																							
				System.out.println("Gib bitte einen gültigen Versuchscode ein!");
			} else if (versuchsCode.equalsIgnoreCase(geheimCode)) {

				System.out.println("Versuchscode ist richtig! Spiel beendet! Du hast gewonnen!");
				break;
			} else {

				versuchsZahl++;
				System.out.println("Versuchscode ist falsch!" + " Anzahl den richtigen Farbe und Platz: "
						+ richtigeStelle(geheimCode, versuchsCode)
						+ ", Anzahl den richtigen Farbe aber falschen Platz: " + richtigeFarbe(geheimCode, versuchsCode)
						+ ". " + "Anzahl Versuch: " + versuchsZahl + ".");
			}

			if (versuchsZahl == anzahlLives)
			{
				System.out.println("Spiel beendet! Du hast verloren! Der Geheimcode war: " + geheimCode);

			}
		}
		versuchsCodeObjekt.close();
	}

	// Method um die richtige Farbe und Stelle zu kontrollieren.
	public static int richtigeStelle(String geheim, String versuch) {

		int richtigeFarbePlatz = 0;

		for (int i = 0; i < 4; i++) {

			char a = geheim.charAt(i);
			char g = versuch.charAt(i);

			if (a == g) {

				richtigeFarbePlatz++;
			}
		}

		return richtigeFarbePlatz;

	}

	// Method um die richtige Farbe, aber falsche Stelle zu kontrollieren.
	public static int richtigeFarbe(String geheim, String versuch) {

		int correctFarbe = 0;

		char[] geheimArray = new char[geheim.length()]; // String to char array transferring block.
		char[] versuchArray = new char[versuch.length()]; //

		for (int i = 0; i < geheim.length(); i++) { //

			geheimArray[i] = geheim.charAt(i); //
			versuchArray[i] = versuch.charAt(i); //

		}

		for (int i = 0; i < 4; i++) {

			char a = geheim.charAt(i);
			char g = versuch.charAt(i);

			if (a == g) {

				geheimArray[i] = '0';
				versuchArray[i] = '0';

			}

		}

		for (int l = 0; l < geheim.length(); l++) {
			for (int m = 0; m < versuch.length(); m++) {

				char a = geheimArray[l];
				char g = versuchArray[m];

				if (a == g && a != '0' && g != '0') {
					correctFarbe++;
					geheimArray[l] = '0';
					versuchArray[m] = '0';
				}
			}
		}

		//showArray(geheimArray);
		//showArray(versuchArray);
		return correctFarbe;
	}

	// Method um die vergleichene char zu zeigen.
	public static void showArray(char[] given) {
		for (char a : given) {
			System.out.print(a);
		}
		System.out.println();
	}
}
