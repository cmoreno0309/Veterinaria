package domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cmoreno on 12/03/2016.
 */
public class Mascota implements Parcelable {

    private int codigo_mascota;
    private int imagen;
    private String nombre;
    private String edad;
    private String cumpleanos;
    private String sexo;
    private String raza;
    private String peso;
    private String alimentacion;
    private String tratamiento;
    private String color;
    private String esterilizado;

    public Mascota(int codigo_mascota, int imagen, String nombre, String edad, String cumpleanos, String sexo, String raza, String peso, String alimentacion, String tratamiento, String color, String esterilizado) {
        this.codigo_mascota = codigo_mascota;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.cumpleanos = cumpleanos;
        this.sexo = sexo;
        this.raza = raza;
        this.peso = peso;
        this.alimentacion = alimentacion;
        this.tratamiento = tratamiento;
        this.color = color;
        this.esterilizado = esterilizado;
    }

    public int getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(int codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
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

    public String getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        this.cumpleanos = cumpleanos;
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

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(String esterilizado) {
        this.esterilizado = esterilizado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
