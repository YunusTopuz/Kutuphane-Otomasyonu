package aa.classlar;

import aa.Formlar.Baglantı.Baglanti;
import aa.Formlar.UyedekiKitaplar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Uye {
    
    private static Uye u=new Uye();

    private int uye_id;
    private String uye_adi;
    private String uye_soyadi;
    private int adminlik;

    public Uye() {
    }

    public Uye(int uye_id, String uye_adi, String uye_soyadi, int adminlik) {
        this.uye_id = uye_id;
        this.uye_adi = uye_adi;
        this.uye_soyadi = uye_soyadi;
        this.adminlik = adminlik;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public void setUye_adi(String uye_adi) {
        this.uye_adi = uye_adi;
    }

    public void setUye_soyadi(String uye_soyadi) {
        this.uye_soyadi = uye_soyadi;
    }

    public void setAdminlik(int adminlik) {
        this.adminlik = adminlik;
    }

    public int getUye_id() {
        return uye_id;
    }

    public String getUye_adi() {
        return uye_adi;
    }

    public String getUye_soyadi() {
        return uye_soyadi;
    }

    public int getAdminlik() {
        return adminlik;
    }

    public void uyeKayıtEkle(int id, String ad, String soyad, int admin) {

        Baglanti bag = new Baglanti();
        bag.baglanti();

        String sql = "INSERT INTO uye values ('" + id + "','" + ad + "','" + soyad + "','" + admin + "')";

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
    
    public void uyekiKitaplar(int uyeid) {

        Baglanti bag = new Baglanti();
        bag.baglanti();
        UyedekiKitaplar uk=new UyedekiKitaplar();
                

        //String sql = "select kitap_adi from kutuphane,kutuphane_stok where kutuphane.kitap_id in(select kitap_id from kutuphane_stok where stok_id in(select stok_id from odunc where uye_id='"+uyeid+"')) GROUP BY kitap_adi;";

    

        
        String ekle = "";
      

        try {
            PreparedStatement stat = bag.c.prepareStatement("select * from kutuphane where kitap_id in(select kitap_id from kutuphane_stok where stok_id in(select stok_id from odunc where uye_id='"+uyeid+"')) ");
            ResultSet Rs = stat.executeQuery();
            ekle=ekle + " Kitap Adi    "+"\n";
            while (Rs.next()) {
                //dizayn2="Kitap  İd  "+"Kitap Adı  "+"Sayfa Sayısı"+"Basım Tarihi  "+"\n";
                ekle = ekle +  Rs.getString(2) + "            " + " \n";
                if (ekle == "") {
                    JOptionPane.showMessageDialog(null, "Bulunamadı");
                    break;
                }
              
                //uk.uye.setText(ekle);
                
            }
            JOptionPane.showMessageDialog(null, ekle);

            // jButton4.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Aranan Kitap Bulunamadı");
            System.out.println(e.toString());

        }

    }

    
    
    public void uyeSil(int id){
         Baglanti bag = new Baglanti();
        bag.baglanti();
        
         String sql = "DELETE from uye where uye_id='" + id + "'";
         
         try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarısız");
            System.out.println(e.toString());

        }
        bag.bagKapat();
         
        
    }
}
