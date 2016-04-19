package com.veterinaria.proyecto.veterinaria.data;

import java.util.List;

import domain.Servicio;

/**
 * Created by ANDROID on 16/04/2016.
 */
public interface ServicioDAO {

    void obtenerServicio(Servicio servicio);
    public List<Servicio> obtenerServicios();
    public long registrarServicio(Servicio servicio);

}

