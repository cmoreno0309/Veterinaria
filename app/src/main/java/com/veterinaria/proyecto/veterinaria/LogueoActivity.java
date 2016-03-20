package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rosa on 17/03/2016.
 */
public class LogueoActivity extends Activity{

    protected void onCreate(Bundle savedInstanceStatte) {
        super.onCreate(savedInstanceStatte);
        setContentView(R.layout.act_logueo);
        Button btn_logueo = (Button) findViewById(R.id.btn_logueo);
        btn_logueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                String password = ((EditText) findViewById(R.id.txt_password)).getText().toString();

                Log.d("Usuario:",usuario+" "+password);
                if (usuario.equals("Maria") && password.equals("123")){
                    Log.d("Entro","yee");
                    startActivity(new Intent(getApplicationContext(),MascotasActivity.class));
                }else{
                    Log.d("No Entro","yee");
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT);
                }

        }
        });
    }


    public void btn_cuenta(View view) {
        startActivity(new Intent(this,RegistroCuenta.class));

    }
}
