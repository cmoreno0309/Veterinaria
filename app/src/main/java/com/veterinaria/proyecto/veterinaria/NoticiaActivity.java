package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import domain.Noticia;

public class NoticiaActivity extends AppCompatActivity {

    ListView lista;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_noticia);

        recyclerView = (RecyclerView) findViewById(R.id.lst_objetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(this,DataSource.NOTICIAS,1);
        recyclerView.setAdapter(adapter);
    }


}
