package sdacademy.Firma;

public class Ksiegowa extends Pracownik {

	int premia;

	public Ksiegowa(int pensja, String opisStanowiska, int nrBiura) {
		super(pensja, opisStanowiska);
		this.premia = premia;
	}

	@Override
	public void dodatek() {
		System.out.println("Dodatek równy 10%");

	}

}