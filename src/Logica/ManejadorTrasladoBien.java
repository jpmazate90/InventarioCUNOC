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
public class ManejadorTrasladoBien {

    private Connection conexion;

    public ManejadorTrasladoBien() {
        conexion = ConexionBD.getInstance();
    }

    public boolean crearTraslado(String noInventario, String responsableNuevo, String responsableAnterior, String fechaTraslado, String motivoTraslado, String division) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("INSERT INTO TRASLADO(NOINVENTARIO,NOTARJETA, RESPONSABLENUEVO,RESPONSABLEANTERIOR,FECHATRASLADO,MOTIVOTRASLADO,DIVISION) VALUES (?,?,?,?,?,?,?);");
            declaracion.setString(1, noInventario);
            declaracion.setString(2, noInventario);
            declaracion.setString(3, responsableNuevo);
            declaracion.setString(4, responsableAnterior);
            declaracion.setString(5, fechaTraslado);
            declaracion.setString(6, motivoTraslado);
            declaracion.setString(7, division);
            declaracion.executeUpdate();

            if (actualizarBien(noInventario, responsableNuevo, division)) {
                return true;
            } else {
//                PreparedStatement declaracion2;
//                
//                declaracion2 = conexion.prepareStatement("DELETE FROM TRASLADO WHERE NOINVENTARIO=? AND NOTARJETA=? AND RESPONSABLENUEVO=? AND RESPONSABLEANTERIOR=? AND FECHATRASLADO=? AND MOTIVOTRASLADO=? AND DIVISION=? ORDER BY ID DESC LIMIT 1;");
//                declaracion2.setString(1, noInventario);
//                declaracion2.setString(2, noInventario);
//                declaracion2.setString(3, responsableNuevo);
//                declaracion2.setString(4, responsableAnterior);
//                declaracion2.setString(5, fechaTraslado);
//                declaracion2.setString(6, motivoTraslado);
//                declaracion2.setString(7, division);
//                declaracion2.executeUpdate();
//
                return false;
            }

        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void llenarTraslados(TablaModelo modelo, String noInventario) {
        PreparedStatement declaracion;
        try {
            declaracion = conexion.prepareStatement("SELECT * FROM TRASLADO WHERE NOINVENTARIO=? ORDER BY FECHATRASLADO DESC");
            declaracion.setString(1, noInventario);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[7];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(4);
                objeto[3] = resultado.getString(5);
                objeto[4] = resultado.getString(6);
                objeto[5] = resultado.getString(7);
                objeto[6] = resultado.getString(8);
                
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema al cargar los traslados");
        }
    }

    public void llenarTrasladosConFiltros(TablaModelo modelo, String noInventario, String fechaInicial, String fechaFinal, String encargadoNuevo, String encargadoViejo) {
        PreparedStatement declaracion;
        try {
            boolean tieneFiltro = false;

            ArrayList<String> listaFiltros = new ArrayList<>();
            String filtros = "";

            if (!encargadoNuevo.equals("")) {
                listaFiltros.add(encargadoNuevo);
                filtros = filtros + " WHERE RESPONSABLENUEVO=? ";
                tieneFiltro = true;
            }
             if (!encargadoViejo.equals("")) {
                listaFiltros.add(encargadoViejo);
                if (tieneFiltro) {
                    filtros = filtros + " AND RESPONSABLEANTERIOR=? ";
                } else {
                    filtros = filtros + " WHERE RESPONSABLEANTERIOR=? ";
                    tieneFiltro = true;
                }
            }

            if (!fechaInicial.equals("") && fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHATRASLADO>=? ";
                } else {
                    filtros = filtros + " WHERE FECHATRASLADO>=? ";
                    tieneFiltro = true;
                }
            } else if (fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHATRASLADO<=? ";
                } else {
                    filtros = filtros + " WHERE FECHATRASLADO<=? ";
                    tieneFiltro = true;
                }
            } else if (!fechaInicial.equals("") && !fechaFinal.equals("")) {
                listaFiltros.add(fechaInicial);
                listaFiltros.add(fechaFinal);
                if (tieneFiltro) {
                    filtros = filtros + " AND FECHATRASLADO BETWEEN ? AND ? ";
                } else {
                    filtros = filtros + " WHERE FECHATRASLADO BETWEEN ? AND ? ";
                    tieneFiltro = true;
                }
            }
            declaracion = conexion.prepareStatement("SELECT * FROM TRASLADO  "+filtros+"  ORDER BY FECHATRASLADO DESC");
            for (int i = 0; i < listaFiltros.size(); i++) {
                declaracion.setString(i + 1, listaFiltros.get(i));
            }
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                Object objeto[] = new Object[7];
                objeto[0] = resultado.getString(1);
                objeto[1] = resultado.getString(2);
                objeto[2] = resultado.getString(4);
                objeto[3] = resultado.getString(5);
                objeto[4] = resultado.getString(6);
                objeto[5] = resultado.getString(7);
                objeto[6] = resultado.getString(8);
                modelo.addRow(objeto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema al cargar los traslados");
        }
    }

    public boolean actualizarBien(String noInventario, String encargadoNuevo, String division) {
        try {
            PreparedStatement declaracion;
            declaracion = conexion.prepareStatement("UPDATE BIEN SET ENCARGADOACTUAL=?, DIVISION=? WHERE NOINVENTARIO=?");
            declaracion.setString(1, encargadoNuevo);
            declaracion.setString(2, division);
            declaracion.setString(3, noInventario);

            declaracion.executeUpdate();
            return true;
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
}
