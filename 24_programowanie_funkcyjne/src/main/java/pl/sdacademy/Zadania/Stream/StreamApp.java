package pl.sdacademy.Zadania.Stream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
	public static void main(String[] args) {

		List<String> imiona = Arrays.asList("Adam","Zdzisiek", "Jola", "Agnieszka","Krzysiek", "Marcin",
			"Michał","Ola",
			"Jacek");
		//do naszej zabawy potrzebujemy jakąś strukturę którą nasz stream będzie mógł wykorzystać jako źróło danych. Może to być tablica, lista, set czy mapa
		System.out.println(imiona);


		/*

		//Wyświetlanie czasu

		Consumer<String> timestampConsumer = txt ->{
			LocalDateTime timeStamp = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy::HH:mm:ss");
			String timeStampText = timeStamp.format(formatter);
			System.out.println(txt + "	" + timeStampText);
		};

		imiona.forEach(timestampConsumer);
		*/


		//Zadanie 13 (1)

		Stream.of(imiona); //aby utworzyć stream, możemy użyć statycznej metody of() klasy Stream...
		List<String> imionaZ_A = imiona.stream() // ...lub zwrócić go ze struktury za pomocą metody stream(). Podstawowe kolekcje posiadają taką metodę od javy 8.
			.map(String::toUpperCase) // na takim strumieniu mozemy wykonać wiele operacji
			// przetwarzających dane - w tym przypadku funkcja toUpperCase będzie "zmapowana" na każdy element naszej źródłowej listy
			.filter(imie->imie.contains("A"))
			.collect(Collectors.toList()); //zazwyczaj na końcu sekwencji metod wywoływanych na streamie wywołujemy metodę collect, aby zebrać wyniki działania streama w jakąś strukturę. Klasa Collectors posiada wiele przydatnych "zbieraczy" (metod przetwarzjących stream na jakąś strukturę czy kolekcję), w tym przypadku zamieniamy stream z powrotem na listę.
		System.out.println(imionaZ_A);

		//Zadanie 14 (2)

		Stream.of(imiona);
		List<String> imionaDluzszeOd_3 = imiona.stream()
			.filter(imie->imie.length()>3)
			.collect(Collectors.toList());
		System.out.println(imionaDluzszeOd_3);

		//Zadanie 15 (3)

		Stream.of(imiona);
		List<String> imionaDuzymi = imiona.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		System.out.println(imionaDuzymi);

		//Zadanie 16 (4)

		Stream.of(imiona);
		String napisZImion = imiona.stream()
			.collect(Collectors.joining(", "));
		System.out.println(napisZImion);

		//Zadanie 17 (5)

		IntSummaryStatistics statystyki = imiona.stream()
			.mapToInt(napis -> napis.length())
			.summaryStatistics();
		System.out.println("Max dlugosc napisu: " + statystyki.getMax());
		System.out.println("Srednia dlugosc napisu: " + statystyki.getAverage());
		System.out.println("Min dlugosc napisu: " + statystyki.getMin());
		System.out.println("Sumaryczna dlugosc napisu: " + statystyki.getSum());

	}
}


