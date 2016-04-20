package com.veterinaria.proyecto.veterinaria.data;

import java.util.List;

import domain.Mascota;

/**
 * Created by ANDROID on 16/04/2016.
 */
public interface MascotaDAO {

    void obtenerMascota(Mascota mascota);
    public List<Mascota> obtenerMascotas();
    public int actualizarMascota(Mascota mascota);
    public long registrarMascota(Mascota mascota);

}

