package domain;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class Mascota {

    private int imagen;
    private String nombre;
    private String edad;

    public Mascota(String nombre, String edad, int imagenPerrito) {
        this.nombre = nombre;
        this.edad   = edad;
        this.imagen = imagenPerrito;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
