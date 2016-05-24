/***********************************************************************
 * Module:  SVSistemNastanitevRezervacijTerminov_SIM.java
 * Author:  Domen
 * Purpose: Defines the Class SVSistemNastanitevRezervacijTerminov_SIM
 ***********************************************************************/

package fri.ris.nastanitve.models;


import java.util.ArrayList;
import java.util.Date;

public class SVSistemNastanitevRezervacijTerminov_SIM {
    public Termin[] PridobiTermineZaNastanitev(Nastanitev nastanitev) {
        Termin[] termini = new Termin[5];

        termini[0] = new Termin(new Date(1468144800000L), new Date(1468317600000L), false, nastanitev);
        termini[1] = new Termin(new Date(1468490400000L), new Date(1468767600000L), false, nastanitev);
        termini[2] = new Termin(new Date(1470409200000L), new Date(1470740400000L), false, nastanitev);
        termini[3] = new Termin(new Date(1471694400000L), new Date(1472558400000L), false, nastanitev);
        termini[4] = new Termin(new Date(1472731200000L), new Date(1473076800000L), false, nastanitev);
        return termini;
    }

    /**
     * @param idTermina
     * @param jeZaseden
     */
    public boolean PosodobiStatusTermina(int idTermina, boolean jeZaseden) {
        // TODO: implement
        return false;
    }

}