package com.example.pe02_registreusuari;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = getIntent().getExtras();
        Persona p = (Persona) b.getSerializable("persona");

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvApellidos = findViewById(R.id.tvApellidos);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvMatriculado = findViewById(R.id.tvMatriculado);
        CheckBox cbPolitica = findViewById(R.id.cbPolitica);
        Button btnSalir = findViewById(R.id.btnSalir);

        tvNombre.setText(p.getNom());
        tvApellidos.setText(p.getCognoms());
        tvEdad.setText(String.valueOf(p.getEdat()));
        tvMatriculado.setText(p.getMatriculado() ? "Sí" : "No");

        btnSalir.setOnClickListener(v -> devolverResultado(cbPolitica));

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                devolverResultado(cbPolitica);
            }
        });
    }

    private void devolverResultado(CheckBox cbPolitica) {
        Intent r = new Intent();
        r.putExtra("acepta", cbPolitica.isChecked());
        setResult(RESULT_OK, r);
        finish();
    }
}