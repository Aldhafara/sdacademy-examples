package sdacademy.Firma;

public class Magazynier extends Pracownik {

	public Magazynier(int pensja, String opisStanowiska, int nrHali){
		super(pensja, opisStanowiska);
	}


	@Override
	public void dodatek() {
		System.out.println("Dodatek zależny od całkowitej sprzedaży");
	}
}