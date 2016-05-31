/***********************************************************************
 * Module:  Termin.java
 * Author:  Domen
 * Purpose: Defines the Class Termin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Termin {
    private int IdTermina;
    private java.util.Date ZacetniDatum;
    private java.util.Date KoncniDatum;
    private boolean zaseden = false;

    public java.lang.String vrniPodrobnostiOTerminu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm", new Locale("sl_SI"));
        return sdf.format(ZacetniDatum) + " - " + sdf.format(KoncniDatum);
    }

    public int vrniDolzinoVDneh() {
        return (int) TimeUnit.MILLISECONDS.toDays(KoncniDatum.getTime() - ZacetniDatum.getTime());
    }

    public void oznaciTerminKotZaseden() {
        zaseden = true;
    }

    public Termin(int idTermina, Date zacetniDatum, Date koncniDatum) {
        IdTermina = idTermina;
        ZacetniDatum = zacetniDatum;
        KoncniDatum = koncniDatum;
    }

    public int getIdTermina() {
        return IdTermina;
    }

    public boolean isZaseden() {
        return zaseden;
    }

}