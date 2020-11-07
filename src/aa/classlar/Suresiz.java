package aa.classlar;

import aa.Formlar.KitapEkle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aa.Formlar.Baglantı.Baglanti;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import kutuphane.Formlar.KitapEkle;

public class Suresiz extends Kutuphane {

    private int suresiz_id;
    private int yazar_id;
    private int kategori_id;

    public Suresiz() {
    }

    public Suresiz(int suresiz_id, int yazar_id, int kategori_id) {
        this.suresiz_id = suresiz_id;
        this.yazar_id = yazar_id;
        this.kategori_id = kategori_id;
    }

    public Suresiz(int suresiz_id, int yazar_id, int kategori_id, int kitap_id, String kitap_adi, int sayfa_sayisi, int basim_tarihi, int yayinevi_id) {
        super(kitap_id, kitap_adi, sayfa_sayisi, basim_tarihi, yayinevi_id);
        this.suresiz_id = suresiz_id;
        this.yazar_id = yazar_id;
        this.kategori_id = kategori_id;
    }

    public int getSuresiz_id() {
        return suresiz_id;
    }

    public void setSuresiz_id(int suresiz_id) {
        this.suresiz_id = suresiz_id;
    }

    public int getYazar_id() {
        return yazar_id;
    }

    public void setYazar_id(int yazar_id) {
        this.yazar_id = yazar_id;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    @Override
    public void kitapEkle(int suresizid, int yazarid, int kategoriid, int kitapid, String kitapadi, int sayfa, int basim, int yayineviid, int stokid, int barcode, int status) {

        Baglanti bag = new Baglanti();
        bag.baglanti();

        KitapEkle ke = new KitapEkle();

        String sql1 = "INSERT INTO kutuphane values ('" + kitapid + "','" + kitapadi + "','" + sayfa + "','" + basim + "','" + yayineviid + "')";
        System.out.println("------------------------------");
        String sql2 = "INSERT INTO suresiz values ('" + suresizid + "','" + yazarid + "','" + kitapid + "','" + kategoriid + "')";
        String sql3 = "INSERT INTO kutuphane_stok values ('" + stokid + "','" + kitapid + "','" + barcode + "','" + status + "')";

        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql1);
            JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
        } catch (Exception e) {
            //
            JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
            System.out.println(e.toString());
        }
        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql2);
            JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
        } catch (Exception e) {
            //
            JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
            System.out.println(e.toString());
        }
//
        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql3);
            JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
        } catch (Exception e) {
            //
            JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
            System.out.println(e.toString());
        }
        bag.bagKapat();

    }

    @Override
    public void kitapSil(int id) {
        Baglanti bag = new Baglanti();
        String sql1 = "DELETE from kutuphane where kitap_id='" + id + "'";
        String sql2 = "DELETE from suresiz where kitap_id='" + id + "'";
        String sql3 = "DELETE from kutuphane_stok where kitap_id='" + id + "'";
        try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql2);

            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarısız");
            System.out.println(e.toString());

        }

        try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql3);
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarısız");
            System.out.println(e.toString());

        }
        try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarısız");
            System.out.println(e.toString());

        }

        bag.bagKapat();
    }
    
//    public void kategoriyeGoreListele(String kategori_id) throws SQLException{
//        
//         Baglanti bag = new Baglanti();
//          bag.baglanti();
//          
//          String sql = "select * from kutuphane where kitap_id in(select kitap_id from suresiz where kategori_id in(select kategori_id from kategori where kategori_adi='" + kategori_id +"'))";
//        
//         try{
//              Statement sta = bag.c.createStatement();
//              sta.executeUpdate(sql); 
//              JOptionPane.showMessageDialog(null, "Aradiginiz Kitaplarin Listesi Bulundu");
//              
//         } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Aradiginiz Türden Kitap Şuan Elimizde Yok");
//            System.out.println(e.toString());
//    }
//          bag.bagKapat();
//
//}
}
