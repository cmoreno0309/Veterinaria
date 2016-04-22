package com.veterinaria.proyecto.veterinaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;


public class NoticiaActivity extends AppCompatActivity {

    public static final String ID_NOTICIA = "idNoticia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_noticia);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = this.getIntent().getExtras();
        String idCodigoNoticia = parametros.getString(ID_NOTICIA);

        Log.d("ID NOTICIA",idCodigoNoticia);

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
