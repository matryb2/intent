package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputKlient;
    RadioButton mala;
    RadioButton srednia;
    RadioButton duza;
    Button dalej;
    CheckBox ser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputKlient = findViewById(R.id.editTextText);
        mala = findViewById(R.id.radioButton);
        srednia = findViewById(R.id.radioButton2);
        duza = findViewById(R.id.radioButton3);
        dalej = findViewById(R.id.button);
        ser = findViewById(R.id.checkBox);

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwaKlient = inputKlient.getText().toString();

                if (nazwaKlient.isEmpty()) {
                    inputKlient.setError("Pole nie może być puste.");
                    inputKlient.requestFocus();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

                intent.putExtra("klient", nazwaKlient);
                intent.putExtra("mala", mala.isChecked());
                intent.putExtra("srednia", srednia.isChecked());
                intent.putExtra("duza", duza.isChecked());
                intent.putExtra("ser", ser.isChecked());

                startActivity(intent);
            }
        });
    }
}
