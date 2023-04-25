public class Klijent {
    public Klijent(String prezime, String ime, int pinBroj, int oib, double stanjeRacuna) {
        this.prezime = prezime;
        this.ime = ime;
        this.pinBroj = pinBroj;
        this.oib = oib;
        this.stanjeRacuna = stanjeRacuna;
    }

    private String prezime;
    private String ime;
    private int pinBroj;
    private int oib;
    private double stanjeRacuna;

    // Getteri
    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getPinBroj() {
        return pinBroj;
    }

    public int getOib() {
        return oib;
    }

    public double getStanjeRacuna() {
        return stanjeRacuna;
    }

    // Setteri
    public void setStanjeRacuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }
}