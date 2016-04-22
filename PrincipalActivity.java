package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.mn_mascota: startActivity(new Intent(this,LogueoActivity.class));
                                  break;
            case R.id.mn_servicio: startActivity(new Intent(this,ServicioActivity.class));
                                   break;

        }

        return true;
    }

    public void btn_Historia(View view) {
        Intent intent = new Intent(this,HistoriaActivity.class);
        startActivity(intent);
    }

    public void btn_Contactenos(View view) {
        Intent intent = new Intent(this,Contactenos.class);
        startActivity(intent);
    }





}
