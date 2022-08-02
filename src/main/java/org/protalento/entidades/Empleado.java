package org.protalento.entidades;

import java.time.LocalDate;
//js
public abstract class Empleado extends Persona {


    private LocalDate fechaCargo;
    private float sueldo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento,  LocalDate fechaCargo, float sueldo) {
        super(nombre, apellido, tipoDoc, numeroDoc, fechaNacimiento);

        this.fechaCargo = fechaCargo;
        this.sueldo = sueldo;
    }



    public LocalDate getFechaCargo() {
        return fechaCargo;
    }

    public void setFechaCargo(LocalDate fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return " fechaCargo: " + fechaCargo +
                " sueldo: " + sueldo ;
    }
}
