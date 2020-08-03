/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Tablas.TablaModelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class ManejadorTiposBien {
    
    private Connection conexion;

    public ManejadorTiposBien() {
        conexion = ConexionBD.getInstance();
    }
    
     public void llenarTiposBien(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("CALL fillTiposBien()");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[2];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar los tipos de bienes");
        } catch(Exception e){
            
        }
    }
     
      public boolean crearTipoBien(String codigo, String nombre) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("INSERT INTO TIPOBIEN(CODIGO,NOMBRE) VALUES (?,?);");
            declaracion.setString(1, codigo);
            declaracion.setString(2, nombre);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
      
      public boolean editarTipoBien(String codigo, String nombre) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE TIPOBIEN SET NOMBRE=? WHERE CODIGO=?");
            declaracion.setString(1, nombre);
            declaracion.setString(2, codigo);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
      
      public boolean eliminarTipoBien(String codigo){
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("DELETE FROM TIPOBIEN WHERE CODIGO=?");
            declaracion.setString(1, codigo);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
    
}
