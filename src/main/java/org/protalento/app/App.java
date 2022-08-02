package org.protalento.app;


import org.protalento.entidades.Estudiante;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Estudiante estudiante= new Estudiante();
        Class<?> f = estudiante.getClass();
        System.out.println(f);
        String class_name = f.getName();
        System.out.println("el nombre de la clase es :" + class_name);

    }

}
