package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import domain.Noticia;

public class NoticiaActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_noticia);
        //Instancia del ListView
        /*lista = (ListView)findViewById(R.id.lst_noticias);

        //Inicializar el adaptador con la fuente de datos
        adaptador = new NoticiasArrayAdapter(this, DataSource.NOTICIAS);

        //Relacionando la lista con el adaptador
        lista.setAdapter(adaptador);

        //Estableciendo la escucha
        lista.setOnItemClickListener(this);*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Noticia noticia = (Noticia)adaptador.getItem(position);
        String msg = "Elegiste la tarea:\n"+noticia.getTitulo();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}
