package aa.Formlar.Baglantı;

//import java.sql.ResultSet;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.SQLException;

public class Baglanti {

    public static Connection c;

    public static void main(String[] args) {

        baglanti();

        bagKapat();
    }

    public static void baglanti() {

        try {
            Class.forName("org.postgresql.Driver");
            String baglanti = "jdbc:postgresql://localhost:5432/Kutuphane";
            String KulAdi = "postgres";
            String KulSifre = "123";
            c = DriverManager.getConnection(baglanti, KulAdi, KulSifre);
            System.out.println("Baglantı Başarılı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void bagKapat() {
        try {
            c.close();
            System.out.println("Baglantı Başarı ile Kapatıldı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
