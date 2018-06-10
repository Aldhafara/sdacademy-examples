package pl.sdacademy.zadanie;

import pl.sdacademy.exception.DevideByZeroException;
import pl.sdacademy.zadanie.Number;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("Podaj dwie liczby całkowite, program zwróci wynik dzielenia: ");
		Scanner reader = new Scanner(System.in);
		int dzielna = reader.nextInt();

		Number dzielnik = null;
		try {
			//dzielnik.setValue(reader.nextInt());

			dzielnik = new Number(reader.nextInt());

			System.out.println("Dzielnik = " + dzielnik.getValue());
		} catch (Exception ex) { //możemy użyć klasy bazowej - wtedy złapalibyśmy też ewentualne inne wyjątki dziedziczące po klasie Exception
			System.out.println("To jest wyjątek! Wiadomość: " + ex.getMessage());
		}


		//Number dzielnik = new Number();
		//dzielnik.setValue(reader.nextInt());

		/*if (Number.isDzielnikValid(dzielnik)) {
			throw new DevideByZeroException("Dzielnik musi byś różny od zera!");
		}*/
		//System.out.println( dzielna + "/" + dzielnik + " = " + dzielna/dzielnik);
/*
		try {
			dzielnik.setValue(0);
		}catch (Exception ex){
			System.out.println("To jest wyjątek!");
		}
*/





	}
}
