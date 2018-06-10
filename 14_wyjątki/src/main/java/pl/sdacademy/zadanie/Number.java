package pl.sdacademy.zadanie;

import pl.sdacademy.exception.DevideByZeroException;

public class Number {
	private int value;

	public Number(int value)throws DevideByZeroException{
		if (!isDzielnikValid(value)) {
			throw new DevideByZeroException("Dzielnik musi byś różny od zera!");
		}
		this.value=value;

	}

	public int getValue() {
		return value;
	}

	private static boolean isDzielnikValid(int number) { //kod walidujący (sprawdzający poprawność) adres email
		// umieszczamy w metodzie prywatnej - tak jest czyściej
		return number!=0; //jeśli adres email zawiera znak '@', metoda zwróci prawdę. W przeciwnym
		// razie zwróci fałsz
	}
}
