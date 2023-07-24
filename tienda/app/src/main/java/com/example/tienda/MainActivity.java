package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registrar = (Button) findViewById(R.id.bRegistro);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intento = new Intent(MainActivity.this, altaproducto.class);
                startActivity(intento);
            }
        });

        View.OnClickListener imgBoton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageButton img1 = (ImageButton) findViewById(R.id.imageButton);
                ImageButton img2 = (ImageButton) findViewById(R.id.imageButton2);
                ImageButton img3 = (ImageButton) findViewById(R.id.imageButton3);
                ImageButton img4 = (ImageButton) findViewById(R.id.imageButton4);
                ImageButton img5 = (ImageButton) findViewById(R.id.imageButton5);
                ImageButton img6 = (ImageButton) findViewById(R.id.imageButton6);

                Intent dproducto = new Intent(MainActivity.this,descripcionproducto.class);

                switch (view.getId()){

                    case R.id.imageButton:
                        startActivity(dproducto);
                        break;

                    case R.id.imageButton2:
                        startActivity(dproducto);
                        break;

                    case R.id.imageButton3:
                        startActivity(dproducto);
                        break;

                    case R.id.imageButton4:
                        startActivity(dproducto);
                        break;

                    case R.id.imageButton5:
                        startActivity(dproducto);
                        break;

                    case R.id.imageButton6:
                        startActivity(dproducto);
                        break;
                }
            }
        };

    }
}