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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel3.setText("*Contrasena:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User5_opt.jpg"))); // NOI18N

        jLabel4.setText("*ConfirmarContrasena:");

        jLabel5.setText("*Nombre Completo:");

        jLabel6.setText("*Dpi:");

        jLabel7.setText("*Area de Trabajo:");

        jLabel8.setText("*Tipo Usuario:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 35)); // NOI18N
        jLabel1.setText("Crear Usuario");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User3_opt.png"))); // NOI18N

        jLabel2.setText("*Usuario:");

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administracion", "Inventario" }));

        jButton1.setText("Crear usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasenaActionPerformed(evt);
            }
        });

        botonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(area, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dpi)))
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(110, 110, 110))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(botonContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contrasena)
                            .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(187, 187, 187)
                        .addComponent(usuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1)
                        .addGap(0, 171, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

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
    private javax.swing.JLabel jLabel11;
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
