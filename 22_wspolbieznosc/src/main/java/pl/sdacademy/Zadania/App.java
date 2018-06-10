package pl.sdacademy.Zadania;


import pl.sdacademy.Zadania.concurrency.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Pudelko bezpiecznePudelko = new BezpiecznePudelko();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Watek(bezpiecznePudelko));
        }
        executorService.shutdown();
    }
}
