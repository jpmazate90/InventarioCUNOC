/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Hash.Md5;
import Logica.ManejadorUsuarios;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class Usuarios extends javax.swing.JFrame {

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorUsuarios manejadorUsuarios;

    public Usuarios() {
        initComponents();
        modelo = new TablaModelo();
        manejadorUsuarios = new ManejadorUsuarios();
        asignarDatosUsuarios();
        ocultarDatos();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void reiniciarTabla() {
        modelo = new TablaModelo();
        asignarDatosUsuarios();
    }

    public void asignarDatosUsuarios() {
        GeneradorModelos.modeloUsuarios(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaUsuarios);
        manejadorUsuarios.llenarUsuarios(modelo);
    }

    public void ocultarDatos() {
        this.labelContrasena.setVisible(false);
        this.labelConfirmarContrasena.setVisible(false);
        this.textoContrasena.setVisible(false);
        this.textoConfirmacionContrasena.setVisible(false);
        this.botonContrasena.setVisible(false);
        this.botonConfirmarContrasena.setVisible(false);
        this.botonVolver.setVisible(false);
        this.boton2Cambiar.setVisible(false);
    }

    public void cambiarContrasena() {
        this.labelContrasena.setVisible(true);
        this.labelConfirmarContrasena.setVisible(true);
        this.textoContrasena.setVisible(true);
        this.textoConfirmacionContrasena.setVisible(true);
        this.boton2Cambiar.setVisible(true);
        this.botonVolver.setVisible(false);
    }

    public void validarCambioContrasena() {
        if (this.textoConfirmacionContrasena.getText().equals(this.textoContrasena.getText())) {
            if (!this.textoContrasena.getText().equals("")) {

                String usuario = this.textoUsuario.getText();

                String contrasena = Md5.getMD5(this.textoContrasena.getText());
                boolean resultado = manejadorUsuarios.cambiarContrasena(usuario, contrasena);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Se cambio con exito la contrasena del usuario: " + usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al intentar cambiar la contrasena en la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contrasenas no pueden estar en blanco");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Las contrasenas no coinciden, revisalas por favor");
        }
    }

    public void editarUsuario() {
        if (!this.textoUsuario.getText().equals("")) {
            String usuario = this.textoUsuario.getText();
            String nombre = this.textoNombre.getText();
            String dpi = this.textoDpi.getText();
            String area = this.textoAreaTrabajo.getText();
            if (!nombre.equals("")) {
                if (nombre.length() <= 200) {
                    if (!dpi.equals("")) {
                        if (dpi.length() == 13) {
                            if (!area.equals("")) {
                                if (area.length() <= 100) {
                                    boolean resultado = manejadorUsuarios.editarUsuario(usuario, nombre, dpi, area);
                                    if (resultado) {
                                        reiniciarTabla();
                                        JOptionPane.showMessageDialog(null, "Se cambio con exito la informacion del usuario: " + usuario);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error al intentar cambiar la informacion en la base de datos");
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Campo de area de trabajo tiene mas de 100 caracteres");

                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El campo de area de trabajo no puede estar en blanco");

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El dpi no cumple el formato de 13 caracteres");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El dpi no puede estar en blanco");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre no puede tener mas de 200 caracteres, cantidad actual: " + nombre.length());

                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco");

            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun usuario");
        }
    }

    public void cambiarEstadoUsuario(int estado) {
        String usuario = this.textoUsuario.getText();
        if (!usuario.equals("")) {
            boolean resultado = manejadorUsuarios.cambiarEstadoUsuario(usuario, estado);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Se realizo el cambio de estado al usuario: " + usuario);
                reiniciarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio de estado al usuario: " + usuario);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun usuario");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        tiposFiltros = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        textoDpi = new javax.swing.JTextField();
        textoAreaTrabajo = new javax.swing.JTextField();
        textoTipoUsuario = new javax.swing.JTextField();
        textoEstado = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        botonCambiarContrasena = new javax.swing.JButton();
        botonDeshabilitar = new javax.swing.JButton();
        botonHabilitar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        textoConfirmacionContrasena = new javax.swing.JPasswordField();
        labelContrasena = new javax.swing.JLabel();
        labelConfirmarContrasena = new javax.swing.JLabel();
        textoContrasena = new javax.swing.JPasswordField();
        botonConfirmarContrasena = new javax.swing.JButton();
        botonContrasena = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        boton2Cambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("USUARIOS DEL SISTEMA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User_opt.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User2_opt.jpg"))); // NOI18N

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel4.setText("Filtar por:");

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtroKeyTyped(evt);
            }
        });

        tiposFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "NombreCompleto", "Dpi", "Area de Trabajo", "Tipo de Usuario", "Estado" }));
        tiposFiltros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tiposFiltrosItemStateChanged(evt);
            }
        });
        tiposFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tiposFiltrosMouseExited(evt);
            }
        });

        jLabel5.setText("Usuario:");

        jLabel6.setText("Nombre Completo:");

        jLabel7.setText("Dpi:");

        jLabel8.setText("Area de Trabajo");

        jLabel9.setText("Tipo de Usuario:");

        jLabel10.setText("Estado:");

        textoUsuario.setEnabled(false);

        textoTipoUsuario.setEnabled(false);

        textoEstado.setEnabled(false);

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonCambiarContrasena.setText("Cambiar Contraseña");
        botonCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarContrasenaActionPerformed(evt);
            }
        });

        botonDeshabilitar.setText("Deshabilitar Usuario");
        botonDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeshabilitarActionPerformed(evt);
            }
        });

        botonHabilitar.setText("Habilitar Usuario");
        botonHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHabilitarActionPerformed(evt);
            }
        });

        jButton5.setText("Crear Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        labelContrasena.setText("Contraseña");

        labelConfirmarContrasena.setText("Confirmar Contraseña");

        botonConfirmarContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonConfirmarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarContrasenaActionPerformed(evt);
            }
        });

        botonContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasenaActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");

        boton2Cambiar.setText("Confirmar");
        boton2Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2CambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addGap(459, 459, 459)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiposFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filtro))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(96, 96, 96)
                                .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(123, 123, 123))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(labelContrasena)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoDpi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonCambiarContrasena))
                                            .addComponent(textoContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonDeshabilitar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                                .addComponent(botonHabilitar))
                            .addComponent(textoAreaTrabajo)
                            .addComponent(textoTipoUsuario)
                            .addComponent(textoEstado)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelConfirmarContrasena)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(157, 157, 157)
                                    .addComponent(boton2Cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(textoConfirmacionContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(botonConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiposFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoAreaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textoTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoDpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(botonCambiarContrasena))
                    .addComponent(botonDeshabilitar)
                    .addComponent(botonHabilitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelContrasena)
                    .addComponent(textoContrasena))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelConfirmarContrasena)
                    .addComponent(textoConfirmacionContrasena))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(boton2Cambiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyTyped
        int valor = tiposFiltros.getSelectedIndex();
// sortea la tabla
        filtro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + filtro.getText(), valor));
            }
        });

        tablaSorteada = new TableRowSorter(modelo);
        tablaUsuarios.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtroKeyTyped

    private void tiposFiltrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tiposFiltrosItemStateChanged
        int valor = tiposFiltros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + filtro.getText(), valor));
        tablaUsuarios.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_tiposFiltrosItemStateChanged

    private void tiposFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tiposFiltrosMouseExited

    }//GEN-LAST:event_tiposFiltrosMouseExited

    private void botonConfirmarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonConfirmarContrasenaActionPerformed

    private void botonContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonContrasenaActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked

        int seleccion = tablaUsuarios.getSelectedRow();// recoge la selecion
        this.textoUsuario.setText((String) tablaUsuarios.getValueAt(seleccion, 0));
        this.textoNombre.setText((String) tablaUsuarios.getValueAt(seleccion, 1));
        this.textoDpi.setText((String) tablaUsuarios.getValueAt(seleccion, 2));
        this.textoAreaTrabajo.setText((String) tablaUsuarios.getValueAt(seleccion, 3));
        this.textoTipoUsuario.setText(tablaUsuarios.getValueAt(seleccion, 4).toString());
        this.textoEstado.setText(tablaUsuarios.getValueAt(seleccion, 5).toString());


    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void botonCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarContrasenaActionPerformed
        cambiarContrasena();
    }//GEN-LAST:event_botonCambiarContrasenaActionPerformed

    private void boton2CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2CambiarActionPerformed
        validarCambioContrasena();
    }//GEN-LAST:event_boton2CambiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editarUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeshabilitarActionPerformed
        cambiarEstadoUsuario(0);
    }//GEN-LAST:event_botonDeshabilitarActionPerformed

    private void botonHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHabilitarActionPerformed
        cambiarEstadoUsuario(1);
    }//GEN-LAST:event_botonHabilitarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CrearUsuario ventana = new CrearUsuario(this, true);
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton2Cambiar;
    private javax.swing.JButton botonCambiarContrasena;
    private javax.swing.JButton botonConfirmarContrasena;
    private javax.swing.JButton botonContrasena;
    private javax.swing.JButton botonDeshabilitar;
    private javax.swing.JButton botonHabilitar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConfirmarContrasena;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField textoAreaTrabajo;
    private javax.swing.JPasswordField textoConfirmacionContrasena;
    private javax.swing.JPasswordField textoContrasena;
    private javax.swing.JTextField textoDpi;
    private javax.swing.JTextField textoEstado;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoTipoUsuario;
    private javax.swing.JTextField textoUsuario;
    private javax.swing.JComboBox<String> tiposFiltros;
    // End of variables declaration//GEN-END:variables
}
