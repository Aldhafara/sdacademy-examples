package exercies;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		LocalDate dzisiaj = LocalDate.now();
		LocalTime taChwila = LocalTime.now();
		LocalDateTime dzisiajDataCzas = LocalDateTime.now();

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy -- HH:mm");



		System.out.println("Dzisiejsza data: " + dzisiaj.format(dateFormatter));
		System.out.println("Obecna: " + taChwila.format(timeFormatter));
		System.out.println("Dzisiejsza data: " + dzisiajDataCzas.format(dateTimeFormatter));

		System.out.println("Podaj pierwszą datę w formacie dd/MM/yyyy:");
		String date1 = scan.nextLine();
		System.out.println("Podaj drugą datę w formacie dd/MM/yyyy:");
		String date2 = scan.nextLine();

		LocalDate data1 = LocalDate.parse(date1, dateFormatter);
		LocalDate data2 = LocalDate.parse(date2, dateFormatter);


		if(data1.isAfter(data2)) {
			System.out.println("Wcześniej jest " + data2);
		} else if(data1.isBefore(data2)) {
			System.out.println("Wcześniej jest " + data1);
		} else {
			System.out.printf("Obie daty są takie same");
		}



		ZonedDateTime czasTokio = ZonedDateTime.of(dzisiajDataCzas,ZoneId.of("Asia/Tokyo"));
		//ZonedDateTime czasLosAngeles = ZonedDateTime.;

		System.out.println("W Tokio jest teraz " + czasTokio.format(dateTimeFormatter));
		//System.out.println("W Los Angeles jest teraz " + czasLosAngeles.format(dateTimeFormatter));


	}
}
