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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("CREAR PERSONAL");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal2_opt.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User3_opt.png"))); // NOI18N

        jLabel4.setText("No Personal:");

        jLabel5.setText("Nombre Completo:");

        jLabel6.setText("Fecha Nacimiento:");

        jLabel7.setText("Correo Electronico:");

        jLabel8.setText("DPI:");

        jLabel9.setText("Puesto:");

        jLabel10.setText("Area de Trabajo:");

        jButton1.setText("CREAR PERSONAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoNo)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoNombre)
                            .addComponent(textoCorreo)
                            .addComponent(textoDpi)
                            .addComponent(textoPuesto)
                            .addComponent(textoArea)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(textoDpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(221, Short.MAX_VALUE))
        );

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
