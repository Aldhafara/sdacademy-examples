package sdacademy.dzielenie;

import sdacademy.exception.DevideByZeroException;

public class Number {
	private double value;

	public Number(double value)throws DevideByZeroException{
		if (!isDzielnikValid(value)) {
			throw new DevideByZeroException("Dzielnik musi byś różny od zera!");
		}
		this.value=value;

	}

	public double getValue() {
		return value;
	}

	private static boolean isDzielnikValid(double number) { //kod walidujący (sprawdzający poprawność) adres email
		// umieszczamy w metodzie prywatnej - tak jest czyściej
		return number!=0; //jeśli adres email zawiera znak '@', metoda zwróci prawdę. W przeciwnym
		// razie zwróci fałsz
	}
}
