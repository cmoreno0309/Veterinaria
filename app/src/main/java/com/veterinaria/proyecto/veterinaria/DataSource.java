package com.veterinaria.proyecto.veterinaria;

import com.veterinaria.proyecto.veterinaria.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Cita;
import domain.Empleado;
import domain.HorarioAtencion;
import domain.Mascota;
import domain.Noticia;
import domain.Recordatorio;
import domain.Servicio;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class DataSource {


    static List<Mascota>      MASCOTAS     = new ArrayList<Mascota>();
    static List<Noticia>      NOTICIAS     = new ArrayList<Noticia>();
    static List<Recordatorio> RECORDATORIO = new ArrayList<Recordatorio>();
    static List<Servicio>     SERVICIO     = new ArrayList<Servicio>();
    static List<Cita>         CITA         = new ArrayList<Cita>();
    static List<HorarioAtencion> HORARIO   = new ArrayList<HorarioAtencion>();




    static{
        /*
        MASCOTAS.add(new Mascota(1,R.drawable.chiguaga,"Chocolate","3 meses","17/01/2016","Macho","chiguagua","7 kilos","Ricocan","Vacuna mensual","si",""));
        MASCOTAS.add(new Mascota(2,R.drawable.perrito,"Shadow","1 año","24/05/2015","Macho","Labrador","23 kilos","Mimaskot","Gotitas al ojo diario","no",""));
        MASCOTAS.add(new Mascota(3,R.drawable.perrito1,"Pepa","5 años","10/04/2011","Hembra","Pequines","10 kilos","Pedigree","Curación de uñas","no",""));
        */
        NOTICIAS.add(new Noticia("1","Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.chiguaga));
        NOTICIAS.add(new Noticia("2","Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.perrito));

        RECORDATORIO.add(new Recordatorio("1","21/03/2015","Pastillas"));
        RECORDATORIO.add(new Recordatorio("2","21/03/2015","Crema"));
        RECORDATORIO.add(new Recordatorio("3","22/03/2015","Pastillas"));
        /*
        SERVICIO.add(new Servicio("1","Peluqueria","Corte de pelo y lavado"));
        SERVICIO.add(new Servicio("1","Baño","Lavado con shampoo anti pulgas"));
        SERVICIO.add(new Servicio("3","Esterilización","Machos y Hembras"));
        */
        CITA.add(new Cita("1",new Empleado("1","Carlos",new Servicio("1","Peluqueria")),new Date(),new Servicio("1","Peluqieria")));
        CITA.add(new Cita("2",new Empleado("1","Juan",new Servicio("1","Peluqueria")),new Date(),new Servicio("2","Baño")));

        HORARIO.add(new HorarioAtencion("1",new Date(),false,new Empleado("1","Juan Perez",new Servicio("1","Peluqueria"))));
        HORARIO.add(new HorarioAtencion("2",new Date(),false,new Empleado("2","Jose Lopez",new Servicio("1","Medico"))));
        HORARIO.add(new HorarioAtencion("3",new Date(),false,new Empleado("3","Carlos Perez",new Servicio("1","Baño"))));


    }

}
