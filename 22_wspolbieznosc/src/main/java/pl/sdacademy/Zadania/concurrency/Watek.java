package pl.sdacademy.Zadania.concurrency;

import pl.sdacademy.Zadania.concurrency.Pudelko;

import java.util.Random;

public class Watek implements Runnable {

    private static String[] NAPISY = {"ALA", "KOT", "PIES", "ŻABA"};
    private Pudelko pudelko;
    private Random randomGenerator = new Random();

    public Watek(Pudelko bezpiecznePudelko) {
        this.pudelko = bezpiecznePudelko;
    }

    @Override
    public void run() { //zadaniem producenta jest umieszczanie w pudełku zawartości - losowo wybranego napisu
        for (int i = 0; i < 50; i++) {
            //boolean czySieUdalo = pudelko.wlozDoPudelka(pobierzLosowyElement());
            boolean czySieUdalo = true;
            if (czySieUdalo) {
                System.out.println(Thread.currentThread().getName()
                    + " wylosował " + randomGenerator.nextInt(100));
            } else {
                System.out.println(Thread.currentThread().getName()
                    + "Producent: nie udało mi się włożyć nowego elementu do pudełka..."); // podobnie jak w przypadku konsumenta, chcemy uniknąć niepotrzebnej pracy producenta gdy pudełko jest pełne i nie da się do niego nic włożyć
                try {
                    Thread.sleep(randomGenerator.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String pobierzLosowyElement() {
        return NAPISY[randomGenerator.nextInt(NAPISY.length)];
    } //metoda prywatna skrywa (niezbyt skomplikowaną, ale mniej czytlną niż napis "pobierzLosowyElement") logikę pobrania losowego napisu
}
