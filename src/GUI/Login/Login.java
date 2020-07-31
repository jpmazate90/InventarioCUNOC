/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login;

import GUI.Login.Administracion.MenuAdministracion;
import GUI.Login.Inventario.MenuInventario;
import Hash.Md5;
import Logica.InicioSesion;
import Objetos.Inicio;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 *
 * @author jpmazate
 */
public class Login extends javax.swing.JFrame {

    private InicioSesion inicioSesion = new InicioSesion();
    private boolean mostrarContra;

    public Login() {
        initComponents();
        mostrarContra = false;
        this.getRootPane().setDefaultButton(ingresar);

    }

    public void ingresar() {
        Inicio mandar = new Inicio(this.textoUsuario.getText(), Md5.getMD5(this.textoContrasena.getText()));
        boolean resultado = inicioSesion.validarDatos(mandar);
        if (resultado) {
            if (mandar.getEstado() == 1) {

                switch (mandar.getTipoUsuario()) {
                    case 1:
                        mandarAdministracion(mandar.getUsuario());
                        break;
                    case 2:
                        mandarInventario(mandar.getUsuario());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Tipo de Usuario no valido");
                        break;
                }
            }else{
            JOptionPane.showMessageDialog(null, "El usuario: "+mandar.getUsuario()+" esta deshabilitado, no puede ingresar al sistema");    
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos Incorrectos, vuelve a intentar");
            this.textoContrasena.setText("");

        }
    }

    public void mandarAdministracion(String usuario) {
        MenuAdministracion menu = new MenuAdministracion(usuario);
        menu.setVisible(true);
        this.setVisible(false);
    }

    public void mandarInventario(String usuario) {
        MenuInventario menu = new MenuInventario(usuario);
        menu.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoContrasena = new javax.swing.JPasswordField();
        textoUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mostrarContrasena = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        textoContrasena.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        textoUsuario.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 3, 25)); // NOI18N
        jLabel3.setText("INICIO DE SESION");

        jLabel4.setBackground(new java.awt.Color(245, 247, 245));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 75, 175));
        jLabel4.setText("¿Olvidaste tu contraseña?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        mostrarContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MostrarContrasena.png"))); // NOI18N
        mostrarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarContrasenaActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario_opt.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario_opt.jpg"))); // NOI18N

        ingresar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });
        ingresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ingresarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ingresar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoUsuario)
                                    .addComponent(textoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar)
                    .addComponent(jLabel4))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoUsuarioActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JOptionPane.showMessageDialog(null, "Por favor comunicate con un administrador del sistema para poder cambiar tu contrasena,\n"
                + "O ponte en contacto al correo: juanpablo-orizabalgil@cunoc.edu.gt con el asunto \"Contrasena Inventario \"");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void mostrarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarContrasenaActionPerformed
        if (this.mostrarContra == false) {
            this.textoContrasena.setEchoChar((char) 0);
            this.mostrarContra = true;
        } else {
            this.textoContrasena.setEchoChar('*');
            this.mostrarContra = false;
        }


    }//GEN-LAST:event_mostrarContrasenaActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        ingresar();
    }//GEN-LAST:event_ingresarActionPerformed

    private void ingresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ingresarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mostrarContrasena;
    private javax.swing.JPasswordField textoContrasena;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
