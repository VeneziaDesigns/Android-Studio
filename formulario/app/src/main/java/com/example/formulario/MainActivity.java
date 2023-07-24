package com.example.formulario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombre = (EditText) findViewById(R.id.nombre);
        EditText direccion = (EditText) findViewById(R.id.direccion);
        EditText telefono = (EditText) findViewById(R.id.telefono);
        EditText password = (EditText) findViewById(R.id.password);
        EditText fecha = (EditText) findViewById(R.id.fecha);



        Button registrarse = (Button) findViewById(R.id.registrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = String.valueOf(nombre.getText());
                String calle = String.valueOf(direccion.getText());
                String tel = String.valueOf(telefono.getText());
                String pass = String.valueOf(password.getText());
                String fec = String.valueOf(fecha.getText());

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",name);
                intent.putExtra("calle",calle);
                intent.putExtra("tel",tel);
                intent.putExtra("pass",pass);
                intent.putExtra("fec",fec);
                startActivity(intent);

            }
        });

    }
}