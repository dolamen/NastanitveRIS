package fri.ris.nastanitve.models;

/***********************************************************************
 * Module:  KRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class KRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/


public class KRezervirajIzbranoNastanitevZaTermin {
    public Nastanitev nastanitev;
    public KPlacajRezervacijo kPlacajRezervacijo = new KPlacajRezervacijo();
    public SVSistemNastanitevRezervacijTerminov_SIM sVSistemNastanitevRezervacijTerminov = new SVSistemNastanitevRezervacijTerminov_SIM();

    public Termin[] vrniSeznamProstihTerminov() {
        return sVSistemNastanitevRezervacijTerminov.pridobiTermineZaNastanitev(nastanitev);
    }

    /**
     * @param termin
     */
    public String[] vrniPodrobnostiONastanitviZaTermin(Termin termin) {
        return nastanitev.vrniPodrobnostiONastanitviZaTermin(termin.getIdTermina());
    }

    /**
     * @param stKreditne
     * @param ime
     * @param priimek
     * @param varnostnaKoda
     */
    public boolean izvediPlacilo(java.lang.String stKreditne, java.lang.String ime, java.lang.String priimek, int varnostnaKoda) {
        return kPlacajRezervacijo.IzvediTransakcijo(stKreditne, ime, priimek, varnostnaKoda);
    }

    /**
     * @param idTermina
     */
    public void zakljuciRezervacijo(int idTermina) {
        nastanitev.oznaciIzbranTerminKotZaseden(idTermina);
        sVSistemNastanitevRezervacijTerminov.posodobiStatusTermina(idTermina, true);
    }

    /**
     * @param termin
     */
    public double izracunajCeno(Termin termin) {
        return nastanitev.getCena() * termin.vrniDolzinoVDneh();
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
        this.nastanitev = newNastanitev;
    }

    /**
     * @pdGenerated default parent getter
     */
    public KPlacajRezervacijo getKPlacajRezervacijo() {
        return kPlacajRezervacijo;
    }

    /**
     * @param newKPlacajRezervacijo
     * @pdGenerated default parent setter
     */
    public void setKPlacajRezervacijo(KPlacajRezervacijo newKPlacajRezervacijo) {
        this.kPlacajRezervacijo = newKPlacajRezervacijo;
    }

    /**
     * @pdGenerated default parent getter
     */
    public SVSistemNastanitevRezervacijTerminov_SIM getSVSistemNastanitevRezervacijTerminov() {
        return sVSistemNastanitevRezervacijTerminov;
    }

    /**
     * @param newSVSistemNastanitevRezervacijTerminov
     * @pdGenerated default parent setter
     */
    public void setSVSistemNastanitevRezervacijTerminov(SVSistemNastanitevRezervacijTerminov_SIM newSVSistemNastanitevRezervacijTerminov) {
        this.sVSistemNastanitevRezervacijTerminov = newSVSistemNastanitevRezervacijTerminov;
    }


}