/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Objetos.EstructuraBien;
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
public class ManejadorEditarBien {

    private Connection conexion;

    public ManejadorEditarBien() {
        conexion = ConexionBD.getInstance();
    }

    public void llenarDatos(EstructuraBien bien) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("SELECT "
                    + "NOINVENTARIO,UNIDADACADEMICA,ANIOINGRESO,TIPOBIEN,NOFACTURA,"
                    + "FECHAFACTURA,FECHAINGRESO,NOSOLICITUDCOMPRA,NOORDENCOMPRA,NOCUR,VALORBIEN,"
                    + "DIVISION,ENCARGADOACTUAL,ENTIDADCOMPRA,ESTADOACTUAL,PROVEEDOR,TIPOINGRESO,DESCRIPCION"
                    + " FROM BIEN WHERE NOINVENTARIO=?");
            declaracion.setString(1, bien.getNoInventario());
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                bien.setNoInventario(resultado.getString(1));
                bien.setUnidadAcademica(resultado.getString(2));
                bien.setAnioIngreso(resultado.getString(3));
                bien.setTipoBien(resultado.getString(4));
                bien.setNoFactura(resultado.getString(5));
                bien.setFechaFactura(resultado.getString(6));
                bien.setFechaIngreso(resultado.getString(7));
                bien.setNoSolicitudCompra(resultado.getString(8));
                bien.setNoOrdenCompra(resultado.getString(9));
                bien.setNoCUR(resultado.getString(10));
                bien.setValorBien(resultado.getString(11));
                bien.setDivision(resultado.getString(12));
                bien.setEncargadoActual(resultado.getString(13));
                bien.setEntidadCompra(resultado.getString(14));
                bien.setEstadoActual(resultado.getString(15));
                bien.setProveedor(resultado.getString(16));
                bien.setTipoIngreso(resultado.getString(17));
                bien.setDescripcion(resultado.getString(18));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema al cargar la informacion del bien");
            bien = null;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema al cargar los datos del bien");
            bien = null;
        }
    }

    public boolean editarBien(EstructuraBien bien) {
        try {
            PreparedStatement declaracion;
            if (bien.getTipoIngreso().equals("COMPRA")) {
                declaracion = conexion.prepareStatement("UPDATE BIEN SET "
                        + "NOFACTURA=?,FECHAFACTURA=?,NOSOLICITUDCOMPRA=?,NOORDENCOMPRA=?,NOCUR=?,VALORBIEN=?,"
                        + "DIVISION=?,ENTIDADCOMPRA=?,PROVEEDOR=?,DESCRIPCION=?"
                        + " WHERE NOINVENTARIO=?");

                declaracion.setString(1, bien.getNoFactura());
                declaracion.setString(2, bien.getFechaFactura());
                declaracion.setString(3, bien.getNoSolicitudCompra());
                declaracion.setString(4, bien.getNoOrdenCompra());
                declaracion.setString(5, bien.getNoCUR());
                declaracion.setString(6, bien.getValorBien());
                declaracion.setString(7, bien.getDivision());
                declaracion.setString(8, bien.getEntidadCompra());
                declaracion.setString(9, bien.getProveedor());
                declaracion.setString(10, bien.getDescripcion());
                declaracion.setString(11, bien.getNoInventario());

                declaracion.executeUpdate();

            }else{
                 declaracion = conexion.prepareStatement("UPDATE BIEN SET "
                        + "NOCUR=?,VALORBIEN=?,"
                        + "DIVISION=?,PROVEEDOR=?,DESCRIPCION=?"
                        + " WHERE NOINVENTARIO=?");
                declaracion.setString(1, bien.getNoCUR());
                declaracion.setString(2, bien.getValorBien());
                declaracion.setString(3, bien.getDivision());
                declaracion.setString(4, bien.getProveedor());
                declaracion.setString(5, bien.getDescripcion());
                declaracion.setString(6, bien.getNoInventario());
                declaracion.executeUpdate();
                
            }

            return true;
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
