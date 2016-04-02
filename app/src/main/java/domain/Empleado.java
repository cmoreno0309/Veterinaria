package domain;

/**
 * Created by Cmoreno on 26/03/2016.
 */
public class Empleado {

    private String codigoEmpleado;
    private String nombreEmpleado;
    private Servicio servicio;

    public Empleado(String codigoEmpleado,String nombreEmpleado,Servicio servicio){
        this.setCodigoEmpleado(codigoEmpleado);
        this.setNombreEmpleado(nombreEmpleado);
        this.servicio = servicio;
    }


    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }


    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
