package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String direccion2, telefono2, password2, fecha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle manojo = intent.getExtras();

        //TextView calle = (TextView) findViewById(R.id.dir);
        direccion2 = (String) manojo.get("calle");

        //TextView tel = (TextView) findViewById(R.id.telf);
        telefono2 = (String) manojo.get("tel");

        //TextView pass = (TextView) findViewById(R.id.pass);
        password2 = (String) manojo.get("pass");

        //TextView fec = (TextView) findViewById(R.id.nacimiento);
        fecha2 = (String) manojo.get("fec");

        /*calle.setText(direccion2);
        tel.setText(telefono2);
        pass.setText(password2);
        fec.setText(fecha2);*/
    }
}