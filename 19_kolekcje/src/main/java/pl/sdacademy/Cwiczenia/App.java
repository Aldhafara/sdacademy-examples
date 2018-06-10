package pl.sdacademy.Cwiczenia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		List<String> napisy = new ArrayList<>();
		napisy.add("Ala");
		napisy.add("ma");
		napisy.add("kota");

		List<Integer> liczby = new ArrayList<>();


		Scanner scanner = new Scanner(System.in);
		int b = scanner.nextInt();
		int max=b;

		while(b != (-1)){
			liczby.add(b);
			if (b>max)
				max=b;
			b = scanner.nextInt();
		}

		for (int i = 0; i <liczby.size()-1 ; i++) {
			if (liczby.get(i)>liczby.get(i+1)){

			}

		}

		//liczby.sort(Integer::compareTo);
		//System.out.println(liczby.get(liczby.size()-1));
		if (max == -1) {
			System.out.println("Tablica jest pusta");
		}else
		System.out.println(max);
	}
}
