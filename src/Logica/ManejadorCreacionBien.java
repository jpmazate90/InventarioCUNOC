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
import java.util.ArrayList;
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
                    declaracion.setString(17, "10000000");
                } else {
                    declaracion.setString(17, "00000000");
                }
                declaracion.setString(18, procedencia);
                declaracion.setString(19, noTranscripcion);
                declaracion.setString(20, correlativo);
                declaracion.setString(21, numeroActa);

                declaracion.executeUpdate();
                return true;

            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS AL INSERTAR DATOS, VERIFIQUE SI EL VALOR DEL BIEN ESTA CORRECTAMENTE ESCRITO, Y LOS DEMAS CAMPOS TAMBIEN LO ESTAN");
            e.printStackTrace();
            return false;
        }catch(Exception e){
            return false;
        }

    }

    public boolean buscarBien(
            String noTarjeta, String unidadAcademica, String anio, String tipoBien, String noFactura,
            String fechaInicial, String fechaFinal, String tipoIngreso,
            String estadoActual, String encargadoActual, String division,
            String proveedor, String valorInicial, String valorFinal, TablaModelo modelo) {
        PreparedStatement declaracion;
        try {
            boolean tieneFiltro = false;

            ArrayList<String> listaFiltros = new ArrayList<>();
            String filtros = "";
            if (!noTarjeta.equals("")) {
                listaFiltros.add(noTarjeta);
                filtros = filtros + " WHERE NOTARJETA=? ";
                tieneFiltro = true;
            }
            if (!unidadAcademica.equals("")) {
                listaFiltros.add(unidadAcademica);
                if (tieneFiltro) {
                    filtros = filtros + " AND UNIDADACADEMICA=? ";
                } else {
                    filtros = filtros + " WHERE UNIDADACADEMICA=? ";
                    tieneFiltro = true;
                }
            }
            if (!anio.equals("")) {
                listaFiltros.add(anio);
                if (tieneFiltro) {
                    filtros = filtros + " AND ANIOINGRESO=? ";
                } else {
                    filtros = filtros + " WHERE ANIOINGRESO=? ";
                    tieneFiltro = true;
                }
            }
            if (!tipoBien.equals("TODOS")) {
                listaFiltros.add(tipoBien);
                if (tieneFiltro) {
                    filtros = filtros + " AND TIPOBIEN=? ";
                } else {
                    filtros = filtros + " WHERE TIPOBIEN=? ";
                    tieneFiltro = true;
                }
            }
            if (!noFactura.equals("")) {
                listaFiltros.add(noFactura);
                if (tieneFiltro) {
                    filtros = filtros + " AND NOFACTURA=? ";
                } else {
                    filtros = filtros + " WHERE NOFACTURA=? ";
                    tieneFiltro = true;
                }
            }
            if (!fechaInicial.equals("") && fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHAINGRESO>=? ";
                } else {
                    filtros = filtros + " WHERE FECHAINGRESO>=? ";
                    tieneFiltro = true;
                }
            } else if (fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHAINGRESO<=? ";
                } else {
                    filtros = filtros + " WHERE FECHAINGRESO<=? ";
                    tieneFiltro = true;
                }
            } else if (!fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHAINGRESO BETWEEN ? AND ? ";
                } else {
                    filtros = filtros + " WHERE FECHAINGRESO BETWEEN ? AND ? ";
                    tieneFiltro = true;
                }
            }

            if (!tipoIngreso.equals("TODOS")) {
                listaFiltros.add(tipoIngreso);
                if (tieneFiltro) {
                    filtros = filtros + " AND TIPOINGRESO=? ";
                } else {
                    filtros = filtros + " WHERE TIPOINGRESO=? ";
                    tieneFiltro = true;
                }
            }
            if (!estadoActual.equals("TODOS")) {
                String dato = "";
                if(estadoActual.equals("DE BAJA")){
                    dato ="0";
                }else{
                    dato = "1";
                }
                listaFiltros.add(dato);
                if (tieneFiltro) {
                    filtros = filtros + " AND ESTADOACTUAL=? ";
                } else {
                    filtros = filtros + " WHERE ESTADOACTUAL=? ";
                    tieneFiltro = true;
                }
            }
            if (!encargadoActual.equals("")) {
                listaFiltros.add(encargadoActual);
                if (tieneFiltro) {
                    filtros = filtros + " AND ENCARGADOACTUAL=? ";
                } else {
                    filtros = filtros + " WHERE ENCARGADOACTUAL=? ";
                    tieneFiltro = true;
                }
            }
            if (!division.equals("")) {
                listaFiltros.add(division);
                if (tieneFiltro) {
                    filtros = filtros + " AND DIVISION=? ";
                } else {
                    filtros = filtros + " WHERE DIVISION=? ";
                    tieneFiltro = true;
                }
            }
            if (!proveedor.equals("")) {
                listaFiltros.add(proveedor);
                if (tieneFiltro) {
                    filtros = filtros + " AND PROVEEDOR=? ";
                } else {
                    filtros = filtros + " WHERE PROVEEDOR=? ";
                    tieneFiltro = true;
                }
            }
            
            if (!valorInicial.equals("") && valorFinal.equals("")) {
                listaFiltros.add(valorInicial);
                if (tieneFiltro) {
                    filtros = filtros + " AND VALORBIEN>=? ";
                } else {
                    filtros = filtros + " WHERE VALORBIEN>=? ";
                    tieneFiltro = true;
                }
            } else if (valorInicial.equals("") && !valorFinal.equals("")) {
                listaFiltros.add(valorFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND VALORBIEN<=?";
                } else {
                    filtros = filtros + " WHERE VALORBIEN<=? ";
                    tieneFiltro = true;
                }
            } else if (!valorInicial.equals("") && !valorFinal.equals("")) {
                listaFiltros.add(valorInicial);
                listaFiltros.add(valorFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND VALORBIEN BETWEEN ? AND ? ";
                } else {
                    filtros = filtros + " WHERE VALORBIEN BETWEEN ? AND ? ";
                    tieneFiltro = true;
                }
            }

            System.out.println("Esto tiene filtros: " + filtros);

         
            declaracion = conexion.prepareStatement("SELECT NOINVENTARIO,UNIDADACADEMICA,ANIOINGRESO,TIPOBIEN,NOFACTURA,FECHAINGRESO,TIPOINGRESO,ESTADOACTUAL,ENCARGADOACTUAL,DIVISION,PROVEEDOR,VALORBIEN FROM BIEN " + filtros);

            for (int i = 0; i < listaFiltros.size(); i++) {
                declaracion.setString(i + 1, listaFiltros.get(i));
            }
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[12];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(3);
                objeto[3] = resultado.getString(4);
                objeto[4] = resultado.getString(5);
                objeto[5] = resultado.getString(6);
                objeto[6] = resultado.getString(7);
                objeto[7] = resultado.getString(8);
                objeto[8] = resultado.getString(9);
                objeto[9] = resultado.getString(10);
                objeto[10] = resultado.getString(11);
                objeto[11] = resultado.getString(12);
                
                
                
                modelo.addRow(objeto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema al cargar los tipos de bienes");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
