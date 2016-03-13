package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import domain.Mascota;

public class MascotasActivity extends Activity implements AdapterView.OnItemClickListener  {

    ListView lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_mascotas);

        //Instancia del ListView
        lista = (ListView)findViewById(R.id.lst_mascotas);

        //Inicializar el adaptador con la fuente de datos
        adaptador = new MascotasArrayAdapter(this, DataSource.MASCOTAS);

        //Relacionando la lista con el adaptador
        lista.setAdapter(adaptador);

        //Estableciendo la escucha
        lista.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Mascota mascota = (Mascota)adaptador.getItem(position);
        String msg = "Elegiste la tarea:\n"+mascota.getNombre()+"-"+mascota.getEdad();
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

    }
}
