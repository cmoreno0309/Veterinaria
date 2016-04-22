package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veterinaria.proyecto.veterinaria.data.ServicioDAO;
import com.veterinaria.proyecto.veterinaria.data.ServicioSQLite;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import domain.Servicio;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentServicio extends Fragment {

    RecyclerView recyclerView;

    ServicioDAO servicioDAO;

    public FragmentServicio(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        servicioDAO= new ServicioSQLite(getContext());

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_servicio, container, false);

        //Lista de Servicios
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lst_objetos);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getActivity(),servicioDAO.obtenerServicios(),3);
        recyclerView.setAdapter(adapter);

        //Convertir imagen en byte
        /*File file = new File("cirugia.jpg");

        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];

        Servicio servicio = new Servicio();
        servicio.setNombreServicio("Baños");
        servicio.setDescripcionServicio("");
        servicio.setImagen(buf);

        long resultado =  servicioDAO.registrarServicio(servicio);

        Log.d("Resultado: ",String.valueOf(resultado));*/

        return rootView;
    }


}
