/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Objetos.EstructuraBajaBien;
import Tablas.TablaModelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

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
    
    public void llenarBajas(TablaModelo modelo,String noInventario, String noAcuerdo, String noReferencia, String fechaInicial, String fechaFinal){
        PreparedStatement declaracion;
        try {
            boolean tieneFiltro = false;

            ArrayList<String> listaFiltros = new ArrayList<>();
            String filtros = "";

            if (!noInventario.equals("")) {
                listaFiltros.add(noInventario);
                filtros = filtros + " WHERE NOINVENTARIO=? ";
                tieneFiltro = true;
            }
            if (!noAcuerdo.equals("")) {
                listaFiltros.add(noAcuerdo);
                if (tieneFiltro) {
                    filtros = filtros + " AND NOACUERDOCONSEJO=? ";
                } else {
                    filtros = filtros + " WHERE NOACUERDOCONSEJO=? ";
                    tieneFiltro = true;
                }
            }
            if (!noReferencia.equals("")) {
                listaFiltros.add(noReferencia);
                if (tieneFiltro) {
                    filtros = filtros + " AND NOREFERENCIAAUDITORIA=? ";
                } else {
                    filtros = filtros + " WHERE NOREFERENCIAAUDITORIA=? ";
                    tieneFiltro = true;
                }
            }

            if (!fechaInicial.equals("") && fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHABAJA>=? ";
                } else {
                    filtros = filtros + " WHERE FECHABAJA>=? ";
                    tieneFiltro = true;
                }
            } else if (fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHABAJA<=? ";
                } else {
                    filtros = filtros + " WHERE FECHABAJA<=? ";
                    tieneFiltro = true;
                }
            } else if (!fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHABAJA BETWEEN ? AND ? ";
                } else {
                    filtros = filtros + " WHERE FECHABAJA BETWEEN ? AND ? ";
                    tieneFiltro = true;
                }
            }
            declaracion = conexion.prepareStatement("SELECT * FROM BAJABIEN  "+filtros+"  ORDER BY FECHABAJA DESC");
            for (int i = 0; i < listaFiltros.size(); i++) {
                declaracion.setString(i + 1, listaFiltros.get(i));
            }
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[5];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getString(5);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar las bajas de bienes");
        }
    }

}
