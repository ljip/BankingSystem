package com.demo;

import java.sql.SQLException;

public interface UslugeBankomata {
    public int podizanjeNovaca(int iznos);

    public int uplataNovaca(int iznos) throws SQLException;

    public int provjeraStanjaRacuna();
}