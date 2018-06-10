package pl.sdacademy.Zadania.Lambda;

import pl.sdacademy.user.User;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaApp {
	public static void main(String[] args) {

		//Zadanie 1

		Consumer<User> wypisz = System.out::println;
		User staszek = new User("Staszek", "Nowak", 23);
		wypisz.accept(staszek);

		//Zadanie 2

		Function<User,String> doDuzych = usr -> usr.getImie().toUpperCase();
		System.out.println(doDuzych.apply(staszek));

		//Zadanie 3

		BiFunction<Integer, Integer, Integer> dodajLiczby = (num1, num2) -> num1+num2;
		BiFunction<Integer, Integer, Integer> odejmijLiczby = (num1, num2) -> num1-num2;
		BiFunction<Integer, Integer, Integer> pomnozLiczby = (num1, num2) -> num1*num2;

		System.out.println(dodajLiczby.apply(10,13 ));
		System.out.println(odejmijLiczby.apply(10,13 ));
		System.out.println(pomnozLiczby.apply(10,13 ));

		//Zadanie 4

		WypiszNapis doWielkich = string -> string.toUpperCase();
		String napis = doWielkich.wypiszNapis(staszek.getNazwisko());
		System.out.println("napis = " + napis);

		//Zadanie 5

		ZadaniaMat dodawanie = ((a, b) -> a+b);
		ZadaniaMat odejmowanie = ((ab,bc) -> ab-bc);
		ZadaniaMat mnozenie = ((a, b) -> a*b);

		System.out.println(dodawanie.wynik(10,13 ));
		System.out.println(odejmowanie.wynik(10,13));
		System.out.println(mnozenie.wynik(10,13 ));


	}

	//Do zadania 4

	public interface WypiszNapis {
		String wypiszNapis(String napis);
	}

	//Do zadania 5

	public interface ZadaniaMat {
		int wynik(int a, int b);
	}
}
