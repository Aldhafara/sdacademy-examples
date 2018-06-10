package sdacademy.SitoArystotelesa;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sieve2 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 1;
		int[] tablica = new int[664590];
		List<Integer> primary = new ArrayList<>();

		long range;
		do {
			System.out.println("Podaj gorny zakres, do ktorego chcesz odnalezc liczby pierwsze (max 10 mln)\n");
			range = sc.nextLong();
		} while(range > 10000000);

		sc.close();
		System.out.print("     Szukam liczb pierwszych.");

		for(int u = 2; u <= range; ++u) {
			int s = 0;

			for(int j = 2; j * j <= u; ++j) {
				if (u % j == 0) {
					++s;
				}
			}

			if (s == 0) {
				tablica[k] = u;
				primary.add(u);
				++k;
				if (k % 5000 == 0) {
					//Runtime.getRuntime().exec("cls");
					System.out.print(".");//Loadingbar
				}
			}
		}

		System.out.println();

		/*
		int i;
		for(i = 1; tablica[i - 1] <= range && (i == 0 || tablica[i] != 0); ++i) {
			System.out.println("	Liczba pierwsza: " + tablica[i] + " jest " + i + " liczbą pierwszą.");
		}


		System.out.println("		Znalazlem " + (i - 1) + " liczb pierwszych.");
		*/


		primary.forEach((num) ->{
			System.out.println("	Liczba pierwsza: " + num + " jest " + (primary.indexOf(num)+1) + " " +
				"liczbą pierwszą.");
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("		Znalazlem " + (primary.size()) + " liczb pierwszych.");

	}
}