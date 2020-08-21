/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Administracion;

import Logica.ManejadorPersonal;
import Logica.ManejadorProveedores;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class Personal extends javax.swing.JFrame {

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorPersonal manejadorPersonal;
    private SimpleDateFormat formateador;

    public Personal() {
        initComponents();
        modelo = new TablaModelo();
        manejadorPersonal = new ManejadorPersonal();
        asignarDatosPersonal();
         this.getRootPane().setDefaultButton(jButton1);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        formateador = new SimpleDateFormat("yyyy-MM-dd");
        this.textoFecha.enableInputMethods(true);

    }

    public void asignarDatosPersonal() {
        GeneradorModelos.modeloPersonal(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaPersonal);
        manejadorPersonal.llenarPersonal(modelo);

    }

    public void recargarTabla() {
        modelo = new TablaModelo();
        this.textoFiltros.setText("");
        this.tablaPersonal.setRowSorter(null);
        manejadorPersonal = new ManejadorPersonal();
        asignarDatosPersonal();
    }

    public void reiniciarEditado() {
        this.textoArea.setText("");
        this.textoCorreo.setText("");
        this.textoDpi.setText("");
        this.textoEstado.setText("");
        this.textoFecha.setDate(new Date());
        this.textoFiltros.setText("");
        this.textoNo.setText("");
        this.textoNombre.setText("");
        this.textoPuesto.setText("");
    }

    public void cambiarEstado(int estado) {
        String no = this.textoNo.getText();
        String nombre = this.textoNombre.getText();
        if (!no.equals("")) {
            boolean resultado = manejadorPersonal.cambiarEstadoPersonal(no, estado);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Se realizo el cambio de estado al personal: " + nombre);
                recargarTabla();
                reiniciarEditado();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio de estado al personal: " + nombre);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun personal");
        }
    }

    public void editarPersonal() {
        String numero = this.textoNo.getText();
        String nombre = this.textoNombre.getText();
        String fecha = formateador.format(this.textoFecha.getDate());
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

                                                                    boolean resultado = manejadorPersonal.editarPersonal(numero, nombre, fecha, correo, dpi, puesto, estado, area);

                                                                    if (resultado) {
                                                                        JOptionPane.showMessageDialog(null, "Se edito con exito el personal: " + nombre);
                                                                        recargarTabla();
                                                                        reiniciarEditado();
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Problemas para editar el personal con nombre: " + nombre + "\n"
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

    public void eliminarPersonal() {
        String no = this.textoNo.getText();
        String nombre = this.textoNombre.getText();
        if (!no.equals("")) {
            boolean resultado = manejadorPersonal.eliminarPersonal(no);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente el personal: "+ nombre);
                recargarTabla();
                reiniciarEditado();
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el personal, puede que ya este referenciado en algun bien");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, no se selecciono ningun personal para eliminarlo");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoFiltros = new javax.swing.JTextField();
        filtros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoNo = new javax.swing.JTextField();
        textoEstado = new javax.swing.JTextField();
        textoPuesto = new javax.swing.JTextField();
        textoDpi = new javax.swing.JTextField();
        textoArea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        textoFecha = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PERSONAL");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("PERSONAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 66, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 12, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal2_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, -1, -1));

        jLabel4.setText("Filtrar por:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 182, -1, -1));

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });
        getContentPane().add(textoFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 174, 1106, -1));

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Personal", "Nombre Completo", "Fecha Nacimiento", "Correo Electronico", "Dpi", "Puesto", "Estado", "Area Trabajo" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        getContentPane().add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 174, 301, -1));

        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 221, 1497, 266));

        jLabel5.setText("No Personal:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 545, -1, -1));

        jLabel6.setText("Nombre Completo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 595, -1, -1));

        jLabel7.setText("Fecha Nacimiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 644, -1, -1));

        jLabel8.setText("Correo Electronico:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        jLabel9.setText("Dpi:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 545, -1, -1));

        jLabel10.setText("Puesto:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 595, -1, -1));

        jLabel11.setText("Estado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 644, -1, -1));

        jLabel12.setText("Area Trabajo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 690, -1, -1));
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 587, 494, -1));
        getContentPane().add(textoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 683, 494, -1));

        textoNo.setEditable(false);
        getContentPane().add(textoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 537, 494, -1));

        textoEstado.setEditable(false);
        getContentPane().add(textoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 636, 699, -1));
        getContentPane().add(textoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 587, 699, -1));
        getContentPane().add(textoDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 537, 699, -1));
        getContentPane().add(textoArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 683, 699, -1));

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 160, -1));

        jButton2.setText("Crear Personal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 730, 168, -1));

        jButton3.setText("Eliminar Personal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 730, 180, -1));
        getContentPane().add(textoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 640, 494, -1));

        jButton4.setText("Habilitar Personal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 730, 180, -1));

        jButton5.setText("Deshabilitar Personal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1017, 730, 190, -1));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 780, -1, -1));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 660, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CrearPersonal ventana = new CrearPersonal(this, true);
        ventana.setVisible(true);
        recargarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textoFiltrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltrosKeyTyped
        int valor = filtros.getSelectedIndex();
// sortea la tabla
        textoFiltros.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
            }
        });

        tablaSorteada = new TableRowSorter(modelo);
        tablaPersonal.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltrosKeyTyped

    private void tablaPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonalMouseClicked

        int seleccion = tablaPersonal.getSelectedRow();// recoge la selecion

        this.textoNo.setText((String) tablaPersonal.getValueAt(seleccion, 0));
        this.textoNombre.setText((String) tablaPersonal.getValueAt(seleccion, 1));
        try {
            this.textoFecha.enableInputMethods(true);
            this.textoFecha.setDate(formateador.parse((String) tablaPersonal.getValueAt(seleccion, 2)));

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.textoCorreo.setText((String) tablaPersonal.getValueAt(seleccion, 3));
        this.textoDpi.setText((String) tablaPersonal.getValueAt(seleccion, 4));
        this.textoPuesto.setText((String) tablaPersonal.getValueAt(seleccion, 5));
        this.textoEstado.setText(Integer.toString((Integer) tablaPersonal.getValueAt(seleccion, 6)));
        this.textoArea.setText((String) tablaPersonal.getValueAt(seleccion, 7));

    }//GEN-LAST:event_tablaPersonalMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cambiarEstado(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cambiarEstado(1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
        int valor = this.filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
        tablaPersonal.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editarPersonal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarPersonal();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JTextField textoArea;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDpi;
    private javax.swing.JTextField textoEstado;
    private com.toedter.calendar.JDateChooser textoFecha;
    private javax.swing.JTextField textoFiltros;
    private javax.swing.JTextField textoNo;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPuesto;
    // End of variables declaration//GEN-END:variables
}
