package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager gestorSensores;
    Sensor proximidad;
    Sensor acelerometro;
    TextView cajaTexto;
    TextView x;
    TextView y;
    TextView z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declaro manager de sensores
        SensorManager gestorSensores = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //declaro el sensor
        Sensor proximidad = gestorSensores.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Sensor acelerometro = gestorSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //A que sensor o sensores vamos a llamar desde el listener
        gestorSensores.registerListener(miListener, proximidad, SensorManager.SENSOR_DELAY_NORMAL);
        gestorSensores.registerListener(miListener, acelerometro, SensorManager.SENSOR_DELAY_GAME);

        cajaTexto = (TextView) findViewById(R.id.cajaTexto);
        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.y);
        z = (TextView) findViewById(R.id.z);


    }
        //Declaro el listener de tiposensor event
    SensorEventListener miListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {

                if (sensorEvent.values[0]<5) {
                    cajaTexto.setText("Aparta la oreja");
                }
                else
                {
                    cajaTexto.setText("lejos");
                }
            }

            if(sensorEvent.sensor.getType()== Sensor.TYPE_ACCELEROMETER){
                x.setText(String.valueOf(sensorEvent.values[0]));
                y.setText(String.valueOf(sensorEvent.values[1]));
                z.setText(String.valueOf(sensorEvent.values[2]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };




    public void onSensorChanged(SensorEvent sensorEvent) {
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}