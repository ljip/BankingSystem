package com.demo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BazaCRUD bazaCRUD = new BazaCRUD();
        bazaCRUD.connect();
        bazaCRUD.unosKlijenta("hrvoje", "hrvic", 987656756, 1239, -100);
    }
}