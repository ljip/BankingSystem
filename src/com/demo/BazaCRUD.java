package com.demo;

import java.sql.*;

public class BazaCRUD {
    Connection connection;
    String url = "jdbc:postgresql://localhost/postgres";
    String user = "postgres";
    String password = "filip";

    public BazaCRUD() throws SQLException {
        connect();
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Not Connected");
            e.printStackTrace();
        }
    }

    public void unosKlijenta(String ime, String prezime, int oib, int pinBroj, double stanjeRacuna) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO klijenti (ime, prezime, oib, stanjeRacuna, pinBroj) VALUES (?,?,?,?,?)");
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setInt(3, oib);
        statement.setDouble(4, stanjeRacuna);
        statement.setInt(5, pinBroj);
        statement.executeUpdate();
    }

    public void azuriranjePodataka(String ime, String prezime, int oib, int pinBroj, double stanjeRacuna) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE klijenti SET ime = ?, prezime = ?, oib = ?, pinBroj = ?, stanjeRacuna = ? WHERE id = ?");
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setInt(3, oib);
        statement.setInt(4, pinBroj);
        statement.setDouble(5, stanjeRacuna);
        statement.executeUpdate();
    }

    public void brisanjePodataka(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM klijenti WHERE id=?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void getNegativanKlijent() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM klijenti WHERE stanjeRacuna < 0");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") +
                    " " + resultSet.getString("ime") +
                    " " + resultSet.getString("prezime") +
                    " " + resultSet.getInt("oib") +
                    " " + resultSet.getDouble("stanjeRacuna"));
        }
    }

    public void close() throws SQLException {
        connection.close();
    }
}