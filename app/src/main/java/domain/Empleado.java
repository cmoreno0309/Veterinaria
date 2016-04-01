package domain;

/**
 * Created by Cmoreno on 26/03/2016.
 */
public class Empleado {

    private String codigoEmpleado;
    private String nombreEmpleado;
    private HorarioAtencion horarioAtencion;

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


    public HorarioAtencion getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(HorarioAtencion horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
}
