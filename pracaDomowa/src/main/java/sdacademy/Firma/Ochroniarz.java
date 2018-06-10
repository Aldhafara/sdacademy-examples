package sdacademy.Firma;

public class Ochroniarz extends Pracownik {

	public Ochroniarz(int pensja, String opisStanowiska){
		super(pensja, opisStanowiska);
	}

	@Override
	public void dodatek() {
		System.out.println("Dodatek równy 0%");
	}

}