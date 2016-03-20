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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        switch (id){
            case R.id.mn_casa:
                               break;
            case R.id.mn_mascota: startActivity(new Intent(this,LogueoActivity.class));
                                  break;
            case R.id.mn_noticia:startActivity(new Intent(this,NoticiaActivity.class));
                                 break;
            case R.id.mn_dueno: startActivity(new Intent(this,DuenoActivity.class));
                                break;
            case R.id.mn_servicio: startActivity(new Intent(this,ServicioActivity.class));
                                   break;

        }



        
        return super.onOptionsItemSelected(item);
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
