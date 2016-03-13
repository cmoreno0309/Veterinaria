package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import domain.Mascota;
import domain.Noticia;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class NoticiasArrayAdapter<T> extends ArrayAdapter<Noticia> {

    public NoticiasArrayAdapter(Context context, List<Noticia> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View listItemView = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo con two_line_list_item.xml
            listItemView = inflater.inflate(R.layout.lista_noticias, parent,false);
        }

        //Obteniendo instancias de los text views
        TextView txt_Titulo  = (TextView)listItemView.findViewById(R.id.txt_titulo);
        TextView txt_Descripcion    = (TextView)listItemView.findViewById(R.id.txt_descripcion);
        ImageView img_noticia= (ImageView) listItemView.findViewById(R.id.ico_noticia);

        //Obteniendo instancia de la Tarea en la posición actual
        Noticia item = getItem(position);

        txt_Titulo.setText(item.getTitulo());
        txt_Descripcion.setText(item.getDescripcion());
        img_noticia.setImageResource(item.getImagen());

        return listItemView;

    }






}
