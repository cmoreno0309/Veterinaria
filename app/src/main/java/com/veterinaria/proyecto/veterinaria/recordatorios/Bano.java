package com.veterinaria.proyecto.veterinaria.recordatorios;

/**
 * Created by Rosa on 15/03/2016.
 */
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;

import com.veterinaria.proyecto.veterinaria.R;

public class Bano extends Fragment {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.content_rec_bano, container, false);

    }
}
