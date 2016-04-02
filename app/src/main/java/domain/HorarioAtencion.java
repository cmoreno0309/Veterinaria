package domain;

import java.util.Date;

/**
 * Created by Cmoreno on 01/04/2016.
 */
public class HorarioAtencion {

    private String codigoHorario;
    private Date fechaDisponible;
    private boolean indReservado;
    private Empleado empleado;

    public HorarioAtencion(String codigoHorario,Date fechaDisponible,boolean indReservado,Empleado empleado) {
      this.codigoHorario   = codigoHorario;
      this.fechaDisponible = fechaDisponible;
      this.indReservado    = indReservado;
      this.empleado        = empleado;
    }

    public String getCodigoHorario() {
        return codigoHorario;
    }

    public void setCodigoHorario(String codigoHorario) {
        this.codigoHorario = codigoHorario;
    }

    public Date getFechaDisponible() {
        return fechaDisponible;
    }

    public void setFechaDisponible(Date fechaDisponible) {
        this.fechaDisponible = fechaDisponible;
    }

    public boolean isIndReservado() {
        return indReservado;
    }

    public void setIndReservado(boolean indReservado) {
        this.indReservado = indReservado;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
