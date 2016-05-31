/***********************************************************************
 * Module:  KPlacajRezervacijo.java
 * Author:  Domen
 * Purpose: Defines the Class KPlacajRezervacijo
 ***********************************************************************/

package fri.ris.nastanitve.models;

public class KPlacajRezervacijo {

    /**
     * @param stKreditne
     * @param ime
     * @param priimek
     * @param varnostnaKoda
     */
    public boolean IzvediTransakcijo(String stKreditne, String ime, String priimek, int varnostnaKoda) {
        if (stKreditne.equals("123456789") || varnostnaKoda == 0) {
            return false;
        }
        return true;
    }

}