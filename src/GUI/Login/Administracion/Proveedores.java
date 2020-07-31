/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Logica.ManejadorProveedores;
import Logica.ManejadorUsuarios;
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
public class Proveedores extends javax.swing.JFrame {

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorProveedores manejadorProveedores;

    public Proveedores() {
        initComponents();
        modelo = new TablaModelo();
        manejadorProveedores = new ManejadorProveedores();
        asignarDatosProveedores();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void asignarDatosProveedores() {
        GeneradorModelos.modeloProveedores(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaProveedores);
        manejadorProveedores.llenarProveedores(modelo);
    }

    public void recargarTabla() {
        modelo = new TablaModelo();
        manejadorProveedores = new ManejadorProveedores();
        asignarDatosProveedores();
    }

    public void crearProveedor() {
        String nit = this.crearNit.getText();
        String nombre = this.crearNombre.getText();
        String direccion = this.crearDireccion.getText();
        String area = this.crearArea.getText();
        String telefono = this.crearTelefono.getText();
        if (!nit.equals("")) {
            if (nit.length() == 8) {
                try {
                    Integer.parseInt(nit);
                    if (!nombre.equals("")) {
                        if (nombre.length() <= 100) {
                            if (!direccion.equals("")) {
                                if (direccion.length() <= 120) {
                                    if (!area.equals("")) {
                                        if (area.length() <= 100) {
                                            if (!telefono.equals("")) {
                                                if (telefono.length() <= 8) {
                                                    try {
                                                        Integer.parseInt(telefono);
                                                        boolean resultado = manejadorProveedores.crearProveedor(nit, nombre, direccion, area, telefono);
                                                        if (resultado) {
                                                            JOptionPane.showMessageDialog(null, "Se creo con exito el proveedor con nit: " + nit);
                                                            recargarTabla();
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Problemas para crear al proveeodr con nit: " + nit);
                                                        }
                                                    } catch (Exception e) {
                                                        JOptionPane.showMessageDialog(null, "Error, en el campo de telefono solo se aceptan numeros");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error, la longitud del telefono tiene que ser de 8 digitos o menos");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error, campo de telefono vacio");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error, el campo de area de trabajo solo acepta 100 caracteres");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error, campo de area de trabajo vacio");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, campo de direccion solo acepta 120 caracteres");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, campo de direccion vacio");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error, el campo de nombre solo acepta 100 caracteres");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, el campo de nombre esta vacio");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error, el nit acepta unicamente numeros");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, el campo de nit acepta exactamente 8 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, el campo de nit esta vacio");
        }
    }

    public void editarProveedor() {
        String nit = this.textoNit.getText();
        String nombre = this.textoNombre.getText();
        String direccion = this.textoDIreccion.getText();
        String area = this.textoArea.getText();
        String telefono = this.textoTelefono.getText();
        if (!nit.equals("")) {
            if (!nombre.equals("")) {
                if (nombre.length() <= 100) {
                    if (!direccion.equals("")) {
                        if (direccion.length() <= 120) {
                            if (!area.equals("")) {
                                if (area.length() <= 100) {
                                    if (!telefono.equals("")) {
                                        if (telefono.length() <= 8) {
                                            try {
                                                Integer.parseInt(telefono);
                                                boolean resultado = manejadorProveedores.editarProveedor(nit, nombre, direccion, area, telefono);
                                                if (resultado) {
                                                    JOptionPane.showMessageDialog(null, "Se edito con exito el proveedor con nit: " + nit);
                                                    recargarTabla();
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Problemas para editar al proveeodr con nit: " + nit);
                                                }
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, "Error, en el campo de telefono solo se aceptan numeros");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error, la longitud del telefono tiene que ser de 8 digitos o menos");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error, campo de telefono vacio");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, el campo de area de trabajo solo acepta 100 caracteres");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, campo de area de trabajo vacio");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error, campo de direccion solo acepta 120 caracteres");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, campo de direccion vacio");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error, el campo de nombre solo acepta 100 caracteres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, el campo de nombre esta vacio");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error, no se selecciono ningun nit");
        }
    }
    
    public void eliminarProveedor(){
        String nit = this.textoNit.getText();
        if(!nit.equals("")){
            boolean resultado = manejadorProveedores.eliminarProveedor(nit);
            if(resultado){
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el proveedor");
                limpiarDatos();
                recargarTabla();
            }else{
            JOptionPane.showMessageDialog(null, "No se puede eliminar el proveedor, puede que ya este referenciado en algun bien");    
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error, no se selecciono ningun nit para eliminarlo");
        }
    }
    public void limpiarDatos(){
        this.textoArea.setText("");
        this.textoDIreccion.setText("");
        this.textoTelefono.setText("");
        this.textoNit.setText("");
        this.textoNombre.setText("");
        
        this.crearArea.setText("");
        this.crearDireccion.setText("");
        this.crearNit.setText("");
        this.crearNombre.setText("");
        this.crearTelefono.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        tiposFiltro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoNit = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoDIreccion = new javax.swing.JTextField();
        textoArea = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        crearNit = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        crearNombre = new javax.swing.JTextField();
        crearDireccion = new javax.swing.JTextField();
        crearArea = new javax.swing.JTextField();
        crearTelefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor2_opt.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor2_opt(1).jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel3.setText("PROVEEDORES");

        jLabel4.setText("Filtrar por:");

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltroKeyTyped(evt);
            }
        });

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

        tiposFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nit", "Nombre" }));
        tiposFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tiposFiltroItemStateChanged(evt);
            }
        });

        jLabel5.setText("NIT:");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Area de Trabajo:");

        jLabel8.setText("Direccion:");

        jLabel9.setText("Telefono:");

        textoNit.setEnabled(false);

        jLabel10.setText("CREAR PROVEEDOR");

        jLabel11.setText("NIT:");

        jLabel12.setText("Nombre:");

        jLabel13.setText("Direccion:");

        jLabel14.setText("Area Trabajo:");

        jLabel15.setText("Telefono:");

        jButton1.setText("Crear Proveedor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar Cambios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(376, 376, 376)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tiposFiltro, 0, 258, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                            .addComponent(textoNit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDIreccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoArea, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(421, 421, 421)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(crearNit)
                                    .addComponent(crearNombre)
                                    .addComponent(crearDireccion)
                                    .addComponent(crearArea)
                                    .addComponent(crearTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(316, 316, 316))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiposFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(crearNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crearNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crearDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crearArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crearTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(textoDIreccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(textoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyTyped
        int valor = tiposFiltro.getSelectedIndex();
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

    private void tiposFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tiposFiltroItemStateChanged
        int valor = tiposFiltro.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro.getText(), valor));
        tablaProveedores.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_tiposFiltroItemStateChanged

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked

        int seleccion = tablaProveedores.getSelectedRow();// recoge la selecion
        this.textoNit.setText(Integer.toString((Integer) tablaProveedores.getValueAt(seleccion, 0)));
        this.textoNombre.setText((String) tablaProveedores.getValueAt(seleccion, 1));
        this.textoDIreccion.setText((String) tablaProveedores.getValueAt(seleccion, 2));
        this.textoArea.setText((String) tablaProveedores.getValueAt(seleccion, 3));
        this.textoTelefono.setText(Integer.toString((Integer) tablaProveedores.getValueAt(seleccion, 4)));

    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearProveedor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarProveedor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarProveedor();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crearArea;
    private javax.swing.JTextField crearDireccion;
    private javax.swing.JTextField crearNit;
    private javax.swing.JTextField crearNombre;
    private javax.swing.JTextField crearTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField textoArea;
    private javax.swing.JTextField textoDIreccion;
    private javax.swing.JTextField textoFiltro;
    private javax.swing.JTextField textoNit;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTelefono;
    private javax.swing.JComboBox<String> tiposFiltro;
    // End of variables declaration//GEN-END:variables
}
