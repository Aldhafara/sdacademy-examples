package pl.sdacademy;

public class Bank {
    public static void main(String[] args) {
        Konto pkoKonto = new Konto(1000);
        pkoKonto.pobierzPieniadze(300);
        pkoKonto.pobierzPieniadze(500);
        pkoKonto.pobierzPieniadze(1200);
    }
}
