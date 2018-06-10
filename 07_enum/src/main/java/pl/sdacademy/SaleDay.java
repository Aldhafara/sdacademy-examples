package pl.sdacademy;

public enum SaleDay {
    MONDAY(0.2),
    TUESDAY(0.2),
    WEDNESDAY(0.3),
    THURSDAY(0.4),
    FRIDAY(0.3),
    SATURDAY(0.1),
    SUNDAY(0.1);

    private final double discont;

    SaleDay(double discont) {
        this.discont = discont;
    }

    public double getDiscont() {
        return discont;
    }

}
