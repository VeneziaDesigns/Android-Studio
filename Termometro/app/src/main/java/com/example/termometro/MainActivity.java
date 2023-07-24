package com.example.termometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager gestorSensores;
    Sensor luz;
    TextView lux;
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager gestorSensores = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor luz = gestorSensores.getDefaultSensor(Sensor.TYPE_LIGHT);

        gestorSensores.registerListener(miListener, luz, SensorManager.SENSOR_DELAY_NORMAL);

        lux = (TextView) findViewById(R.id.grados);
        mensaje = (TextView) findViewById(R.id.grados);

    }
    SensorEventListener miListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {

                lux.setText((String.valueOf(sensorEvent.values[0])));
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}