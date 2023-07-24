package com.example.sonidos;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class servicioSonido extends Service {

    MediaPlayer reproductor;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {

        reproductor = MediaPlayer.create(this,R.raw.cancion);
        reproductor.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int Flags, int startid) {
        reproductor.start();
        //Empezar pegado
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        reproductor.stop();
    }

}
