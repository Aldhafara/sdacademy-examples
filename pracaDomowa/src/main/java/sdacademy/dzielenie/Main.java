package sdacademy.dzielenie;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		double x,z;
		//Number y;

		System.out.println("Hello Word!");

		System.out.println("Podaj dwie liczby. Program zwróci wynik dzielenia x : y");
		System.out.print("x = "); x = scan.nextDouble();
		System.out.print("y = ");
		// y = scan.nextDouble();

		//System.out.println("x = " + x);
		//System.out.println("y = " + y);


		Number y = null;
		try {
			//dzielnik.setValue(reader.nextInt());

			y = new Number(scan.nextDouble());

			System.out.print("x/y = " + x/y.getValue());

			//System.out.println("Dzielnik = " + dzielnik.getValue());
		} catch (Exception ex) { //możemy użyć klasy bazowej - wtedy złapalibyśmy też ewentualne inne wyjątki dziedziczące po klasie Exception
			System.out.println("To jest wyjątek! Wiadomość: " + ex.getMessage());
		}





	}
}