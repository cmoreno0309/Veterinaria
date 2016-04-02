package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RegistroCita extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_registro_cita);

        recyclerView = (RecyclerView) findViewById(R.id.lst_objetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(this,DataSource.HORARIO,5);
        recyclerView.setAdapter(adapter);

    }

}
