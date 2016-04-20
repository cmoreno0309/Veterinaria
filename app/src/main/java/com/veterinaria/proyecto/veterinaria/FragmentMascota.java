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

import com.veterinaria.proyecto.veterinaria.data.MascotaDAO;
import com.veterinaria.proyecto.veterinaria.data.MascotaSQLite;

import java.util.ArrayList;
import java.util.List;

import domain.Mascota;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentMascota extends Fragment {

    RecyclerView recyclerView;
    private MascotaDAO mascotaDAO;

    public FragmentMascota(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mascotaDAO= new MascotaSQLite(getContext());
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Mascota> mascotas = new ArrayList<>();

        View rootView = inflater.inflate(R.layout.content_mascotas, container, false);

        //Lista de Servicios
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(mascotaDAO.obtenerMascotas() != null && !mascotaDAO.obtenerMascotas().isEmpty()){
            mascotas = mascotaDAO.obtenerMascotas();
        }else{
            mascotas = null;
        }


        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),mascotaDAO.obtenerMascotas(),0);
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
