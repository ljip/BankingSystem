import java.sql.*;

public class BazaCRUD {
    private Connection connection;

    public BazaCRUD(String databasepath) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite" + databasepath);
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void unosPodataka(String ime, String prezime, int oib, int pinBroj, double stanjeRacuna) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO klijenti (id, ime, prezime, oib, stanjeRacuna, pinBroj) VALUES (?,?,?,?,?,?)");
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setInt(3, oib);
        statement.setInt(4, pinBroj);
        statement.setDouble(5, stanjeRacuna);
        statement.executeUpdate();
    }

    public void azuriranjePodataka(String ime, String prezime, int oib, int pinBroj, double stanjeRacuna) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE klijenti SET id = ?, ime = ?, prezime = ?, oib = ?, stanjeRacuna = ?, pinBroj = ? WHERE id = ?");
        statement.setString(1, ime);
        statement.setString(2, prezime);
        statement.setInt(3, oib);
        statement.setInt(4, pinBroj);
        statement.setDouble(5, stanjeRacuna);
        statement.executeUpdate();
    }

    public void brisanjePodataka(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM klijenti WHERE id=?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void getNegativanKlijent() throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM klijenti WHERE stanjeRacuna < 0");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") +
                    " " + resultSet.getString("ime") +
                    " " + resultSet.getString("prezime") +
                    " " + resultSet.getInt("oib") +
                    " " + resultSet.getString("stanjeRacuna"));
        }
    }
}
