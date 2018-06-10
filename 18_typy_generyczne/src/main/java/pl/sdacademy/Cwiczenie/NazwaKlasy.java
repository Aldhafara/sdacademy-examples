package pl.sdacademy.Cwiczenie;

public class NazwaKlasy<T> {


    public void wypiszNazweKlasy(T obiekt){
        System.out.println(obiekt.getClass().getSimpleName());
    }



}
