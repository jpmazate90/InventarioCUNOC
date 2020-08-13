/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Objetos.EstructuraBajaBien;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jpmazate
 */
public class ManejadorBajaBien {

    private Connection conexion;

    public ManejadorBajaBien() {
        conexion = ConexionBD.getInstance();
    }
    
    public boolean guardarBajaBien(EstructuraBajaBien baja){
        
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("INSERT INTO BAJABIEN(NOINVENTARIO,NOACUERDOCONSEJO,NOREFERENCIAAUDITORIA,FECHABAJA) VALUES (?,?,?,?);");
            declaracion.setString(1, baja.getNoInventario());
            declaracion.setString(2, baja.getNoAcuerdoConsejo());
            declaracion.setString(3, baja.getNoReferenciaAuditoria());
            declaracion.setTimestamp(4, baja.getFechaBaja());           
            declaracion.executeUpdate();
            return true;
            
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

}
