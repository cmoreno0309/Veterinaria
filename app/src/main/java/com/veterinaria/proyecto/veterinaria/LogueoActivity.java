package com.veterinaria.proyecto.veterinaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
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
                if (usuario.equals("fulanofeliz") && password.equals("123")){
                    setContentView(R.layout.act_recordatorios);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT);
                }

        }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }


}
