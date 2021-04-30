package com.example.compras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompraTotal extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_total);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle params = intent.getExtras();
            String compraTotal = params.getString("compraTotal");

            TextView labelResultado = (TextView) findViewById(R.id.labelResultado);

            labelResultado.setText(labelResultado.getText().toString() + compraTotal);
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}