/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariocunoc;

import Conexion.ConexionBD;
import GUI.Login.Login;
import Hash.Md5;
import java.awt.HeadlessException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class InventarioCUNOC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
//        Connection conexion = ConexionBD.getInstance();
//        if (conexion == null) {
//            System.out.println("no hay base de datos");
//        } else {
//            try {
//                Hash.Md5 a = new Md5();
//                PreparedStatement declaracion;
//                declaracion = conexion.prepareStatement("INSERT INTO USUARIO(USUARIO,CONTRASENA,NOMBRECOMPLETO,DPI,AREATRABAJO,TIPOUSUARIO,ESTADO) VALUES (?,?,?,?,?,?,?);");
//                declaracion.setString(1, "2");// maneja el resultado 
//                declaracion.setString(2, Md5.getMD5("2"));
//                declaracion.setString(3, "juan pablo orizabal");
//                declaracion.setString(4, "4334565622585");
//                declaracion.setString(5, "INVENTARIO");
//                declaracion.setInt(6, 2);
//                declaracion.setInt(7, 1);
//
//                declaracion.executeUpdate();// maneja el resultado 
//                JOptionPane.showMessageDialog(null, "se inserto correctamente");
//            } catch (HeadlessException | SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
    }

    

}
