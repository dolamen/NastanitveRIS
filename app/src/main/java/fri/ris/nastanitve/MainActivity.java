package fri.ris.nastanitve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fri.ris.nastanitve.models.Nastanitev;

public class MainActivity extends AppCompatActivity {

    private Nastanitev izbranaNastanitev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izbranaNastanitev = new Nastanitev(1, "Ljubljana", "Sončna cesta 10", "Slovenija", 1, 29.50, "Very nice room.");


    }
}
