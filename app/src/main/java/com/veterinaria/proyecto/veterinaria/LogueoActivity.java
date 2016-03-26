package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogueoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_logueo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btn_logueo = (Button) findViewById(R.id.btn_logueo);
        TextView link_registrar = (TextView) findViewById(R.id.link_registrar);

        btn_logueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.txt_usuario)).getText().toString();
                String password = ((EditText) findViewById(R.id.txt_password)).getText().toString();

                Log.d("Usuario:", usuario + " " + password);
                if (usuario.equals("Maria") && password.equals("123")) {
                    Log.d("Entro", "yee");
                    startActivity(new Intent(getApplicationContext(), MascotasActivity.class));
                } else {
                    Log.d("No Entro", "yee");
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        link_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MascotasActivity.class));
            }
        });


    }


    public void btn_cuenta(View view) {
        startActivity(new Intent(this, RegistroCuenta.class));

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;

        }
        return true;
    }


}
