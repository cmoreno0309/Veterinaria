package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sCallegari on 21/04/16.
 */
public class FragmentPerfil extends Fragment{

    SharedPreferences pref;

    public static final String NOMBRE= "NOMBRE";

    public FragmentPerfil(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = this.getActivity().getSharedPreferences("pref2", Context.MODE_PRIVATE);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.content_dueno, container, false);
        TextView txt_nombre = (TextView) rootview.findViewById(R.id.txt_nombre);
        txt_nombre.setText(pref.getString(NOMBRE,""));
        Button btn_editar = (Button) rootview.findViewById(R.id.btn_editar);

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentPerfilEditable fragment2 = new FragmentPerfilEditable();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setBreadCrumbTitle(getResources().getString(R.string.btn_dueno));
                fragmentTransaction.replace(R.id.content_frame, fragment2);
                fragmentTransaction.commit();
            }
        });

        return rootview;
    }



}
