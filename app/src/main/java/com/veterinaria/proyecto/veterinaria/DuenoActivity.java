package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by ANDROID on 19/03/2016.
 */
public class DuenoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dueno);
        Button btn_editar = (Button) findViewById(R.id.btn_editar);
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.content_dueno_editable);
            }
        });
       /* Button btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // setContentView(R.layout.content_dueno);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

}
