import java.sql.SQLException;

public class Bankomat implements UslugeBankomata {
    private BazaCRUD bazaCRUD;
    private Klijent trenutniKlijent;
    public Bankomat(BazaCRUD bazaCRUD, Klijent trenutniKlijent){
        this.bazaCRUD = bazaCRUD;
        this.trenutniKlijent = trenutniKlijent;
    }
    @Override
    public double podizanjeNovaca(double iznos) {
        double noviIznos = trenutniKlijent.getStanjeRacuna() - iznos;
        if (noviIznos < 0) {
            throw new IllegalArgumentException("Nemate dovoljno novaca na računu; "  + trenutniKlijent.getStanjeRacuna());
        }
        return noviIznos;
    }

    @Override
    public double uplataNovaca(double iznos) throws SQLException {
        double noviIznos = trenutniKlijent.getStanjeRacuna() + iznos;
        bazaCRUD.azuriranjePodataka(trenutniKlijent.getIme(), trenutniKlijent.getPrezime(),
                trenutniKlijent.getOib(), trenutniKlijent.getPinBroj(), noviIznos);
        trenutniKlijent.setStanjeRacuna(noviIznos);
        return noviIznos;
    }

    @Override
    public double provjeraStanjaRacuna() {
        return trenutniKlijent.getStanjeRacuna();
    }

    @Override
    public double konverzijaHRKuEUR() {
        return 0;
    }
}