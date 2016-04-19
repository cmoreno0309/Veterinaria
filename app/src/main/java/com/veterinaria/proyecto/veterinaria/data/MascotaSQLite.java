package com.veterinaria.proyecto.veterinaria.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import domain.Mascota;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class MascotaSQLite implements MascotaDAO {

    MySqlOpenHelper mySqlOpenHelper;

    public MascotaSQLite(Context context) {
        Log.d("basededatos", "PersonaSQLite");
        mySqlOpenHelper = new MySqlOpenHelper(context);

    }

    @Override
    public void obtenerMascota(Mascota mascota) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.MascotaEntry.TABLE_NAME,
                null, TablaDBContract.MascotaEntry.COLUMN_NOMBRE + "=?",
                new String[]{"" + mascota.getNombre()}, null, null, null);

        if (cursor.moveToFirst()) {
            mascota.setNombre(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_NOMBRE)));
            mascota.setSexo(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_SEXO)));
            mascota.setEdad(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_EDAD)));
            mascota.setAlimentacion(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_ALIMENTACION)));
            mascota.setImagen(cursor.getBlob(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_IMAGEN)));
        }
        sqLiteDatabase.close();
    }

    @Override
    public List<Mascota> obtenerMascotas() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TablaDBContract.MascotaEntry.TABLE_NAME,
                null, null, null, null, null, null);

        List<Mascota> mascotas = new ArrayList<>();
        cursor.moveToFirst();
        if(cursor.getCount() != 0){
            do {
                Mascota mascota = new Mascota();
                mascota.setNombre(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_NOMBRE)));
                mascota.setSexo(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_SEXO)));
                mascota.setAlimentacion(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_ALIMENTACION)));
                mascota.setEdad(cursor.getString(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_EDAD)));
                mascota.setImagen(cursor.getBlob(cursor.getColumnIndex(TablaDBContract.MascotaEntry.COLUMN_IMAGEN)));
                mascotas.add(mascota);

            } while (cursor.moveToNext());

        }

        sqLiteDatabase.close();

        return mascotas;
    }


    @Override
    public int actualizarMascota(Mascota mascota) {
        return 0;
    }

    @Override
    public long registrarMascota(Mascota mascota) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_NOMBRE, mascota.getNombre());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_ALIMENTACION, mascota.getAlimentacion());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_COLOR, mascota.getColor());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_EDAD, mascota.getEdad());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_CUMPLEANIOS, mascota.getCumpleanos());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_ESTERILIZADO, mascota.getEsterilizado());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_SEXO, mascota.getSexo());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_TRATAMIENTO, mascota.getTratamiento());
        contentValues.put(TablaDBContract.MascotaEntry.COLUMN_IMAGEN, mascota.getImagen());

        long row = sqLiteDatabase.
                insert(TablaDBContract.MascotaEntry.TABLE_NAME, null, contentValues);


        return row;
    }
}
