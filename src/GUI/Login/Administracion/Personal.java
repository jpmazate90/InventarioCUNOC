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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("PERSONAL");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal_opt.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal2_opt.jpg"))); // NOI18N

        jLabel4.setText("Filtrar por:");

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Personal", "Nombre Completo", "Fecha Nacimiento", "Correo Electronico", "Dpi", "Puesto", "Estado", "Area Trabajo" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });

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

        jLabel5.setText("No Personal:");

        jLabel6.setText("Nombre Completo:");

        jLabel7.setText("Fecha Nacimiento:");

        jLabel8.setText("Correo Electronico:");

        jLabel9.setText("Dpi:");

        jLabel10.setText("Puesto:");

        jLabel11.setText("Estado:");

        jLabel12.setText("Area Trabajo:");

        textoNo.setEnabled(false);

        textoEstado.setEnabled(false);

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Personal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar Personal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Habilitar Personal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Deshabilitar Personal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoFiltros))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(439, 439, 439)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                            .addComponent(textoDpi, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                            .addComponent(textoPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                            .addComponent(textoArea, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(textoNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(52, Short.MAX_VALUE))
        );

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
