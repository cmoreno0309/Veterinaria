package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.veterinaria.proyecto.veterinaria.data.MascotaDAO;
import com.veterinaria.proyecto.veterinaria.data.MascotaSQLite;
import com.veterinaria.proyecto.veterinaria.data.ServicioSQLite;

import domain.Mascota;

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
    MascotaDAO mascotaDAO;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mascotaDAO= new MascotaSQLite(getContext());
    }

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


        return rootView;
    }



    public void mGuardarMascota(View view){
        Mascota mascota = new Mascota();
        mascota.setNombre(edtnombre.getText().toString());
        mascota.setCumpleanos(edtcumpleanos.getText().toString());
        mascota.setRaza(edtraza.getText().toString());
        mascota.setPeso(edtpeso.getText().toString());
        mascota.setEdad("22");
        mascota.setAlimentacion(edtalimentacion.getText().toString());
        mascota.setColor(edtcolor.getText().toString());

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
        long resultado =  mascotaDAO.registrarMascota(mascota);
        Log.d("Resultado registro ", String.valueOf(resultado));
        getActivity().setResult(getActivity().RESULT_OK, intent);
        getActivity().finish();
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
