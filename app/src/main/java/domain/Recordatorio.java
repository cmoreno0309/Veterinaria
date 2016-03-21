package domain;

/**
 * Created by Reapro on 21/03/2016.
 */
public class Recordatorio {

    private String codigoRecordatorio;
    private String titulo;
    private String descripcion;

    public Recordatorio(String codigoRecordatorio,String titulo,String descripcion){
        this.codigoRecordatorio = codigoRecordatorio;
        this.titulo             = titulo;
        this.descripcion        = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoRecordatorio() {
        return codigoRecordatorio;
    }

    public void setCodigoRecordatorio(String codigoRecordatorio) {
        this.codigoRecordatorio = codigoRecordatorio;
    }
}
