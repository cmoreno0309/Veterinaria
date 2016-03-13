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

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class MascotasArrayAdapter<T> extends ArrayAdapter<Mascota> {

    public MascotasArrayAdapter(Context context, List<Mascota> objects) {
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
            listItemView = inflater.inflate(R.layout.lista_mascotas, parent,false);
        }

        //Obteniendo instancias de los text views
        TextView txt_Nombre  = (TextView)listItemView.findViewById(R.id.txt_nombre);
        TextView txt_Edad    = (TextView)listItemView.findViewById(R.id.txt_edad);
        ImageView img_mascota= (ImageView) listItemView.findViewById(R.id.ico_mascota);

        //Obteniendo instancia de la Tarea en la posición actual
        Mascota item = getItem(position);

        txt_Nombre.setText(item.getNombre());
        txt_Edad.setText(item.getEdad());
        img_mascota.setImageResource(item.getImagen());

        return listItemView;

    }






}
