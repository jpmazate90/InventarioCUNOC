/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Logica.ManejadorUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class CrearUsuario extends javax.swing.JDialog {

    private boolean mostrarContra;
    private boolean mostrarContra2;
    private ManejadorUsuarios manejador;

    public CrearUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarContra = false;
        mostrarContra2 = false;
        manejador = new ManejadorUsuarios();
    }

    public void crearUsuario() {
        String usuario = this.usuario.getText();
        String contrasena = this.contrasena.getText();
        String confirmar = this.confirmar.getText();
        String nombre = this.nombre.getText();
        String dpi = this.dpi.getText();
        String area = this.area.getText();
        int tipo = this.tipo.getSelectedIndex() + 1;
        int estado = 1;
        if (!usuario.equals("")) {
            if (usuario.length() <= 30) {
                if (!contrasena.equals("")) {
                    if (!confirmar.equals("")) {
                        if (contrasena.equals(confirmar)) {
                            if (!nombre.equals("")) {
                                if (!dpi.equals("")) {
                                    if (dpi.length() == 13) {
                                        if (!area.equals("")) {
                                            if (area.length()<=100) {
                                                if (tipo >= 1 && tipo <= 2) {
                                                    boolean resultado = manejador.crearUsuario(usuario, contrasena, nombre, dpi, area, tipo, estado);
                                                    if (resultado) {
                                                        JOptionPane.showMessageDialog(null, "Se ha creado con exito el usuario: " + usuario);
                                                        this.setVisible(false);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Existieron problemas al crear el usuario: " + usuario + ".\n"
                                                                + "Los problemas pueden ser:\n"
                                                                + "1.- Ya existe el usuario con ese nombre\n"
                                                                + "3.- El nombre sobrepasa los 200 caracteres\n"
                                                                + "3.- El dpi sobrepasa los 13 caracteres o se esta repitiendo\n"
                                                                + "4.- El area de trabajo sobrepasa los 100 caracteres\n"
                                                                + "");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "El campo de Tipo de Usuario no es valido");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "El area de trabajo sobrepasa los 100 caracteres");

                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El campo de Area de Trabajo esta en blanco, es campo obligatorio");
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "El campo de Dpi no cumple con el formato");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El campo de Dpi esta en blanco, es campo obligatorio");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El campo de Nombre Completo esta en blanco, es campo obligatorio");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El campo de contrasena y de confirmar contrasena no coinciden");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo de confirmar contrasena esta en blanco, es campo obligatorio");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El campo de contrasena esta en blanco, es campo obligatorio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario sobrepasa los 30 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario esta en blanco, es campo obligatorio");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        confirmar = new javax.swing.JPasswordField();
        nombre = new javax.swing.JTextField();
        dpi = new javax.swing.JTextField();
        tipo = new javax.swing.JComboBox<>();
        area = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        botonContrasena = new javax.swing.JButton();
        botonConfirmar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREAR USUARIO");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("*Contrasena:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 229, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User5_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 31, -1, -1));

        jLabel4.setText("*ConfirmarContrasena:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel5.setText("*Nombre Completo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel6.setText("*Dpi:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel7.setText("*Area de Trabajo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 417, -1, -1));

        jLabel8.setText("*Tipo Usuario:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 466, -1, -1));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 188, 338, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 35)); // NOI18N
        jLabel1.setText("Crear Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 73, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User3_opt.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 30, -1, -1));

        jLabel2.setText("*Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 229, 338, -1));
        getContentPane().add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 280, 338, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 321, 338, -1));
        getContentPane().add(dpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 370, 338, -1));

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion", "Inventario" }));
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 458, 338, -1));
        getContentPane().add(area, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 417, 338, -1));

        jButton1.setText("Crear usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 499, 338, -1));

        botonContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(botonContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 30, 30));

        botonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 280, 30, 30));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasenaActionPerformed
        if (this.mostrarContra == false) {
            this.contrasena.setEchoChar((char) 0);
            this.mostrarContra = true;
        } else {
            this.contrasena.setEchoChar('*');
            this.mostrarContra = false;
        }
    }//GEN-LAST:event_botonContrasenaActionPerformed

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        if (this.mostrarContra2 == false) {
            this.confirmar.setEchoChar((char) 0);
            this.mostrarContra2 = true;
        } else {
            this.confirmar.setEchoChar('*');
            this.mostrarContra2 = false;
        }
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField area;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonContrasena;
    private javax.swing.JPasswordField confirmar;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JTextField dpi;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> tipo;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
