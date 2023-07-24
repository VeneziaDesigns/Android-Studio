package com.example.sonidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

        MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this,segunda.class);
                startActivity(intento);


            }
        });
        Button reproducir = (Button) findViewById(R.id.reproducir);
        reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  mp = MediaPlayer.create(getApplicationContext(),R.raw.cancion);
                mp.setLooping(true);
                mp.start();     */

                //startService(new Intent(MainActivity.this,servicioSonido.class));

                String url = "https://pablotorres.info/scape/10.mp3";
                //Inicializar
                mp = new MediaPlayer();
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mp.setDataSource(url);
                    mp.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                    mp.start();
            }
        });

    }
}