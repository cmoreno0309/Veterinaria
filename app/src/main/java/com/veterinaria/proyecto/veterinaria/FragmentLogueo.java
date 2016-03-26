package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentLogueo extends Fragment {

    EditText txtUsuario,txtClave;
    TextView link_registrar;

    public FragmentLogueo(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_logueo, container, false);
        Button btn_logueo = (Button) rootView.findViewById(R.id.btn_logueo);

        txtUsuario      = (EditText) rootView.findViewById(R.id.txt_usuario);
        txtClave        = (EditText) rootView.findViewById(R.id.txt_password);
        link_registrar  = (TextView) rootView.findViewById(R.id.link_registrar);

        Log.d("Usuario2:", txtUsuario + " Password2:" + txtClave);

        btn_logueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Usuario:", txtUsuario.getText().toString() + " " + txtClave.getText().toString());
                if (txtUsuario.getText().toString().equals("Maria") && txtClave.getText().toString().equals("123")) {
                    Log.d("Entro", "yee");

                    FragmentMascota fragment2 = new FragmentMascota();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setBreadCrumbTitle(getResources().getString(R.string.btn_dueno));
                    fragmentTransaction.replace(R.id.content_frame, fragment2);
                    fragmentTransaction.commit();


                } else {
                    Log.d("No Entro", "yee");
                    Toast.makeText(getActivity(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        link_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegistroCuenta.class));
            }
        });

        return rootView;
    }



}
