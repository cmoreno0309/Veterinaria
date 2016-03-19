package com.example.rosa.veterinaria_s;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Rosa on 17/03/2016.
 */
public class ServicioActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_servicios);
    }
    public void llenarServicioB(View view){

        TextView t = (TextView) findViewById(R.id.txt_servicio);
        t.setText("Info de bano");

    }

    public void llenarServicioE(View view){

        TextView t = (TextView) findViewById(R.id.txt_servicio);
        t.setText("Info de examenes");

    }

    public void llenarServicioP(View view){

        TextView t = (TextView) findViewById(R.id.txt_servicio);
        t.setText("Info de peluqueria");

    }
}
