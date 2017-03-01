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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ingenieria
 */
public class Conexion {

    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;

    //Método base para realizar una consulta a la Base de Datos
    public void consultaABaseDeDatosBase(String consulta) {
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\usuario\\Downloads\\Versiones RecetasPro\\Base de datos RecetasPro/Recetas.accdb"; //Dirección de donde está la base de datos
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

    //Método base para realizar una inserción en la base de datos
    public void insertarABaseDeDatosBase(String insercion) {
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\usuario\\Downloads\\Versiones RecetasPro\\Base de datos RecetasPro/Recetas.accdb"; //Dirección de donde está la base de datos
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

    //Método que regresa un entero, el cual es el código (Primary Key) de la última Receta
    public int consultaUltimoID() {
        int a = 0;
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\usuario\\Downloads\\Versiones RecetasPro\\Base de datos RecetasPro/Recetas.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos

            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT TOP 1 * FROM Receta ORDER BY codigo_receta DESC "; //query que solicita la última fila de datos
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    a = rs.getInt("codigo_receta"); //Se pide que solo regrese el último código de la receta.
                }
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
        return a;
    }

    //Método que devuelve en un arraylist la lista de los ingredientes totales.
    public ArrayList consultaIngredientes() {
        ArrayList result = new ArrayList<>();
        try {
           String dbURL = "jdbc:ucanaccess://C:\\Users\\usuario\\Downloads\\Versiones RecetasPro\\Base de datos RecetasPro/Recetas.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "Select * from Ingrediente"; //query que pide traer los datos de la tabla Ingrediente.
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    result.add(rs.getString("nombre_ingrediente"));//Se solicita únicamente la columna de Nombre_ingrediente
                }
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList consultaCodigosRecetas() {
        ArrayList result = new ArrayList<>();
        try {
           String dbURL = "jdbc:ucanaccess://C:\\Users\\usuario\\Downloads\\Versiones RecetasPro\\Base de datos RecetasPro/Recetas.accdb"; //Dirección de donde está la base de datos
            String username = ""; //Usuario de la base de datos
            String password = ""; //Password del usuario de la base de datos
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "select codigo_receta from Receta;"; 
            pst = con.prepareStatement(query);
            rs = null;
            try {
                rs = pst.executeQuery();
                while (rs.next()) {
                    result.add(rs.getString("codigo_receta"));
                }
            } catch (SQLException sql) {
            }
            pst.close();
            con.close();
        } catch (SQLException e) {
        }
        return result;
    }

}
