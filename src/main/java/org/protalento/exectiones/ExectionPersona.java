package org.protalento.exectiones;
//js
import org.protalento.interfaces.Constante;

import java.util.Arrays;

public class ExectionPersona extends Exception {
    private static final long serialVersionUID = 1L;
    private Integer codigo;

    public ExectionPersona(Integer codigo){
        super();
        this.codigo = codigo;
    }
    public ExectionPersona(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        switch (codigo){
            case 1:
                return "Los Documentos validos son: " + Arrays.toString(Constante.tipoDocument);
            default:
                return super.getMessage();
        }

    }
}
