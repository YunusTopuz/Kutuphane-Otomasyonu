/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.classlar;

import aa.Formlar.AdminAnaSayfasi;
import aa.Formlar.AdminSayfasi;
public class singleton {
    
  private static singleton s=new singleton();
   
     
    private singleton() {
   }

   public static singleton nesneAl() {
      return s;
   }

   public String getAdminAd() {
      return "Yunus" ;
   }
  
}

