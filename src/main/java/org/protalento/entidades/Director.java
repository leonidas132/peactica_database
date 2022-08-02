package org.protalento.entidades;
//js
import java.time.LocalDate;

public class Director extends Empleado {
    private String carrera;

    public Director() {
    }

    public Director(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento, LocalDate fechaCargo, float sueldo, String carrera) {
        super(nombre, apellido, tipoDoc, numeroDoc, fechaNacimiento, fechaCargo, sueldo);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return  "nombre: " + getNombre()+ " apellido: " + getApellido() + " tipoDoc: " + getTipoDoc()+
                 " numeroDoc: "+ getNumeroDoc() + " fecha Nacimiento: "+ getFechaNacimiento()+ " fecha cargo:"
                + getFechaCargo() + " carrera: "+ carrera + " sueldo: "+ getSueldo();
    }

    public void tipoPersona(){
        System.out.println(getNombre() +" "+ getApellido()+" es un Director");
    }
}
