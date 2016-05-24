/***********************************************************************
 * Module:  Termin.java
 * Author:  Domen
 * Purpose: Defines the Class Termin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import java.security.cert.TrustAnchor;
import java.text.SimpleDateFormat;
import java.util.*;

public class Termin {
    private java.util.Date ZacetniDatum;
    private java.util.Date KoncniDatum;
    private boolean zaseden;

    public Nastanitev nastanitev;

    public java.lang.String VrniPodrobnostiOTerminu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm", new Locale("sl_SI"));
        return sdf.format(ZacetniDatum) + " - " + sdf.format(KoncniDatum);
    }

    public boolean OznaciTerminKotZaseden() {
        zaseden = true;
        return true;
    }

    public Termin(Date zacetniDatum, Date koncniDatum, boolean zaseden, Nastanitev nastanitev) {
        ZacetniDatum = zacetniDatum;
        KoncniDatum = koncniDatum;
        this.zaseden = zaseden;
        this.nastanitev = nastanitev;
    }

    /** @pdGenerated default parent getter */
    public Nastanitev getNastanitev() {
        return nastanitev;
    }

    /** @pdGenerated default parent setter
     * @param newNastanitev */
    public void setNastanitev(Nastanitev newNastanitev) {
        if (this.nastanitev == null || !this.nastanitev.equals(newNastanitev))
        {
            if (this.nastanitev != null)
            {
                Nastanitev oldNastanitev = this.nastanitev;
                this.nastanitev = null;
                oldNastanitev.removeTermin(this);
            }
            if (newNastanitev != null)
            {
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
}