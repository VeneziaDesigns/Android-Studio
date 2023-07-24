package com.valmuelstudios.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registro extends AppCompatActivity {


    openHelper bd;
    SQLiteDatabase base;

    EditText usuario;
    EditText pass ;
    EditText mail ;
    EditText edad ;


    View.OnClickListener registrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user,password,email,age;


            user = "'"+String.valueOf(usuario.getText())+"'";
            password = "'"+String.valueOf(pass.getText())+"'";
            email = "'"+String.valueOf(mail.getText())+"'";
            age = "'"+String.valueOf(edad.getText())+"'";


            base = bd.getWritableDatabase();

            base.execSQL("INSERT INTO usuarios(usuario,pass,mail,edad) VALUES("+user+","+password+","+email+","+age+")");

            base.close();
            bd.close();

            Intent intento = new Intent(registro.this,MainActivity.class);
            startActivity(intento);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button registro = (Button) findViewById(R.id.btnregistro);
        registro.setOnClickListener(registrar);

         usuario = (EditText)findViewById(R.id.usuario);
         pass = (EditText)findViewById(R.id.pass);
         mail = (EditText)findViewById(R.id.mail);
         edad = (EditText)findViewById(R.id.edad);

        bd = new openHelper(this);
    }
}