/***********************************************************************
 * Module:  ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin.java
 * Author:  Domen
 * Purpose: Defines the Class ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin
 ***********************************************************************/

package fri.ris.nastanitve.models;

import android.os.Bundle;
import android.os.Handler;
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

import java.util.Arrays;
import java.util.Locale;

import fri.ris.nastanitve.R;

public class ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin extends AppCompatActivity {
    public KRezervirajIzbranoNastanitevZaTermin kRezervirajIzbranoNastanitevZaTermin;

    private ListView listView;
    private ViewFlipper viewFlipper;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        kRezervirajIzbranoNastanitevZaTermin = new KRezervirajIzbranoNastanitevZaTermin();

        Nastanitev izbranaNastanitev = new Nastanitev("Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Zelo prostorno stanovanje s kavčem in TV + Wi-Fi. Živali dovoljene!");

        Termin[] termins = PricniRezervacijo(izbranaNastanitev);
        izbranaNastanitev.setTermin(Arrays.asList(termins));
        IzberiTermin(izbranaNastanitev);
    }

    /**
     * @param izbranaNastanitev
     */
    public Termin[] PricniRezervacijo(Nastanitev izbranaNastanitev) {
        viewFlipper.setDisplayedChild(0);
        Termin[] termini = kRezervirajIzbranoNastanitevZaTermin.VrniSeznamProstihTerminov(izbranaNastanitev);

        // fill list view adapter
        String[] content = new String[termini.length];
        for (int i = 0; i < termini.length; i++) {
            content[i] = termini[i].VrniPodrobnostiOTerminu();
        }

        adapter = new ArrayAdapter<>(this,
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
                PrikaziPodrobnostiONastanitviZaTermin(nastanitev, nastanitev.getTermin().get(position));
            }
        });
    }

    /**
     * @param nastanitev
     * @param termin
     */
    public void PrikaziPodrobnostiONastanitviZaTermin(final Nastanitev nastanitev, final Termin termin) {
        viewFlipper.setDisplayedChild(1);

        TextView naslovText = (TextView) findViewById(R.id.podrobnosti_naslov);
        if (naslovText != null) {
            naslovText.setText(String.format(Locale.GERMAN, "%s, %s, %s", nastanitev.getNaslov(), nastanitev.getKraj(), nastanitev.getDrzava()));
        }

        TextView kapacitetaText = (TextView) findViewById(R.id.podrobnosti_kapaciteta);
        if (kapacitetaText != null) {
            kapacitetaText.setText(String.format(Locale.GERMAN, "Kapaciteta: %d", nastanitev.getKapaciteta()));
        }

        TextView opisText = (TextView) findViewById(R.id.podrobnosti_opis);
        if (opisText != null) {
            opisText.setText(nastanitev.getOpis());
        }

        TextView terminText = (TextView) findViewById(R.id.termin_podrobnosti_text_view);
        if (terminText != null) {
            terminText.setText(termin.VrniPodrobnostiOTerminu());
        }
        TextView cenaText = (TextView) findViewById(R.id.podrobnosti_cena);
        if (cenaText != null) {
            cenaText.setText(String.format(Locale.GERMAN, "Cena: %.2f€ / noč", nastanitev.getCena()));
        }
        Button rezerviraj = (Button) findViewById(R.id.rezerviraj_button);
        Button nazaj = (Button) findViewById(R.id.nazaj_button);
        if (rezerviraj != null) {
            rezerviraj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VnesiImeInKK(nastanitev, termin);
                }
            });
        }
        if (nazaj != null) {
            nazaj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(0);
                }
            });
        }
    }

    public void VnesiImeInKK(final Nastanitev nastanitev, final Termin termin) {
        viewFlipper.setDisplayedChild(2);

        TextView cenaText = (TextView) findViewById(R.id.cena);
        if (cenaText != null)
            cenaText.setText(String.format(Locale.GERMAN, "Za plačilo: %.2f€", kRezervirajIzbranoNastanitevZaTermin.IzračunajCeno(nastanitev, termin)));

        final EditText ime = (EditText) findViewById(R.id.ime_edit);
        final EditText kk = (EditText) findViewById(R.id.kk_edit);
        final EditText primek = (EditText) findViewById(R.id.priimek_edit);
        final EditText naslov = (EditText) findViewById(R.id.naslov_edit);

        Button nazaj = (Button) findViewById(R.id.placaj_nazaj_button);
        if (nazaj != null) {
            nazaj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(1);
                }
            });
        }

        Button placaj = (Button) findViewById(R.id.placaj_button);
        if (placaj != null) {
            placaj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!(ime != null && ime.getText().toString().trim().isEmpty()) && !(primek != null && primek.getText().toString().trim().isEmpty()) && !(kk != null && kk.getText().toString().trim().isEmpty()) && !(naslov != null && naslov.getText().toString().trim().isEmpty())) {
                        TextView summary = (TextView) findViewById(R.id.summary);
                        if (summary != null) {
                            summary.setText(String.format(Locale.GERMAN, "Znesek: %.2f€\nKreditna kartica: %s\nLastnik: %s %s\nNaslov plačnika: %s\n\nPlačilo bo izvedeno ob kliku na gumb 'Izvedi plačilo.'",
                                    kRezervirajIzbranoNastanitevZaTermin.IzračunajCeno(nastanitev, termin),
                                    kk != null ? kk.getText().toString() : "",
                                    ime != null ? ime.getText().toString() : "",
                                    primek != null ? primek.getText().toString() : "",
                                    naslov != null ? naslov.getText().toString() : ""));
                        }
                        viewFlipper.setDisplayedChild(3);
                    } else {
                        Toast.makeText(ZMPrijavljenUporabnikRezervirajIzbranoNastanitevZaTermin.this, "Preveri podatke!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        Button izvediPlacilo_nazaj = (Button) findViewById(R.id.izvedi_placilo_nazaj_button);
        if (izvediPlacilo_nazaj != null) {
            izvediPlacilo_nazaj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(2);
                }
            });
        }

        Button izvediPlacilo = (Button) findViewById(R.id.izvedi_placilo__button);
        if (izvediPlacilo != null) {
            izvediPlacilo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewFlipper.setDisplayedChild(4);

                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            kRezervirajIzbranoNastanitevZaTermin.sVSistemNastanitevRezervacijTerminov.PosodobiStatusTermina(termin.getIdTermina(), true);
                            PrikaziSporociloOUspesniRezervaciji();
                        }
                    }, 3000);
                }
            });
        }


    }

    public String PrikaziSporociloOUspesniRezervaciji() {
        viewFlipper.setDisplayedChild(5);
        Button home = (Button) findViewById(R.id.home__button);
        if (home != null) {
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Nastanitev izbranaNastanitev = new Nastanitev("Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Zelo prostorno stanovanje s kavčem in TV + Wi-Fi. Živali dovoljene!");
                    Termin[] termins = PricniRezervacijo(izbranaNastanitev);
                    izbranaNastanitev.setTermin(Arrays.asList(termins));
                    IzberiTermin(izbranaNastanitev);
                }
            });
        }
        return null;
    }

    public String VrniSporociloONapaki() {
        viewFlipper.setDisplayedChild(6);
        return null;
    }

}