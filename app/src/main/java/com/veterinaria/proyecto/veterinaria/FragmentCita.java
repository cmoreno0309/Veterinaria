package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentCita extends Fragment {

    RecyclerView recyclerView;

    public FragmentCita(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_cita, container, false);

        //Lista de Citas
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),DataSource.CITA,4);
        recyclerView.setAdapter(adapter);



        return rootView;
    }


}
