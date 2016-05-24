/***********************************************************************
 * Module:  SVSistemNastanitevRezervacijTerminov_SIM.java
 * Author:  Domen
 * Purpose: Defines the Class SVSistemNastanitevRezervacijTerminov_SIM
 ***********************************************************************/

package fri.ris.nastanitve.models;

public class SVSistemNastanitevRezervacijTerminov_SIM {

   public Nastanitev[] PridobiNastanitve() {
      Nastanitev[] nastanitve = new Nastanitev[5];
      for (int i = 0; i < 5; i++) {
         Nastanitev nastanitev = new Nastanitev(i, "Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Very nice room.");

      }
      return null;
   }
   
   /** @param idTermina 
    * @param jeZaseden */
   public boolean PosodobiStatusTermina(int idTermina, boolean jeZaseden) {
      // TODO: implement
      return false;
   }

}