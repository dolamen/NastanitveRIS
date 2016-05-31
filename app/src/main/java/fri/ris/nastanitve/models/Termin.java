/***********************************************************************
 * Module:  Termin.java
 * Author:  Domen
 * Purpose: Defines the Class Termin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Termin {
    private int IdTermina;
    private java.util.Date ZacetniDatum;
    private java.util.Date KoncniDatum;
    private boolean zaseden = false;

    public Nastanitev nastanitev;

    public java.lang.String VrniPodrobnostiOTerminu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm", new Locale("sl_SI"));
        return sdf.format(ZacetniDatum) + " - " + sdf.format(KoncniDatum);
    }

    public boolean OznaciTerminKotZaseden() {
        zaseden = true;
        return true;
    }

    public Termin(int idTermina, Date zacetniDatum, Date koncniDatum) {
        IdTermina = idTermina;
        ZacetniDatum = zacetniDatum;
        KoncniDatum = koncniDatum;
    }

    /**
     * @pdGenerated default parent getter
     */
    public Nastanitev getNastanitev() {
        return nastanitev;
    }

    /**
     * @param newNastanitev
     * @pdGenerated default parent setter
     */
    public void setNastanitev(Nastanitev newNastanitev) {
        if (this.nastanitev == null || !this.nastanitev.equals(newNastanitev)) {
            if (this.nastanitev != null) {
                Nastanitev oldNastanitev = this.nastanitev;
                this.nastanitev = null;
                oldNastanitev.removeTermin(this);
            }
            if (newNastanitev != null) {
                this.nastanitev = newNastanitev;
                this.nastanitev.addTermin(this);
            }
        }
    }


    public Date getZacetniDatum() {
        return ZacetniDatum;
    }

    public Date getKoncniDatum() {
        return KoncniDatum;
    }

    public int getIdTermina() {
        return IdTermina;
    }

    public boolean isZaseden() {
        return zaseden;
    }

}