package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    RecyclerView.LayoutManager   mLayoutManager;
    protected String[] mDataset;

    public FragmentMedicacion() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initDataset();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Lista de Recordatorios
        recyclerView = (RecyclerView) container.findViewById(R.id.lst_objetos);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getContext(),DataSource.RECORDATORIO,0);
        recyclerView.setAdapter(adapter);

        return inflater.inflate(R.layout.content_rec_medicacion, container, false);
    }

    private void initDataset() {
        mDataset = new String[60];
        for (int i = 0; i < 60; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }
}
