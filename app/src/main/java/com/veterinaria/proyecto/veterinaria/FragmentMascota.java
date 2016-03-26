package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentMascota extends Fragment {

    RecyclerView recyclerView;

    public FragmentMascota(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_mascotas, container, false);

        //Lista de Servicios
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),DataSource.MASCOTAS,0);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle parametros = new Bundle();
                parametros.putBoolean("ENCONTRADO", false);
                Intent intent = new Intent(getActivity(), RegistroMascota.class);
                intent.putExtras(parametros);
                startActivityForResult(intent, 1234);
            }
        });



        return rootView;
    }



}
