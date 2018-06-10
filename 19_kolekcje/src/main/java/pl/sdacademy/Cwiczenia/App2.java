package pl.sdacademy.Cwiczenia;

import java.util.*;

public class App2 {
	public static void main(String[] args) {

		Set<String> napisy = new HashSet<>();


		Scanner scanner = new Scanner(System.in);
		String b = scanner.nextLine();
		String max=b;

		while(!b.equals("exit")){
			napisy.add(b);
			b = scanner.nextLine();
		}

		if (max.equals("exit")) {
			System.out.println("Tablica jest pusta");
		}

		System.out.println("Podaj jeszcze jeden napis:");
		String napis = scanner.nextLine();
		Set<Character> uniqueChar = new HashSet<>();
		for (char character : napis.toCharArray()) {
			uniqueChar.add(character);

		}
		System.out.println("Napisy zbior: " + uniqueChar);
		Map<String, Integer> znakWystapienie = new HashMap<>();



		for (Map.Entry<String,Integer> userEntry: znakWystapienie.entrySet()){
			System.out.println(userEntry.getKey() + "" + userEntry.getValue());
		}

		//Map<String, Integer> znakWystapienie = new HashMap<>();
		znakWystapienie.put(uniqueChar.toString(), uniqueChar.hashCode());
		System.out.println(znakWystapienie);



	}
}
