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
        modelo.addColumn("FECHA CREACION");
        modelo.addColumn("FECHA EDITADO");

    }
    
    public static void modeloProveedores(TablaModelo modelo) {
        modelo.addColumn("NIT");
        modelo.addColumn("NOMBRE EMPRESA");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("AREA TRABAJO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("FECHA CREACION");
        modelo.addColumn("FECHA EDITADO");
    }
    
    
    public static void modeloAuxiliarProveedores(TablaModelo modelo) {
        modelo.addColumn("NIT");
        modelo.addColumn("NOMBRE EMPRESA");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("AREA TRABAJO");
        modelo.addColumn("TELEFONO");
    }
    
    public static void modeloPersonal(TablaModelo modelo) {
        modelo.addColumn("NO PERSONAL");
        modelo.addColumn("NOMBRE COMPLETO");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("CORREO ELECTRONICO");
        modelo.addColumn("DPI");
        modelo.addColumn("PUESTO");
        modelo.addColumn("ESTADO");
        modelo.addColumn("AREA TRABAJO");
        modelo.addColumn("FECHA CREACION");
        modelo.addColumn("FECHA EDITADO");
    }
    
    public static void modeloAuxiliarEncargado(TablaModelo modelo) {
        modelo.addColumn("NO PERSONAL");
        modelo.addColumn("NOMBRE COMPLETO");
        modelo.addColumn("DPI");
        modelo.addColumn("AREA TRABAJO");        
    }
    
     public static void modeloTiposBien(TablaModelo modelo) {
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        
    }
    
        public static void modeloBienes(TablaModelo modelo) {
        modelo.addColumn("NOINVENTARIO");
        modelo.addColumn("UNIDAD");
        modelo.addColumn("ANIO");
        modelo.addColumn("TIPO BIEN");
        modelo.addColumn("FACTURA");
        modelo.addColumn("FECHA INGRESO");
        modelo.addColumn("TIPO INGRESO");
        modelo.addColumn("ESTADO");
        modelo.addColumn("ENCARGADO");
        modelo.addColumn("DIVISION");
        modelo.addColumn("PROVEEDOR");
        modelo.addColumn("VALOR");                                
    }
    
    
    public static void asignarModeloTabla(TablaModelo modelo, JTable tabla) {
        tabla.setModel(modelo);
    }
    
}
