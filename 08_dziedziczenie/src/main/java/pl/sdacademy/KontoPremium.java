package pl.sdacademy;

public class KontoPremium extends Konto {
    private int debet;

    public KontoPremium(int stanKonta, int debet) {
        super(stanKonta);
        this.debet = debet;
    }

    @Override
    public void pobierzPieniadze(int ilePodrac) {
        super.pobierzPieniadze(ilePodrac);


        if ((getStanKonta()+this.debet)-ilePodrac>0){
        this.setStanKonta(this.getStanKonta()-ilePodrac);
            System.out.println("Podrano " + ilePodrac + " złotych, pozostało " + getStanKonta());}
        else{
        System.out.println("Brak wystarczajacych środków!!");
    }

    }



}
