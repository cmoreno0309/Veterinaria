package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class RegistroMascota extends Fragment {

    public static final String ID_MASCOTA = "ID_MASCOTA";
    public static final String NOMBRE = "NOMBRE";
    public static final String EDAD = "EDAD";
    public static final String CUMPLEANOS = "CUMPLEANOS";
    public static final String SEXO = "SEXO";
    public static final String RAZA = "RAZA";
    public static final String PESO = "PESO";
    public static final String ALIMENTACION = "ALIMENTACION";
    public static final String TRATAMIENTO = "TRATAMIENTO";
    public static final String COLOR = "COLOR";
    public static final String ESTERILIZADO = "ESTERILIZADO";
    public static final String ENCONTRADO = "ENCONTRADO";
    private EditText edtnombre,edtcumpleanos,edtcolor,edtraza,edtpeso,edtalimentacion,edtesterilizado;
    int idmascota;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_registro_mascota, container, false);


        edtnombre = (EditText) rootView.findViewById(R.id.edtnombre);
        //edtanios = (EditText) findViewById(R.id.edtanios);
        edtcumpleanos = (EditText) rootView.findViewById(R.id.edtcumpleanos);
        edtcolor = (EditText) rootView.findViewById(R.id.edtcolor);
        //edtsexo = (EditText) findViewById(R.id.edtsexo);
        edtraza = (EditText) rootView.findViewById(R.id.edtraza);
        edtpeso = (EditText) rootView.findViewById(R.id.edtpeso);
        edtalimentacion = (EditText) rootView.findViewById(R.id.edtalimentacion);
        //edtesterilizado = (EditText) findViewById(R.id.edtesterilizado);

        Bundle parametros = new Bundle();
               parametros = getActivity().getIntent().getExtras();
        Boolean encontrado = parametros.getBoolean(ENCONTRADO);

        if(encontrado){


            idmascota = parametros.getInt(ID_MASCOTA);
            String nombre = parametros.getString(NOMBRE);
            String edad = parametros.getString(EDAD);
            String cumpleanos = parametros.getString(CUMPLEANOS);
            String sexo = parametros.getString(SEXO);
            String raza = parametros.getString(RAZA);
            String peso = parametros.getString(PESO);
            String alimentacion = parametros.getString(ALIMENTACION);
            String tratamiento = parametros.getString(TRATAMIENTO);
            String color = parametros.getString(COLOR);
            String esterilizado = parametros.getString(ESTERILIZADO);


            edtnombre.setText(nombre);
            //edtanios.setText(edad);
            edtcumpleanos.setText(cumpleanos);
            edtcolor.setText(color);
            //edtsexo.setText(raza);
            edtraza.setText(raza);
            edtpeso.setText(peso);
            edtalimentacion.setText(alimentacion);
            /*edtesterilizado.setText(esterilizado);*/
        }

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setContentView(R.layout.content_registro_mascota);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    public void mGuardarMascota(View view){
        Intent intent= new Intent();
        intent.putExtra(NOMBRE,edtnombre.getText().toString());
        intent.putExtra(CUMPLEANOS,edtcumpleanos.getText().toString());
        //intent.putExtra(SEXO,txtNombre.getText().toString());
        intent.putExtra(RAZA,edtraza.getText().toString());
        intent.putExtra(PESO,edtpeso.getText().toString());
        intent.putExtra(ALIMENTACION,edtalimentacion.getText().toString());
        intent.putExtra(COLOR,edtcolor.getText().toString());
        //intent.putExtra(ESTERILIZADO,edtesterilizado.getText().toString());
        //setResult(Activity.RESULT_OK,intent);
        //getActivity().startActivityForResult(RESULT_OK,intent);
        //finish();
    }

    public void mLimpiarRegistro(View view){
        edtnombre.setText("");
        edtcumpleanos.setText("");
        edtcolor.setText("");
        edtraza.setText("");
        edtpeso.setText("");
        edtalimentacion.setText("");
        edtesterilizado.setText("");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                //finish();
                break;

        }
        return true;
    }
}
