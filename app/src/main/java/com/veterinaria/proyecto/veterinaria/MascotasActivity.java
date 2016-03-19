package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import domain.Mascota;

public class MascotasActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mascotas);


        recyclerView = (RecyclerView) findViewById(R.id.lst_objetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(this,DataSource.MASCOTAS,"m");
        recyclerView.setAdapter(adapter);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
      /*  if (id == R.id.action_clear) {
            //Limpiar todos los elementos
            adaptador.clear();
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Mascota mascota = (Mascota)adaptador.getItem(position);
        String msg = "Elegiste la tarea:\n"+mascota.getNombre()+"-"+mascota.getEdad();
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,DescripcionMascota.class);
        startActivity(intent);
    }*/

    public void mRegistrarMascota(View view){
        Intent intent = new Intent(this,RegistroMascota.class);
        startActivity(intent);
    }
}
