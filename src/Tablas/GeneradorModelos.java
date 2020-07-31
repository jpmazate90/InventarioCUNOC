/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import javax.swing.JTable;

/**
 *
 * @author jpmazate
 */
public class GeneradorModelos {
    
    public static void modeloUsuarios(TablaModelo modelo) {
        modelo.addColumn("USUARIO");
        modelo.addColumn("NOMBRE COMPLETO");
        modelo.addColumn("DPI");
        modelo.addColumn("AREA TRABAJO");
        modelo.addColumn("TIPO USUARIO");
        modelo.addColumn("ESTADO");
    }
    
    public static void modeloProveedores(TablaModelo modelo) {
        modelo.addColumn("NIT");
        modelo.addColumn("NOMBRE EMPRESA");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("AREA TRABAJO");
        modelo.addColumn("TELEFONO");
    }
    
    
    
    public static void asignarModeloTabla(TablaModelo modelo, JTable tabla) {
        tabla.setModel(modelo);
    }
    
}
