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
        this.filtro.setText("");
        this.tablaUsuarios.setRowSorter(null);
        asignarDatosUsuarios();
    }

    public void asignarDatosUsuarios() {
        try {
            GeneradorModelos.modeloUsuarios(modelo);
            GeneradorModelos.asignarModeloTabla(modelo, tablaUsuarios);
            manejadorUsuarios.llenarUsuarios(modelo);
        } catch (Exception e) {
        }

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

    public void cambiarContrasena(boolean valor) {
        if (valor) {

            this.labelContrasena.setVisible(true);
            this.labelConfirmarContrasena.setVisible(true);
            this.textoContrasena.setVisible(true);
            this.textoConfirmacionContrasena.setVisible(true);
            this.boton2Cambiar.setVisible(true);
            this.botonVolver.setVisible(true);
        } else {
            this.labelContrasena.setVisible(false);
            this.labelConfirmarContrasena.setVisible(false);
            this.textoContrasena.setVisible(false);
            this.textoConfirmacionContrasena.setVisible(false);
            this.boton2Cambiar.setVisible(false);
            this.botonVolver.setVisible(false);
        }
    }

    public void validarCambioContrasena() {
        if (this.textoConfirmacionContrasena.getText().equals(this.textoContrasena.getText())) {
            if (!this.textoContrasena.getText().equals("")) {

                String usuario = this.textoUsuario.getText();

                String contrasena = Md5.getMD5(this.textoContrasena.getText());
                if (!usuario.equals("")) {

                    boolean resultado = manejadorUsuarios.cambiarContrasena(usuario, contrasena);
                    if (resultado) {
                        JOptionPane.showMessageDialog(null, "Se cambio con exito la contrasena del usuario: " + usuario);
                        reiniciarEditado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al intentar cambiar la contrasena en la base de datos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error no se selecciono un usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contrasenas no pueden estar en blanco");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Las contrasenas no coinciden, revisalas por favor");
        }
    }

    public void reiniciarEditado() {
        this.textoAreaTrabajo.setText("");
        this.textoConfirmacionContrasena.setText("");
        this.textoContrasena.setText("");
        this.textoDpi.setText("");
        this.textoEstado.setText("");
        this.textoNombre.setText("");
        this.textoTipoUsuario.setText("");
        this.textoUsuario.setText("");
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
                                        reiniciarEditado();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Existieron problemas al crear el usuario: " + usuario + ".\n"
                                                + "Los problemas pueden ser:\n"
                                                + "1.- Ya existe el usuario con ese nombre\n"
                                                + "3.- El nombre sobrepasa los 200 caracteres\n"
                                                + "3.- El dpi sobrepasa los 13 caracteres o se esta repitiendo\n"
                                                + "4.- El area de trabajo sobrepasa los 100 caracteres\n");

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
                reiniciarEditado();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AREA DE USUARIOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("USUARIOS DEL SISTEMA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 48, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User_opt.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 22, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User2_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1338, 22, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 169, 1438, 282));

        jLabel4.setText("Filtar por:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, -1, -1));

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filtroKeyTyped(evt);
            }
        });
        getContentPane().add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 128, 1165, -1));

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
        getContentPane().add(tiposFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 128, -1, -1));

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 477, -1, -1));

        jLabel6.setText("Nombre Completo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 522, -1, -1));

        jLabel7.setText("Dpi:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 575, -1, -1));

        jLabel8.setText("Area de Trabajo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, -1, -1));

        jLabel9.setText("Tipo de Usuario:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, -1, -1));

        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        textoUsuario.setEditable(false);
        getContentPane().add(textoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 469, 486, -1));
        getContentPane().add(textoDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 567, 486, -1));
        getContentPane().add(textoAreaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 469, 668, -1));

        textoTipoUsuario.setEditable(false);
        getContentPane().add(textoTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 522, 668, -1));

        textoEstado.setEditable(false);
        getContentPane().add(textoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 575, 668, -1));
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 522, 486, -1));

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 628, 170, -1));

        botonCambiarContrasena.setText("Cambiar Contraseña");
        botonCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(botonCambiarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 628, -1, -1));

        botonDeshabilitar.setText("Deshabilitar Usuario");
        botonDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeshabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(botonDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 630, 300, -1));

        botonHabilitar.setText("Habilitar Usuario");
        botonHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(botonHabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 630, 290, -1));

        jButton5.setText("Crear Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 662, 170, -1));
        getContentPane().add(textoConfirmacionContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 747, 470, -1));

        labelContrasena.setText("Contraseña");
        getContentPane().add(labelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 696, -1, -1));

        labelConfirmarContrasena.setText("Confirmar Contraseña");
        getContentPane().add(labelConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 747, -1, -1));
        getContentPane().add(textoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 696, 470, -1));

        botonConfirmarContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonConfirmarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 747, 36, 35));

        botonContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(botonContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 696, 36, 35));

        botonVolver.setText("Ocultar");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 800, 146, -1));

        boton2Cambiar.setText("Confirmar");
        boton2Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2CambiarActionPerformed(evt);
            }
        });
        getContentPane().add(boton2Cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 800, 161, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 834, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 850, -1, -1));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 620, -1, -1));

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
        cambiarContrasena(true);
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
        reiniciarTabla();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        cambiarContrasena(false);
    }//GEN-LAST:event_botonVolverActionPerformed


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
