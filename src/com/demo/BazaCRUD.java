package com.demo;

import java.sql.*;

public class BazaCRUD {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "filip";

    public BazaCRUD() throws SQLException {
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Not connected to database.");
            e.printStackTrace();
        }
    }

    public static void getDataFromKlijentiTable() {
        String selectQuery = "SELECT * FROM klijenti";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ime = resultSet.getString("ime");
                String prezime = resultSet.getString("prezime");
                double stanjeRacuna = resultSet.getDouble("stanjeRacuna");
                System.out.println("ID: " + id + ", Name: " + ime + ", Last Name: " + prezime + ", Balance: " + stanjeRacuna);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void close() throws SQLException {
        connection.close();
        System.out.println("Connection to database closed.");
    }

    public void azuriranjePodataka(String ime, String prezime, int oib, int pinBroj, int noviIznos) {
    }
}
