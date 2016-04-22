package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veterinaria.proyecto.veterinaria.data.PerfilDAO;
import com.veterinaria.proyecto.veterinaria.data.PerfilSQLite;

/**
 * Created by sCallegari on 21/04/16.
 */
public class FragmentPerfil extends Fragment{

    private PerfilDAO perfilDAO;

    public FragmentPerfil(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.content_dueno, container, false);

        return rootview;
    }

}
