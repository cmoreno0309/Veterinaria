package domain;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class Mascota {

    private int codigo_mascota;
    private int imagen;
    private String nombre;
    private String edad;
    private String fecha_nacimiento;
    private String sexo;
    private String raza;
    private String peso;
    private String alimentacion;
    private String tratamiento;

    public Mascota(int codigo_mascota, int imagen, String nombre, String edad, String fecha_nacimiento, String sexo, String raza, String peso, String alimentacion, String tratamiento) {
        this.codigo_mascota = codigo_mascota;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.raza = raza;
        this.peso = peso;
        this.alimentacion = alimentacion;
        this.tratamiento = tratamiento;
    }

    public int getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(int codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
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


    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

}
