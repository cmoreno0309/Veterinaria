package com.veterinaria.proyecto.veterinaria.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class MySqlOpenHelper extends SQLiteOpenHelper {


    private static final String name = "veterinaria.db";
    Context context;
    private static int versionDB = 7;

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

        String sql_empleado = "CREATE TABLE " + TablaDBContract.CitaEntry.TABLE_NAME + " (" +
                TablaDBContract.CitaEntry._ID + " INTEGER PRIMARY KEY," +
                TablaDBContract.CitaEntry.COLUMN_FECHACITA      + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_HORA           + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_CODIGOEMPLEADO           + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_NOMBREEMPLEADO           + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_IMAGENEMPLEADO           + " BLOB ," +
                TablaDBContract.CitaEntry.COLUMN_CODIGOSERVICIO           + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_NOMBRESERVICIO           + " TEXT ," +
                TablaDBContract.CitaEntry.COLUMN_ESTADO      + " TEXT)";
        db.execSQL(sql_empleado);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("basededatos", "onUpgrade");

        db.execSQL("DROP TABLE IF EXISTS " + TablaDBContract.MascotaEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TablaDBContract.ServicioEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TablaDBContract.CitaEntry.TABLE_NAME);
        onCreate(db);

    }
}
