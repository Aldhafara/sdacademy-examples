package pl.sdacademy.Zadania.callable.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;

public class LosowyNapis implements Callable<String> { //interfejs callable dodatkowo określa typ obiektu, jaki ma zwrócić wątek w wyniku swojego działania.

   // private static final String [] NAPISY = {"ALA", "KOT", "TYGRYS", "MALPKA"};
    private static Random random = new Random();

    @Override
    public String call() throws Exception {
       // return pobierzLosowyNapis(); //nasz wątek zwraca losowy napis z tablicy
    ;
            return null;
    }

    private Integer pobierzLosowyNapis() {
        return random.nextInt(50);
    }
}
