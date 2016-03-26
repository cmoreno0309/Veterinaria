package domain;

import java.util.Date;

/**
 * Created by Cmoreno on 26/03/2016.
 */
public class Cita {

    private String codigoCita;
    private Empleado empleado;
    private Date fechaCita;
    private Servicio servicio;


    public Cita(String codigoCita,Empleado empleado,Date fechaCita,Servicio servicio){
        this.codigoCita = codigoCita;
        this.empleado   = empleado;
        this.fechaCita  = fechaCita;
        this.servicio   = servicio;
    }


    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
