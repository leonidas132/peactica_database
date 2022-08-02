package org.protalento.implementaciones;
//js
import org.protalento.entidades.Estudiante;
import org.protalento.jdbc.Conexion;
import org.protalento.jdbc.DAO;
import org.protalento.utilidades.Fecha;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class impEstudiante implements DAO <Estudiante,String> {
    private PreparedStatement preparedStatementBuscar;
    private PreparedStatement preparedStatementInsertar;
    private PreparedStatement preparedStatementModificar;
    private PreparedStatement preparedStatementEliminar;
    private PreparedStatement preparedStatementListar;
    private Conexion conexion;

    public impEstudiante() {
     conexion = new Conexion();
    }

    @Override
    public Estudiante buscar(String numeroDoc) {
        Estudiante estudiante =null;
        String sql = "select nombre, Apellido,tipoDoc,NumeroDoc,fechaNacimiento,fechaIngreso,cursos from estudiante where NumeroDoc = ?";
        try {
            if(null == preparedStatementBuscar){
                preparedStatementBuscar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementBuscar.setString(1,numeroDoc);
            ResultSet resultSet= preparedStatementBuscar.executeQuery();
            if(resultSet.next()){
                estudiante = new Estudiante();
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("Apellido"));
                estudiante.setTipoDoc(resultSet.getString("tipoDOC"));
                estudiante.setNumeroDoc(resultSet.getString("NumeroDoc"));
                estudiante.setFechaNacimiento(Fecha.getLocalDate(resultSet.getString("fechaNacimiento")));
                estudiante.setFechaIngreso(Fecha.getLocalDate(resultSet.getString("fechaIngreso")));
                estudiante.setListaCurso(resultSet.getString("cursos"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return estudiante;
    }

    @Override
    public boolean Insertar(Estudiante estudiante) {
        String sql = "insert into estudiante(nombre,apellido,tipoDoc,NumeroDoc,fechaNacimiento,fechaIngreso,cursos)values(?,?,?,?,?,?,?)";
        try {
            if(null == preparedStatementInsertar){
                preparedStatementInsertar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementInsertar.setString(1,estudiante.getNombre());
            preparedStatementInsertar.setString(2,estudiante.getApellido());
            preparedStatementInsertar.setString(3,estudiante.getTipoDoc());
            preparedStatementInsertar.setString(4,estudiante.getNumeroDoc());
            preparedStatementInsertar.setString(5,Fecha.getString(estudiante.getFechaNacimiento()));
            preparedStatementInsertar.setString(6,Fecha.getString(estudiante.getFechaIngreso()));
            preparedStatementInsertar.setString(7,estudiante.getListaCurso());

            return preparedStatementInsertar.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean Modificar(Estudiante estudiante) {
        String sql = "update estudiante set nombre=?, Apellido=?,tipoDoc=? where NumeroDoc=?";
        try {
            if(null == preparedStatementModificar) {
                preparedStatementModificar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementModificar.setString(1,estudiante.getNombre());
            preparedStatementModificar.setString(2,estudiante.getApellido());
            preparedStatementModificar.setString(3,estudiante.getTipoDoc());
            preparedStatementModificar.setString(4, estudiante.getNumeroDoc());
            System.out.println("modify ok");
            return preparedStatementModificar.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Estudiante estudiante) {
        String sql = "delete from estudiante where NumeroDoc =?";
        try {
            if(null == preparedStatementEliminar) {
                preparedStatementEliminar = conexion.getConexion().prepareStatement(sql);
            }
            preparedStatementEliminar.setString(1,estudiante.getNumeroDoc());
            return preparedStatementEliminar.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Estudiante> Listar() {
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException  {

        impEstudiante impEstud = new impEstudiante();
        Estudiante estudiante = new Estudiante("profe2","marmo","NI","12F",Fecha.getLocalDate("1998-07-01"),Fecha.getLocalDate("2021-10-11"),"java,jsp");
       // impEstud.Insertar(estudiante);
        //impEstud.Modificar(estudiante);
       //impEstud.Eliminar(estudiante);
     //   System.out.println(impEstud.buscar("124F"));

        Class<Estudiante> clazz = Estudiante.class;
        try {
            clazz.getField("fechaIngreso");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
