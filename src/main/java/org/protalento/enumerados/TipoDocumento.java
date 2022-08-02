package org.protalento.enumerados;
// ss
public enum TipoDocumento {
    DNI("Documento Nacional de Identidad"), PAS("pasaporte"),TI("targeta de identidad"),CC("cedula de cuidadania");

    private String descripcion;

    private TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
