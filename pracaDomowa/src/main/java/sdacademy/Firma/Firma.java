package sdacademy.Firma;

public class Firma {


	public static void main(String[] args) {


		int budzetRoczny = 6000;
		int n;

		Ksiegowa paniKrysytna = new Ksiegowa(2300, "Pisze rozliczenia", 004);
		Ochroniarz panKazimierz = new Ochroniarz(1700, "Strzeże & Broni");
		Magazynier panZbigniew = new Magazynier(2000, "Przygotowuje towar", 2);

		int[] budzetPlacowy = new int[5];
		budzetPlacowy[0] = paniKrysytna.pensja;
		budzetPlacowy[1] = panKazimierz.pensja;
		budzetPlacowy[2] = panZbigniew.pensja;


		  Pracownik adolf=new Pracownik(800,"Dłubie w nosie") {
			  @Override
			  public void dodatek()
			  {
				  System.out.println("A za co dodatek? Dopłacić powinien, że w ogóle go zatrudnliśmy!");
			  }
		  };

	}
}