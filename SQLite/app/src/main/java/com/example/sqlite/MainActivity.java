package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase base;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLite bd = new SQLite(this);


                //Ejecuta SQLite.java
        base = bd.getWritableDatabase();

        Button boton = (Button)findViewById(R.id.bRegistro);
        boton.setOnClickListener(bRegistro);

    }

    View.OnClickListener bRegistro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Pablo','pablo1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Antonio','antonio1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Adrian','adrian1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Carlos','carlos1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Pedro','pedro1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Manolo','manolo1') ");
            base.execSQL("INSERT INTO usuarios (usuario,pass) VALUES ('Ivan','ivan1') ");
        }
    };

}