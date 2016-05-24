/***********************************************************************
 * Module:  Nastanitev.java
 * Author:  Domen
 * Purpose: Defines the Class Nastanitev
 ***********************************************************************/

package fri.ris.nastanitve.models;

/***********************************************************************
 * Module:  Nastanitev.java
 * Author:  Domen
 * Purpose: Defines the Class Nastanitev
 ***********************************************************************/

public class Nastanitev {
    private String Kraj;
    private String Naslov;
    private String Drzava;
    private int Kapaciteta;
    private double Cena;
    private String Opis;

    public java.util.List<Termin> termin;

    public Nastanitev(String kraj, String naslov, String drzava, int kapaciteta, double cena, String opis) {
        Kraj = kraj;
        Naslov = naslov;
        Drzava = drzava;
        Kapaciteta = kapaciteta;
        Cena = cena;
        Opis = opis;
    }

    public Termin[] VrniSeznamProstihTerminov() {
        return termin.toArray(new Termin[termin.size()]);
    }

    /**
     * @param termin
     */
    public Nastanitev VrniPodrobnostiONastanitviZaTermin(Termin termin) {
        return this;
    }

    /**
     * @param idTermina
     */
    public boolean OznaciTerminKotZaseden(int idTermina) {
        return termin.get(idTermina).OznaciTerminKotZaseden();
    }


    /**
     * @pdGenerated default getter
     */
    public java.util.List<Termin> getTermin() {
        if (termin == null)
            termin = new java.util.ArrayList<Termin>();
        return termin;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorTermin() {
        if (termin == null)
            termin = new java.util.ArrayList<Termin>();
        return termin.iterator();
    }

    /**
     * @param newTermin
     * @pdGenerated default setter
     */
    public void setTermin(java.util.List<Termin> newTermin) {
        removeAllTermin();
        for (java.util.Iterator iter = newTermin.iterator(); iter.hasNext(); )
            addTermin((Termin) iter.next());
    }

    /**
     * @param newTermin
     * @pdGenerated default add
     */
    public void addTermin(Termin newTermin) {
        if (newTermin == null)
            return;
        if (this.termin == null)
            this.termin = new java.util.ArrayList<Termin>();
        if (!this.termin.contains(newTermin)) {
            this.termin.add(newTermin);
            newTermin.setNastanitev(this);
        }
    }

    /**
     * @param oldTermin
     * @pdGenerated default remove
     */
    public void removeTermin(Termin oldTermin) {
        if (oldTermin == null)
            return;
        if (this.termin != null)
            if (this.termin.contains(oldTermin)) {
                this.termin.remove(oldTermin);
                oldTermin.setNastanitev((Nastanitev) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllTermin() {
        if (termin != null) {
            Termin oldTermin;
            for (java.util.Iterator iter = getIteratorTermin(); iter.hasNext(); ) {
                oldTermin = (Termin) iter.next();
                iter.remove();
                oldTermin.setNastanitev((Nastanitev) null);
            }
        }
    }

    public double getCena() {
        return Cena;
    }

    public String getKraj() {
        return Kraj;
    }

    public String getNaslov() {
        return Naslov;
    }

    public String getDrzava() {
        return Drzava;
    }

    public int getKapaciteta() {
        return Kapaciteta;
    }

    public String getOpis() {
        return Opis;
    }
}