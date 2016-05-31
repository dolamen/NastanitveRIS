/***********************************************************************
 * Module:  Nastanitev.java
 * Author:  Domen
 * Purpose: Defines the Class Nastanitev
 ***********************************************************************/

package RezervirajNastanitevZaIzbranTermin;

import java.util.*;

public class Nastanitev {
   private String Kraj;
   private String Naslov;
   private String Drzava;
   private int Kapaciteta;
   private double Cena;
   private String Opis;
   
   public java.util.List<Termin> termin;
   
   public Termin[] vrniSeznamProstihTerminov() {
      // TODO: implement
      return 0;
   }
   
   /** @param idTermina */
   public java.lang.String[] vrniPodrobnostiONastanitviZaTermin(int idTermina) {
      // TODO: implement
      return null;
   }
   
   /** @param idTermina */
   public void oznaciIzbranTerminKotZaseden(int idTermina) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Termin> getTermin() {
      if (termin == null)
         termin = new java.util.ArrayList<Termin>();
      return termin;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTermin() {
      if (termin == null)
         termin = new java.util.ArrayList<Termin>();
      return termin.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTermin */
   public void setTermin(java.util.List<Termin> newTermin) {
      removeAllTermin();
      for (java.util.Iterator iter = newTermin.iterator(); iter.hasNext();)
         addTermin((Termin)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTermin */
   public void addTermin(Termin newTermin) {
      if (newTermin == null)
         return;
      if (this.termin == null)
         this.termin = new java.util.ArrayList<Termin>();
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