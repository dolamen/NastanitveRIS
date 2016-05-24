/***********************************************************************
 * Module:  Nastanitev.java
 * Author:  Domen
 * Purpose: Defines the Class Nastanitev
 ***********************************************************************/

package fri.ris.nastanitve;

import java.util.*;

public class Nastanitev {
    private int ID;
    private String Kraj;
    private String Naslov;
    private String Drzava;
    private int Kapaciteta;
    private double Cena;
    private String Opis;
    private Termin[] termini;

    public Termin termin;

    public Nastanitev(int ID, String kraj, String naslov, String drzava, int kapaciteta, double cena, String opis) {
        this.ID = ID;
        Kraj = kraj;
        Naslov = naslov;
        Drzava = drzava;
        Kapaciteta = kapaciteta;
        Cena = cena;
        Opis = opis;
    }

    public Termin[] VrniSeznamProstihTerminov() {
        // TODO: implement
        return null;
    }

    /**
     * @param idTermina
     */
    public Nastanitev VrniPodrobnostiONastanitviZaTermin(int idTermina) {
        // TODO: implement
        return null;
    }

    /**
     * @param idTermina
     */
    public boolean OznaciTerminKotZaseden(int idTermina) {
        // TODO: implement
        return false;
    }


    /**
     * @pdGenerated default parent getter
     */
    public Termin getTermin() {
        return termin;
    }

    /**
     * @param newTermin
     * @pdGenerated default parent setter
     */
    public void setTermin(Termin newTermin) {
        if (this.termin == null || !this.termin.equals(newTermin)) {
            if (this.termin != null) {
                Termin oldTermin = this.termin;
                this.termin = null;
                oldTermin.removeNastanitev(this);
            }
            if (newTermin != null) {
                this.termin = newTermin;
                this.termin.addNastanitev(this);
            }
        }
    }

    public int getID() {
        return ID;
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

    public double getCena() {
        return Cena;
    }

    public String getOpis() {
        return Opis;
    }

    public Termin[] getTermini() {
        return termini;
    }


}