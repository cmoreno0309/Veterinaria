package com.veterinaria.proyecto.veterinaria.data;

import java.util.List;

import domain.Cita;

/**
 * Created by ANDROID on 16/04/2016.
 */
public interface CitaDAO {

    void obtenerCita(Cita cita);

    public List<Cita> obtenerCitas();

    public long actualizarCita(Cita cita);

}

