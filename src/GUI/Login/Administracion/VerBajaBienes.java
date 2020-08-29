/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Exportacion.ExportarPDF;
import Logica.ManejadorBajaBien;
import Logica.ManejadorTrasladoBien;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class VerBajaBienes extends javax.swing.JDialog {

    private Frame frame;
    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private SimpleDateFormat formateador;
    private SimpleDateFormat fechaTimestamp;
    private ManejadorBajaBien manejadorBajaBien;
    private String usuarioActual;

    public VerBajaBienes(java.awt.Frame parent, boolean modal, String usuarioActual) {
        super(parent, modal);
        this.frame = parent;
        this.usuarioActual = usuarioActual;
        initComponents();
        this.frame = frame;
        modelo = new TablaModelo();
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        fechaTimestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        manejadorBajaBien = new ManejadorBajaBien();
        this.usuarioActual = usuarioActual;
        this.tablaBajas.setModel(modelo);

    }

    public void llenarTabla() {
        GeneradorModelos.modeloBaja(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaBajas);

        String fechaInicial = "";
        String fechaFinal = "";
        String noInventario = this.textoNoInventario.getText();
        String noAcuerdo = this.textoNoAcuerdo.getText();
        String noReferencia = this.textoNoReferencia.getText();
        if (this.textoCheckFechaInicial.isSelected()) {
            fechaInicial = formateador.format(this.textoFechaInicial.getDate());
        }
        if (this.textoCheckFechaFinal.isSelected()) {
            fechaFinal = formateador.format(this.textoFechaFinal.getDate());
        }
        manejadorBajaBien.llenarBajas(modelo, noInventario, noAcuerdo, noReferencia, fechaInicial, fechaFinal);
        this.textoFechaHoraReporte.setText(fechaTimestamp.format(new Date()));
    }

    public void recargarTabla() {
        modelo = new TablaModelo();
        this.textoFiltros.setText("");
        this.tablaBajas.setRowSorter(null);
        manejadorBajaBien = new ManejadorBajaBien();
        llenarTabla();
    }

    public void imprimirReporte() {
        if (existenElementosParaImprimir()) {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            File archivo = ExportarPDF.usarFileChooser(".pdf");
            if (archivo.getName().equals("null.pdf") == false) {// exporta a html segun el reporte
                int totalRegistros = totalRegistros();
                ArrayList<String> filtrosPrimarios = filtrosPrimarios();
                ArrayList<String> filtrosSecundarios = filtrosSecundarios();
                ExportarPDF.exportarReporteBaja(tablaBajas, totalRegistros, usuarioActual, this.textoFechaHoraReporte.getText(), filtrosPrimarios, filtrosSecundarios, archivo);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUNA RUTA PARA GUARDAR EL ARCHIVO, NO SE REALIZARA NINGUNA ACCION");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTEN ELEMENTOS EN LA TABLA PARA REALIZAR UN ARCHIVO DEL REPORTE");
        }
    }

    public ArrayList<String> filtrosPrimarios() {
        ArrayList<String> mandar = new ArrayList<>();
        if (!this.textoNoInventario.getText().equals("")) {
            mandar.add("No de Inventario: " + this.textoNoInventario.getText());
        }

        if (!this.textoNoAcuerdo.getText().equals("")) {
            mandar.add("No de Acuerdo Consejo: " + this.textoNoAcuerdo.getText());
        }

        if (!this.textoNoReferencia.getText().equals("")) {
            mandar.add("No de Referencia Auditoria: " + this.textoNoReferencia.getText());
        }

        if (this.textoCheckFechaInicial.isSelected()) {
            mandar.add("Fecha Inicial: " + formateador.format(this.textoFechaInicial.getDate()));
        }
        if (this.textoCheckFechaFinal.isSelected()) {
            mandar.add("Fecha Final: " + formateador.format(this.textoFechaFinal.getDate()));
        }

        return mandar;
    }

    public ArrayList<String> filtrosSecundarios() {
        ArrayList<String> mandar = new ArrayList<>();
        if (!textoFiltros.getText().equals("")) {
            mandar.add(filtros.getSelectedItem().toString() + ": " + textoFiltros.getText());
        }
        return mandar;
    }

    public int totalRegistros() {
        return this.tablaBajas.getRowCount();
    }

    public boolean existenElementosParaImprimir() {
        System.out.println(this.tablaBajas.getRowCount());
        return this.tablaBajas.getRowCount() != 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filtros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBajas = new javax.swing.JTable();
        textoFiltros = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoNoAcuerdo = new javax.swing.JTextField();
        textoNoInventario = new javax.swing.JTextField();
        textoNoReferencia = new javax.swing.JTextField();
        textoFechaFinal = new com.toedter.calendar.JDateChooser();
        textoFechaInicial = new com.toedter.calendar.JDateChooser();
        textoCheckFechaFinal = new javax.swing.JCheckBox();
        textoCheckFechaInicial = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textoFechaHoraReporte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE BAJA DE BIENES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("REPORTE BAJA DE BIENES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 53, -1, -1));

        jLabel2.setText("FILTRAR POR:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 111, -1, -1));

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NO INVENTARIO", "NO ACUERDO CONSEJO", "NO REFERENCIA AUDITORIA", "FECHA BAJA" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        getContentPane().add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 103, 210, -1));

        tablaBajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaBajas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 161, 972, -1));

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });
        getContentPane().add(textoFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 103, 650, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jLabel3.setText("FILTROS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setText("No Inventario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel5.setText("No Acuerdo Consejo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel6.setText("No Referencia Auditoria:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel7.setText("Fecha Inicial:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel8.setText("Fecha Final:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));
        getContentPane().add(textoNoAcuerdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 208, -1));
        getContentPane().add(textoNoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 215, -1));
        getContentPane().add(textoNoReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 208, -1));
        getContentPane().add(textoFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));
        getContentPane().add(textoFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        getContentPane().add(textoCheckFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));
        getContentPane().add(textoCheckFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        jButton1.setText("Aplicar Filtros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 210, -1));

        botonImprimir.setBackground(new java.awt.Color(92, 138, 184));
        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha_opt.jpg"))); // NOI18N
        botonImprimir.setText("Crear PDF");
        botonImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonImprimirMouseExited(evt);
            }
        });
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 250, -1));

        jLabel9.setText("Fecha y Hora del Reporte:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, -1, 30));

        textoFechaHoraReporte.setEditable(false);
        getContentPane().add(textoFechaHoraReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, 310, -1));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 740, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 320, -1, -1));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 730, -1, -1));

        jButton2.setText("Limpiar Filtros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoFiltrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltrosKeyTyped
        int valor = filtros.getSelectedIndex();
// sortea la tabla
        textoFiltros.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
            }
        });

        tablaSorteada = new TableRowSorter(modelo);
        tablaBajas.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltrosKeyTyped

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
        int valor = this.filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
        tablaBajas.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    private void botonImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonImprimirMouseEntered
        botonImprimir.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonImprimirMouseEntered

    private void botonImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonImprimirMouseExited
        botonImprimir.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonImprimirMouseExited

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        imprimirReporte();
    }//GEN-LAST:event_botonImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        recargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    limpiarFiltros();
    }//GEN-LAST:event_jButton2ActionPerformed
public void limpiarFiltros(){
    this.textoCheckFechaFinal.setSelected(false);
    this.textoCheckFechaInicial.setSelected(false);
    this.textoFechaFinal.setDate(new Date());
    this.textoFechaInicial.setDate(new Date());
    this.textoNoAcuerdo.setText("");
    this.textoNoInventario.setText("");
    this.textoNoReferencia.setText("");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonImprimir;
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBajas;
    private javax.swing.JCheckBox textoCheckFechaFinal;
    private javax.swing.JCheckBox textoCheckFechaInicial;
    private com.toedter.calendar.JDateChooser textoFechaFinal;
    private javax.swing.JTextField textoFechaHoraReporte;
    private com.toedter.calendar.JDateChooser textoFechaInicial;
    private javax.swing.JTextField textoFiltros;
    private javax.swing.JTextField textoNoAcuerdo;
    private javax.swing.JTextField textoNoInventario;
    private javax.swing.JTextField textoNoReferencia;
    // End of variables declaration//GEN-END:variables
}
