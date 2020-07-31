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
public class ManejadorUsuarios {

    private Connection conexion;

    public ManejadorUsuarios() {
        conexion = ConexionBD.getInstance();
    }

    public void llenarUsuarios(TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("CALL fillUsuarios()");
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[6];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getInt(5);
                objeto[5] = resultado.getInt(6);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {      
            JOptionPane.showMessageDialog(null,"Problema al cargar los Usuarios");
        }
    }
    
    public boolean cambiarContrasena(String usuario, String contrasena){
       try {// prepara la orden 
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE USUARIO SET Contrasena=? WHERE Usuario=?");
            declaracion.setString(1, contrasena);
            declaracion.setString(2, usuario);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
    
    public boolean editarUsuario(String usuario, String nombre, String dpi, String area){
        try {// prepara la orden 
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE USUARIO SET nombreCompleto=?,dpi=?,areaTrabajo=? WHERE Usuario=?");
            declaracion.setString(1, nombre);
            declaracion.setString(2, dpi);
            declaracion.setString(3, area);
            declaracion.setString(4, usuario);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
        
    }
    
    public boolean cambiarEstadoUsuario(String usuario, int estado){
        try {// prepara la orden 
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE USUARIO SET Estado=? WHERE Usuario=?");
            declaracion.setInt(1, estado);
            declaracion.setString(2, usuario);
            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
    
    public boolean crearUsuario(String usuario, String contrasena, String nombre,String dpi, String area,Integer tipo, Integer estado){
         try {
                PreparedStatement declaracion;
                declaracion = conexion.prepareStatement("INSERT INTO USUARIO(USUARIO,CONTRASENA,NOMBRECOMPLETO,DPI,AREATRABAJO,TIPOUSUARIO,ESTADO) VALUES (?,?,?,?,?,?,?);");
                declaracion.setString(1, usuario);// maneja el resultado 
                declaracion.setString(2, Md5.getMD5(contrasena));
                declaracion.setString(3, nombre);
                declaracion.setString(4, dpi);
                declaracion.setString(5, area);
                declaracion.setInt(6, tipo);
                declaracion.setInt(7, estado);

                declaracion.executeUpdate();// maneja el resultado 
                return true;
         } catch (HeadlessException | SQLException e) {
                return false;
            }
    }

}
