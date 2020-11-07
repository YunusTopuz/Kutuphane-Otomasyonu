package aa.classlar;

import aa.Formlar.Baglantı.Baglanti;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Sureli extends Kutuphane {

    private int sureli_id;
    private int sayi;
    private int editor_id;

    public Sureli() {
    }

    public Sureli(int sureli_id, int sayi, int editor_id) {
        this.sureli_id = sureli_id;
        this.sayi = sayi;
        this.editor_id = editor_id;
    }

    public Sureli(int sureli_id, int sayi, int editor_id, int kitap_id, String kitap_adi, int sayfa_sayisi, int basim_tarihi, int yayinevi_id) {
        super(kitap_id, kitap_adi, sayfa_sayisi, basim_tarihi, yayinevi_id);
        this.sureli_id = sureli_id;
        this.sayi = sayi;
        this.editor_id = editor_id;
    }

    public int getSureli_id() {
        return sureli_id;
    }

    public void setSureli_id(int sureli_id) {
        this.sureli_id = sureli_id;
    }

    public int getSayi() {
        return sayi;
    }

    public void setSayi(int sayi) {
        this.sayi = sayi;
    }

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    @Override
    public void kitapEkle(int sureliid, int editorid, int sayi, int kitapid, String kitapadi, int sayfa, int basim, int yayineviid, int stokid, int status, int barcode) {

        Baglanti bag = new Baglanti();
        bag.baglanti();

        String sql1 = "INSERT INTO kutuphane values ('" + kitapid + "','" + kitapadi + "','" + sayfa + "','" + basim + "','" + yayineviid + "')";
        String sql2 = "INSERT INTO sureli values ('" + sureliid + "','" + sayi + "','" + editorid + "','" + kitapid + "')";
        String sql3 = "insert into kutuphane_stok values('" + stokid + "','" + kitapid + "','" + barcode + "','" + status + "')";
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
        String sql2 = "DELETE from sureli where kitap_id='" + id + "'";
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

}
