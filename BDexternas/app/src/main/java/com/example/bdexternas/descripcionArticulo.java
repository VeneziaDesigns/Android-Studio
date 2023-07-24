package com.example.bdexternas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class descripcionArticulo extends AppCompatActivity {

    // Para dar wrap content o match parent ajustar contenido
    LinearLayout.LayoutParams parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_articulo);

        TextView cod1 = (TextView) findViewById(R.id.Textcod);
        TextView nom1 = (TextView) findViewById(R.id.Textnombre);
        TextView cat1 = (TextView) findViewById(R.id.Textcategoria);
        TextView des1 = (TextView) findViewById(R.id.Textdescripcion);
        TextView url = (TextView) findViewById(R.id.url);
            ImageView img1 = (ImageView) findViewById(R.id.imageView);

        Intent desArticulo = getIntent();
        Bundle manojo = desArticulo.getExtras();

        cod1.setText(manojo.getString("cod"));
        nom1.setText(manojo.getString("nom"));
        cat1.setText(manojo.getString("cat"));
        des1.setText(manojo.getString("des"));
        //url.setText(manojo.getString("url1"));
            Picasso.with(this).load(manojo.getString("url1")).resize(400,300).into(img1);


        LinearLayout otro = (LinearLayout)findViewById(R.id.otro);
        TableRow fila = new TableRow(this);

        CardView tarjeta = new CardView(this);
        LinearLayout contenedor = new LinearLayout(this);

        ImageView imagen1 = new ImageView(this);
        TextView texto1 = new TextView(this);
        TextView texto2 = new TextView(this);

        contenedor.setOrientation(LinearLayout.VERTICAL);
                                                        //Altura                            //Anchura
        parametros = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        tarjeta.setLayoutParams(parametros);
        contenedor.setLayoutParams(parametros);

        //Atributos CardView
        tarjeta.setRadius(20);
        tarjeta.setCardElevation(30);

        Picasso.with(this).load(manojo.getString("url1")).resize(1000,500).into(imagen1);

        texto1.setText(manojo.getString("nom"));
        texto2.setText(manojo.getString("des"));

        contenedor.addView(imagen1);
        contenedor.addView(texto1);
        contenedor.addView(texto2);

        tarjeta.addView(contenedor);

        otro.addView(tarjeta);

    }
}