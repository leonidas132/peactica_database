package org.protalento.entidades;

import java.time.LocalDate;

public class Profesor extends Empleado{
    private String listaCurso;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento, LocalDate fechaCargo, float sueldo, String listaCurso) {
        super(nombre, apellido, tipoDoc, numeroDoc, fechaNacimiento, fechaCargo, sueldo);
        this.listaCurso = listaCurso;
    }

    public String getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(String listaCurso) {
        this.listaCurso = listaCurso;
    }
    @Override
    public String toString() {
        return  "nombre: " + getNombre()+ " apellido: " + getApellido() + " tipoDoc: " + getTipoDoc()+
                " numeroDoc: "+ getNumeroDoc() + " fecha Nacimiento: "+ getFechaNacimiento()+ " fecha cargo:"
                + getFechaCargo() + " sueldo: "+ getSueldo() + " lista cursos: " + listaCurso;
    }
    public void tripoPersona(){
        System.out.println(getNombre() +" "+ getApellido()+" "+ " es un profesor");
    }


}
