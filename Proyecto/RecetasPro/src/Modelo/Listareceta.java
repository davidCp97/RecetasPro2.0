/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Listareceta {

    Conexion var = new Conexion();
    ArrayList Resultado = new ArrayList<>();

    // Metodo que trae la lista de recetas que contengan los ingredientes dados como parametros
    public void ResLista(ArrayList ListaIngresdientes) {
        String sql = "SELECT receta.codigo_receta AS cod, receta.nombre, ingrediente.nombre_ingrediente\n"
                + "FROM (Ingrediente_receta LEFT JOIN Ingrediente AS ingrediente ON Ingrediente_receta.nombre_ingrediente = Ingrediente.nombre_ingrediente) LEFT JOIN Receta AS receta ON Ingrediente_receta.codigo_receta = receta.codigo_receta\n"
                + "WHERE ingrediente.nombre_ingrediente In ('";
        for (int i = 0; i < ListaIngresdientes.size(); i++) {
            if (i == ListaIngresdientes.size() - 1) {
                sql += ListaIngresdientes.get(i).toString() + "');";
            } else {
                sql += ListaIngresdientes.get(i).toString() + "','";
            }
        }

        ArrayList CodigoConsulta = new ArrayList<>(var.ConsultaElementosListasIngredientes(sql));

        //System.err.println(CodigoConsulta + " Codigos consulta");

        ArrayList TodosLosCodigosRecetas = new ArrayList<>(var.Lista_Codigo_Receta());
        //System.out.println(TodosLosCodigosRecetas + " Codigos recetas");
        ArrayList ListaReceta = new ArrayList<>();

        int count = 0;
        int TamañoListaIng = ListaIngresdientes.size();
        //System.out.println(TamañoListaIng);

        for (int i = 0; i < TodosLosCodigosRecetas.size(); i++) {
            count = 0;
            for (int j = 0; j < CodigoConsulta.size(); j++) {
                //ystem.out.println(TodosLosCodigosRecetas.get(i)+"=="+CodigoConsulta.get(j));
                if (CodigoConsulta.get(j).equals(TodosLosCodigosRecetas.get(i))) {
                    count++;
                    //System.out.println("Entro");
                } else {
                    // System.out.println("NoEntro");
                }
                if (count == ListaIngresdientes.size()) {
                    ListaReceta.add(TodosLosCodigosRecetas.get(i));
                    //System.out.println("Agrego");
                    break;

                }

            }

        }
        //System.out.println(w);

        sql = "SELECT nombre from Receta where codigo_receta in (";
        for (int i = 0; i < ListaReceta.size(); i++) {
            if (i == ListaReceta.size() - 1) {
                sql += ListaReceta.get(i).toString() + ");";
            } else {
                sql += ListaReceta.get(i).toString() + ",";
            }
        }
        
         ArrayList nombres = new ArrayList<>(var.NombreRecetasConsultaXListaIngredientes(sql));
         Resultado=nombres;
         

    }
    
    

    public String ResultadoNombre() {
        String a = "";        
        for (int i = 0; i < Resultado.size(); i++) {
            a = a + "- " + Resultado.get(i).toString() + "\n";
        }
        return a;
    }

    

}
