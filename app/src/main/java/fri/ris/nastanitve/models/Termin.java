/***********************************************************************
 * Module:  Termin.java
 * Author:  Domen
 * Purpose: Defines the Class Termin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import java.util.*;

public class Termin {
   private int ID;
   private Date ZacetniDatum;
   private Date KoncniDatum;
   
   public Collection<Nastanitev> nastanitev;
   
   public Termin[] VrniSeznamProstihTerminov() {
      // TODO: implement
      return null;
   }
   
   public int VrniPodrobnostiONastanitviZaTermin() {
      // TODO: implement
      return 0;
   }
   
   public int OznaciTerminKotZaseden() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public Collection<Nastanitev> getNastanitev() {
      if (nastanitev == null)
         nastanitev = new HashSet<Nastanitev>();
      return nastanitev;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorNastanitev() {
      if (nastanitev == null)
         nastanitev = new HashSet<Nastanitev>();
      return nastanitev.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNastanitev */
   public void setNastanitev(Collection<Nastanitev> newNastanitev) {
      removeAllNastanitev();
      for (Iterator iter = newNastanitev.iterator(); iter.hasNext();)
         addNastanitev((Nastanitev)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNastanitev */
   public void addNastanitev(Nastanitev newNastanitev) {
      if (newNastanitev == null)
         return;
      if (this.nastanitev == null)
         this.nastanitev = new HashSet<Nastanitev>();
      if (!this.nastanitev.contains(newNastanitev))
      {
         this.nastanitev.add(newNastanitev);
         newNastanitev.setTermin(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldNastanitev */
   public void removeNastanitev(Nastanitev oldNastanitev) {
      if (oldNastanitev == null)
         return;
      if (this.nastanitev != null)
         if (this.nastanitev.contains(oldNastanitev))
         {
            this.nastanitev.remove(oldNastanitev);
            oldNastanitev.setTermin((Termin)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNastanitev() {
      if (nastanitev != null)
      {
         Nastanitev oldNastanitev;
         for (Iterator iter = getIteratorNastanitev(); iter.hasNext();)
         {
            oldNastanitev = (Nastanitev)iter.next();
            iter.remove();
            oldNastanitev.setTermin((Termin)null);
         }
      }
   }

}