package org.protalento.implementaciones;
//js
import org.protalento.entidades.Administrativo;
import org.protalento.jdbc.Conexion;
import org.protalento.jdbc.DAO;

import java.sql.PreparedStatement;
import java.util.List;

public class impAdministrativo implements DAO<Administrativo,String> {
    private PreparedStatement preparedStatementBuscar;
    private PreparedStatement preparedStatementInsertar;
    private PreparedStatement preparedStatementModificar;
    private PreparedStatement preparedStatementEliminar;
    private PreparedStatement preparedStatementListar;
    private Conexion conexion;

    public impAdministrativo() {
        conexion = new Conexion();
    }

    @Override
    public Administrativo buscar(String numeroDoc) {
        return null;
    }

    @Override
    public boolean Insertar(Administrativo administrativo) {
        return false;
    }

    @Override
    public boolean Modificar(Administrativo administrativo) {
        return false;
    }

    @Override
    public boolean Eliminar(Administrativo administrativo) {
        return false;
    }

    @Override
    public List<Administrativo> Listar() {
        return null;
    }
}
