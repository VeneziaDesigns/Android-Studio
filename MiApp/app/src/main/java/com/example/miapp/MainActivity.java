package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        View.OnClickListener miBoton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView CajaTexto = (TextView) findViewById(R.id.cajaTexto);

                switch (view.getId()) {

                    case R.id.btnComenzar:
                        CajaTexto.setText("Listo?");
                        break;

                    case R.id.btnTutorial:
                        CajaTexto.setText("Practica");
                        break;

                    case R.id.btnSalir:
                        CajaTexto.setText("Salir");
                        break;
                }
            }
        };

        /*  ¡¡¡¡¡¡MODO LARGO (NO RECOMENDABLE)!!!!!!

         View.OnClickListener pulsarBoton1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView cajaTexto = (TextView) findViewById(R.id.Cajatexto);
                cajaTexto.setText("Comienzo");
            }
        };


        View.OnClickListener pulsarBoton2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView cajaTexto = (TextView) findViewById(R.id.Cajatexto);
            cajaTexto.setText("Práctica");
        }
    };

        View.OnClickListener pulsarBoton3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView cajaTexto = (TextView) findViewById(R.id.Cajatexto);
            cajaTexto.setText("Adios");
        }
    };
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnComenzar = (Button) findViewById(R.id.btnComenzar);
        btnComenzar.setOnClickListener(miBoton);

        Button btnTutorial = (Button) findViewById(R.id.btnTutorial);
        btnTutorial.setOnClickListener(miBoton);

        Button btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(miBoton);
    }
}