package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.veterinaria.proyecto.veterinaria.recordatorios.Bano;
import com.veterinaria.proyecto.veterinaria.recordatorios.Examen;
import com.veterinaria.proyecto.veterinaria.recordatorios.Peluqueria;


public class FragmentRecordatorio extends Fragment {

    private FragmentTabHost tabHost;

    public FragmentRecordatorio(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.act_recordatorios, container, false);

        tabHost = (FragmentTabHost) getView().findViewById(android.R.id.tabhost);

        //tabHost.setup(FragmentRecordatorio.this,
          //      getFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Lengüeta 1"),
                Bano.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Lengüeta 2"),
                Peluqueria.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Lengüeta 3"),
                Examen.class, null);

        return rootView;
    }
}
