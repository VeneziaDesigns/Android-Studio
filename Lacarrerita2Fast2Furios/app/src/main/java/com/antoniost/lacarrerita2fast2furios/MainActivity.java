package com.antoniost.lacarrerita2fast2furios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btm2Pantalla =(Button) findViewById(R.id.btm2Pantalla);
        btm2Pantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento= new Intent(MainActivity.this, elToreto.class);
                startActivity(intento);
                finish();
            }
        });

    }
}