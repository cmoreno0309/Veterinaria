package domain;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class Servicio {

    private int    codigoServicio;
    private String nombreServicio;
    private String descripcionServicio;
    private byte[] imagen;

    public  Servicio() {

    }

    public  Servicio(String nombreServicio,String descripcionServicio) {
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;

    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }
}
