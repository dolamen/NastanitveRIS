/***********************************************************************
 * Module:  SVSistemNastanitevRezervacijTerminov_SIM.java
 * Author:  Domen
 * Purpose: Defines the Class SVSistemNastanitevRezervacijTerminov_SIM
 ***********************************************************************/

package fri.ris.nastanitve.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SVSistemNastanitevRezervacijTerminov_SIM {

    Termin[] termini = new Termin[]{
            new Termin(0, new Date(1468144800000L), new Date(1468317600000L)),
            new Termin(1, new Date(1468490400000L), new Date(1468767600000L)),
            new Termin(2, new Date(1470409200000L), new Date(1470740400000L)),
            new Termin(3, new Date(1471694400000L), new Date(1472558400000L)),
            new Termin(4, new Date(1472731200000L), new Date(1473076800000L)),
    };

    public Termin[] PridobiTermineZaNastanitev(Nastanitev nastanitev) {
        List<Termin> termini = new ArrayList<>();
        for (Termin t : this.termini) {
            if (!t.isZaseden()) {
                t.setNastanitev(nastanitev);
                termini.add(t);
            }
        }
        return termini.toArray(new Termin[termini.size()]);
    }

    /**
     * @param idTermina
     * @param jeZaseden
     */
    public boolean PosodobiStatusTermina(int idTermina, boolean jeZaseden) {
        return termini[idTermina].OznaciTerminKotZaseden();
    }

}