package aa.classlar;

import aa.Formlar.Baglantı.Baglanti;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import kutuphane.Formlar.Baglantı.Baglanti;

public class Editor {
    private int editor_id;
    private String editor_adi;

    public Editor() {
    }

    public Editor(int editor_id, String editor_adi) {
        this.editor_id = editor_id;
        this.editor_adi = editor_adi;
    }

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    public String getEditor_adi() {
        return editor_adi;
    }

    public void setEditor_adi(String editor_adi) {
        this.editor_adi = editor_adi;
    }
    
    
    
    public void editorEkle(int id,String ad){
        
         Baglanti bag = new Baglanti();
        bag.baglanti();

        String sql = "INSERT INTO editor values ('" + id + "','" + ad + "')";

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
