package org.protalento.jdbc;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public  Connection getConexion (){
        Connection connection = null;
        String db_driver = "org.mariadb.jdbc.Driver";
        String db_url = "jdbc:mariadb://localhost:3306/sistemas_colegio";
        String db_user="root";
        String db_clave="";

        try {
            Class.forName(db_driver);
            connection = DriverManager.getConnection(db_url,db_user,db_clave);
            System.out.println("conexion ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConexion();


    }
}
