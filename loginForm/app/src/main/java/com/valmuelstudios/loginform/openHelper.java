package com.valmuelstudios.loginform;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class openHelper extends SQLiteOpenHelper {

    private static final String crearTabla  = "CREATE TABLE usuarios (usuario TEXT PRIMARY KEY, pass TEXT, mail TEXT, edad TEXT)";

    private static final String nombreBD ="usuarios.sqlite";
    private static final int versionBD = 1;

    public openHelper(Context context){

        super(context,nombreBD,null,versionBD);

    }

    @Override
    public void onCreate(SQLiteDatabase base) {

        base.execSQL(crearTabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
