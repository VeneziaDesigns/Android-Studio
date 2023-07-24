package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite  extends SQLiteOpenHelper {
                                                    //Lenguaje SQL
    private static final String crearTabla = "CREATE TABLE usuarios (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " usuario TEXT, pass TEXT)";

    private static final String nombreDB = "Login.SQLite";
    private static final int versionDB = 1;

    public SQLite(Context context){
        //Constructor
        super(context, nombreDB, null, versionDB);

    }

    @Override
    public void onCreate(SQLiteDatabase base) {

        base.execSQL(crearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
