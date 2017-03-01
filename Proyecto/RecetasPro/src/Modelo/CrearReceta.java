/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.ArrayList;

/**
 *
 * @author Ingenieria
 */
public class CrearReceta {

    Conexion var = new Conexion();

    
    //Método Se realiza la inserción de las Receta, Luego se hace la inserción de la llave compuesta
    // de Receta_Ingrediente. Se pasa por Array la lista de ingredientes.
    public void IngresoTablaReceta(String nombre, String descripcion, String tiempo, ArrayList ing) {
        String sql = "insert into Receta (nombre, descripcion, tiempo) values ('" + nombre + "','" + descripcion + "','" + tiempo + "')";
        int a = var.consultaUltimoID(); //Consulta el último ID ingresado en Receta.
        var.insertarABaseDeDatosBase(sql);
        for (int i = 0; i < ing.size(); i++) {
            sql = "insert into Ingrediente_receta (codigo_receta, nombre_ingrediente) values ('" + a + "','" + ing.get(i).toString() + "')";
            var.insertarABaseDeDatosBase(sql);
        }
    }

    
    //Método que regresa el String que se muestra en el Listado de los ingredientes, debajo de
    //Agregar un nuevo ingrediente
    public String mostrarIngredientes() {
        String a="";
        ArrayList nuev = new ArrayList<>(var.consultaIngredientes());
        for (int i = 0; i < nuev.size(); i++) {
            a=a+"- "+nuev.get(i).toString()+"\n";
        }
        return a;
    }
    
    
    
}
