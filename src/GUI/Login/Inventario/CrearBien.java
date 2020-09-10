/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Inventario;

import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import GUI.Login.VistasAuxiliares.AuxiliarProveedor;
import Logica.ManejadorCreacionBien;
import Logica.ManejadorTiposBien;
import Objetos.PasarString;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author jpmazate
 */
public class CrearBien extends javax.swing.JFrame {

    /**
     * Creates new form CrearBien
     */
    private String usuario;
    private ManejadorTiposBien manejadorTipoBien;
    private ManejadorCreacionBien manejadorCreacionBien;
    private SimpleDateFormat formateador;
    private SimpleDateFormat fechaCompleta;

    public CrearBien(String usuario) {
        initComponents();
        this.usuario = usuario;
        manejadorTipoBien = new ManejadorTiposBien();
        manejadorCreacionBien = new ManejadorCreacionBien();
        formateador = new SimpleDateFormat("yyyy");
        fechaCompleta = new SimpleDateFormat("yyyy-MM-dd");
         this.getRootPane().setDefaultButton(jButton3);
        cargarDatosIniciales();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void cargarDatosIniciales() {
        manejadorTipoBien.llenarCodigos(this.boxTipoBien);
        int numeroElemento = 0;
        if (this.boxTipoBien.getItemCount() > 0) {
            this.boxTipoBien.setSelectedIndex(0);

        } else {
            numeroElemento = 1;
        }

    }

    public void validarDatos() {
        try {

            String unidad = this.textoUnidad.getText();
            String tipoBien = this.boxTipoBien.getSelectedItem().toString();
            String tipoIngreso = this.boxTipoIngreso.getSelectedItem().toString();
            String noFactura = this.textoNoFactura.getText();
            String fechaFactura = fechaCompleta.format(this.fechaFactura.getDate());
            String noSolicitudCompra = this.textoNoSolicitudCompra.getText();
            String noOrdenCompra = this.textoNoOrdenCompra.getText();
            String noCUR = this.textoNoCur.getText();
            String division = this.textoDivision.getText();
            String encargado = this.textoEncargado.getText();
            String entidadCompra = this.boxEntidadCompra.getSelectedItem().toString();
            String proveedor = this.textoProveedor.getText();
            String valorBien = this.textoValor.getText();
            String descripcion = this.textoDescripcion.getText();

            if (!tipoIngreso.equals("") && tipoIngreso.equals("COMPRA")) {

                if (!unidad.equals("")) {
                    if (unidad.length() <= 30) {
                        if (!tipoBien.equals("")) {
                            if (!tipoIngreso.equals("")) {
                                if (!noFactura.equals("")) {
                                    if (noFactura.length() <= 20) {
                                        if (!fechaFactura.equals("")) {
                                            if (!noSolicitudCompra.equals("")) {
                                                if (noSolicitudCompra.length() <= 50) {
                                                    if (!noOrdenCompra.equals("")) {
                                                        if (noOrdenCompra.length() <= 50) {
                                                            if (!noCUR.equals("")) {
                                                                if (noCUR.length() <= 50) {
                                                                    if (!division.equals("")) {
                                                                        if (division.length() <= 50) {
                                                                            if (!encargado.equals("")) {
                                                                                if (!entidadCompra.equals("")) {
                                                                                    if (!proveedor.equals("")) {
                                                                                        if (!valorBien.equals("")) {
                                                                                            try {
                                                                                                Float.parseFloat(valorBien);
                                                                                                //Integer.parseInt(valorBien);
                                                                                                if (!descripcion.equals("")) {
                                                                                                    descripcion = "---";
                                                                                                }
                                                                                                mandarDatos();

                                                                                            } catch (Exception e) {
                                                                                                JOptionPane.showMessageDialog(null, "EL VALOR DEL BIEN NO ES UN NUMERO DECIMAL");
                                                                                            }

                                                                                        } else {
                                                                                            JOptionPane.showMessageDialog(null, "EL VALOR DEL BIEN NO PUEDE ESTAR VACIO");
                                                                                        }
                                                                                    } else {
                                                                                        JOptionPane.showMessageDialog(null, "EL PROVEEDOR NO PUEDE ESTAR VACIO");
                                                                                    }
                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(null, "LA ENTIDAD DE COMPRA NO PUEDE ESTAR VACIA");
                                                                                }
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "EL ENCARGADO NO PUEDE ESTAR VACIO");
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(null, "LA DIVISION NO PUEDE PASAR DE 50 CARACTERES, ACTUALES: " + division.length());
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "LA DIVISION NO PUEDE ESTAR VACIA");
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "EL NO. DE CUR NO PUEDE PASAR LOS 50 CARACTERES, ACTUALES: " + noCUR.length());
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "EL NO. DE CUR NO PUEDE ESTAR VACIO");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "EL NO. DE ORDEN DE COMPRA NO PUEDE PASAR LOS 50 CARACTERES, ACTUALES: " + noOrdenCompra.length());
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "EL NO. DE ORDEN DE COMPRA NO PUEDE ESTAR VACIO");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "EL NO. DE SOLICITUD DE COMPRA NO PUEDE PASAR LOS 50 CARACTERES, ACTUALES: " + noSolicitudCompra.length());
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "EL NO. DE SOLICITUD DE COMPRA NO PUEDE ESTAR VACIO");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "LA FECHA DE FACTURA NO PUEDE ESTAR VACIa");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "EL NO. DE FACTURA NO PUEDE PASAR LOS 20 CARACTERES, ACTUALES: " + noFactura.length());
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL NO. DE FACTURA NO PUEDE ESTAR VACIO");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "EL TIPO DE INGRESO NO PUEDE ESTAR VACIO");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "EL TIPO DE BIEN NO PUEDE ESTAR VACIO");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE PASAR LOS 30 CARACTERES, ACTUALES: " + unidad.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE ESTAR VACIO");
                }

            } else if (!tipoIngreso.equals("") && (tipoIngreso.equals("TRASLADO") || tipoIngreso.equals("DONACION"))) {

                if (!unidad.equals("")) {
                    if (unidad.length() <= 30) {
                        if (!tipoBien.equals("")) {
                            if (!tipoIngreso.equals("")) {

                                if (!noCUR.equals("")) {
                                    if (noCUR.length() <= 50) {
                                        if (!division.equals("")) {
                                            if (division.length() <= 50) {
                                                if (!encargado.equals("")) {

                                                    if (!valorBien.equals("")) {
                                                        try {
                                                            Float.parseFloat(valorBien);
                                                            //Integer.parseInt(valorBien);
                                                            if (!descripcion.equals("")) {
                                                                descripcion = "---";
                                                            }
                                                            mandarDatos();

                                                        } catch (Exception e) {
                                                            JOptionPane.showMessageDialog(null, "EL VALOR DEL BIEN NO ES UN NUMERO DECIMAL");
                                                        }

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "EL VALOR DEL BIEN NO PUEDE ESTAR VACIO");
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "EL ENCARGADO NO PUEDE ESTAR VACIO");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "LA DIVISION NO PUEDE PASAR DE 50 CARACTERES, ACTUALES: " + division.length());
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "LA DIVISION NO PUEDE ESTAR VACIA");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "EL NO. DE CUR NO PUEDE PASAR LOS 50 CARACTERES, ACTUALES: " + noCUR.length());
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "EL NO. DE CUR NO PUEDE ESTAR VACIO");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "EL TIPO DE INGRESO NO PUEDE ESTAR VACIO");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "EL TIPO DE BIEN NO PUEDE ESTAR VACIO");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE PASAR LOS 30 CARACTERES, ACTUALES: " + unidad.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE ESTAR VACIO");
                }

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mandarDatos() {
        String unidad = this.textoUnidad.getText();
        String tipoBien = this.boxTipoBien.getSelectedItem().toString();
        String tipoIngreso = this.boxTipoIngreso.getSelectedItem().toString();
        String noFactura = this.textoNoFactura.getText();
        String fechaFactura = fechaCompleta.format(this.fechaFactura.getDate());
        String noSolicitudCompra = this.textoNoSolicitudCompra.getText();
        String noOrdenCompra = this.textoNoOrdenCompra.getText();
        String noCUR = this.textoNoCur.getText();
        String division = this.textoDivision.getText();
        String encargado = this.textoEncargado.getText();
        String entidadCompra = this.boxEntidadCompra.getSelectedItem().toString();
        String proveedor = this.textoProveedor.getText();
        String valorBien = this.textoValor.getText();
        String descripcion = this.textoDescripcion.getText();

        int valor = manejadorCreacionBien.obtenerNumero(tipoBien);
        String fechaActual = formateador.format(new Date());
        String noInventario = unidad + "-" + tipoBien + "-" + valor + "-" + fechaActual;
        JOptionPane.showMessageDialog(null, "El Numero de inventario y de tarjeta que se utilizara es: " + noInventario);

        if (tipoIngreso.equals("COMPRA")) {

            boolean resultado = manejadorCreacionBien.crearBien(noInventario, this.usuario, noInventario, unidad, tipoBien, valor, fechaActual, tipoBien, descripcion, noFactura, fechaFactura,
                    noSolicitudCompra, noOrdenCompra, noCUR, valorBien, division, encargado, encargado, tipoIngreso, entidadCompra, proveedor, "---", "---", "---", "---");
            if (resultado) {
                JOptionPane.showMessageDialog(null, "SE CREO CORRECTAMENTE EL BIEN CON CODIGO " + noInventario);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "EXISTIERON ERRORES AL INTENTAR CREAR EL BIEN DENTRO DE LA BASE DE DATOS " + noInventario);
            }
        } else {
            boolean resultado = manejadorCreacionBien.crearBien(noInventario, this.usuario, noInventario, unidad, tipoBien, valor, fechaActual, tipoBien, descripcion, "---", "---",
                    "---", "---", noCUR, valorBien, division, encargado, encargado, tipoIngreso, "---", "---", "---", "---", "---", "---");
            if (resultado) {
                JOptionPane.showMessageDialog(null, "SE CREO CORRECTAMENTE EL BIEN CON CODIGO " + noInventario);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "EXISTIERON ERRORES AL INTENTAR CREAR EL BIEN DENTRO DE LA BASE DE DATOS " + noInventario);
            }
        }
    }

    public void mostrarDatos() {
        int valor = boxTipoIngreso.getSelectedIndex();
        if (valor == 0) {
            this.labelEntidad.setVisible(true);
            this.labelFechaFactura.setVisible(true);
            this.labelNoFactura.setVisible(true);
            this.labelNoOrdenCompra.setVisible(true);
            this.labelNoSolicitudCompra.setVisible(true);
            this.labelProveedor.setVisible(true);
            this.botonProveedor.setVisible(true);
            this.boxEntidadCompra.setVisible(true);
            this.fechaFactura.setVisible(true);
            this.textoNoFactura.setVisible(true);
            this.textoNoOrdenCompra.setVisible(true);
            this.textoNoSolicitudCompra.setVisible(true);
            this.textoProveedor.setVisible(true);
        } else {
            this.labelEntidad.setVisible(false);
            this.labelFechaFactura.setVisible(false);
            this.labelNoFactura.setVisible(false);
            this.labelNoOrdenCompra.setVisible(false);
            this.labelNoSolicitudCompra.setVisible(false);
            this.labelProveedor.setVisible(false);
            this.botonProveedor.setVisible(false);
            this.boxEntidadCompra.setVisible(false);
            this.fechaFactura.setVisible(false);
            this.textoNoFactura.setVisible(false);
            this.textoNoOrdenCompra.setVisible(false);
            this.textoNoSolicitudCompra.setVisible(false);
            this.textoProveedor.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Jlabel = new javax.swing.JLabel();
        boxTipoBien = new javax.swing.JComboBox<>();
        textoUnidad = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        labelNoFactura = new javax.swing.JLabel();
        textoNoFactura = new javax.swing.JTextField();
        labelFechaFactura = new javax.swing.JLabel();
        fechaFactura = new com.toedter.calendar.JDateChooser();
        labelNoSolicitudCompra = new javax.swing.JLabel();
        textoNoSolicitudCompra = new javax.swing.JTextField();
        labelNoOrdenCompra = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textoNoOrdenCompra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        textoValor = new javax.swing.JTextField();
        textoNoCur = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        boxTipoIngreso = new javax.swing.JComboBox<>();
        labelEntidad = new javax.swing.JLabel();
        boxEntidadCompra = new javax.swing.JComboBox<>();
        textoDivision = new javax.swing.JTextField();
        textoEncargado = new javax.swing.JTextField();
        labelProveedor = new javax.swing.JLabel();
        textoProveedor = new javax.swing.JTextField();
        botonProveedor = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CREAR BIEN");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("CREACION DE BIENES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2_opt.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(987, 12, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2_opt.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 12, -1, -1));

        jLabel4.setText("No Unidad Academica:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Jlabel.setText("Tipo de Bien:");
        jPanel1.add(Jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        boxTipoBien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoBienItemStateChanged(evt);
            }
        });
        jPanel1.add(boxTipoBien, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 142, 262, -1));

        textoUnidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        textoUnidad.setText("12");
        textoUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoUnidadKeyTyped(evt);
            }
        });
        jPanel1.add(textoUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 95, 262, -1));

        jLabel5.setText("Descripcion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 356, -1, -1));

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 356, 348, 129));

        labelNoFactura.setText("No Factura:");
        jPanel1.add(labelNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 246, -1, -1));
        jPanel1.add(textoNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 238, 262, -1));

        labelFechaFactura.setText("Fecha Factura:");
        jPanel1.add(labelFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 302, -1, -1));
        jPanel1.add(fechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 302, 262, -1));

        labelNoSolicitudCompra.setText("No Solicitud Compra:");
        jPanel1.add(labelNoSolicitudCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 356, -1, -1));
        jPanel1.add(textoNoSolicitudCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 356, 262, -1));

        labelNoOrdenCompra.setText("No Orden Compra:");
        jPanel1.add(labelNoOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 411, -1, -1));

        jLabel10.setText("No CUR:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 444, -1, -1));
        jPanel1.add(textoNoOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 403, 262, -1));

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 40, 20));

        jLabel11.setText("Valor del bien:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 292, -1, -1));
        jPanel1.add(textoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 292, 289, -1));
        jPanel1.add(textoNoCur, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 444, 262, -1));

        jLabel12.setText("Division:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 103, -1, -1));

        jLabel13.setText("Encargado:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 150, -1, -1));

        jLabel14.setText("Tipo Ingreso:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 203, -1, -1));

        boxTipoIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPRA", "TRASLADO", "DONACION" }));
        boxTipoIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoIngresoItemStateChanged(evt);
            }
        });
        jPanel1.add(boxTipoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 195, 262, -1));

        labelEntidad.setText("Entidad Compra:");
        jPanel1.add(labelEntidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 203, -1, -1));

        boxEntidadCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUNOC", "TESORERIA USAC", "GUATECOMPRAS" }));
        jPanel1.add(boxEntidadCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 195, 289, -1));
        jPanel1.add(textoDivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 95, 289, -1));

        textoEncargado.setEditable(false);
        jPanel1.add(textoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 142, 289, -1));

        labelProveedor.setText("Proveedor:");
        jPanel1.add(labelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 248, -1, -1));

        textoProveedor.setEditable(false);
        jPanel1.add(textoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 242, 289, -1));

        botonProveedor.setText("?");
        botonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(botonProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 40, 20));

        jButton3.setText("CREAR BIEN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 503, 350, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarEncargado aux = new AuxiliarEncargado(this, true, resultado);
        aux.setVisible(true);
        this.textoEncargado.setText(resultado.getValor());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedorActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarProveedor aux = new AuxiliarProveedor(this, true, resultado);
        aux.setVisible(true);
        this.textoProveedor.setText(resultado.getValor());
    }//GEN-LAST:event_botonProveedorActionPerformed

    private void textoUnidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoUnidadKeyTyped
        //  actualizarCodigo();
    }//GEN-LAST:event_textoUnidadKeyTyped

    private void boxTipoBienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoBienItemStateChanged
        //actualizarCodigo();
    }//GEN-LAST:event_boxTipoBienItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        validarDatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boxTipoIngresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoIngresoItemStateChanged
        mostrarDatos();
    }//GEN-LAST:event_boxTipoIngresoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel;
    private javax.swing.JButton botonProveedor;
    private javax.swing.JComboBox<String> boxEntidadCompra;
    private javax.swing.JComboBox<String> boxTipoBien;
    private javax.swing.JComboBox<String> boxTipoIngreso;
    private com.toedter.calendar.JDateChooser fechaFactura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEntidad;
    private javax.swing.JLabel labelFechaFactura;
    private javax.swing.JLabel labelNoFactura;
    private javax.swing.JLabel labelNoOrdenCompra;
    private javax.swing.JLabel labelNoSolicitudCompra;
    private javax.swing.JLabel labelProveedor;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoDivision;
    private javax.swing.JTextField textoEncargado;
    private javax.swing.JTextField textoNoCur;
    private javax.swing.JTextField textoNoFactura;
    private javax.swing.JTextField textoNoOrdenCompra;
    private javax.swing.JTextField textoNoSolicitudCompra;
    private javax.swing.JTextField textoProveedor;
    private javax.swing.JFormattedTextField textoUnidad;
    private javax.swing.JTextField textoValor;
    // End of variables declaration//GEN-END:variables
}
