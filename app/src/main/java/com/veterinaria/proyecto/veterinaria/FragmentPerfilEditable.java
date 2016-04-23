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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ANDROID on 23/04/2016.
 */
public class FragmentPerfilEditable extends Fragment {

    SharedPreferences.Editor editor;
    SharedPreferences pref;

    EditText txt_nombre;

    public FragmentPerfilEditable(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = this.getActivity().getSharedPreferences("pref2", Context.MODE_PRIVATE);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.content_dueno_editable, container, false);
        EditText txt_ed_nombre = (EditText) rootview.findViewById(R.id.txt_ed_nombre);
        txt_ed_nombre.setText(pref.getString(FragmentPerfil.NOMBRE,"nombre"));

        Button btn_guardar = (Button) rootview.findViewById(R.id.btn_guardar);
        txt_nombre= (EditText) rootview.findViewById(R.id.txt_ed_nombre);

                btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = pref.edit();
                editor.putString(FragmentPerfil.NOMBRE, txt_nombre.getText().toString());

                editor.commit();
                FragmentPerfil fragment2 = new FragmentPerfil();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setBreadCrumbTitle(getResources().getString(R.string.btn_dueno));
                fragmentTransaction.replace(R.id.content_frame, fragment2);
                fragmentTransaction.commit();
            }
        });

        return rootview;
    }
}
