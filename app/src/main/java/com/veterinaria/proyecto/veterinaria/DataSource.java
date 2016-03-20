package com.veterinaria.proyecto.veterinaria;

import com.veterinaria.proyecto.veterinaria.R;

import java.util.ArrayList;
import java.util.List;

import domain.Mascota;
import domain.Noticia;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class DataSource {


    static List<Mascota> MASCOTAS=new ArrayList<Mascota>();
    static List<Noticia> NOTICIAS=new ArrayList<Noticia>();




    static{

       MASCOTAS.add(new Mascota(1,R.drawable.chiguaga,"Chocolate","3 meses","17/01/2016","Macho","chiguagua","7 kilos","Ricocan","Vacuna mensual","si",""));
        MASCOTAS.add(new Mascota(2,R.drawable.perrito,"Shadow","1 año","24/05/2015","Macho","Labrador","23 kilos","Mimaskot","Gotitas al ojo diario","no",""));
        MASCOTAS.add(new Mascota(3,R.drawable.perrito1,"Pepa","5 años","10/04/2011","Hembra","Pequines","10 kilos","Pedigree","Curación de uñas","no",""));

        NOTICIAS.add(new Noticia("Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.chiguaga));
        NOTICIAS.add(new Noticia("Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.perrito));

    }

}
