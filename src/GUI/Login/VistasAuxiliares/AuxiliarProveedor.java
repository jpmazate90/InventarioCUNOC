/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.VistasAuxiliares;

import Logica.ManejadorProveedores;
import Objetos.PasarString;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class AuxiliarProveedor extends javax.swing.JDialog {

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorProveedores manejadorProveedores;
    private PasarString resultado;

    public AuxiliarProveedor(java.awt.Frame parent, boolean modal, PasarString resultado) {
        super(parent, modal);
        initComponents();
        modelo = new TablaModelo();
        this.resultado = resultado;
        manejadorProveedores = new ManejadorProveedores();
        asignarDatosProveedores();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void asignarDatosProveedores() {
        try {
            GeneradorModelos.modeloAuxiliarProveedores(modelo);
            GeneradorModelos.asignarModeloTabla(modelo, tablaProveedores);
            manejadorProveedores.llenarProveedores(modelo);
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        filtros = new javax.swing.JComboBox<>();
        textoFiltro = new javax.swing.JTextField();
        textoNit = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SELECCIONAR PROVEEDOR");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("SELECCIONA AL PROVEEDOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jLabel2.setText("Filtra por:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, -1, -1));

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 141, 906, 269));

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nit", "Nombre", "Direccion", "Area de trabajo", "Telefono" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        getContentPane().add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 94, -1, -1));

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltroKeyTyped(evt);
            }
        });
        getContentPane().add(textoFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 94, 627, -1));

        textoNit.setEditable(false);
        getContentPane().add(textoNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 436, 284, -1));

        textoNombre.setEditable(false);
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 483, 284, -1));

        jLabel3.setText("NIT:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 444, -1, -1));

        jLabel4.setText("NOMBRE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 491, -1, -1));

        jButton1.setText("ESCOGER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 439, 101, 79));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor2_opt(1).jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 200, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyTyped
        int valor = filtros.getSelectedIndex();
// sortea la tabla
        textoFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro.getText(), valor));
            }
        });

        tablaSorteada = new TableRowSorter(modelo);
        tablaProveedores.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltroKeyTyped

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
        int valor = filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro.getText(), valor));
        tablaProveedores.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        int seleccion = tablaProveedores.getSelectedRow();// recoge la selecion
        this.textoNit.setText(Integer.toString((Integer) tablaProveedores.getValueAt(seleccion, 0)));
        this.textoNombre.setText((String) tablaProveedores.getValueAt(seleccion, 1));

    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        devolverValor();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void devolverValor() {
        String nit = this.textoNit.getText();
        if (!nit.equals("")) {
            this.resultado.setValor(nit);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN PROVEEDOR");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField textoFiltro;
    private javax.swing.JTextField textoNit;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
