package org.protalento.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Fecha {

//fechas
    public static final String PATRON_FECHA = "yyyy-MM-dd";
    public static final String PATRON_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";

    // para que no me puedan instanciar la clase creamos un constructor privado

    private Fecha() {

    }

    /**
     * obtener un LocalDate de un String
     *
     * @param fecha con patron yyyy-MM-dd
     * @return fecha LocalDate
     * <p>
     * ojo el metodo ofPattern crea un formato utilizando el patron espesificado
     */

    /* el metodo parse() Obtiene una instancia de LocalDate de una cadena de texto utilizando un formateador específico.
     El texto se analiza utilizando el formateador, devolviendo una fecha*/
    public static LocalDate getLocalDate(String fecha) {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(PATRON_FECHA));
    }

    /**
     * obtener un LocalDate de un String
     *
     * @param fecha con patron yyyy-MM-dd HH:mm:ss
     * @return fecha LocalDateTime
     * <p>
     * ojo el metodo ofPattern crea un formato utilizando el patron espesificado
     */

    /*
    * el metodo parse() Obtiene una instancia de LocalDateTime de una cadena de texto utilizando un formateador específico.
      El texto se analiza utilizando el formateador, devolviendo una fecha y hora.*/
    public static LocalDateTime getLocalDateTime(String fecha) {
        return LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern(PATRON_FECHA_HORA));
    }


    /**
     * obtener String de LocalDate
     *
     * @param fecha LocalDate
     *              return una fecha String con un patron yyyy-MM-dd
     */

     /*el metodo format Da formato a esta fecha utilizando el formateador especificado.
      Esta fecha se pasará al formateador para producir una caden
      */

     /*Formateador para imprimir y analizar objetos de fecha y hora.
     Esta clase proporciona el punto de entrada principal de la aplicación para imprimir y analizar y proporciona
     implementaciones comunes de DateTimeFormatter*/
    public static String getString(LocalDate fecha) {
        return fecha.format(DateTimeFormatter.ofPattern(PATRON_FECHA));
    }



    /**
     * obtener String de LocalDate
     *
     * @param fecha LocalDateTime
     * return una fecha String con un patron yyyy-MM-dd HH:mm:ss
     * */
    public static String getString(LocalDateTime fecha) {
        return fecha.format(DateTimeFormatter.ofPattern(PATRON_FECHA_HORA));
    }









}
