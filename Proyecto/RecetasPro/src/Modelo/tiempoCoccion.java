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
import java.util.Scanner;


public class tiempoCoccion {
   
    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static PreparedStatement pst2;
    static ResultSet rs;
    static ResultSet rs2;

public static void main(String[] args)throws SQLException{
Scanner input = new Scanner(System.in);

          System.out.println(tiempoCocc(20));
          System.out.println(nombreReceta("Arroz Hindú"));
    }

    //Método que realiza la búsqueda por tiempo de cocción en minutos.
    public static String tiempoCocc(int t){
          String a = "";
       Scanner input = new Scanner(System.in);
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";// Dirección Base de datos
            String username = "";
            String password = "";
           
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT * FROM Receta WHERE tiempo = '"+t+"'";//Consulta base de datos.
            pst = con.prepareStatement(query);
            rs = null;
            
            try{
                rs = pst.executeQuery();
                while(rs.next())
                {
                    a+=rs.getString("nombre")+"\n";    //Guarda el valor del nombre en un String
                }
                
            }catch(SQLException sql){}
            pst.close();
            con.close();
            
        }
        catch(SQLException e)
        {}
return a;
    }
    // Método que realiza la busqueda del nombre de la receta
    public static String nombreReceta(String q){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String m="";
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";//Dirección base de datos
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT nombre FROM Receta WHERE  nombre like \""+q+"*\";";//Consulta base de datos
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                { 
                    m+=rs.getString("nombre")+"\n";// Guarda el valor del nombre en un String
                }
              
                 
               
            }catch(SQLException sql){}
            pst.close();
        
            con.close();
             
        }
        catch(SQLException e)
        {}
          return m;
    }

}
