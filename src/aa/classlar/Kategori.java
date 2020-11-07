package aa.classlar;

import aa.Formlar.KategoriListele;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import aa.Formlar.Baglantı.Baglanti;
//import kutuphane.Formlar.KategoriListele;

public class Kategori {

    private int kategori_id;
    private String kategori_adi;

    public Kategori() {
    }

    public Kategori(int kategori_id, String kategori_adi) {
        this.kategori_id = kategori_id;
        this.kategori_adi = kategori_adi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    public void kategoriEkle(int id, String ad) {

        Baglanti bag = new Baglanti();
        bag.baglanti();

        String sql = "INSERT INTO kategori values ('" + id + "','" + ad + "')";

        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql);
            JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
        } catch (Exception e) {
            //
            JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
            System.out.println(e.toString());
        }
        bag.bagKapat();
    }

    public void kategoriyeGoreListele(String kategori_adi) {

        Baglanti bag = new Baglanti();
        bag.baglanti();
        String ekle = "";
        //  String sql = "select * from kutuphane where kitap_id in(select kitap_id from suresiz where kategori_id in(select kategori_id from kategori where kategori_adi='" + kategori_adi +"'))";
        KategoriListele list = new KategoriListele();

        try {  //BURANIN İÇİNDE HATA VAR
            PreparedStatement stat = bag.c.prepareStatement("select * from kutuphane where kitap_id in(select kitap_id from suresiz where kategori_id in(select kategori_id from kategori where kategori_adi='" + kategori_adi + "'))");
            ResultSet Rs = stat.executeQuery();
            while (Rs.next()) {
                ekle = ekle + Rs.getInt(1) + " " + Rs.getString(2) + "   " + Rs.getInt(3) + " " + Rs.getInt(4) + " " + Rs.getInt(5) + " \n";
                if (ekle == "") {
                    JOptionPane.showMessageDialog(null, "Aranan Kitap Bulunamadı");
                    break;
                }
                //list.sonuc.setText(ekle);

            }
            JOptionPane.showMessageDialog(null, ekle);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Aradiginiz Türden Kitap Şuan Elimizde Yok");
            System.out.println(e.toString());
        }
        bag.bagKapat();

    }

}
