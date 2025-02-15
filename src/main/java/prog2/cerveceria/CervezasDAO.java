package prog2.cerveceria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CervezasDAO {

    private final String dbFullURL;
    private final String dbUser;
    private final String dbPswd;

    @Autowired
    public CervezasDAO(
            @Qualifier("dbName") String dbName,
            @Qualifier("dbURL") String dbURL,
            @Qualifier("dbUser") String dbUser,
            @Qualifier("dbPswd") String dbPswd) {
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName;
        this.dbUser = dbUser;
        this.dbPswd = dbPswd;
    }

    public List<CervezaDTO> getCervezasByColor(String color) {
        ArrayList<CervezaDTO> resultado = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement();
            stmt.execute("SELECT marca, color, foto FROM cervezas WHERE color='" + color + "';");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                CervezaDTO cerveza = new CervezaDTO();
                cerveza.setMarca(rs.getString("marca"));
                cerveza.setColor(rs.getString("color"));
                cerveza.setFoto(rs.getString("foto"));
                resultado.add(cerveza);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }

    public List<String> getColores() {
        ArrayList<String> resultado = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement();
            stmt.execute("SELECT DISTINCT color FROM cervezas;");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                resultado.add(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Colores obtenidos: " + resultado);
        return resultado;
    }
}
