/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Objetos.Inicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jpmazate
 */
public class InicioSesion {

    private Connection conexion;

    public InicioSesion() {
        conexion = ConexionBD.getInstance();
    }

    public boolean validarDatos(Inicio datos) {
        try {
            PreparedStatement declaracion = conexion.prepareStatement("CALL getUsuario(?,?)");
            declaracion.setString(1, datos.getUsuario());
            declaracion.setString(2, datos.getContrasena());
            ResultSet resultado = declaracion.executeQuery();
            if(resultado.next()){
                int tipoUsuario = resultado.getInt(1);
                int estado = resultado.getInt(2);
                datos.setTipoUsuario(tipoUsuario);
                datos.setEstado(estado);
                return true;
            }else{
                return false;
            }          
        } catch (SQLException e) {
            return false;
        }
    }
    
    

}
