package com.example.actividad040;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] presidentes = {
            "Jose de San Martín",
            "Pedro Diez Canseco",
            "Jose Pardo y Barreda",
            "Jose Luis Bustamante",
            "Zenón Noriega",
            "Manuel Odría",
            "Manuel Prado",
            "Fco Morales Bermúdez",
            "Fernando Belaunde",
            "Alberto Fujimori",
            "Valentín Paniagua",
            "Alejandro Toledo",
            "Alan García",
            "Pedro Pablo Kuczynski",
            "Martín Alberto Vizcarra"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                presidentes
        );
        AutoCompleteTextView textView = findViewById(R.id.txtPresidentes);
        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }
}