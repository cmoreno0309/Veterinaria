package domain;

/**
 * Created by Cmoreno on 26/03/2016.
 */
public class Empleado {

    private String codigoEmpleado;
    private String nombreEmpleado;

    public Empleado(String codigoEmpleado,String nombreEmpleado){
        this.setCodigoEmpleado(codigoEmpleado);
        this.setNombreEmpleado(nombreEmpleado);
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
}
