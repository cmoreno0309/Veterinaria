package com.veterinaria.proyecto.veterinaria.data;

import android.provider.BaseColumns;

/**
 * Created by ANDROID on 16/04/2016.
 */
public class TablaDBContract {

    public static final class MascotaEntry implements BaseColumns {
        public static final String TABLE_NAME    = "mascota";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_EDAD   = "edad";
        public static final String COLUMN_CUMPLEANIOS  = "cumpleano";
        public static final String COLUMN_SEXO         = "sexo";
        public static final String COLUMN_ALIMENTACION = "alimentacion";
        public static final String COLUMN_TRATAMIENTO  = "tratamiento";
        public static final String COLUMN_COLOR        = "color";
        public static final String COLUMN_ESTERILIZADO = "esterilizado";
        public static final String COLUMN_IMAGEN       = "imagen";
    }

    public static final class ServicioEntry implements BaseColumns {
        public static final String TABLE_NAME         = "servicio";
        public static final String COLUMN_NOMBRE      = "nombreServicio";
        public static final String COLUMN_DESCRIPCION = "descripcionServicio";
        public static final String COLUMN_IMAGEN      = "imagen";
    }

}
