package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentServicio extends Fragment {

    RecyclerView recyclerView;

    public FragmentServicio(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_servicio, container, false);

        //Lista de Servicios
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),DataSource.SERVICIO,3);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


}
