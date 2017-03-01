/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import javax.swing.JOptionPane;

/**
 *
 * @author ingenieria
 */
public class InOut {
    public String solicitarDatosStr (String m){
        String d = JOptionPane.showInputDialog(m);
        return d;
    }
    
    public void mostrarDatos (String m){
        JOptionPane.showMessageDialog(null, m);
    }
}
