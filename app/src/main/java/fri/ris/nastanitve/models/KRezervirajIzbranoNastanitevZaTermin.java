package fri.ris.nastanitve.models;

import java.util.concurrent.TimeUnit;

/***********************************************************************
 * Module:  KRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class KRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/


public class KRezervirajIzbranoNastanitevZaTermin {
    public java.util.Collection<Nastanitev> nastanitev;
    public KPlacajRezervacijo kPlacajRezervacijo = new KPlacajRezervacijo();
    public SVSistemNastanitevRezervacijTerminov_SIM sVSistemNastanitevRezervacijTerminov = new SVSistemNastanitevRezervacijTerminov_SIM();

    /**
     * @param nastanitev
     */
    public Termin[] VrniSeznamProstihTerminov(Nastanitev nastanitev) {
        return sVSistemNastanitevRezervacijTerminov.PridobiTermineZaNastanitev(nastanitev);
    }

    public int VrniPodrobnostiONastanitviZaTermin() {
        // TODO: implement
        return 0;
    }

    public int ZaključiRezervacijo() {
        // TODO: implement
        return 0;
    }

    public double IzračunajCeno(Nastanitev nastanitev, Termin termin) {
        return nastanitev.getCena() * TimeUnit.MILLISECONDS.toDays(termin.getKoncniDatum().getTime() - termin.getZacetniDatum().getTime());
    }


    /**
     * @pdGenerated default getter
     */
    public java.util.Collection<Nastanitev> getNastanitev() {
        if (nastanitev == null)
            nastanitev = new java.util.HashSet<Nastanitev>();
        return nastanitev;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorNastanitev() {
        if (nastanitev == null)
            nastanitev = new java.util.HashSet<Nastanitev>();
        return nastanitev.iterator();
    }

    /**
     * @param newNastanitev
     * @pdGenerated default setter
     */
    public void setNastanitev(java.util.Collection<Nastanitev> newNastanitev) {
        removeAllNastanitev();
        for (java.util.Iterator iter = newNastanitev.iterator(); iter.hasNext(); )
            addNastanitev((Nastanitev) iter.next());
    }

    /**
     * @param newNastanitev
     * @pdGenerated default add
     */
    public void addNastanitev(Nastanitev newNastanitev) {
        if (newNastanitev == null)
            return;
        if (this.nastanitev == null)
            this.nastanitev = new java.util.HashSet<Nastanitev>();
        if (!this.nastanitev.contains(newNastanitev))
            this.nastanitev.add(newNastanitev);
    }

    /**
     * @param oldNastanitev
     * @pdGenerated default remove
     */
    public void removeNastanitev(Nastanitev oldNastanitev) {
        if (oldNastanitev == null)
            return;
        if (this.nastanitev != null)
            if (this.nastanitev.contains(oldNastanitev))
                this.nastanitev.remove(oldNastanitev);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllNastanitev() {
        if (nastanitev != null)
            nastanitev.clear();
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