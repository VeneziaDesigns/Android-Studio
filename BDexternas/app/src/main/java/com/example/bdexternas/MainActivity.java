package com.example.bdexternas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.squareup.picasso.Picasso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public void rellenaArticulos(String consulta){

        conexionExterna conectar2 = new conexionExterna();
        LinearLayout contenido = (LinearLayout)findViewById(R.id.contenido);
        // Para dar wrap content o match parent ajustar contenido


        try {
            conectar2.consulta = consulta;
            conectar2.execute().get();
            ResultSet mostrarArticulos = conectar2.resultados;
            contenido.removeAllViews();

            while (mostrarArticulos.next())
            {
                TextView nuevoTexto = new TextView(this);




              //Cambia el tamaño de letra
                nuevoTexto.setTextSize(32);

                //Muestra el campo de la base de datos (2)
                nuevoTexto.setText(mostrarArticulos.getString(2));
                contenido.addView(nuevoTexto);

                //Introduce espacios
                Space nuevoEspacio = new Space(this);
                nuevoEspacio.setMinimumHeight(100);
                contenido.addView(nuevoEspacio);

                    nuevoTexto.setOnClickListener(new View.OnClickListener() {

                        String codigo = mostrarArticulos.getString(1);
                        String nombre = mostrarArticulos.getString(2);
                        String categoria = mostrarArticulos.getString(3);
                        String descripcion = mostrarArticulos.getString(4);
                        String url = mostrarArticulos.getString(5);
                        @Override
                    public void onClick(View view) {
                        Intent desArticulo = new Intent(MainActivity.this,descripcionArticulo.class);
                            desArticulo.putExtra("cod",codigo);
                            desArticulo.putExtra("nom",nombre);
                            desArticulo.putExtra("cat",categoria);
                            desArticulo.putExtra("des",descripcion);
                            desArticulo.putExtra("url1",url);
                        startActivity(desArticulo);
                        
                    }
                });
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registrar = (Button)findViewById(R.id.registrarProducto);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acReg = new Intent(MainActivity.this,registrarArticulo.class);
                startActivity(acReg);
            }
        });

        LinearLayout contenido = (LinearLayout)findViewById(R.id.contenido);
        LinearLayout chips = (LinearLayout)findViewById(R.id.chips);

        //Hace que una tarea sea asincrona
        conexionExterna conectar = new conexionExterna();
        //conexionExterna conectar2 = new conexionExterna();

        try{
            conectar.consulta = "SELECT DISTINCT categoria FROM articulos";
            conectar.execute().get();
            ResultSet misChips = conectar.resultados;
            while(misChips.next())
            {
                Chip michip = new Chip(this);
                michip.setText(misChips.getString(1));
                String nomCategoria = misChips.getString(1);
                michip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rellenaArticulos("SELECT * FROM articulos WHERE categoria='"
                                +nomCategoria+"'");
                    }
                });

                chips.addView(michip);
            }
        }catch(Exception e){
        }

        rellenaArticulos("SELECT nombre FROM articulos");

        /*try {
            conectar2.consulta = "SELECT * FROM articulos";
            conectar2.execute().get();
            ResultSet mostrarArticulos = conectar2.resultados;
            while (mostrarArticulos.next())
            {
               TextView nuevoTexto = new TextView(this);

               //Cambia el tamaño de letra
               nuevoTexto.setTextSize(32);

               //Muestra el campo de la base de datos (2)
               nuevoTexto.setText(mostrarArticulos.getString(2));
               contenido.addView(nuevoTexto);

                //Introduce espacios
               Space nuevoEspacio = new Space(this);
               nuevoEspacio.setMinimumHeight(100);
               contenido.addView(nuevoEspacio);
            }
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}