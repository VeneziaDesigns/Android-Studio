package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos la variable = Boton buscar por id R.id.Boton
        Button botonClick = (Button)findViewById(R.id.botonClick);

        //
        botonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                TextView textoClick = (TextView) findViewById(R.id.textoClick);
                //
                textoClick.setText("Has pulsado el boton");
            }
        });
        Button botonLargo = (Button)findViewById(R.id.botonLargo);

        botonLargo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                TextView textoLargo = (TextView) findViewById(R.id.textoLargo);

                textoLargo.setText("Has mantenido el boton pulsado");
                return false;
            }
        });
        Button clickMixto = (Button) findViewById(R.id.clickMixto);
        clickMixto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textoMixto = (TextView)  findViewById(R.id.textoMixto);
                textoMixto.setText("Pulsacion corta");

            }
        });
        clickMixto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextView textoMixto = (TextView) findViewById(R.id.textoMixto);
                textoMixto.setText("Pulsacion larga");
                return false;
            }
        });
        ImageView botonBlanco = (ImageView) findViewById(R.id.botonBlanco);
        botonBlanco.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    //Si motionevent action down muestrame el recurso de imagen "blanco"
                    botonBlanco.setImageResource(R.drawable.blanco);
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    //Si motionevent action up muestrame el recurso de imagen "negro"
                    botonBlanco.setImageResource(R.drawable.negro);
                }

                return true;
            }
        });

        Button play =(Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView gris = (ImageView) findViewById(R.id.gris);
                ObjectAnimator animator = ObjectAnimator.ofFloat( gris,"translationX", 600);
                animator.setDuration(6000);
                animator.start();
            }
        });
    }
}