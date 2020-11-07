/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.classlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import aa.Formlar.Baglantı.Baglanti;

/**
 *
 * @author emrah
 */
public class arama {
    private int id;
    private int ad;

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JTextArea getAramaTablosu() {
        return AramaTablosu;
    }

    public void setAramaTablosu(JTextArea AramaTablosu) {
        this.AramaTablosu = AramaTablosu;
    }
    
    
    public void idArama(int id){
        Baglanti bag = new Baglanti();
        bag.baglanti();
        
         String sql = "select * from kutuphane where kitap_id=(select kitap_id from kutuphane_stok where kitap_id='" + id + "' and status=0)";
        
       String ekle = "";
        //String dizayn = "";

        try {
            Statement sta = bag.c.createStatement();
            ResultSet Rs=sta.executeQuery(sql);
            
            while (Rs.next()) {
              //  dizayn="Kitap  İd  "+"Kitap Adı  "+"Sayfa Sayısı"+"Basım Tarihi  "+"\n";
                ekle = "Kitap İd      Kitap Adi            Sayfa Sayisi          Basim Tarihi"+"\n"+ekle + Rs.getInt(1) + "                  " + Rs.getString(2) + "           " + Rs.getInt(3) + "                       " + Rs.getInt(4) + "\n";
                if (ekle == "") {
                    JOptionPane.showMessageDialog(null, "Aranan Kitap Bulunamadı");
                    break;
                }
                AramaTablosu.setText(ekle);
                JOptionPane.showMessageDialog(null, "Aranan Kitap Bulundu");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Aranan Kitap Bulunamadı");
            System.out.println(e.toString());

        }
        //JOptionPane.showMessageDialog(null, "Aranan Kitap Bulunamadı");
        bag.bagKapat();
    }
    
    
    
    
    
    private javax.swing.JTextArea AramaTablosu;
}
