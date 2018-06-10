package pl.sdacademy;

public class Konto {
    private int stanKonta;

    public Konto(int stanKonta){
        this.stanKonta = stanKonta;
    }

    public void pobierzPieniadze(int ilePodrac){
        if (stanKonta-ilePodrac>0)
        {stanKonta = stanKonta - ilePodrac;
            System.out.println("Podrano " + ilePodrac + " złotych, pozostało " + stanKonta);}
        else
            System.out.println("Brak wystarczajacych środków!!");

    }

    public void setStanKonta(int stanKonta) {
        this.stanKonta = stanKonta;
    }

    public int getStanKonta() {
        return stanKonta;
    }
}
