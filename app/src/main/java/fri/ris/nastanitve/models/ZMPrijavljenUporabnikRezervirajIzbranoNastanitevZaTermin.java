/***********************************************************************
 * Module:  ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import fri.ris.nastanitve.R;

public class ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin extends AppCompatActivity {
    public KRezervirajIzbranoNastanitevZaTermin kRezervirajIzbranoNastanitevZaTermin;

    private ListView listView;
    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setDisplayedChild(0);

        kRezervirajIzbranoNastanitevZaTermin = new KRezervirajIzbranoNastanitevZaTermin();

        Nastanitev izbranaNastanitev = new Nastanitev("Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Zelo prostorno stanovanje s kavčem in TV + Wi-Fi.");
        Termin[] termins = PricniRezervacijo(izbranaNastanitev);
        izbranaNastanitev.setTermin(Arrays.asList(termins));
        IzberiTermin(izbranaNastanitev);

    }

    /**
     * @param izbranaNastanitev
     */
    public Termin[] PricniRezervacijo(Nastanitev izbranaNastanitev) {
        Termin[] termini = kRezervirajIzbranoNastanitevZaTermin.VrniSeznamProstihTerminov(izbranaNastanitev);

        String[] content = new String[termini.length];
        for (int i = 0; i < termini.length; i++) {
            content[i] = termini[i].VrniPodrobnostiOTerminu();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, content);
        listView.setAdapter(adapter);
        return termini;
    }

    /**
     * @param nastanitev
     */
    public void IzberiTermin(final Nastanitev nastanitev) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PrikažePodrobnostiONastanitviZaTermin(nastanitev, nastanitev.getTermin().get(position));
            }
        });
    }

    /**
     * @param nastanitev
     * @param termin
     */
    public void PrikažePodrobnostiONastanitviZaTermin(final Nastanitev nastanitev, final Termin termin) {
        viewFlipper.setDisplayedChild(1);

        TextView naslovText = (TextView) findViewById(R.id.podrobnosti_naslov);
        naslovText.setText(nastanitev.getNaslov() + ", " + nastanitev.getKraj() + ", " + nastanitev.getDrzava());

        TextView kapacitetaText = (TextView) findViewById(R.id.podrobnosti_kapaciteta);
        kapacitetaText.setText("Kapaciteta: " + nastanitev.getKapaciteta());

        TextView opisText = (TextView) findViewById(R.id.podrobnosti_opis);
        opisText.setText(nastanitev.getOpis());

        TextView terminText = (TextView) findViewById(R.id.termin_podrobnosti_text_view);
        terminText.setText(termin.VrniPodrobnostiOTerminu());
        TextView cenaText = (TextView) findViewById(R.id.podrobnosti_cena);
        cenaText.setText("Cena: " + nastanitev.getCena() + "€ / noč");
        Button rezerviraj = (Button) findViewById(R.id.rezerviraj_button);
        Button nazaj = (Button) findViewById(R.id.nazaj_button);
        rezerviraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VnesiImeInKK(nastanitev, termin);
            }
        });
        nazaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(0);
            }
        });
    }

    public void VnesiImeInKK(Nastanitev nastanitev, Termin termin) {
        viewFlipper.setDisplayedChild(2);

        TextView cenaText = (TextView) findViewById(R.id.cena);
        cenaText.setText("Za plačilo: " + String.valueOf(nastanitev.getCena() * TimeUnit.MILLISECONDS.toDays(termin.getKoncniDatum().getTime() - termin.getZacetniDatum().getTime())) + "€");

        Button nazaj = (Button) findViewById(R.id.placaj_nazaj_button);
        nazaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(1);
            }
        });

        Button placaj = (Button) findViewById(R.id.placaj_button);
        placaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ime = (EditText) findViewById(R.id.ime_edit);
                EditText kk = (EditText) findViewById(R.id.kk_edit);

                if(!ime.getText().toString().trim().isEmpty() && !kk.getText().toString().trim().isEmpty()){

                }else{
                    Toast.makeText(ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin.this, "Preveri podatke!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public String PrikaziSporociloOUspesniRezervaciji() {
        // TODO: implement
        return null;
    }

    public String VrniSporociloONapaki() {
        // TODO: implement
        return null;
    }

}