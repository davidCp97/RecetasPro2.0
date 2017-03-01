/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ingenieria
 */
public class Conexion {

    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;

    
    
    
    
    public void consultaABaseDeDatosBase(String consulta) {
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\Ingenieria\\Downloads\\Pre\\Nueva carpeta/Rest1.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            String query = consulta; //query a modificar (Select * from tabla1)
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    System.out.print(rs.getString("")); // Nombre de la columna 1 de la tabla
                    System.out.print(" | "); // Espacio para separar columnas
                    System.out.print(rs.getString("")); // Nombre de la columna 2 de la tabla
                    System.out.print(" | "); // Espacio para separar columnas
                    System.out.print(rs.getString("")); // Nombre de la columna 3 de la tabla
                    System.out.print(" | "); // Espacio para separar columnas
                    System.out.print(rs.getString("")); // Nombre de la columna 4 de la tabla....
                    System.out.println("");//Salto de línea
                }
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
    }

    public void insertarABaseDeDatosBase(String insercion) {
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\Ingenieria\\Downloads\\Pre\\Nueva carpeta\\Rest1.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            try {

                String query = insercion; //Inserción a modificar (INSERT INTO Tabla VALUES ('valores'))
                pst = con.prepareStatement(query);
                pst.executeUpdate();
                System.out.println("Inserted");//Confirmación en consola de una inserción con éxito
            } catch (SQLException sql) {
            }
            con.close();
        } catch (SQLException e) {
        }
    }
     public ArrayList consultaReceta() {
        ArrayList result = new ArrayList<>();
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\ingenieria\\Desktop\\recetas/Recetas.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "Select nombre from receta"; //query a modificar (Select * from tabla1)
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    result.add(rs.getString("nombre"));
                }
                System.out.println(result);
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
        return result;
    
    }

}
