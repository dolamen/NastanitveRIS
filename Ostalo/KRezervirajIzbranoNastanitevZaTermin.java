/***********************************************************************
 * Module:  KRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class KRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/

package RezervirajNastanitevZaIzbranTermin;

import java.util.*;

public class KRezervirajIzbranoNastanitevZaTermin {
   public Nastanitev nastanitev;
   public KPlacajRezervacijo kPlacajRezervacijo;
   public SVSistemNastanitevRezervacijTerminov sVSistemNastanitevRezervacijTerminov;
   
   public Termin[] vrniSeznamProstihTerminov() {
      // TODO: implement
      return null;
   }
   
   /** @param termin */
   public String[] vrniPodrobnostiONastanitviZaTermin(Termin termin) {
      // TODO: implement
      return null;
   }
   
   /** @param idTermina */
   public void zakljuciRezervacijo(int idTermina) {
      // TODO: implement
   }
   
   /** @param termin */
   public double izracunajCeno(Termin termin) {
      // TODO: implement
      return 0;
   }
   
   /** @param stKreditne 
    * @param ime 
    * @param priimek 
    * @param varnostnaKoda */
   public boolean izvediPlacilo(java.lang.String stKreditne, java.lang.String ime, java.lang.String priimek, int varnostnaKoda) {
      // TODO: implement
      return false;
   }
   
   
   /** @pdGenerated default parent getter */
   public Nastanitev getNastanitev() {
      return nastanitev;
   }
   
   /** @pdGenerated default parent setter
     * @param newNastanitev */
   public void setNastanitev(Nastanitev newNastanitev) {
      this.nastanitev = newNastanitev;
   }
   /** @pdGenerated default parent getter */
   public KPlacajRezervacijo getKPlacajRezervacijo() {
      return kPlacajRezervacijo;
   }
   
   /** @pdGenerated default parent setter
     * @param newKPlacajRezervacijo */
   public void setKPlacajRezervacijo(KPlacajRezervacijo newKPlacajRezervacijo) {
      this.kPlacajRezervacijo = newKPlacajRezervacijo;
   }
   /** @pdGenerated default parent getter */
   public SVSistemNastanitevRezervacijTerminov getSVSistemNastanitevRezervacijTerminov() {
      return sVSistemNastanitevRezervacijTerminov;
   }
   
   /** @pdGenerated default parent setter
     * @param newSVSistemNastanitevRezervacijTerminov */
   public void setSVSistemNastanitevRezervacijTerminov(SVSistemNastanitevRezervacijTerminov newSVSistemNastanitevRezervacijTerminov) {
      this.sVSistemNastanitevRezervacijTerminov = newSVSistemNastanitevRezervacijTerminov;
   }

}