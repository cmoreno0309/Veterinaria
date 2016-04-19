package com.veterinaria.proyecto.veterinaria.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class MySqlOpenHelper extends SQLiteOpenHelper {


    private static final String name = "veterinaria.db";
    Context context;
    private static int versionDB = 1;

    public MySqlOpenHelper(Context context) {

        super(context, name, null, versionDB);
        Log.d("basededatos", "MySqlOpenHelper-Constr");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("onCreate", "mascota");
        String sql = "CREATE TABLE " + TablaDBContract.MascotaEntry.TABLE_NAME + " (" +
                TablaDBContract.MascotaEntry._ID + " INTEGER PRIMARY KEY," +
                TablaDBContract.MascotaEntry.COLUMN_NOMBRE       + " TEXT NOT NULL," +
                TablaDBContract.MascotaEntry.COLUMN_EDAD         + " TEXT NOT NULL," +
                TablaDBContract.MascotaEntry.COLUMN_CUMPLEANIOS  + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_SEXO         + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_ALIMENTACION + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_TRATAMIENTO  + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_COLOR        + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_ESTERILIZADO + " TEXT ," +
                TablaDBContract.MascotaEntry.COLUMN_IMAGEN       + " BLOB)";
        db.execSQL(sql);

        String sql_servicio = "CREATE TABLE " + TablaDBContract.ServicioEntry.TABLE_NAME + " (" +
                TablaDBContract.ServicioEntry._ID + " INTEGER PRIMARY KEY," +
                TablaDBContract.ServicioEntry.COLUMN_NOMBRE      + " TEXT ," +
                TablaDBContract.ServicioEntry.COLUMN_DESCRIPCION + " TEXT ," +
                TablaDBContract.ServicioEntry.COLUMN_IMAGEN      + " BLOB)";
        db.execSQL(sql_servicio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("basededatos", "onUpgrade");

        db.execSQL("DROP TABLE IF EXISTS " + TablaDBContract.MascotaEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TablaDBContract.ServicioEntry.TABLE_NAME);
        onCreate(db);

    }
}
