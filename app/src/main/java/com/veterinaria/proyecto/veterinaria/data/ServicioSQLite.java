package com.veterinaria.proyecto.veterinaria.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import domain.Servicio;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class ServicioSQLite implements ServicioDAO {

    MySqlOpenHelper mySqlOpenHelper;

    public ServicioSQLite(Context context) {
        Log.d("basededatos", "ServicioSQLite");
        mySqlOpenHelper = new MySqlOpenHelper(context);

    }

    @Override
    public void obtenerServicio(Servicio servicio) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.ServicioEntry.TABLE_NAME,
                null, TablaDBContract.ServicioEntry._ID + "=?", new String[]{"" + servicio.getCodigoServicio()}, null, null, null);

        if (cursor.moveToFirst()) {
            servicio.setNombreServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_NOMBRE)));
            servicio.setDescripcionServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_DESCRIPCION)));
            servicio.setImagen(cursor.getBlob(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_IMAGEN)));
        }
        sqLiteDatabase.close();
    }

    @Override
    public List<Servicio> obtenerServicios() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.ServicioEntry.TABLE_NAME,
                null, null, null, null, null, null);

        List<Servicio> servicios = new ArrayList<>();
        cursor.moveToFirst();
        if(cursor.getCount() != 0){
            do {
                Servicio servicio = new Servicio();
                servicio.setCodigoServicio(cursor.getInt(cursor.getColumnIndex(TablaDBContract.ServicioEntry._ID)));
                servicio.setNombreServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_NOMBRE)));
                servicio.setDescripcionServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_DESCRIPCION)));
                servicio.setImagen(cursor.getBlob(cursor.getColumnIndex(TablaDBContract.ServicioEntry.COLUMN_IMAGEN)));
                servicios.add(servicio);

            } while (cursor.moveToNext());

        }

        sqLiteDatabase.close();

        return servicios;
    }

    @Override
    public long registrarServicio(Servicio servicio) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TablaDBContract.ServicioEntry.COLUMN_NOMBRE, servicio.getNombreServicio());
        contentValues.put(TablaDBContract.ServicioEntry.COLUMN_DESCRIPCION, servicio.getDescripcionServicio());
        contentValues.put(TablaDBContract.ServicioEntry.COLUMN_IMAGEN, servicio.getImagen());

        long row = sqLiteDatabase.
                insert(TablaDBContract.ServicioEntry.TABLE_NAME, null, contentValues);


        return row;
    }
}
