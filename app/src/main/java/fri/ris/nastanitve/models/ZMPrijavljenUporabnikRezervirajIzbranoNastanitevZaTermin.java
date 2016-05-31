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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        Nastanitev izbranaNastanitev = new Nastanitev("Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Zelo prostorno stanovanje s kavčem in TV + Wi-Fi. Živali dovoljene!");
        kRezervirajIzbranoNastanitevZaTermin = new KRezervirajIzbranoNastanitevZaTermin();
        kRezervirajIzbranoNastanitevZaTermin.setNastanitev(izbranaNastanitev);

        Termin[] termins = PricniRezervacijo(izbranaNastanitev);
        izbranaNastanitev.setTermin(Arrays.asList(termins));
        IzberiTermin(izbranaNastanitev);
    }

    /**
     * @param izbranaNastanitev
     */
    public Termin[] PricniRezervacijo(Nastanitev izbranaNastanitev) {
        viewFlipper.setDisplayedChild(0);
        Termin[] termini = kRezervirajIzbranoNastanitevZaTermin.vrniSeznamProstihTerminov();

        // fill list view adapter
        String[] content = new String[termini.length];
        for (int i = 0; i < termini.length; i++) {
            content[i] = termini[i].vrniPodrobnostiOTerminu();
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

        String[] podrobnosti = kRezervirajIzbranoNastanitevZaTermin.vrniPodrobnostiONastanitviZaTermin(termin);

        TextView naslovText = (TextView) findViewById(R.id.podrobnosti_naslov);
        if (naslovText != null) {
            naslovText.setText(podrobnosti[0]);
        }

        TextView kapacitetaText = (TextView) findViewById(R.id.podrobnosti_kapaciteta);
        if (kapacitetaText != null) {
            kapacitetaText.setText(podrobnosti[1]);
        }

        TextView opisText = (TextView) findViewById(R.id.podrobnosti_opis);
        if (opisText != null) {
            opisText.setText(podrobnosti[3]);
        }

        TextView terminText = (TextView) findViewById(R.id.termin_podrobnosti_text_view);
        if (terminText != null) {
            terminText.setText(podrobnosti[4]);
        }
        TextView cenaText = (TextView) findViewById(R.id.podrobnosti_cena);
        if (cenaText != null) {
            cenaText.setText(podrobnosti[2]);
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
            cenaText.setText(String.format(Locale.GERMAN, "Za plačilo: %.2f€", kRezervirajIzbranoNastanitevZaTermin.izracunajCeno(termin)));

        final EditText ime = (EditText) findViewById(R.id.ime_edit);
        final EditText kk = (EditText) findViewById(R.id.kk_edit);
        final EditText primek = (EditText) findViewById(R.id.priimek_edit);
        final EditText naslov = (EditText) findViewById(R.id.naslov_edit);
        final EditText koda = (EditText) findViewById(R.id.key_edit);

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
                    if (!(ime != null && ime.getText().toString().trim().isEmpty()) && !(primek != null && primek.getText().toString().trim().isEmpty()) && !(kk != null && kk.getText().toString().trim().isEmpty()) && !(naslov != null && naslov.getText().toString().trim().isEmpty()) && !(koda != null && koda.getText().toString().isEmpty())) {
                        TextView summary = (TextView) findViewById(R.id.summary);
                        if (summary != null) {
                            summary.setText(String.format(Locale.GERMAN, "Znesek: %.2f€\nKreditna kartica: %s\nLastnik: %s %s\nNaslov plačnika: %s\n\nPlačilo bo izvedeno ob kliku na gumb 'Izvedi plačilo.'",
                                    kRezervirajIzbranoNastanitevZaTermin.izracunajCeno(termin),
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
                            boolean placiloUspesno = kRezervirajIzbranoNastanitevZaTermin.izvediPlacilo(kk.getText().toString(), ime.getText().toString(), primek.getText().toString(), Integer.parseInt(koda != null ? koda.getText().toString() : "0"));
                            if (placiloUspesno) {
                                kRezervirajIzbranoNastanitevZaTermin.zakljuciRezervacijo(termin.getIdTermina());
                                PrikaziSporociloOUspesniRezervaciji();
                            } else {
                                VrniSporociloONapaki();
                                Button popravi = (Button) findViewById(R.id.popravi_button);
                                if (popravi != null) {
                                    popravi.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            VnesiImeInKK(nastanitev, termin);
                                        }
                                    });
                                }
                            }
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

    public void VrniSporociloONapaki() {
        viewFlipper.setDisplayedChild(6);
    }

}