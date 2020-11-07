package aa.classlar;

import java.sql.Statement;
import javax.swing.JOptionPane;
import aa.Formlar.Baglantı.Baglanti;

public class Yayinevi {

    private int yayinevi_id;
    private String yayinevi_adi;
    private String iletisim;

    public Yayinevi() {
    }

    public Yayinevi(int yayinevi_id, String yayinevi_adi, String iletisim) {
        this.yayinevi_id = yayinevi_id;
        this.yayinevi_adi = yayinevi_adi;
        this.iletisim = iletisim;
    }

    public int getYayinevi_id() {
        return yayinevi_id;
    }

    public void setYayinevi_id(int yayinevi_id) {
        this.yayinevi_id = yayinevi_id;
    }

    public String getYayinevi_adi() {
        return yayinevi_adi;
    }

    public void setYayinevi_adi(String yayinevi_adi) {
        this.yayinevi_adi = yayinevi_adi;
    }

    public String getIletisim() {
        return iletisim;
    }

    public void setIletisim(String iletisim) {
        this.iletisim = iletisim;
    }

    public void YayineviEkle(int id, String ad, String mail) {

        Baglanti bag = new Baglanti();
        bag.baglanti();

        String sql = "INSERT INTO yayinevi values ('" + id + "','" + ad + "','" + mail + "')";

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

}
