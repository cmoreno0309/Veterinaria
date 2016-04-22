package com.veterinaria.proyecto.veterinaria.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import domain.Cita;
import domain.Servicio;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class CitaSQLite implements CitaDAO {

    MySqlOpenHelper mySqlOpenHelper;

    public CitaSQLite(Context context) {
        Log.d("basededatos", "ServicioSQLite");
        mySqlOpenHelper = new MySqlOpenHelper(context);

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();

    }

    @Override
    public void obtenerCita(Cita cita) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.CitaEntry.TABLE_NAME,
                null, TablaDBContract.CitaEntry._ID + "=?", new String[]{"" + cita.getCodigoCita()}, null, null, null);

        if (cursor.moveToFirst()) {
            cita.setNombreServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_NOMBRESERVICIO)));
        }
        sqLiteDatabase.close();
    }

    @Override
    public List<Cita> obtenerCitas() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.CitaEntry.TABLE_NAME,
                null, null, null, null, null, null);

        List<Cita> citas = new ArrayList<>();
        cursor.moveToFirst();
        if(cursor.getCount() != 0){
            do {
                Cita cita = new Cita();
                cita.setCodigoCita(cursor.getInt(cursor.getColumnIndex(TablaDBContract.CitaEntry._ID)));
                cita.setFechaCita(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_FECHACITA)));
                cita.setHora(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_HORA)));
                cita.setNombreServicio(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_NOMBRESERVICIO)));
                cita.setNombreEmpleado(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_NOMBREEMPLEADO)));
                cita.setEstado(cursor.getString(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_ESTADO)));
                cita.setImagen(cursor.getBlob(cursor.getColumnIndex(TablaDBContract.CitaEntry.COLUMN_IMAGENEMPLEADO)));
                citas.add(cita);

            } while (cursor.moveToNext());

        }

        sqLiteDatabase.close();

        return citas;
    }

    @Override
    public long actualizarCita(Cita cita) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TablaDBContract.CitaEntry.COLUMN_ESTADO, cita.getEstado());
        long row = sqLiteDatabase.update(TablaDBContract.CitaEntry.TABLE_NAME,contentValues,TablaDBContract.CitaEntry._ID + " ="+cita.getCodigoCita(),null);
        return row;
    }
}
