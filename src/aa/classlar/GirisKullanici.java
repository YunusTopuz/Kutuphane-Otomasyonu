/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.classlar;

import aa.Formlar.AdminAnaSayfasi;
import aa.Formlar.Baglantı.Baglanti;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author idea
 */
public class GirisKullanici {
    
    public void giris(String name,String namebox){
        
        if (namebox.equals(name)) {

            Baglanti bag = new Baglanti();
            bag.baglanti();
            try {
                Statement st = bag.c.createStatement();
                ResultSet rs = st.executeQuery("select * from uye");
                while (rs.next()) {
                    if (rs.getInt("adminlik") == 1) {
                        if (rs.getInt("adminlik") == 1) {
                            AdminAnaSayfasi ans = new AdminAnaSayfasi();
                            ans.setVisible(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Yanlis Kullanici Adi veya Sifre");
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Giris Basarisiz");
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Basarisiz");
        }

    
    }
    
}
