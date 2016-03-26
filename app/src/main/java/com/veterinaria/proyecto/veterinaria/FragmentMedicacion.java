package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cmoreno on 21/03/2016.
 */
public class FragmentMedicacion extends Fragment {

    RecyclerView recyclerView;

    public FragmentMedicacion() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_rec_medicacion, container, false);

        //Lista de Recordatorios
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),DataSource.RECORDATORIO,2);
        recyclerView.setAdapter(adapter);

        return rootView;
    }





}
