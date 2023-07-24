package com.example.bdexternas;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.transform.Result;

public class conexionExterna extends AsyncTask<Void,Void,Void> {

    public ResultSet resultados;
    public String consulta="";
    Connection conexion;

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion =
                    DriverManager.getConnection("jdbc:mysql://pablotorresbayo.ddns.net:3306/tienda", "pruebas", "Pruebas1**");
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://pablotorresbayo.ddns.net:3306/tienda"
                   // , "pruebas", "Pruebas1**");

            //String cadena = R.string.url+R.string.puerto+R.string.bbdd+R.string.usuario+R.string.pass;
            //Connection conexion = DriverManager.getConnection(String.valueOf(R.string.url+R.string.puerto+R.string.bbdd),String.valueOf(R.string.usuario),String.valueOf(R.string.pass));

            Statement sentencia = conexion.createStatement();
            //resultados = sentencia.executeQuery("SELECT * FROM articulos WHERE codigo =111111");
            resultados = sentencia.executeQuery(consulta);

        } catch (Exception e) {
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void avoid){

        try {
            conexion.close();
        }catch (SQLException throwables)
        {

        }    }


}
