package com.example.compras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxArroz;
    private CheckBox checkBoxFeijao;
    private CheckBox checkBoxLeite;
    private CheckBox checkBoxFile;
    private CheckBox checkBoxMaca;
    private EditText numberTxtQtdArroz;
    private EditText numberTxtQtdFeijao;
    private EditText numberTxtQtdLeite;
    private EditText numberTxtQtdFile;
    private EditText numberTxtQtdMaca;
    private Button btnFinalizarCompra;

    private double precoArroz = 4.99;
    private double precoLeite = 5.99;
    private double precoFile = 59.76;
    private double precoFeijao = 7.99;
    private double precoMaca = 3.22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxArroz = (CheckBox) findViewById(R.id.checkBoxArroz);
        checkBoxFeijao = (CheckBox) findViewById(R.id.checkBoxFeijão);
        checkBoxLeite = (CheckBox) findViewById(R.id.checkBoxLeite);
        checkBoxFile = (CheckBox) findViewById(R.id.checkBoxFile);
        checkBoxMaca = (CheckBox) findViewById(R.id.checkBoxMaca);
        numberTxtQtdArroz = (EditText) findViewById(R.id.numberTxtQtdArroz);
        numberTxtQtdFeijao = (EditText) findViewById(R.id.numberTxtQtdFeijao);
        numberTxtQtdLeite = (EditText) findViewById(R.id.numberTxtQtdLeite);
        numberTxtQtdFile = (EditText) findViewById(R.id.numberTxtQtdFile);
        numberTxtQtdMaca = (EditText) findViewById(R.id.numberTxtQtdMaca);
        btnFinalizarCompra = (Button) findViewById(R.id.btnFinalizarCompra);

        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double compraTotal = 0;
                double valorArroz = 0;
                double valorFeijao = 0;
                double valorLeite = 0;
                double valorFile = 0;
                double valorMaca = 0;

                if (checkBoxArroz.isChecked()) {
                    valorArroz = precoArroz * Double.parseDouble(numberTxtQtdArroz.getText().toString());
                }

                if (checkBoxFeijao.isChecked()) {
                    valorFeijao = precoFeijao * Double.parseDouble(numberTxtQtdFeijao.getText().toString());
                }

                if (checkBoxLeite.isChecked()) {
                    valorLeite = precoLeite * Double.parseDouble(numberTxtQtdLeite.getText().toString());
                }

                if (checkBoxFile.isChecked()) {
                    valorFile = precoFile * Double.parseDouble(numberTxtQtdFile.getText().toString());
                }

                if (checkBoxMaca.isChecked()) {
                    valorMaca = precoMaca * Double.parseDouble(numberTxtQtdMaca.getText().toString());
                }

                compraTotal = valorArroz + valorFeijao + valorFile + valorLeite + valorMaca;
                chamarAtividade(compraTotal);
            }
        });
    }

    private void chamarAtividade(double compraTotal)
    {
        Bundle params = new Bundle();
        params.putString("compraTotal", String.valueOf(compraTotal));

        Intent intent = new Intent(this, CompraTotal.class);
        intent.putExtras(params);

        startActivity(intent);
    }
}