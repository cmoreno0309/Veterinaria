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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.veterinaria.proyecto.veterinaria.data.CitaDAO;
import com.veterinaria.proyecto.veterinaria.data.CitaSQLite;
import com.veterinaria.proyecto.veterinaria.data.MascotaSQLite;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import domain.Cita;
import domain.Servicio;

public class RegistroCita extends AppCompatActivity {

    RecyclerView recyclerView;
    public static final String VETERINARIO = "VETERINARIO";
    public static final String FECHA_CITA = "FECHA_CITA";
    public static final String ENCONTRADO = "ENCONTRADO";
    private CitaDAO citaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_registro_cita);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        citaDAO= new CitaSQLite(this);

       /* Cita cita = new Cita();
        cita.setCodigoCita(1);
        cita.setFechaCita("23/04/016");
        cita.setHora("10:00 p.m");
        cita.setNombreServicio("Peluqueria");
        cita.setNombreEmpleado("Juan Perez");
        cita.setEstado("Reservado");

        //Convertir imagen en byte

        long resultado =  citaDAO.registrarCita(cita);


        Cita cita1 = new Cita();

        cita1.setCodigoCita(2);
        cita1.setFechaCita("23/04/016");
        cita1.setHora("09:00 p.m");
        cita1.setNombreServicio("Consulta Médica");
        cita1.setNombreEmpleado("Diana Paredes");
        cita1.setEstado("Sin Reserva");

        //Convertir imagen en byte

        long resultado1 =  citaDAO.registrarCita(cita1);

        Cita cita2 = new Cita();

        cita2.setCodigoCita(3);
        cita2.setFechaCita("23/04/016");
        cita2.setHora("08:00 p.m");
        cita2.setNombreServicio("Consulta Médica");
        cita2.setNombreEmpleado("Julio Morales");
        cita2.setEstado("Reservado");

        //Convertir imagen en byte

        long resultado2 =  citaDAO.registrarCita(cita2);


        Log.d("Resultado: ", String.valueOf(resultado2));
*/
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
                Log.d("Calendario ", "fecha");
                RecyclerView.Adapter adapter= new AdapterRecyclerVeterinaria(getBaseContext(),citaDAO.obtenerCitas(),5);
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
