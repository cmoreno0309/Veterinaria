package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import domain.Mascota;

/**
 * Created by Cmoreno on 18/03/2016.
 */
public class AdapterRecyclerVeterinaria extends RecyclerView.Adapter<AdapterRecyclerVeterinaria.CustomViewHolder> {

    Context context;
    Object lst_Objetos;
    String tipoObjeto;


    public AdapterRecyclerVeterinaria(Context context,Object lst_Objetos,String tipoObjeto){
        this.context = context;
        this.lst_Objetos = lst_Objetos;
        this.tipoObjeto  = tipoObjeto;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_objetos, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        Log.d("CUSTOMVIEWHOLDER", "create");
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder  viewHolder, int position) {

           List<Mascota> masobj= (List<Mascota>) lst_Objetos;
           Log.d("TAMANO:",String.valueOf(masobj.size()));

           Log.d("TIPO: ", tipoObjeto);

            Mascota mascota = masobj.get(position);
            viewHolder.imagen.setImageResource(mascota.getImagen());
            viewHolder.txt_principal.setText(mascota.getNombre());
            viewHolder.txt_secundario.setText(mascota.getEdad());
            Log.d("ONBINDVIEWHOLDER", "pos " + position);
    }

    @Override
    public int getItemCount() {
        List<Mascota> masobj= (List<Mascota>) lst_Objetos;
            return null==masobj? 0: masobj.size();

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView  txt_principal;
        private TextView  txt_secundario;

        public CustomViewHolder(View view) {
            super(view);
            this.imagen         = (ImageView) view.findViewById(R.id.imagen);
            this.txt_principal  = (TextView) view.findViewById(R.id.txt_principal);
            this.txt_secundario = (TextView) view.findViewById(R.id.txt_secundario);

        }
    }



}
