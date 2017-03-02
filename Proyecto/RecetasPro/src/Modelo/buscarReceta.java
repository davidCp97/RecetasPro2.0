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


public class buscarReceta {
   
    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static PreparedStatement pst2;
    static ResultSet rs;
    static ResultSet rs2;

public static void main(String[] args)throws SQLException{

         
          System.out.println(mostrarRecetaIng("Arroz Hindú"));

    }
    
   //Método que busca el nombre de la receta y muestra la información de la misma receta
    public static String mostrarReceta(String q){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String m="";
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";//Dorección base de datos
            String username = "";
            String password = "";
            String nom="";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT codigo_receta, nombre, descripcion, tiempo  FROM Receta WHERE  nombre like \""+q+"*\";";//COnsulta
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                 //Se guardan las variables en un String
                    m+=rs.getString("codigo_receta")+"\n";
                    m+=rs.getString("nombre")+"\n";
                    m+=rs.getString("descripcion")+"\n";
                    m+=rs.getString("tiempo")+"\n";
                    
                }
 
                 
               
            }catch(SQLException sql){}
            pst.close();
        
            con.close();
             
        }
        catch(SQLException e)
        {}
          return m;
    }
    public static String mostrarRecetaIng(String q){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String m="";
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";//Dorección base de datos
            String username = "";
            String password = "";
            String nom="";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT nombre_ingrediente FROM Ingrediente_receta, Receta WHERE  Ingrediente_receta.codigo_receta = Receta.codigo_receta AND nombre like \""+q+"*\";";//COnsulta
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                 //Se guardan las variables en un String
                    m+=rs.getString("nombre_ingrediente")+"\n";
                    
                    
                }
 
                 
               
            }catch(SQLException sql){}
            pst.close();
        
            con.close();
             
        }
        catch(SQLException e)
        {}
          return m;
    }
    
    //Método que devuelve el nombre de las recetas en un ArrayList
    public static ArrayList nombreRecetaItem(){
         ArrayList<String> ar = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String m="";
          try{

            String dbURL = "jdbc:ucanaccess://E:\\Nueva carpeta/Rest1.accdb";
            String username = "";
            String password = "";
            String nom="";
            
            con = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT nombre FROM Receta";
            
            pst = con.prepareStatement(query);
            rs = null;
            rs2 = null;
         
            try{
                rs = pst.executeQuery();
                
                while(rs.next())
                {
                
                    ar.add(rs.getString("nombre"));
     
                }
  
                 
               
            }catch(SQLException sql){}
            pst.close();
        
            con.close();
             
        }
        catch(SQLException e)
        {}
          return ar;
    }
    
    
  
}