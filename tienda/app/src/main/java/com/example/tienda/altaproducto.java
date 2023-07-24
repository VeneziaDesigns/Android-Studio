package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class altaproducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altaproducto);

        Button alta = (Button) findViewById(R.id.bAlta);
        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aProducto = new Intent(altaproducto.this, registrarproducto.class);
                startActivity(aProducto);
            }
        });
        Button visualizar = (Button) findViewById(R.id.bVisualizar);
        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vProducto = new Intent(altaproducto.this,descripcionproducto.class);
                startActivity(vProducto);
            }
        });
    }
}