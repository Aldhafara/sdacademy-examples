package sdacademy.Firma;

public abstract class Pracownik {

	int pensja;
	String opisStanowiska;

	public Pracownik(int pensja, String opisStanowiska) {
		this.pensja = pensja;
		this.opisStanowiska = opisStanowiska;
	}

	public int getPensja() {
		return pensja;
	}


	public String getOpisStanowiska() {
		return opisStanowiska;
	}

	public abstract void dodatek();
}
