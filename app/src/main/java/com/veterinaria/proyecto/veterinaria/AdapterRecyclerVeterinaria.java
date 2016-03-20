package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import domain.Mascota;
import domain.Noticia;

/**
 * Created by Cmoreno on 18/03/2016.
 */
public class AdapterRecyclerVeterinaria extends RecyclerView.Adapter<AdapterRecyclerVeterinaria.CustomViewHolder> {

    Context context;
    Object  lst_Objetos;
    int     tipoObjeto;
    List<Mascota> lista_mascotas;
    List<Noticia> lista_noticia;


    public AdapterRecyclerVeterinaria(Context context,Object lst_Objetos,int tipoObjeto){
        this.context = context;
        this.lst_Objetos = lst_Objetos;
        this.tipoObjeto  = tipoObjeto;
        switch (tipoObjeto){
            case 0:  this.lista_mascotas = (List<Mascota>)lst_Objetos;
                     break;
            case 1:  this.lista_noticia  = (List<Noticia>)lst_Objetos;
                     break;

        }


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_objetos, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder  viewHolder, int position) {

        switch (tipoObjeto) {
            case 0: Mascota mascota = lista_mascotas.get(position);
                    viewHolder.imagen.setImageResource(mascota.getImagen());
                    viewHolder.txt_principal.setText(mascota.getNombre());
                    viewHolder.txt_secundario.setText(mascota.getEdad());
                    break;

            case 1: Noticia noticia = lista_noticia.get(position);
                    viewHolder.imagen.setImageResource(noticia.getImagen());
                    viewHolder.txt_principal.setText(noticia.getTitulo());
                    viewHolder.txt_secundario.setText(noticia.getDescripcion());


        }




    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imagen;
        private TextView  txt_principal;
        private TextView  txt_secundario;

        public CustomViewHolder(View view) {
            super(view);
            this.imagen         = (ImageView) view.findViewById(R.id.imagen);
            this.txt_principal  = (TextView) view.findViewById(R.id.txt_principal);
            this.txt_secundario = (TextView) view.findViewById(R.id.txt_secundario);

            imagen.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (tipoObjeto) {

                case 0:     int position = getLayoutPosition();
                            Mascota mascota = lista_mascotas.get(position);
                            Bundle parametros = new Bundle();
                            parametros.putInt("ID_MASCOTA", mascota.getCodigo_mascota());
                            parametros.putString("NOMBRE", mascota.getNombre());
                            parametros.putString("EDAD", mascota.getEdad());
                            parametros.putString("CUMPLEANOS", mascota.getCumpleanos());
                            parametros.putString("SEXO", mascota.getSexo());
                            parametros.putString("RAZA", mascota.getRaza());
                            parametros.putString("PESO", mascota.getPeso());
                            parametros.putString("ALIMENTACION", mascota.getAlimentacion());
                            parametros.putString("TRATAMIENTO", mascota.getTratamiento());
                            parametros.putString("COLOR", mascota.getColor());
                            parametros.putInt("IMAGEN", mascota.getImagen());
                            Intent intent = new Intent(context,DescripcionMascota.class);
                            intent.putExtras(parametros);
                            //intent.putExtra("",) parceable algun día ...

                            context.startActivity(intent);
                        break;

                case 1: context.startActivity(new Intent(context,NoticiaActivity.class));
                        break;

            }

        }
    }

    @Override
    public int getItemCount() {

        switch (tipoObjeto) {
            case 0:  return null == lista_mascotas ? 0 : lista_mascotas.size();

            case 1:  return null==lista_noticia? 0: lista_noticia.size();

            default: return 0;


        }
    }


}
