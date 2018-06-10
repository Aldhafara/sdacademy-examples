package pl.sdacademy.zadania;

public class Main {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Ala");
		stringBuilder.append(" ma");
		stringBuilder.append(" kota.");
		System.out.println(stringBuilder.toString());

		String napis = stringBuilder.toString();
		int i = 5;
		System.out.println(i + " znak to: " + napis.charAt(i));

		String word = "Ala";
		boolean trueOrFalse = napis.startsWith(word);
		System.out.print("Czy zdanie zaczyna się od \"" + word + " \" ? ");
		System.out.println(trueOrFalse);

		word = "kota.";

		trueOrFalse = napis.endsWith(word);
		System.out.print("Czy zdanie kończy się na \"" + word + " \" ? ");
		System.out.println(trueOrFalse);

		word = "Litwo! Ojczyzno moja!";
		System.out.println("Długość napisu: \"" + word + " \" wynosi " + word.length() + " znaków.");

		word = "abcdefghi";
		char znak = 'd';
		System.out.println("Znak \"" + znak + "\" znajduje się na " + (word.indexOf(znak)+1) + " miejscu " +
			"napisu" +
			" \"" + word + "\"");

		word = "Ala ma kota, kot ma mleko.";
		i = 7;
		int j = 12;
		System.out.println("Część zdania \"" + word + "\" od " + i + " znaku do " + j + " to \"" + word
			.substring(i-1,j-1 ) + "\"");

		word = "Ala ma kota.";
		trueOrFalse = word.toUpperCase().contains("ALA");
		System.out.println(trueOrFalse);



	}
}
