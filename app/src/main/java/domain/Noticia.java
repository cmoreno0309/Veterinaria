package domain;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class Noticia {
    private String titulo;
    private String descripcion;
    private int imagen;

    public Noticia(String titulo,String descripcion,int imagen){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;

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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
