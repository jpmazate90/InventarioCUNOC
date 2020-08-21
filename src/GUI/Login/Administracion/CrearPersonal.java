/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Logica.ManejadorPersonal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class CrearPersonal extends javax.swing.JDialog {

    /**
     * Creates new form CrearProveedor
     */
    private ManejadorPersonal manejadorPersonal;
    private SimpleDateFormat formateador;
    public CrearPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        manejadorPersonal = new ManejadorPersonal();
        this.fecha.setDate(new Date());
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        this.fecha.enableInputMethods(true);
         this.getRootPane().setDefaultButton(jButton1);

    }

    public void crearPersonal() {
        String numero = this.textoNo.getText();
        String nombre = this.textoNombre.getText();
        String fecha = formateador.format(this.fecha.getDate());
        String correo = this.textoCorreo.getText();
        String dpi = this.textoDpi.getText();
        String puesto = this.textoPuesto.getText();
        String area = this.textoArea.getText();
        String estado = "1";
        System.out.println(fecha);
        if (!numero.equals("")) {
            if (numero.length() <= 50) {
                if (!nombre.equals("")) {
                    if (nombre.length() <= 200) {
                        if (!fecha.equals("")) {
                            if (!correo.equals("")) {
                                if (correo.length() <= 200) {
                                    if (correo.contains("@")) {
                                        if (correo.contains(".")) {
                                            if (!dpi.equals("")) {
                                                if (dpi.length() == 13) {
                                                    if (!puesto.equals("")) {
                                                        if (puesto.length() <= 50) {
                                                            if (!area.equals("")) {
                                                                if (area.length() <= 200) {
                                                                    
                                                                    boolean resultado =manejadorPersonal.crearPersonal(numero, nombre, fecha, correo, dpi, puesto, estado, area);

                                                                    if (resultado) {
                                                                        JOptionPane.showMessageDialog(null, "Se creo con exito el personal: " + nombre);
                                                                        this.setVisible(false);
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Problemas para crear al personal con nombre: " + nombre+ "\n"
                                                                                + "Los errores pueden ser los siguientes:\n"
                                                                                + "1.- El No de Personal ya se repite en otro personal\n"
                                                                                + "2.- El dpi se repite en otro personal\n"
                                                                                + "");
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Error, el area no puede sobrepasar los 200 caracteres");
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Error, area no puede estar vacio");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Error, el puesto no puede sobrepasar los 50 caracteres");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error, el puesto no puede estar vacio");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error, el dpi debe de tener 13 caracteres estrictamente");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error, el dpi no puede estar vacio");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Error, el correo no cumple el formato, falta un punto (.)");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error, el correo no cumple el formato, falta una @");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, el correo sobrepasa los 200 caracteres");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, el correo no puede estar vacio");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error, la fecha no puede estar vacia");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, el nombre sobrepasa los 200 caracteres");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error, el nombre no puede estar vacio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, el numero de personal sobrepasa los 50 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, el numero de personal no puede estar vacio");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        textoNo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoDpi = new javax.swing.JTextField();
        textoPuesto = new javax.swing.JTextField();
        textoArea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CREAR PERSONAL");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("CREAR PERSONAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 95, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal2_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User3_opt.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 53, -1, -1));

        jLabel4.setText("No Personal:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 190, -1, -1));

        jLabel5.setText("Nombre Completo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 243, -1, -1));

        jLabel6.setText("Fecha Nacimiento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 288, -1, -1));

        jLabel7.setText("Correo Electronico:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 330, -1, -1));

        jLabel8.setText("DPI:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 371, -1, -1));

        jLabel9.setText("Puesto:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 412, -1, -1));

        jLabel10.setText("Area de Trabajo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 461, -1, -1));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 288, 530, -1));
        getContentPane().add(textoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 182, 530, -1));
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 235, 530, -1));
        getContentPane().add(textoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 330, 530, -1));
        getContentPane().add(textoDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 371, 530, -1));
        getContentPane().add(textoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 412, 530, -1));
        getContentPane().add(textoArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 453, 530, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_opt.png"))); // NOI18N
        jButton1.setText("CREAR PERSONAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, -1, -1));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 20, 30));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 10, 40));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 640, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearPersonal();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField textoArea;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDpi;
    private javax.swing.JTextField textoNo;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPuesto;
    // End of variables declaration//GEN-END:variables
}
