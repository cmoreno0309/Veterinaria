package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionMascota extends AppCompatActivity {

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
    public static final String IMAGEN = "IMAGEN";
    public static final String ENCONTRADO = "ENCONTRADO";

    private TextView txtnombre,txtanios,txtcumpleanos,txtcolor,txtsexo,txtraza,txtpeso,txtalimentacion,txttratamiento;
    private ImageView imgfoto;
    private ImageView _btn1, _btn2, _btn3;
    int idmascota;
    String esterilizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_descripcion_mascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtnombre = (TextView) findViewById(R.id.txtnombre);
        txtanios = (TextView) findViewById(R.id.txtanios);
        txtcumpleanos = (TextView) findViewById(R.id.txtcumpleanos);
        txtcolor = (TextView) findViewById(R.id.txtcolor);
        txtsexo = (TextView) findViewById(R.id.txtsexo);
        txtraza = (TextView) findViewById(R.id.txtraza);
        txtpeso = (TextView) findViewById(R.id.txtpeso);
        txtalimentacion = (TextView) findViewById(R.id.txtalimentacion);
        txttratamiento = (TextView) findViewById(R.id.txttratamiento);
        imgfoto = (ImageView) findViewById(R.id.imgfoto);

        Bundle parametros = this.getIntent().getExtras();
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
        int imagen = parametros.getInt(IMAGEN);
        esterilizado = parametros.getString(ESTERILIZADO);
        Log.d("imagen" , imagen + "");


        imgfoto.setImageResource(imagen);
        txtnombre.setText(nombre);
        txtanios.setText(edad);
        txtcumpleanos.setText(cumpleanos);
        txtcolor.setText(color);
        txtsexo.setText(sexo);
        txtraza.setText(raza);
        txtpeso.setText(peso);
        txtalimentacion.setText(alimentacion);
        txttratamiento.setText(tratamiento);


    }

    public void mEditarMascota(View view){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


            if(resultCode==RESULT_OK) {
                /*String mensaje = data.getStringExtra(RegistroMascota.NOMBRE) +
                        " " + data.getStringExtra(DetallePersonaActivity.APELLIDO)
                        + " save!";*/
                //Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                txtnombre.setText(data.getStringExtra(RegistroMascota.NOMBRE));
                txtcumpleanos.setText(data.getStringExtra(RegistroMascota.CUMPLEANOS));
                txtcolor.setText(data.getStringExtra(RegistroMascota.COLOR));
                //txtsexo.setText(data.getStringExtra(RegistroMascota.NOMBRE));
                txtraza.setText(data.getStringExtra(RegistroMascota.RAZA));
                txtpeso.setText(data.getStringExtra(RegistroMascota.PESO));
                txtalimentacion.setText(data.getStringExtra(RegistroMascota.ALIMENTACION));
                //txttratamiento.setText(data.getStringExtra(RegistroMascota.NOMBRE));
            }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_mascota, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home   : finish();
                                       break;
            case R.id.mn_recordatorio: startActivity(new Intent(this, RecordatorioActivity.class));
                                       break;
            case R.id.mn_reservar    : startActivity(new Intent(this, RegistroCita.class));
                                       break;
            case R.id.mn_editar      :  //Define el bundle
                                        Bundle parametros = new Bundle();
                                        parametros.putInt("ID_MASCOTA", idmascota);
                                        parametros.putString("NOMBRE", txtnombre.getText() + "");
                                        parametros.putString("EDAD", txtanios.getText() + "");
                                        parametros.putString("CUMPLEANOS", txtcumpleanos.getText() + "");
                                        parametros.putString("SEXO",txtsexo.getText() + "");
                                        parametros.putString("RAZA",  txtraza.getText() + "");
                                        parametros.putString("PESO", txtpeso.getText() + "");
                                        parametros.putString("ALIMENTACION",  txtalimentacion.getText() + "");
                                        parametros.putString("TRATAMIENTO",  txttratamiento.getText() + "");
                                        parametros.putString("COLOR", txtcolor.getText() + "");
                                        parametros.putString("ESTERILIZADO", esterilizado);
                                        parametros.putBoolean("ENCONTRADO", true);

                                        Intent intent = new Intent(this,Main_Fragment_Mascota.class);
                                        intent.putExtras(parametros);

                                        //Inicia la actividad
                                        startActivityForResult(intent,1234);
                                        break;

        }

        return true;
    }



}
