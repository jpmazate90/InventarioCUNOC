/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Hash.Md5;
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
public class ManejadorProveedores {

    private Connection conexion;

    public ManejadorProveedores() {
        conexion = ConexionBD.getInstance();
    }

    public void llenarProveedores(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("CALL fillProveedores()");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[7];
                objeto[0] = resultado.getInt(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getInt(5);
                objeto[5] = resultado.getTimestamp(6);
                objeto[6] = resultado.getTimestamp(7);

                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar los proveedores");
        } catch(Exception e){
            
        }
    }
    
     public void llenarAuxiliarProveedores(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("SELECT NIT, NOMBRE, DIRECCION,AREATRABAJO,TELEFONO FROM PROVEEDOR ORDER BY NIT");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[5];
                objeto[0] = resultado.getInt(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getInt(5);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar los proveedores");
        } catch(Exception e){
            
        }
    }

    public boolean crearProveedor(String nit, String nombre, String direccion, String area, String telefono) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("INSERT INTO PROVEEDOR(NIT,NOMBRE,DIRECCION,AREATRABAJO,TELEFONO) VALUES (?,?,?,?,?);");
            declaracion.setInt(1, Integer.parseInt(nit));
            declaracion.setString(2, nombre);
            declaracion.setString(3, direccion);
            declaracion.setString(4, area);
            declaracion.setInt(5, Integer.parseInt(telefono));

            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

    public boolean editarProveedor(String nit, String nombre, String direccion, String area, String telefono) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE PROVEEDOR SET NOMBRE=?,DIRECCION=?,areaTrabajo=?,TELEFONO=? WHERE NIT=?");
            declaracion.setString(1, nombre);
            declaracion.setString(2, direccion);
            declaracion.setString(3, area);
            declaracion.setInt(4, Integer.parseInt(telefono));
            declaracion.setInt(5, Integer.parseInt(nit));
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
    
    
    public boolean eliminarProveedor(String nit){
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("DELETE FROM PROVEEDOR WHERE NIT=?");
            declaracion.setInt(1, Integer.parseInt(nit));
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

}
