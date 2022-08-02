package org.protalento.implementaciones;


import org.protalento.entidades.Persona;
import org.protalento.entidades.Profesor;
import org.protalento.jdbc.Conexion;
import org.protalento.jdbc.DAO;
import org.protalento.utilidades.Fecha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class impProfesor implements DAO<Profesor,String> {
    private PreparedStatement preparedStatementBuscar;
    private PreparedStatement preparedStatementInsertar;
    private PreparedStatement preparedStatementModificar;
    private PreparedStatement preparedStatementEliminar;
    private PreparedStatement preparedStatementListar;
    private Conexion conexion;

    public impProfesor() {
       conexion = new Conexion();
    }

    @Override
    public Profesor buscar(String numeroDoc) {
        Profesor profesor = null;
        String sql = "select nombre,Apellido,tipoDoc,fechaNacimiento,fechaCargo,sueldo,listaCursos from Profesor where numeroDoc=?";
        try {
            if(null ==preparedStatementBuscar) {
                preparedStatementBuscar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementBuscar.setString(1,numeroDoc);
            ResultSet resultSet = preparedStatementBuscar.executeQuery();
             if(resultSet.next()){
                 profesor = new Profesor();
                 profesor.setNombre(resultSet.getString("nombre"));
                 profesor.setApellido(resultSet.getString("Apellido"));
                 profesor.setTipoDoc(resultSet.getString("tipoDoc"));
                 profesor.setNumeroDoc(numeroDoc);
                 profesor.setFechaNacimiento(Fecha.getLocalDate(resultSet.getString("fechaNacimiento")));
                 profesor.setFechaCargo(Fecha.getLocalDate(resultSet.getString("fechaCargo")));
                 profesor.setSueldo(resultSet.getFloat("sueldo"));
                 profesor.setListaCurso(resultSet.getString("listaCursos"));
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }

    @Override
    public boolean Insertar(Profesor profesor) {
        String sql = "Insert into profesor(nombre,Apellido,tipoDoc,numeroDoc,fechaNacimiento,fechaCargo,sueldo,listaCursos) values(?,?,?,?,?,?,?,?)";
        try {
            if(null ==preparedStatementInsertar) {
                preparedStatementInsertar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementInsertar.setString(1,profesor.getNombre());
            preparedStatementInsertar.setString(2,profesor.getApellido());
            preparedStatementInsertar.setString(3,profesor.getTipoDoc());
            preparedStatementInsertar.setString(4,profesor.getNumeroDoc());
            preparedStatementInsertar.setString(5,Fecha.getString(profesor.getFechaNacimiento()));
            preparedStatementInsertar.setString(6,Fecha.getString(profesor.getFechaCargo()));
            preparedStatementInsertar.setFloat(7,profesor.getSueldo());
            preparedStatementInsertar.setString(8,profesor.getListaCurso());

            System.out.println("insert ok");
            return preparedStatementInsertar.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Modificar(Profesor profesor) {
        String sql = "update profesor set nombre=?,Apellido=?,tipoDoc=?,sueldo =? where NumeroDoc =?";
        try {
            if(null == preparedStatementModificar) {
                preparedStatementModificar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementModificar.setString(1,profesor.getNombre());
            preparedStatementModificar.setString(2,profesor.getApellido());
            preparedStatementModificar.setString(3,profesor.getTipoDoc());
            preparedStatementModificar.setFloat(4,profesor.getSueldo());
            preparedStatementModificar.setString(5,profesor.getNumeroDoc());
            System.out.println("update ok");
            return preparedStatementModificar.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Profesor profesor) {
        String sql = "delete from profesor where NumeroDoc =?";

        try {
            if(null == preparedStatementEliminar) {
                preparedStatementEliminar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementEliminar.setString(1,profesor.getNumeroDoc());
            return preparedStatementEliminar.executeUpdate() == 1;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Profesor> Listar() {
        List<Profesor> lista = new ArrayList<>();
        String sql = "select nombre,Apellido,tipoDoc,NumeroDoc,fechaNacimiento,fechaCargo,sueldo,listaCursos from profesor";

        try {
            if(null == preparedStatementListar){
                preparedStatementListar = conexion.getConexion().prepareStatement(sql);
            }
            ResultSet resultSet = preparedStatementListar.executeQuery();
            while(resultSet.next()){
                Profesor profesor = new Profesor();
                profesor.setNombre(resultSet.getString("nombre"));
                profesor.setApellido(resultSet.getString("Apellido"));
                profesor.setTipoDoc(resultSet.getString("tipoDoc"));
                profesor.setNumeroDoc(resultSet.getString("NumeroDoc"));
                profesor.setFechaNacimiento(Fecha.getLocalDate(resultSet.getString("fechaNacimiento")));
                profesor.setFechaCargo(Fecha.getLocalDate(resultSet.getString("fechaCargo")));
                profesor.setSueldo(resultSet.getFloat("sueldo"));
                profesor.setListaCurso(resultSet.getString("listaCursos"));
                lista.add(profesor);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void main(String[] args) {

        impProfesor impProfe = new impProfesor();
        System.out.println(impProfe.buscar("123HJ"));


        Profesor profesor= new Profesor("joche","ferroso","DNI","12KJ",Fecha.getLocalDate("1996-11-13"),Fecha.getLocalDate("2022-10-11"),200000,"JAVA.HTML");
        //impProfe.Insertar(profesor);
       // impProfe.Modificar(profesor);
       // impProfe.Eliminar(profesor);
        System.out.println(impProfe.Listar());
    }
}
