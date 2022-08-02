package org.protalento.entidades;

import java.time.LocalDate;

public class Administrativo extends Empleado {

    public Administrativo() {
    }

    public Administrativo(String nombre, String apellido, String tipoDoc, String numeroDoc, LocalDate fechaNacimiento, LocalDate fechaCargo, float sueldo) {
        super(nombre, apellido, tipoDoc, numeroDoc, fechaNacimiento, fechaCargo, sueldo);
    }

    public void tipoPersona(){
        System.out.println(getNombre()+" "+getApellido() +" "+ "es un administrativo");
    }
}
