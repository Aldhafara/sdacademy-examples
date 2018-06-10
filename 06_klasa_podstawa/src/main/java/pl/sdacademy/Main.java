package pl.sdacademy;

public class Main {
    public static void main(String[] args) {



        Zwierze [] zoo = {
                 new Zwierze("Leon", 2, "Lew"),
                new Zwierze("Jadźka", 3, "Owca"),
                new Zwierze("Reksio", 1, "Rekin")
            };

        for (Zwierze zwierze: zoo) {
            if(zwierze.czyGrozny()) {
                System.out.println(zwierze.getGatunek() + " " + zwierze.getImie() + " jest groźnym zwierzęciem! Lepiej uciekaj");
            }
            else {
                System.out.println(zwierze.getGatunek() + " " + zwierze.getImie() + " nie jest groźnym zwierzęciem - można pogłaskać");
            }
        }

        User [] klasa = {
                new User ("Jan", "Kowalski", 25),
                new User ("Krzyś", "Nowak", 12),
        };

        for (User user: klasa){
            if(user.isAdult()){
                System.out.println(user.getName() + " jest dorosły.");
            }
            else System.out.println(user.getName() + " jest niepełnoletni.");
        }




    }
}
