package org.protalento.jdbc;

import java.util.List;

public interface DAO <E,K> {
    //acceso a datos
    E buscar (K k);
    boolean Insertar (E e);
    boolean Modificar(E e);
    boolean Eliminar(E e);
    List<E> Listar();


}
