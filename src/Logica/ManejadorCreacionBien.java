/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
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
public class ManejadorCreacionBien {

    private Connection conexion;

    public ManejadorCreacionBien() {
        conexion = ConexionBD.getInstance();
    }

    public int obtenerNumero(String tipoBien) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("SELECT NUMEROELEMENTO FROM BIEN WHERE TIPOBIEN=? ORDER BY NUMEROELEMENTO DESC LIMIT 1");
            declaracion.setString(1, tipoBien);
            ResultSet resultado = declaracion.executeQuery();

            if (resultado.next()) {
                int valor = resultado.getInt(1);
                return valor + 1;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar los tipos de bienes");
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean crearBien(String noInventario, String usuario, String noTarjeta, String unidadAcademica,
            String letra, int numeroElemento, String anioIngreso, String tipoBien, String descripcion, String noFactura, String fechaFactura, String noSolicitudCompra,
            String noOrdenCompra, String noCUR, String valorBien, String division, String encargadoInicial, String encargadoActual,
            String tipoIngreso, String entidadCompra, String proveedor, String procedencia, String noTranscripcion, String correlativo, String numeroActa) {

        try {
            if (tipoIngreso.equals("COMPRA")) {
                PreparedStatement declaracion;
                declaracion = conexion.prepareStatement("INSERT INTO BIEN(NoInventario,Usuario,NoTarjeta,UnidadAcademica,Letra,NumeroElemento,AnioIngreso,TipoBien,Descripcion,NoFactura ,FechaFactura,NoSolicitudCompra,NoOrdenCompra,NoCUR,ValorBien\n"
                        + ",Division,EncargadoInicial,EncargadoActual,TipoIngreso,EntidadCompra,EstadoActual,Proveedor,Procedencia,NoTranscripcion,CorrelativoInscripcion,NumeroActa)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                declaracion.setString(1, noInventario);
                declaracion.setString(2, usuario);
                declaracion.setString(3, noTarjeta);
                declaracion.setString(4, unidadAcademica);
                declaracion.setString(5, letra);
                declaracion.setInt(6, numeroElemento);
                declaracion.setInt(7, Integer.parseInt(anioIngreso));
                declaracion.setString(8, tipoBien);
                declaracion.setString(9, descripcion);
                declaracion.setString(10, noFactura);
                declaracion.setString(11, fechaFactura);
                declaracion.setString(12, noSolicitudCompra);
                declaracion.setString(13, noOrdenCompra);
                declaracion.setString(14, noCUR);
                declaracion.setFloat(15, Float.parseFloat(valorBien));
                declaracion.setString(16, division);
                declaracion.setString(17, encargadoInicial);
                declaracion.setString(18, encargadoActual);
                declaracion.setString(19, tipoIngreso);
                declaracion.setString(20, entidadCompra);
                declaracion.setInt(21, 1);
                declaracion.setString(22, proveedor);
                declaracion.setString(23, procedencia);
                declaracion.setString(24, noTranscripcion);
                declaracion.setString(25, correlativo);
                declaracion.setString(26, numeroActa);

                declaracion.executeUpdate();
                return true;

            } else {
                PreparedStatement declaracion;
                declaracion = conexion.prepareStatement("INSERT INTO BIEN(NoInventario,Usuario,NoTarjeta,UnidadAcademica,Letra,NumeroElemento,AnioIngreso,TipoBien,Descripcion,NoCUR,ValorBien\n"
                        + ",Division,EncargadoInicial,EncargadoActual,TipoIngreso,EstadoActual,Proveedor,Procedencia,NoTranscripcion,CorrelativoInscripcion,NumeroActa)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                declaracion.setString(1, noInventario);
                declaracion.setString(2, usuario);
                declaracion.setString(3, noTarjeta);
                declaracion.setString(4, unidadAcademica);
                declaracion.setString(5, letra);
                declaracion.setInt(6, numeroElemento);
                declaracion.setInt(7, Integer.parseInt(anioIngreso));
                declaracion.setString(8, tipoBien);
                declaracion.setString(9, descripcion);
                declaracion.setString(10, noCUR);
                declaracion.setFloat(11, Float.parseFloat(valorBien));// hay que cambiar por float
                declaracion.setString(12, division);
                declaracion.setString(13, encargadoInicial);
                declaracion.setString(14, encargadoActual);
                declaracion.setString(15, tipoIngreso);
                declaracion.setInt(16, 1);
                if (tipoIngreso.equals("DONACION")) {
                    declaracion.setString(17, "1000000");
                } else {
                    declaracion.setString(17, "0000000");
                }
                declaracion.setString(18, procedencia);
                declaracion.setString(19, noTranscripcion);
                declaracion.setString(20, correlativo);
                declaracion.setString(21, numeroActa);

                declaracion.executeUpdate();
                return true;

            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
