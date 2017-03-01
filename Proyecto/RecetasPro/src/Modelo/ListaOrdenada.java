package Modelo;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;




public class ListaOrdenada {

    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;

    
    public ArrayList consultaReceta() {
        ArrayList result = new ArrayList<>();
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\david\\Desktop\\recetas/Recetas.accdb"; //Dirección de donde está la base de datos
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
    public String mostrarRecetasordenadas(ArrayList ordenado) {
        String a="";
        ArrayList nuev = new ArrayList<>();
        nuev = ordenado;
        for (int i = 0; i < nuev.size(); i++) {
            a=a+"- "+nuev.get(i).toString()+"\n";
        }
        return a;
    }
     
}
