package com.veterinaria.proyecto.veterinaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class RegistroCita extends AppCompatActivity {

    RecyclerView recyclerView;
    public static final String VETERINARIO = "VETERINARIO";
    public static final String FECHA_CITA = "FECHA_CITA";
    public static final String ENCONTRADO = "ENCONTRADO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_registro_cita);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*Intent intent= getIntent();

        boolean encontrado=intent.getBooleanExtra(RegistroCita.ENCONTRADO, true);

        if(encontrado){
            String nombre_veterinario = intent.getStringExtra(RegistroCita.VETERINARIO);
            String fecha_cita = intent.getStringExtra(RegistroCita.FECHA_CITA);

        }*/

        recyclerView = (RecyclerView) findViewById(R.id.lst_objetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HashSet<Date> events = new HashSet<>();
        events.add(new Date());

        CalendarView cv = ((CalendarView)findViewById(R.id.calendar_view));
        cv.updateCalendar(events);

        cv.setEventHandler(new CalendarView.EventHandler() {
            @Override

            public void onDayLongPress(Date date) {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance();
                //Toast.makeText(RegistroCita.this, df.format(date), Toast.LENGTH_SHORT).show();

                RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getBaseContext(),DataSource.HORARIO,5);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home   : finish();
                break;
        }

        return true;
    }

}
