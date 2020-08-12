package Logica;

import Conexion.ConexionBD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            if (actualizarBien(noInventario, responsableNuevo,division)) {
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
