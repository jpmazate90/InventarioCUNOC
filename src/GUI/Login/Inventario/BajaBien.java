package GUI.Login.Inventario;

import Logica.ManejadorBajaBien;
import Objetos.EstructuraBajaBien;
import Objetos.EstructuraBien;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

public class BajaBien extends javax.swing.JDialog {

    private EstructuraBien bien;
    private ManejadorBajaBien manejadorBajaBien;

    public BajaBien(java.awt.Frame parent, boolean modal, EstructuraBien bien) {
        super(parent, modal);
        initComponents();
        this.bien = bien;
        manejadorBajaBien = new ManejadorBajaBien();
        llenarCampos();
    }

    public void llenarCampos() {
        this.textoDivision.setText(bien.getDivision());
        this.textoEncargado.setText(bien.getEncargadoActual());
        this.textoEstado.setText(bien.getEstadoActual());
        this.textoFechaIngreso.setText(bien.getFechaIngreso());
        this.textoInventario.setText(bien.getNoInventario());
        this.textoProveedor.setText(bien.getProveedor());
        this.textoTipoIngreso.setText(bien.getTipoIngreso());
        this.textoValor.setText(bien.getValorBien());
    }

    public void darBajaBien() {
        String noAcuerdo = this.campoNoAcuerdo.getText();
        String noReferencia = this.campoNoReferencia.getText();
        if (!noAcuerdo.equals("")) {
            if (noAcuerdo.length() <= 30) {
                if (!noReferencia.equals("")) {
                    if (noReferencia.length() <= 30) {//0=yes, 1=no, 2=cancel
                        int input = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja el bien con No de Inventario: " + this.bien.getNoInventario() + ""
                                + "\nCon los siguientes datos:\n"
                                + "No Acuerdo Consejo:" + noAcuerdo + "\n"
                                + "No Referencia Auditoria: " + noReferencia);
                        if (input == 0) {
                            EstructuraBajaBien mandar = new EstructuraBajaBien(this.bien.getNoInventario(), noAcuerdo, noReferencia, new Timestamp(new Date().getTime()));
                            boolean resultado = manejadorBajaBien.guardarBajaBien(mandar);
                            if (resultado) {
                                JOptionPane.showMessageDialog(null, "SE HA REGISTRADO LA BAJA DEL BIEN CON EXITO, NO DE INVENTARIO: "+this.bien.getNoInventario());
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "EXISTIERON PROBLEMAS PARA REGISTRAR LA BAJA DEL BIEN");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA BAJA DEL BIEN, REVISA LOS DATOS Y VUELVE A DAR CLICK AL BOTON DE DAR DE BAJA O CIERRA LA VENTANA PARA SALIRTE");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR, EL NUMERO DE REFERENCIA DE AUDITORIA NO PUEDE PASAR DE 30 CARACTERES, ACTUALES: " + noReferencia.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, EL NUMERO DE REFERENCIA DE AUDITORIA NO PUEDE ESTAR VACIO");
                }

            } else {
                JOptionPane.showMessageDialog(null, "ERROR, EL NUMERO DE ACUERDO DE CONSEJO NO PUEDE PASAR DE 30 CARACTERES, ACTUALES: " + noAcuerdo.length());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, EL NUMERO DE ACUERDO DE CONSEJO NO PUEDE ESTAR VACIO");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoInventario = new javax.swing.JTextField();
        textoEncargado = new javax.swing.JTextField();
        textoTipoIngreso = new javax.swing.JTextField();
        textoValor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textoFechaIngreso = new javax.swing.JTextField();
        textoProveedor = new javax.swing.JTextField();
        textoDivision = new javax.swing.JTextField();
        textoEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoNoReferencia = new javax.swing.JTextField();
        campoNoAcuerdo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BAJA DE BIEN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("BAJA DE BIEN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 180, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        jLabel1.setText("No Inventario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel2.setText("Encargado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel3.setText("Tipo de Ingreso:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel7.setText("Valor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        textoInventario.setEditable(false);
        getContentPane().add(textoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 290, -1));

        textoEncargado.setEditable(false);
        getContentPane().add(textoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 290, -1));

        textoTipoIngreso.setEditable(false);
        getContentPane().add(textoTipoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 290, -1));

        textoValor.setEditable(false);
        getContentPane().add(textoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 290, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 20, 20));

        textoFechaIngreso.setEditable(false);
        getContentPane().add(textoFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 290, -1));

        textoProveedor.setEditable(false);
        getContentPane().add(textoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 290, -1));

        textoDivision.setEditable(false);
        getContentPane().add(textoDivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 290, -1));

        textoEstado.setEditable(false);
        getContentPane().add(textoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 290, -1));

        jLabel13.setText("Estado:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jLabel14.setText("Division:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        jLabel15.setText("Proveedor:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jLabel16.setText("Fecha de Ingreso:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        jLabel8.setText("No Acuerdo Consejo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel9.setText("No Referencia Auditoria:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));
        getContentPane().add(campoNoReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 410, -1));
        getContentPane().add(campoNoAcuerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 410, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_opt.png"))); // NOI18N
        jButton1.setText("DAR DE BAJA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 300, 110));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 270, -1, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        darBajaBien();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoNoAcuerdo;
    private javax.swing.JTextField campoNoReferencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textoDivision;
    private javax.swing.JTextField textoEncargado;
    private javax.swing.JTextField textoEstado;
    private javax.swing.JTextField textoFechaIngreso;
    private javax.swing.JTextField textoInventario;
    private javax.swing.JTextField textoProveedor;
    private javax.swing.JTextField textoTipoIngreso;
    private javax.swing.JTextField textoValor;
    // End of variables declaration//GEN-END:variables
}
