package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sCallegari on 21/04/16.
 */
public class FragmentPerfil extends Fragment{
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
