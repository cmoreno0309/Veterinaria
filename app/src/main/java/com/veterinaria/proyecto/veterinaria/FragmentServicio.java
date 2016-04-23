package com.veterinaria.proyecto.veterinaria;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayInputStream;
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
        Bitmap imagen1 = null;
        Resources mRes = getContext().getResources();
        imagen1 = BitmapFactory.decodeResource(mRes,R.drawable.banio);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bitMapByte = null;
        imagen1.compress(Bitmap.CompressFormat.JPEG,0,out);
        bitMapByte = out.toByteArray();
        imagen1.recycle();

        try{
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        Servicio servicio = new Servicio();
        servicio.setNombreServicio("Baños");
        servicio.setDescripcionServicio("");
       // servicio.setImagen(bitMapByte);

        long resultado =  servicioDAO.registrarServicio(servicio);
        Log.d("Resultado: ",String.valueOf(resultado));
        //Servicio 2
        Bitmap imagen2 = null;
        Resources mRes2 = getContext().getResources();
        imagen2 = BitmapFactory.decodeResource(mRes2,R.drawable.peluqueria);

        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        byte[] bitMapByte2 = null;
        imagen2.compress(Bitmap.CompressFormat.JPEG,0,out2);
        bitMapByte2 = out2.toByteArray();
        imagen2.recycle();

        try{
            out2.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }


        Servicio servicio1 = new Servicio();
        servicio1.setNombreServicio("Peluqueria");
        servicio1.setDescripcionServicio("");
        //servicio1.setImagen(bitMapByte2);

        long resultado1 =  servicioDAO.registrarServicio(servicio1);

        Log.d("Resultado: ",String.valueOf(resultado1));

        //Servicio 3
        Bitmap imagen3 = null;
        Resources mRes3 = getContext().getResources();
        imagen3 = BitmapFactory.decodeResource(mRes3,R.drawable.laboratorio);

        ByteArrayOutputStream out3 = new ByteArrayOutputStream();
        byte[] bitMapByte3 = null;
        imagen3.compress(Bitmap.CompressFormat.JPEG,0,out3);
        bitMapByte3 = out3.toByteArray();
        imagen3.recycle();

        try{
            out3.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }


        Servicio servicio3 = new Servicio();
        servicio3.setNombreServicio("Exámenes Médicos");
        servicio3.setDescripcionServicio("Rayos x,Ecografías");
        //servicio3.setImagen(bitMapByte3);

        long resultado3 =  servicioDAO.registrarServicio(servicio3);

        Log.d("Resultado: ",String.valueOf(resultado3));





        return rootView;
    }


}
