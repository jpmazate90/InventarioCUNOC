/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Logica.ManejadorProveedores;
import Logica.ManejadorTiposBien;
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
public class TipoBien extends javax.swing.JFrame {

    /**
     * Creates new form TipoBien
     */
    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorTiposBien manejadorTipos;

    public TipoBien() {
        initComponents();
        modelo = new TablaModelo();
        manejadorTipos = new ManejadorTiposBien();
        asignarDatosTiposBien();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void asignarDatosTiposBien() {
        try {
            GeneradorModelos.modeloTiposBien(modelo);
            GeneradorModelos.asignarModeloTabla(modelo, tablaBienes);
            manejadorTipos.llenarTiposBien(modelo);
        } catch (Exception e) {
        }

    }

    public void recargarTabla() {
        modelo = new TablaModelo();
        this.textoFiltro.setText("");
        this.tablaBienes.setRowSorter(null);
        manejadorTipos = new ManejadorTiposBien();
        asignarDatosTiposBien();
    }

    public void borrarDatosCreacion() {
        this.crearCodigo.setText("");
        this.crearNombre.setText("");

    }

    public void borrarDatosEditado() {
        this.textoCodigo.setText("");
        this.textoNombre.setText("");

    }

    public void crearTipoBien() {
        String codigo = this.crearCodigo.getText();
        String nombre = this.crearNombre.getText();

        if (!codigo.equals("")) {
            if (codigo.length() <= 30) {
                if (!nombre.equals("")) {
                    if (nombre.length() <= 200) {
                        boolean resultado = manejadorTipos.crearTipoBien(codigo, nombre);
                        if (resultado) {
                            JOptionPane.showMessageDialog(null, "Se creo con exito el tipo de bien con codigo: " + codigo);
                            recargarTabla();
                            borrarDatosCreacion();
                        } else {
                            JOptionPane.showMessageDialog(null, "Problemas para crear el tipo de bien con codigo: " + codigo + "\n"
                                    + "Los errores pueden ser los siguientes:\n"
                                    + "1.- El codigo ya se encuentra registrado en el sistema, prueba con uno nuevo\n"
                                    + "");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "SE ACEPTA MAXIMO 200 CARACTERES PARA EL NOMBRE, CARACTERES ACTUALES: " + nombre.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO PUEDE ESTAR EN BLANCO EL NOMBRE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SE ACEPTA MAXIMO 30 CARACTERES, CARACTERES ACTUALES: " + codigo.length());
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO PUEDE ESTAR EN BLANCO EL CODIGO");
        }
    }

    public void editarTipoBien() {
        String codigo = this.textoCodigo.getText();
        String nombre = this.textoNombre.getText();

        if (!codigo.equals("")) {
            if (codigo.length() <= 30) {
                if (!nombre.equals("")) {
                    if (nombre.length() <= 200) {
                        boolean resultado = manejadorTipos.editarTipoBien(codigo, nombre);
                        if (resultado) {
                            JOptionPane.showMessageDialog(null, "Se edito con exito el tipo de bien con codigo: " + codigo);
                            recargarTabla();
                            borrarDatosEditado();
                        } else {
                            JOptionPane.showMessageDialog(null, "Problemas para editar el tipo de bien con codigo: " + codigo + "\n"
                                    + "Los errores pueden ser los siguientes:\n"
                                    + "1.- El codigo ya se encuentra registrado en el sistema, prueba con uno nuevo\n"
                                    + "2.- Error interno del sistema, comunicarse con el Administrador de la base de datos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "SE ACEPTA MAXIMO 200 CARACTERES PARA EL NOMBRE, CARACTERES ACTUALES: " + nombre.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO PUEDE ESTAR EN BLANCO EL NOMBRE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SE ACEPTA MAXIMO 30 CARACTERES, CARACTERES ACTUALES: " + codigo.length());
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN ELEMENTO PARA EDITAR");
        }
    }

    public void eliminarTipoBien() {
        String codigo = this.textoCodigo.getText();
        if (!codigo.equals("")) {
            boolean resultado = manejadorTipos.eliminarTipoBien(codigo);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito el tipo de bien con codigo: " + codigo);
                recargarTabla();
                borrarDatosEditado();
            } else {
                JOptionPane.showMessageDialog(null, "Problemas para eliminar el tipo de bien con codigo: " + codigo + "\n"
                        + "Los errores pueden ser los siguientes:\n"
                        + "1.- El codigo ya se encuentra referenciado en un bien, ya no se puede eliminar\n"
                );
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN ELEMENTO PARA ELIMINAR");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        textoFiltro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        crearCodigo = new javax.swing.JTextField();
        crearNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        filtros = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel1.setText("TIPOS DE BIENES");

        tablaBienes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaBienes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBienesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBienes);

        jLabel2.setText("Filtrar:");

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltroKeyTyped(evt);
            }
        });

        jLabel3.setText("Codigo:");

        jLabel4.setText("Nombre:");

        textoCodigo.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Crear Nuevo Tipo de Bien");

        jLabel6.setText("Codigo:");

        jLabel7.setText("Nombre:");

        crearNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearNombreActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar Elemento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoFiltro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel4))
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                                    .addComponent(textoNombre)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(crearNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                    .addComponent(crearCodigo)))
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(crearCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearNombreActionPerformed

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
        tablaBienes.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltroKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        crearTipoBien();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaBienesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBienesMouseClicked
        int seleccion = tablaBienes.getSelectedRow();// recoge la selecion
        this.textoCodigo.setText((String) tablaBienes.getValueAt(seleccion, 0));
        this.textoNombre.setText((String) tablaBienes.getValueAt(seleccion, 1));

    }//GEN-LAST:event_tablaBienesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editarTipoBien();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        eliminarTipoBien();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
 int valor = filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro.getText(), valor));
        tablaBienes.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crearCodigo;
    private javax.swing.JTextField crearNombre;
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoFiltro;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
