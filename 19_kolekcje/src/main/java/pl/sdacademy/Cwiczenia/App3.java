package pl.sdacademy.Cwiczenia;


import java.util.*;
import java.util.Random;

public class App3 {
    public static void main(String[] args) {

        Map<String, Integer> imionaWiek = new HashMap<>();
        imionaWiek.put("Gracjan", 25);
        imionaWiek.put("Zenobia", 57);
        imionaWiek.put("Gertruda", 45);

        System.out.println(imionaWiek);


        Map<String, Integer> imionaWiek2 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Podaj imię: ");
        String name = scanner.nextLine();
        Random generator = new Random();

        while(!name.equals("exit")){
            imionaWiek2.put(name,generator.nextInt(90)+18);
            System.out.println("Podaj kolejne imię [wyjsciezawsze po wpisaniu \"exit\"] : ");
            name = scanner.nextLine();
        }
        System.out.println(imionaWiek2);

    }
}
