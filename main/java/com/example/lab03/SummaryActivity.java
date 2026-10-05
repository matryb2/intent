package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();

        String klient = intent.getStringExtra("klient");

        boolean mala = intent.getBooleanExtra("mala", false);
        boolean srednia = intent.getBooleanExtra("srednia", false);
        boolean duza = intent.getBooleanExtra("duza", false);
        boolean ser = intent.getBooleanExtra("ser", false);

        String wynik = "Klient: " + klient + "\n";

        if (mala) {
            wynik += "Rozmiar: mała\n";
        } else if (srednia) {
            wynik += "Rozmiar: średnia\n";
        } else if (duza) {
            wynik += "Rozmiar: duża\n";
        }

        if (ser) {
            wynik += "Ser: tak";
        } else {
            wynik += "Ser: nie";
        }

        textView.setText(wynik);
    }
}
