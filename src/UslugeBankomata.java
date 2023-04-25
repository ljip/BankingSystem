import java.sql.SQLException;

public interface UslugeBankomata {
    public double podizanjeNovaca(double iznos);
    public double uplataNovaca(double iznos) throws SQLException;
    public double provjeraStanjaRacuna();

    public double konverzijaHRKuEUR();

}
