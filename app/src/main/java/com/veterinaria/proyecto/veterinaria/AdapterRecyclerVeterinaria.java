package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeImageTransform;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.veterinaria.proyecto.veterinaria.data.CitaDAO;
import com.veterinaria.proyecto.veterinaria.data.CitaSQLite;

import java.util.List;

import domain.Cita;
import domain.Empleado;
import domain.HorarioAtencion;
import domain.Mascota;
import domain.Noticia;
import domain.Recordatorio;
import domain.Servicio;

/**
 * Created by Cmoreno on 18/03/2016.
 */
public class AdapterRecyclerVeterinaria extends RecyclerView.Adapter<AdapterRecyclerVeterinaria.CustomViewHolder> {

    Context context;
    Object lst_Objetos;
    int tipoObjeto;
    List<Mascota> lista_mascotas;
    List<Noticia> lista_noticia;
    List<Recordatorio> lista_recordatorio;
    List<Servicio> lista_servicio;
    List<Cita> lista_cita;
    List<HorarioAtencion> lista_horario;
    private CitaDAO citaDAO;
    int posicionCita = 0;

    public static final String VETERINARIO = "VETERINARIO";
    public static final String FECHA_CITA = "FECHA_CITA";

    public AdapterRecyclerVeterinaria(Context context, Object lst_Objetos, int tipoObjeto) {
        this.context = context;
        this.lst_Objetos = lst_Objetos;
        this.tipoObjeto = tipoObjeto;
        citaDAO= new CitaSQLite(context);
        switch (tipoObjeto) {
            case 0:
                this.lista_mascotas = (List<Mascota>) lst_Objetos;
                break;
            case 1:
                this.lista_noticia = (List<Noticia>) lst_Objetos;
                break;
            case 2:
                this.lista_recordatorio = (List<Recordatorio>) lst_Objetos;
                break;
            case 3:
                this.lista_servicio = (List<Servicio>) lst_Objetos;
                break;
            case 4:
                this.lista_cita = (List<Cita>) lst_Objetos;
                break;
            case 5:
                this.lista_cita = (List<Cita>) lst_Objetos;
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
    public void onBindViewHolder(CustomViewHolder viewHolder, int position) {

        switch (tipoObjeto) {
            case 0:
                Mascota mascota = lista_mascotas.get(position);
                byte[] img= mascota.getImagen();
                if(img !=null){
                    Bitmap bitmap= BitmapFactory.decodeByteArray(img, 0, img.length);
                    viewHolder.imagen.setImageBitmap(bitmap);
                }
                viewHolder.txt_principal.setText(mascota.getNombre());
                viewHolder.txt_secundario.setText(mascota.getEdad());
                break;

            case 1:
                Noticia noticia = lista_noticia.get(position);
                viewHolder.imagen.setImageResource(noticia.getImagen());
                viewHolder.txt_principal.setText(noticia.getTitulo());
                viewHolder.txt_secundario.setText(noticia.getDescripcion());
                break;


            case 2:
                Recordatorio recordatorio = lista_recordatorio.get(position);
                viewHolder.txt_principal.setText(recordatorio.getTitulo());
                viewHolder.txt_secundario.setText(recordatorio.getDescripcion());
                break;

            case 3:
                Servicio servicio = lista_servicio.get(position);
                viewHolder.txt_principal.setText(servicio.getNombreServicio());
                viewHolder.txt_secundario.setText(servicio.getDescripcionServicio());
                byte[] imagenServicio= servicio.getImagen();
                if(imagenServicio !=null){
                    Bitmap bitmap= BitmapFactory.decodeByteArray(imagenServicio, 0, imagenServicio.length);
                    viewHolder.imagen.setImageBitmap(bitmap);
                    viewHolder.imagen.setImageBitmap(bitmap);
                }
                break;

            case 4:
                Cita cita = lista_cita.get(position);
                viewHolder.txt_principal.setText(cita.getNombreEmpleado());
                viewHolder.txt_secundario.setText(cita.getNombreServicio()+" "+cita.getFechaCita()+" "+cita.getHora());
                break;

            case 5:
                Cita cita1 = lista_cita.get(position);
                viewHolder.txt_principal.setText(cita1.getNombreEmpleado()+" "+cita1.getEstado());
                viewHolder.txt_secundario.setText(cita1.getNombreServicio()+" "+cita1.getFechaCita()+" "+cita1.getHora());
                break;
        }


    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imagen;
        private TextView txt_principal;
        private TextView txt_secundario;
        private Button btn_vermas;

        public CustomViewHolder(View view) {
            super(view);
            this.imagen = (ImageView) view.findViewById(R.id.imagen);
            this.txt_principal = (TextView) view.findViewById(R.id.txt_principal);
            this.txt_secundario = (TextView) view.findViewById(R.id.txt_secundario);
            this.btn_vermas = (Button) view.findViewById(R.id.btn_vermas);
            switch (tipoObjeto) {
                case 0:
                    this.btn_vermas.setText("Reservar Cita");
                    break;
                case 1:
                    this.btn_vermas.setText("Ver mas");
                    break;
                case 2:
                    this.btn_vermas.setText("Ver mas");
                    break;
                case 3:
                    this.btn_vermas.setText("Ver mas");
                    this.btn_vermas.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    //this.btn_vermas.setText("Reservar Cita");
                    this.btn_vermas.setVisibility(View.INVISIBLE);
                    break;
                case 5:
                    Cita cita1 = lista_cita.get(posicionCita);
                    Log.d("piscion ",String.valueOf(posicionCita));
                    Log.d("Reservado/sin ",cita1.getEstado());
                    posicionCita++;
                    this.btn_vermas.setText("Reservar");
                    if(cita1.getEstado().equals("Reservado")){
                        Log.d("Reservado ","RESERVADO");
                        this.btn_vermas.setVisibility(View.INVISIBLE);
                    }

                    break;

            }


            imagen.setOnClickListener(this);

            btn_vermas.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            if (v.getId() == this.imagen.getId()) {
                switch (tipoObjeto) {

                    case 0:
                        int position = getLayoutPosition();
                        Mascota mascota = lista_mascotas.get(position);
                        Bundle parametros = new Bundle();
                        parametros.putString("NOMBRE", mascota.getNombre());
                        parametros.putString("EDAD", mascota.getEdad());
                        parametros.putString("CUMPLEANOS", mascota.getCumpleanos());
                        parametros.putString("SEXO", mascota.getSexo());
                        parametros.putString("RAZA", mascota.getRaza());
                        parametros.putString("PESO", mascota.getPeso());
                        parametros.putString("ALIMENTACION", mascota.getAlimentacion());
                        parametros.putString("TRATAMIENTO", mascota.getTratamiento());
                        parametros.putString("COLOR", mascota.getColor());
                        //parametros.putByte("IMAGEN", mascota.getImagen());
                        Intent intent = new Intent(context, DescripcionMascota.class);
                        intent.putExtras(parametros);
                        //intent.putExtra("",) parceable algun día ...

                        context.startActivity(intent);
                        break;

                    case 1:
                        context.startActivity(new Intent(context, NoticiaActivity.class));
                        break;

                    case 5: int positionCita = getLayoutPosition();
                            Cita cita = lista_cita.get(positionCita);
                            long resultado = citaDAO.actualizarCita(cita);
                            break;


                }

            } else if (v.getId() == this.btn_vermas.getId()) {

                //
                Intent intent;
                int position = getLayoutPosition();
                Bundle parametros = new Bundle();
                Log.d(tipoObjeto + "","tipoObjeto");
                switch (tipoObjeto) {
                    case 0:
                        /*HorarioAtencion horario = lista_horario.get(position);
                        Empleado empleado = horario.getEmpleado();
                        intent = new Intent(context, RegistroCita.class);
                        String nombre_veterinario = empleado.getNombreEmpleado();
                        String fecha_cita = horario.getFechaDisponible().toString();
                        intent.putExtra(VETERINARIO, nombre_veterinario);
                        intent.putExtra(FECHA_CITA,fecha_cita);
                        context.startActivity(intent);*/
                        context.startActivity(new Intent(context, RegistroCita.class));
                        break;

                    case 1:
                        Noticia noticia = lista_noticia.get(position);
                        parametros.putString("idNoticia", noticia.getCodigoNoticia());
                        intent = new Intent(context, NoticiaActivity.class);
                        intent.putExtras(parametros);
                        context.startActivity(intent);
                        break;
                    case 5:
                        int positionCita = getLayoutPosition();
                        Cita cita = lista_cita.get(positionCita);
                        long resultado = citaDAO.actualizarCita(cita);
                        Log.d("Resultado ", String.valueOf(resultado));
                        if(resultado == 1){
                            Toast.makeText(context,"Se registró la cita",Toast.LENGTH_SHORT).show();
                        }
                        break;

                }


            }


        }
    }


    @Override
    public int getItemCount() {

        switch (tipoObjeto) {
            case 0:
                return null == lista_mascotas ? 0 : lista_mascotas.size();

            case 1:
                return null == lista_noticia ? 0 : lista_noticia.size();

            case 2:
                return null == lista_recordatorio ? 0 : lista_recordatorio.size();

            case 3:
                return null == lista_servicio ? 0 : lista_servicio.size();

            case 4:
                return null == lista_cita ? 0 : lista_cita.size();

            case 5:
                return null == lista_cita ? 0 : lista_cita.size();

            default:
                return 0;


        }
    }


}
