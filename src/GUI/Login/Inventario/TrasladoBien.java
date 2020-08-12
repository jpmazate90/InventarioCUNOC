package GUI.Login.Inventario;

import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import Logica.ManejadorTrasladoBien;
import Objetos.PasarString;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Timestamp;    

public class TrasladoBien extends javax.swing.JDialog {
    
    private String noInventario;
    private String encargado;
    private String division;
    private Frame parent;
    private ManejadorTrasladoBien manejadorTrasladoBien;
    private SimpleDateFormat formateador;
    
    public TrasladoBien(java.awt.Frame parent, boolean modal, String noInventario, String encargado, String division) {
        super(parent, modal);
        initComponents();
        
        manejadorTrasladoBien = new ManejadorTrasladoBien();
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        this.noInventario = noInventario;
        this.encargado = encargado;
        this.division = division;
        
        this.parent = parent;
        this.textoNoInventario.setText(noInventario);
        this.textoEncargadoActual.setText(encargado);
        this.textoDivisionAnterior.setText(division);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoMotivo = new javax.swing.JTextArea();
        textoNoInventario = new javax.swing.JTextField();
        textoEncargadoActual = new javax.swing.JTextField();
        textoEncargadoNuevo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textoDivisionAnterior = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textoDivisionNueva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Traslado de Bien");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("TRASLADO DE BIEN");

        jLabel2.setText("NO INVENTARIO:");

        jLabel3.setText("ENCARGADO ACTUAL:");

        jLabel4.setText("NUEVO ENCARGADO:");

        jLabel5.setText("MOTIVO DE TRASLADO:");

        textoMotivo.setColumns(20);
        textoMotivo.setRows(5);
        jScrollPane1.setViewportView(textoMotivo);

        textoNoInventario.setEditable(false);

        textoEncargadoActual.setEditable(false);

        textoEncargadoNuevo.setEditable(false);

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("DIVISION ANTERIOR:");

        textoDivisionAnterior.setEditable(false);

        jLabel7.setText("DIVISION NUEVA:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito_opt.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito_opt.jpg"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar_opt.png"))); // NOI18N
        jButton2.setText("Guardar Traslado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNoInventario)
                            .addComponent(textoEncargadoActual)
                            .addComponent(textoDivisionAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7))
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textoEncargadoNuevo)
                                        .addComponent(textoDivisionNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(569, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(22, 22, 22)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoEncargadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoDivisionAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoEncargadoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoDivisionNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel9)
                    .addContainerGap(625, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarEncargado aux = new AuxiliarEncargado(this.parent, true, resultado);
        aux.setVisible(true);
        this.textoEncargadoNuevo.setText(resultado.getValor());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardarCambios();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void guardarCambios() {
        String nuevoEncargado = this.textoEncargadoNuevo.getText();
        String divisionNueva = this.textoDivisionNueva.getText();
        String motivo = this.textoMotivo.getText();
        String noInven = this.textoNoInventario.getText();
        String encargadoActual = this.textoEncargadoActual.getText();
        
        if (!nuevoEncargado.equals("")) {
            
            if (!divisionNueva.equals("")) {
                if (divisionNueva.length() <= 50) {
                    if (!motivo.equals("")) {
                
                
                        boolean resultado = manejadorTrasladoBien.crearTraslado(noInven, nuevoEncargado, encargadoActual, new Timestamp(new Date().getTime()).toString(), motivo, divisionNueva);
                        if (resultado) {
                            JOptionPane.showMessageDialog(null, "SE HA REALIZADO CORRECTAMENTE EL TRASLADO DE ENCARGADO DEL BIEN CON NO DE INVENTARIO: " + noInven);
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL INTENTAR CREAR EL TRASLADO DEL BIEN CON NO DE INVENTARIO: " + noInven);                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE DADO UN MOTIVO DE TRASLADO, DEBE DE LLENARSE");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "LA DIVISION NO ACEPTA MAS DE 50 CARACTERES, ACTUALES: " + divisionNueva.length());
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA LLENADO EL CAMPO DE DIVISION NUEVA, NO PUEDE ESTAR VACIO");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN ENCARGADO NUEVO");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoDivisionAnterior;
    private javax.swing.JTextField textoDivisionNueva;
    private javax.swing.JTextField textoEncargadoActual;
    private javax.swing.JTextField textoEncargadoNuevo;
    private javax.swing.JTextArea textoMotivo;
    private javax.swing.JTextField textoNoInventario;
    // End of variables declaration//GEN-END:variables
}
