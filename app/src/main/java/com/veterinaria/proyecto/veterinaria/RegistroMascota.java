package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class RegistroMascota extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_registro_mascota);

        edtnombre = (EditText) findViewById(R.id.edtnombre);
        //edtanios = (EditText) findViewById(R.id.edtanios);
        edtcumpleanos = (EditText) findViewById(R.id.edtcumpleanos);
        edtcolor = (EditText) findViewById(R.id.edtcolor);
        //edtsexo = (EditText) findViewById(R.id.edtsexo);
        edtraza = (EditText) findViewById(R.id.edtraza);
        edtpeso = (EditText) findViewById(R.id.edtpeso);
        edtalimentacion = (EditText) findViewById(R.id.edtalimentacion);
        //edtesterilizado = (EditText) findViewById(R.id.edtesterilizado);

        Bundle parametros = this.getIntent().getExtras();
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
        setResult(RESULT_OK,intent);
        finish();
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
}
