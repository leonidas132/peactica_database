package org.protalento.implementaciones;

import org.protalento.entidades.Director;
import org.protalento.jdbc.Conexion;
import org.protalento.jdbc.DAO;

import java.sql.PreparedStatement;
import java.util.List;

public class impDirector implements DAO<Director,String> {
    private PreparedStatement preparedStatementBuscar;
    private PreparedStatement preparedStatementInsertar;
    private PreparedStatement preparedStatementModificar;
    private PreparedStatement preparedStatementEliminar;
    private PreparedStatement preparedStatementListar;
    private Conexion conexion;

    public impDirector() {
       conexion = new Conexion();
    }

    @Override
    public Director buscar(String numeroDoc) {

        return null;
    }

    @Override
    public boolean Insertar(Director director) {
        return false;
    }

    @Override
    public boolean Modificar(Director director) {
        return false;
    }

    @Override
    public boolean Eliminar(Director director) {
        return false;
    }

    @Override
    public List<Director> Listar() {
        return null;
    }
}
