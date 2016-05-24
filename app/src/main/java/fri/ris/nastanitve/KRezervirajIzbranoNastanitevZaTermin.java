/***********************************************************************
 * Module:  KRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class KRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/

package fri.ris.nastanitve;

import java.util.*;

public class KRezervirajIzbranoNastanitevZaTermin {
   public Collection<Termin> termin;
   public KPlacajRezervacijo kPlacajRezervacijo;
   public SVSistemNastanitevRezervacijTerminov_SIM sVSistemNastanitevRezervacijTerminovSIM;
   
   public String VrniSeznamProstihTerminov() {
      // TODO: implement
      return null;
   }
   
   public int VrniPodrobnostiONastanitviZaTermin() {
      // TODO: implement
      return 0;
   }
   
   public int ZaključiRezervacijo() {
      // TODO: implement
      return 0;
   }
   
   public int IzračunajCeno() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public Collection<Termin> getTermin() {
      if (termin == null)
         termin = new HashSet<Termin>();
      return termin;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTermin() {
      if (termin == null)
         termin = new HashSet<Termin>();
      return termin.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTermin */
   public void setTermin(Collection<Termin> newTermin) {
      removeAllTermin();
      for (Iterator iter = newTermin.iterator(); iter.hasNext();)
         addTermin((Termin)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTermin */
   public void addTermin(Termin newTermin) {
      if (newTermin == null)
         return;
      if (this.termin == null)
         this.termin = new HashSet<Termin>();
      if (!this.termin.contains(newTermin))
         this.termin.add(newTermin);
   }
   
   /** @pdGenerated default remove
     * @param oldTermin */
   public void removeTermin(Termin oldTermin) {
      if (oldTermin == null)
         return;
      if (this.termin != null)
         if (this.termin.contains(oldTermin))
            this.termin.remove(oldTermin);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTermin() {
      if (termin != null)
         termin.clear();
   }

}