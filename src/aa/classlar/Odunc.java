
package aa.classlar;

import java.sql.Date;
import java.sql.Statement;
import javax.swing.JOptionPane;
import aa.Formlar.Baglantı.Baglanti;


public class Odunc {
    
    private int oduncu_id;
    private int uye_id;
    private int stok_id;
    private Date odunc_tarihi;

    public Odunc() {
    }

    public Odunc(int oduncu_id, int uye_id, int stok_id, Date odunc_tarihi) {
        this.oduncu_id = oduncu_id;
        this.uye_id = uye_id;
        this.stok_id = stok_id;
        this.odunc_tarihi = odunc_tarihi;
    }

    public int getOduncu_id() {
        return oduncu_id;
    }

    public void setOduncu_id(int oduncu_id) {
        this.oduncu_id = oduncu_id;
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }

    public Date getOdunc_tarihi() {
        return odunc_tarihi;
    }

    public void setOdunc_tarihi(Date odunc_tarihi) {
        this.odunc_tarihi = odunc_tarihi;
    }
    
    
    
    
    public void oduncVer(int kitapİd,int oduncİd,int kullaniciİd,int Stokid){
        
        Baglanti bag = new Baglanti();
        bag.baglanti();
        
        String sql1 = "update kutuphane_stok set status=1 where  kitap_id='" + kitapİd + "'";
        String sql2 = "insert into odunc (odunc_id,uye_id,stok_id) values ('" + oduncİd + "','" + kullaniciİd + "','" + Stokid + "') ";
       

        try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null, "Güncelleme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Güncelleme Başarısız");
            System.out.println(e.toString());

        }
        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql2);
            JOptionPane.showMessageDialog(null, "Ödünç işlemi Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ödünç İşlemi Başarısız");
            System.out.println(e.toString());

        }
        
        
    }
    
    public void kitapAl(int stokid){
        
        
        Baglanti bag = new Baglanti();
        bag.baglanti();
        
         String sql1 = "update kutuphane_stok set status=0 where  stok_id='" + stokid + "'";
         String sql2 = "DELETE from odunc where stok_id='" + stokid + "'";
         
         try {
            Statement sta = bag.c.createStatement();
            sta.executeUpdate(sql1);
            JOptionPane.showMessageDialog(null, "Güncelleme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Güncelleme Başarısız");
            System.out.println(e.toString());

        }
        try {
            Statement sta = bag.c.createStatement();
            sta.execute(sql2);
            JOptionPane.showMessageDialog(null, "Ödünç Geri Verme Başarılı");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ödünç Geri Verme Başarısız");
            System.out.println(e.toString());

        }
        bag.bagKapat();
        
        
    }
    
    
}
