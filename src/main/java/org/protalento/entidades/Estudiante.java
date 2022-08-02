package org.protalento.entidades;
//js

import java.time.LocalDate;

public class Estudiante extends Persona{
    private LocalDate fechaIngreso;
    private String ListaCurso;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento, LocalDate fechaIngreso, String listaCurso) {
        super(nombre, apellido, tipoDoc, numeroDoc, fechaNacimiento);
        this.fechaIngreso = fechaIngreso;
        ListaCurso = listaCurso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getListaCurso() {
        return ListaCurso;
    }

    public void setListaCurso(String listaCurso) {
        ListaCurso = listaCurso;
    }

    @Override
    public String toString() {
        return  "nombre: " + getNombre()+ " apellido: " + getApellido() + " tipoDoc: " + getTipoDoc()+
                " numeroDoc: "+ getNumeroDoc() + " fecha Nacimiento: "+ getFechaNacimiento()+ " fechaIngreso: " + fechaIngreso +
                " ListaCurso: " + ListaCurso ;

    }

    public void tipoPersona(){
        System.out.println(getNombre()+" "+getApellido()+" "+ " es un estudiante");
    }
}
