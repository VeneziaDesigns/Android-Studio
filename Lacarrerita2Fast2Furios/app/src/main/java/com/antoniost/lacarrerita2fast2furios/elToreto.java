package com.antoniost.lacarrerita2fast2furios;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class elToreto extends AppCompatActivity {

    ImageView uno,dos,tres;
    ImageView ferrari,lamborghini,mg;
    int aleatorio,recorrido,numero1,numero2,numero3;
    int timer,a;
    TextView ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_toreto);
        ganador = findViewById(R.id.ganador);
        Button volare =(Button) findViewById(R.id.volare);
        volare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ImageView laNave =(ImageView) findViewById(R.id.laNave);
                //ObjectAnimator animator=(ObjectAnimator) ObjectAnimator.ofFloat(laNave,"translationX",6000);
                //animator.setDuration(8000);
                //animator.start();
            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    protected void onStart(){
        super.onStart();
        Button volare =(Button) findViewById(R.id.volare);
        ImageView tres=(ImageView) findViewById(R.id.tres);
        ImageView dos=(ImageView)  findViewById(R.id.dos);
        ImageView uno=(ImageView) findViewById(R.id.uno);

        //Delay
        final Handler Handler5 = new Handler();
        Handler5.postDelayed(new Runnable() {
            @Override
            public void run() {
                tres.setVisibility(View.INVISIBLE);
                dos.setVisibility(View.INVISIBLE);
                uno.setVisibility(View.INVISIBLE);
            }
        }, 0);

        final Handler Handler = new Handler();
        Handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tres.setVisibility(View.VISIBLE);
                dos.setVisibility(View.INVISIBLE);
                uno.setVisibility(View.INVISIBLE);
            }
        }, 1000);

        final Handler Handler2 = new Handler();
        Handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                tres.setVisibility(View.INVISIBLE);
                dos.setVisibility(View.VISIBLE);

            }

        }, 2000);
        final Handler Handler3 = new Handler();
        Handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                dos.setVisibility(View.INVISIBLE);
                uno.setVisibility(View.VISIBLE);
            }
        },3000);
        final Handler Handler4 = new Handler();
        Handler4.postDelayed(new Runnable() {
            @Override
            public void run() {

                uno.setVisibility(View.INVISIBLE);
            }
        },4000);


        volare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView ferrari = (ImageView) findViewById(R.id.ferrari);
                ImageView lamborghini = (ImageView) findViewById(R.id.lamborghini);
                ImageView mg =(ImageView) findViewById(R.id.mg);
                    Random aleatorio = new Random();
                    Random aleatorio2 = new Random();
                    Random aleatorio3 = new Random();
                        numero1 = aleatorio.nextInt(3000) + 2500;
                        numero2 = aleatorio2.nextInt(3000) + 2500;
                        numero3 = aleatorio3.nextInt(3000) + 2500;
                            ObjectAnimator animator = ObjectAnimator.ofFloat( ferrari,"translationX", 2500);
                            ObjectAnimator animator2 = ObjectAnimator.ofFloat( lamborghini,"translationX", 2500);
                            ObjectAnimator animator3 = ObjectAnimator.ofFloat( mg, "translationX" , 2500);
                                animator.setDuration(numero1);
                                animator2.setDuration(numero2);
                                animator3.setDuration(numero3);
                                    animator.start();
                                    animator2.start();
                                    animator3.start();

                if (numero1<numero2 && numero1<numero3){

                    ganador.setText("ganador ferrari");
                    ganador.setVisibility(View.VISIBLE);
                }

                else if (numero2<numero1 && numero2<numero3){

                    ganador.setText("ganador lamborghini");
                    ganador.setVisibility(View.VISIBLE);
                }

                else if (numero3<numero1 && numero3<numero1){

                    ganador.setText("ganador mg");
                    ganador.setVisibility(View.VISIBLE);
                }
            }
        });






            }


}
