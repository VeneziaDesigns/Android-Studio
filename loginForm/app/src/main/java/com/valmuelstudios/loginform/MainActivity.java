package com.valmuelstudios.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    openHelper bd;
    String user,pass;
    EditText editTextuser;
    EditText editTextpass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //arreglo
        bd = new openHelper(this);

        Button registro = (Button) findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registro.class);
                startActivity(intent);

            }
        });

        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SQLiteDatabase base;
                editTextuser = (EditText)findViewById(R.id.editTextuser);
                editTextpass = (EditText)findViewById(R.id.editTextpass);

                String user = String.valueOf(editTextuser.getText());
                String pass = String.valueOf(editTextpass.getText());

                base = bd.getWritableDatabase();
                                                        //arreglado
                Cursor c = base.rawQuery("SELECT usuario,pass FROM usuarios WHERE usuario='"+user+"'",null);

                if(c.moveToFirst()){

                    user = c.getString(0);
                    String passrecuperado = c.getString(1);

                    //if(passrecuperado == pass)
                    if(passrecuperado.equals(pass)){
                        Intent intento = new Intent(MainActivity.this, entrar.class);

                        intento.putExtra("user",user);

                        startActivity(intento);
                        finish();
                    }
                }else{
                    TextView incorrecto = (TextView) findViewById(R.id.incorrecto);
                    incorrecto.setText("Usuario o contraseña incorrectos");
                }
            }
        });


    }
}