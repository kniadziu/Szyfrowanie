import java.util.Scanner;

public class Enigma{
	public static void main(String[] args){	
		showMenu();
	}
	
	public static void showMenu() {
	
		System.out.println("********************************");
		System.out.println("\t Program ENIGMA");
		System.out.println("\t Autor: Grzegorz Koziel");
		System.out.println("********************************");
		
		//System.out.println("\n---------------------------------------------------------------");
		System.out.println("\n Wybierz opcje: \n\n 1. Szyfruj metoda Cesara\n 2. Szyfruj metoda Vigenere\n 3. Koniec\n");
		System.out.print("#:");
		String option = getString();
		
		if ("1".equals(option)) {
			System.out.print("Podaj text do szyfrowania (max 255 znakow): ");
			String inputString = getString();
			System.out.print("Podaj przesuniecie: ");
			int shift = getInt();
			System.out.println("Tekst zaszyfrowany: " + encryptCesar(inputString, shift));
			showMenu();
		} else if ("2".equals(option)) {
			System.out.print("Podaj text do zaszyfrowania (max 255 znakow): ");
			String inputString = getString();
			System.out.print("Podaj Haslo nie krotsze niz " + inputString.length() + ": ");
			String passString = getString();
			System.out.println("Tekst zaszyfrowany: " + encryptVigenere(inputString, passString));
			showMenu();
		} else if ("3".equals(option)) {
			System.out.println("Koniec.....");
		} else {
			showMenu();
		} 
	}
		
	public static String encryptVigenere(String text, String klucz) {
		String textEncrypted = "";
		text = text.toUpperCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char znak = text.charAt(i);
			textEncrypted += (char)(((znak - 65) + (klucz.charAt(j)-65)) % 26 + 65);
			j = ++j % klucz.length();
		}
		return textEncrypted;
	}
		
	public static StringBuilder encryptCesar(String text, int shift){
		StringBuilder textEncrypted = new StringBuilder();
		char znak;
		int len=text.length();
		for (int i=0;i<len;i++){
			znak = text.charAt(i);
			if (Character.isLetter(znak)){
				znak = (char)(text.charAt(i) + shift);
				if ((Character.isLowerCase(text.charAt(i)) && znak >'z') || (Character.isUpperCase(text.charAt(i)) && znak > 'Z')){
					znak = (char)(text.charAt(i) - (26 - shift));
				}	
			}
			textEncrypted.append(znak);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		}
		return textEncrypted;
	}
	
	public static int getInt() {
		return new Scanner(System.in).nextInt();
	}
 
	public static String getString() 
	{
		return new Scanner(System.in).next();
	}
	
}   //KONIEC APLIKACJI
