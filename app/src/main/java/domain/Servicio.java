package domain;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class Servicio {

    private String codigoServicio;
    private String nombreServicio;
    private String descripcionServicio;

    public Servicio(String codigoServicio,String nombreServicio){
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
    }

    public Servicio(String codigoServicio,String nombreServicio,String descripcionServicio){
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;

    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
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
}
