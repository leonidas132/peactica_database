package org.protalento.entidades;
//js
import java.time.LocalDate;

public abstract class Persona {
    private String nombre ;
    private String apellido;
    private String tipoDoc;
    private String numeroDoc;
    private LocalDate fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.numeroDoc = numeroDoc;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return
                "nombre: " + nombre + " apellido: " + apellido + " tipoDoc: " + tipoDoc + " numeroDoc: " + numeroDoc + " fechaNacimiento: " + fechaNacimiento;
    }

}
