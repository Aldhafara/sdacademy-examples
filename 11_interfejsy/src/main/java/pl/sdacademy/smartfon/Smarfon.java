package pl.sdacademy.smartfon;

public class Smarfon implements Telefon, Komputer {
    @Override
    public void kalkulator(int liczba1, int liczba2) {
        System.out.println(liczba1 + " + " + liczba2 + " = " + (liczba1+liczba2));
    }

    @Override
    public void przegladarka(String adres) {
        System.out.println("Przedladam stronę o adresie: " + adres);
    }

    @Override
    public void dzwonDo(String numer) {

    }

    @Override
    public void wyslijSMS(String numer) {

    }
}
