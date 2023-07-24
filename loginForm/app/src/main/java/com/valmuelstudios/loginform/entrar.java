package com.valmuelstudios.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class entrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        Intent intento = getIntent();
        Bundle manojo = intento.getExtras();

        TextView bienvenida = (TextView) findViewById(R.id.bienvenida);
        bienvenida.setText("Hola de nuevo "+manojo.getString("user"));
    }
}