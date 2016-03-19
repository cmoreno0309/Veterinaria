package com.example.rosa.veterinaria_s.recordatorios;

/**
 * Created by Rosa on 15/03/2016.
 */

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;

import com.example.rosa.veterinaria_s.R;

public class Examen extends Fragment {

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.content_rec_vacunas, container, false);

    }
}
