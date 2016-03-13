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

        MASCOTAS.add(new Mascota("Chocolate","3 meses",R.drawable.chiguaga));
        MASCOTAS.add(new Mascota("Negro","5 meses", R.drawable.perrito));
        MASCOTAS.add(new Mascota("Pinky","1 año",R.drawable.perrito1));

        NOTICIAS.add(new Noticia("Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.chiguaga));
        NOTICIAS.add(new Noticia("Cuidados con perritos pequeños","Perrito chiguaga ...................",R.drawable.perrito));

    }

}
