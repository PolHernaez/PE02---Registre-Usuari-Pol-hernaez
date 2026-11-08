package com.example.pe02_registreusuari;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellidos = findViewById(R.id.etApellidos);
        EditText etEdad = findViewById(R.id.etEdad);
        Button btnMostrarInfo = findViewById(R.id.btnMostrarInfo);
        btnMostrarInfo.setOnClickListener(v-> {
        String nom = etNombre.getText().toString();
        String cognoms = etApellidos.getText().toString();
            RadioButton rbSi = findViewById(R.id.rbSi);
            boolean matriculado = rbSi.isChecked();
            String edatText = etEdad.getText().toString();
            if (edatText.isEmpty()) {
                etEdad.setError("Escriu l'edat");
                return;
            }
            int edat = Integer.parseInt(edatText);

            Persona p = new Persona(nom, cognoms, edat, matriculado);
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            Bundle c = new Bundle();
            c.putSerializable("persona", p);
            i.putExtras(c);
            startActivityForResult(i, 1);


        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            boolean acepta = data.getBooleanExtra("acepta", false);
            TextView tvPolitica = findViewById(R.id.tvPolitica);
            tvPolitica.setText(acepta ? "Aceptada" : "No aceptada");
        }
    }

}