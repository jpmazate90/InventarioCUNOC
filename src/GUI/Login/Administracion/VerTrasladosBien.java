/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Exportacion.ExportarPDF;
import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import Logica.ManejadorPersonal;
import Logica.ManejadorTrasladoBien;
import Objetos.PasarString;
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
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class VerTrasladosBien extends javax.swing.JDialog {

    private Frame frame;
    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private SimpleDateFormat formateador;
    private SimpleDateFormat fechaTimestamp;
    private ManejadorTrasladoBien manejadorTraslados;
    private String noInventario;
    private String usuarioActual;

    public VerTrasladosBien(java.awt.Frame parent, boolean modal, Frame frame, String noInventario, String usuarioActual) {
        super(parent, modal);
        initComponents();
        this.frame = frame;
        modelo = new TablaModelo();
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        fechaTimestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        manejadorTraslados = new ManejadorTrasladoBien();
        this.noInventario = noInventario;
        this.usuarioActual=usuarioActual;
        llenarTabla(false);
    }

    public void llenarTabla(boolean filtro) {
        GeneradorModelos.modeloTraslados(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaTraslados);
        if (filtro) {
            String fechaInicial = "";
            String fechaFinal = "";
            String encargadoActual = this.filtroEncargadoNuevo.getText();
            String encargadoAnterior = this.filtroEncargadoAnterior.getText();
            if (this.filtroCheckFechaInicial.isSelected()) {
                fechaInicial = formateador.format(this.filtroFechaInicial.getDate());
            }
            if (this.filtroCheckFechaFinal.isSelected()) {
                fechaFinal = formateador.format(this.filtroFechaFinal.getDate());
            }
            manejadorTraslados.llenarTrasladosConFiltros(modelo, this.noInventario, fechaInicial, fechaFinal, encargadoActual, encargadoAnterior);
        } else {
            manejadorTraslados.llenarTraslados(modelo, this.noInventario);
        }
        this.textoFechaReporte.setText(fechaTimestamp.format(new Date()));
    }

    public void recargarTabla(boolean filtro) {
        modelo = new TablaModelo();
        this.textoFiltros.setText("");
        this.tablaTraslados.setRowSorter(null);
        manejadorTraslados = new ManejadorTrasladoBien();
        llenarTabla(filtro);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filtros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTraslados = new javax.swing.JTable();
        textoFiltros = new javax.swing.JTextField();
        filtroFechaInicial = new com.toedter.calendar.JDateChooser();
        filtroFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filtroCheckFechaFinal = new javax.swing.JCheckBox();
        filtroCheckFechaInicial = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        filtroEncargadoNuevo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        filtroEncargadoAnterior = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        textoFechaReporte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        botonImprimir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTE TRASLADOS DE BIEN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("TRASLADOS DEL BIEN: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel2.setText("FILTRAR POR:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "NoInventario", "ResponsableNuevo", "ResponsableAnterior", "FechaTraslado", "MotivoTraslado", "Division" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        getContentPane().add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 240, -1));

        tablaTraslados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaTraslados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 1160, 380));

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });
        getContentPane().add(textoFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 770, -1));
        getContentPane().add(filtroFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(filtroFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel5.setText("FECHA INICIAL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel6.setText("FECHA FINAL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));
        getContentPane().add(filtroCheckFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 30, 30));
        getContentPane().add(filtroCheckFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 223, 30, 30));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jLabel7.setText("FILTROS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jButton1.setText("APLICAR FILTROS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 220, -1));

        filtroEncargadoNuevo.setEditable(false);
        getContentPane().add(filtroEncargadoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 160, -1));

        jButton2.setText("?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 50, 20));

        jLabel8.setText("Responsable Nuevo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel9.setText("Responsable Anterior");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        filtroEncargadoAnterior.setEditable(false);
        getContentPane().add(filtroEncargadoAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 160, -1));

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 50, 20));
        getContentPane().add(textoFechaReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 570, 260, -1));

        jLabel10.setText("Fecha y Hora del Reporte:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, -1, -1));

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
        getContentPane().add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 570, 240, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 730, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 320, -1, -1));

        jButton4.setText("LIMPIAR FILTROS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonImprimirMouseEntered
        botonImprimir.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonImprimirMouseEntered

    private void botonImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonImprimirMouseExited
        botonImprimir.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonImprimirMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarEncargado aux = new AuxiliarEncargado(this.frame, true, resultado);
        aux.setVisible(true);
        this.filtroEncargadoNuevo.setText(resultado.getValor());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarEncargado aux = new AuxiliarEncargado(this.frame, true, resultado);
        aux.setVisible(true);
        this.filtroEncargadoAnterior.setText(resultado.getValor());
    }//GEN-LAST:event_jButton3ActionPerformed

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
        tablaTraslados.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltrosKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        recargarTabla(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
        int valor = this.filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
        tablaTraslados.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        generarReporte();

    }//GEN-LAST:event_botonImprimirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      limpiarCampos();
    }//GEN-LAST:event_jButton4ActionPerformed
    public void limpiarCampos(){
        this.filtroCheckFechaFinal.setSelected(false);
        this.filtroCheckFechaInicial.setSelected(false);
        this.filtroEncargadoAnterior.setText("");
        this.filtroEncargadoNuevo.setText("");
        this.filtroFechaFinal.setDate(new Date());
        this.filtroFechaInicial.setDate(new Date());
    }
    
    public void generarReporte() {

        if (existenElementosParaImprimir()) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            File archivo = ExportarPDF.usarFileChooser(".pdf");
            if (archivo.getName().equals("null.pdf") == false) {// exporta a html segun el reporte
                int totalRegistros = totalRegistros();
                ArrayList<String> filtrosPrimarios = filtrosPrimarios();
                ArrayList<String> filtrosSecundarios = filtrosSecundarios();
                ExportarPDF.exportarReporteTraslado(tablaTraslados, noInventario, totalRegistros, usuarioActual, this.textoFechaReporte.getText(), filtrosPrimarios, filtrosSecundarios, archivo);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUNA RUTA PARA GUARDAR EL ARCHIVO, NO SE REALIZARA NINGUNA ACCION");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTEN ELEMENTOS EN LA TABLA PARA REALIZAR UN ARCHIVO DEL REPORTE");
        }
    }
    
    public ArrayList<String> filtrosPrimarios() {
        ArrayList<String> mandar = new ArrayList<>();
        if (this.filtroCheckFechaInicial.isSelected()) {
            mandar.add("Fecha Inicial: "+formateador.format(this.filtroFechaInicial.getDate()));
        }
        if (this.filtroCheckFechaFinal.isSelected()) {
            mandar.add("Fecha Final: "+formateador.format(this.filtroFechaFinal.getDate()));
        }
        if (!this.filtroEncargadoNuevo.getText().equals("")) {
            mandar.add("Responsable Nuevo: "+this.filtroEncargadoNuevo.getText());
        }
        if (!this.filtroEncargadoAnterior.getText().equals("")) {
            mandar.add("Responsable Anterior: "+this.filtroEncargadoAnterior.getText());
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
        return this.tablaTraslados.getRowCount();
    }

    public boolean existenElementosParaImprimir() {
        return this.tablaTraslados.getRowCount() != 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonImprimir;
    private javax.swing.JCheckBox filtroCheckFechaFinal;
    private javax.swing.JCheckBox filtroCheckFechaInicial;
    private javax.swing.JTextField filtroEncargadoAnterior;
    private javax.swing.JTextField filtroEncargadoNuevo;
    private com.toedter.calendar.JDateChooser filtroFechaFinal;
    private com.toedter.calendar.JDateChooser filtroFechaInicial;
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTraslados;
    private javax.swing.JTextField textoFechaReporte;
    private javax.swing.JTextField textoFiltros;
    // End of variables declaration//GEN-END:variables
}
