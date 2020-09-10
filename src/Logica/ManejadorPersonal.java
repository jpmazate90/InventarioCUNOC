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
public class ManejadorPersonal {

    private Connection conexion;

    public ManejadorPersonal() {
        conexion = ConexionBD.getInstance();
    }

    public void llenarPersonal(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("CALL fillPersonal()");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[10];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getDate(3).toString();
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getString(5);
                objeto[5] = resultado.getString(6);
                objeto[6] = resultado.getInt(7);
                objeto[7] = resultado.getString(8);
                objeto[8] = resultado.getTimestamp(9);
                objeto[9] = resultado.getTimestamp(10);

                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar al personal");
        }
    }
    
    public void llenarAuxiliarEncaragdo(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("SELECT NOPERSONAL,NOMBRECOMPLETO,DPI,AREATRABAJO FROM PERSONAL WHERE ESTADO=1 ORDER BY NOPERSONAL");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[4];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar a los encargados");
        }
    }
    

    public boolean crearPersonal(String no, String nombre, String fecha, String correo, String dpi, String puesto, String estado, String area) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("INSERT INTO PERSONAL(NOPERSONAL,NOMBRECOMPLETO,FECHANACIMIENTO,CORREOELECTRONICO,DPI,PUESTO,ESTADO,AREATRABAJO) VALUES (?,?,?,?,?,?,?,?);");
            declaracion.setString(1, no);
            declaracion.setString(2, nombre);
            declaracion.setString(3, fecha);
            declaracion.setString(4, correo);
            declaracion.setString(5, dpi);
            declaracion.setString(6, puesto);
            declaracion.setInt(7, Integer.parseInt(estado));
            declaracion.setString(8, area);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cambiarEstadoPersonal(String no, int estado) {
        try {// prepara la orden 
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE PERSONAL SET Estado=? WHERE NOPERSONAL=?");
            declaracion.setInt(1, estado);
            declaracion.setString(2, no);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

    public boolean editarPersonal(String no, String nombre, String fecha, String correo, String dpi, String puesto, String estado, String area) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE PERSONAL SET NOMBRECOMPLETO=?,FECHANACIMIENTO=?,CORREOELECTRONICO=?,DPI=?,PUESTO=?,AREATRABAJO=? WHERE NOPERSONAL=?");
            declaracion.setString(1, nombre);
            declaracion.setString(2, fecha);
            declaracion.setString(3, correo);
            declaracion.setString(4, dpi);
            declaracion.setString(5, puesto);
            declaracion.setString(6, area);
            declaracion.setString(7, no);
             declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

    public boolean eliminarPersonal(String no) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("DELETE FROM PERSONAL WHERE NOPERSONAL=?");
            declaracion.setString(1, no);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
}
