package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bankomat implements UslugeBankomata {
    private BazaCRUD bazaCRUD;
    private Klijent klijent;
    private Connection connection;

    public Bankomat(BazaCRUD bazaCRUD, Klijent trenutniKlijent) {
        this.klijent = trenutniKlijent;
        this.bazaCRUD = bazaCRUD;
    }

    public void unosKlijenta(String ime, String prezime, int oib, int pinBroj, int stanjeRacuna) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO klijenti (id, ime, prezime, oib, stanjeRacuna, pinBroj) VALUsES (?,?,?,?,?,?)");
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setInt(3, oib);
        statement.setInt(4, pinBroj);
        statement.setDouble(5, stanjeRacuna);
        statement.executeUpdate();
    }

    @Override
    public int podizanjeNovaca(int iznos) {
        int noviIznos = klijent.getStanjeRacuna() - iznos;
        if (noviIznos < 0) {
            throw new IllegalArgumentException("Nemate dovoljno novaca na računu; " + klijent.getStanjeRacuna());
        }
        return noviIznos;
    }

    @Override
    public int uplataNovaca(int iznos) throws SQLException {
        int noviIznos = klijent.getStanjeRacuna() + iznos;
        bazaCRUD.azuriranjePodataka(klijent.getIme(), klijent.getPrezime(),
                klijent.getOib(), klijent.getPinBroj(), noviIznos);
        klijent.setStanjeRacuna(noviIznos);
        return noviIznos;
    }

    @Override
    public int provjeraStanjaRacuna() {
        return klijent.getStanjeRacuna();
    }
}