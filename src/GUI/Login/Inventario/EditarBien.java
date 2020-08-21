/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login.Inventario;

import GUI.Login.VistasAuxiliares.AuxiliarProveedor;
import Logica.ManejadorEditarBien;
import Objetos.EstructuraBien;
import Objetos.PasarString;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class EditarBien extends javax.swing.JDialog {

    private String noInventario;
    private ManejadorEditarBien manejadorEditarBien;
    private SimpleDateFormat fechaCompleta;
    private Frame frame;

    public EditarBien(java.awt.Frame parent, boolean modal, String noInventario) {
        super(parent, modal);
        initComponents();
        this.noInventario = noInventario;
        this.frame=frame;
        manejadorEditarBien = new ManejadorEditarBien();
        fechaCompleta = new SimpleDateFormat("yyyy-MM-dd");
        llenarDatos();
        

    }

    public final void llenarDatos() {
        try {
            EstructuraBien bien = new EstructuraBien(this.noInventario);
            manejadorEditarBien.llenarDatos(bien);
            if (bien != null) {
                this.textoNoInventario.setText(bien.getNoInventario());
                this.textoUnidadAcademica.setText(bien.getUnidadAcademica());
                this.textoAnioIngreso.setText(bien.getAnioIngreso());
                this.textoTipoBien.setText(bien.getTipoBien());

                if (bien.getNoFactura() != null) {
                    this.textoNoFactura.setText(bien.getNoFactura());
                }
                if (bien.getFechaFactura() != null) {
                    this.textoFechaFactura.setDate(fechaCompleta.parse(bien.getFechaFactura()));
                }
                this.textoFechaIngreso.setText(bien.getFechaIngreso());

                if (bien.getNoSolicitudCompra() != null) {

                    this.textoNoSolicitudCompra.setText(bien.getNoSolicitudCompra());
                }
                if (bien.getNoOrdenCompra() != null) {
                    this.textoNoOrdenCompra.setText(bien.getNoOrdenCompra());
                }
                this.textoNoCur.setText(bien.getNoCUR());
                this.textoValorBien.setText(bien.getValorBien());
                this.textoDivision.setText(bien.getDivision());
                this.textoEncargadoActual.setText(bien.getEncargadoActual());
                if (bien.getEntidadCompra() != null) {

                    if (bien.getEntidadCompra().equals("CUNOC")) {
                        this.textoEntidadCompra.setSelectedIndex(0);
                    } else if (bien.getEntidadCompra().equals("TESORERIA USAC")) {
                        this.textoEntidadCompra.setSelectedIndex(1);
                    } else {
                        this.textoEntidadCompra.setSelectedIndex(2);
                    }
                }
                this.textoEstadoActual.setText(bien.getEstadoActual());
                this.textoProveedor.setText(bien.getProveedor());
                this.textoTipoIngreso.setText(bien.getTipoIngreso());
                if (bien.getDescripcion() != null) {

                    this.textoDescripcion.setText(bien.getDescripcion());
                }

                if (this.textoTipoIngreso.getText().equals("TRASLADO") || this.textoTipoIngreso.getText().equals("DONACION")) {
                    this.textoNoFactura.setEditable(false);
                    this.textoFechaFactura.setEnabled(false);
                    this.textoNoSolicitudCompra.setEditable(false);
                    this.textoNoFactura.setEditable(false);
                    this.textoNoOrdenCompra.setEditable(false);
                    this.textoEntidadCompra.setEnabled(false);
                    this.botonProveedor.setEnabled(false);
                }

            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS CON LA FECHA DE LA FACTURA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS AL LLENAR LOS DATOS");
            e.printStackTrace();

        }

    }

    public void mandarDatos() {
        String noInventario = this.textoNoInventario.getText();
        String unidadAcademica = this.textoUnidadAcademica.getText();
        String anioIngreso = this.textoAnioIngreso.getText();
        String tipoBien = this.textoTipoBien.getText();
        String noFactura = this.textoNoFactura.getText();
        String fechaFactura = fechaCompleta.format(this.textoFechaFactura.getDate());
        String fechaIngreso = this.textoFechaIngreso.getText();
        String noSolicitudCompra = this.textoNoSolicitudCompra.getText();
        String noOrdenCompra = this.textoNoOrdenCompra.getText();
        String noCUR = this.textoNoCur.getText();
        String valorBien = this.textoValorBien.getText();
        String division = this.textoDivision.getText();
        String encargado = this.textoEncargadoActual.getText();
        String entidadCompra = this.textoEntidadCompra.getSelectedItem().toString();
        String estadoActual = this.textoEstadoActual.getText();
        String proveedor = this.textoProveedor.getText();
        String tipoIngreso = this.textoTipoIngreso.getText();
        String descripcion = this.textoDescripcion.getText();
        
        
        EstructuraBien bien = new EstructuraBien(noInventario);
        bien.setTipoIngreso(tipoIngreso);
        bien.setNoFactura(noFactura);
        bien.setFechaFactura(fechaFactura);
        bien.setNoSolicitudCompra(noSolicitudCompra);
        bien.setNoOrdenCompra(noOrdenCompra);
        bien.setNoCUR(noCUR);
        bien.setValorBien(valorBien);
        bien.setDivision(division);
        bien.setEntidadCompra(entidadCompra);    
        bien.setProveedor(proveedor);
        bien.setDescripcion(descripcion);
        
        boolean resultado = manejadorEditarBien.editarBien(bien);
        if(resultado){
            JOptionPane.showMessageDialog(null, "SE ACTUALIZARON CORRECTAMENTE LOS DATOS DEL BIEN CON NO DE INVENTARIO: "+noInventario);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "PROBLEMAS AL EDITAR LOS DATOS DEL BIEN CON NO DE INVENTARIO: "+noInventario);
        }

    }

    public void editarBien() {
        try {
            String noInventario = this.textoNoInventario.getText();
            String unidadAcademica = this.textoUnidadAcademica.getText();
            String anioIngreso = this.textoAnioIngreso.getText();
            String tipoBien = this.textoTipoBien.getText();
            String noFactura = this.textoNoFactura.getText();
            String fechaFactura = fechaCompleta.format(this.textoFechaFactura.getDate());
            String fechaIngreso = this.textoFechaIngreso.getText();
            String noSolicitudCompra = this.textoNoSolicitudCompra.getText();
            String noOrdenCompra = this.textoNoOrdenCompra.getText();
            String noCUR = this.textoNoCur.getText();
            String valorBien = this.textoValorBien.getText();
            String division = this.textoDivision.getText();
            String encargado = this.textoEncargadoActual.getText();
            String entidadCompra = this.textoEntidadCompra.getSelectedItem().toString();
            String estadoActual = this.textoEstadoActual.getText();
            String proveedor = this.textoProveedor.getText();
            String tipoIngreso = this.textoTipoIngreso.getText();
            String descripcion = this.textoDescripcion.getText();

            if (!tipoIngreso.equals("") && tipoIngreso.equals("COMPRA")) {

                if (!unidadAcademica.equals("")) {
                    if (unidadAcademica.length() <= 30) {
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
                        JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE PASAR LOS 30 CARACTERES, ACTUALES: " + unidadAcademica.length());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE ESTAR VACIO");
                }

            } else if (!tipoIngreso.equals("") && (tipoIngreso.equals("TRASLADO") || tipoIngreso.equals("DONACION"))) {

                if (!unidadAcademica.equals("")) {
                    if (unidadAcademica.length() <= 30) {
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
                        JOptionPane.showMessageDialog(null, "EL NO. DE UNIDAD ACADEMICA NO PUEDE PASAR LOS 30 CARACTERES, ACTUALES: " + unidadAcademica.length());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        textoNoInventario = new javax.swing.JTextField();
        textoUnidadAcademica = new javax.swing.JTextField();
        textoAnioIngreso = new javax.swing.JTextField();
        textoTipoBien = new javax.swing.JTextField();
        textoNoFactura = new javax.swing.JTextField();
        textoTipoIngreso = new javax.swing.JTextField();
        textoFechaIngreso = new javax.swing.JTextField();
        textoNoSolicitudCompra = new javax.swing.JTextField();
        textoNoOrdenCompra = new javax.swing.JTextField();
        textoNoCur = new javax.swing.JTextField();
        textoDivision = new javax.swing.JTextField();
        textoEncargadoActual = new javax.swing.JTextField();
        textoEstadoActual = new javax.swing.JTextField();
        textoProveedor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        textoFechaFactura = new com.toedter.calendar.JDateChooser();
        textoEntidadCompra = new javax.swing.JComboBox<>();
        botonProveedor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textoValorBien = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR BIEN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("EDITAR INFORMACION DE UN BIEN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 57, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar_opt.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 29, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar_opt.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 29, -1, -1));

        jLabel4.setText("NoInventario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel7.setText("Unidad Academica:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel8.setText("Año Ingreso:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel9.setText("Tipo Bien:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel10.setText("No Factura:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel11.setText("Fecha Factura:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel12.setText("Fecha Ingreso:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel13.setText("No Solicitud Compra:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel14.setText("No Orden Compra:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        jLabel15.setText("No CUR:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, -1));

        jLabel16.setText("Valor Bien:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        jLabel17.setText("Division:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        jLabel18.setText("Encargado Actual:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, -1));

        jLabel19.setText("Tipo Ingreso:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        jLabel20.setText("Entidad Compra:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, -1, -1));

        jLabel21.setText("Estado Actual:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, -1));

        jLabel22.setText("Proveedor:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        textoNoInventario.setEditable(false);
        getContentPane().add(textoNoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 141, 243, -1));

        textoUnidadAcademica.setEditable(false);
        getContentPane().add(textoUnidadAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 182, 243, -1));

        textoAnioIngreso.setEditable(false);
        getContentPane().add(textoAnioIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 223, 243, -1));

        textoTipoBien.setEditable(false);
        getContentPane().add(textoTipoBien, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 264, 243, -1));
        getContentPane().add(textoNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 305, 243, -1));

        textoTipoIngreso.setEditable(false);
        getContentPane().add(textoTipoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, 243, -1));

        textoFechaIngreso.setEditable(false);
        getContentPane().add(textoFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 243, -1));
        getContentPane().add(textoNoSolicitudCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 243, -1));
        getContentPane().add(textoNoOrdenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 243, -1));
        getContentPane().add(textoNoCur, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 243, -1));
        getContentPane().add(textoDivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 243, -1));

        textoEncargadoActual.setEditable(false);
        getContentPane().add(textoEncargadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 243, -1));

        textoEstadoActual.setEditable(false);
        getContentPane().add(textoEstadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 243, -1));

        textoProveedor.setEditable(false);
        getContentPane().add(textoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 190, -1));

        jLabel23.setText("Descripcion:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, -1, -1));

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 570, 210));

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 230, -1));
        getContentPane().add(textoFechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 240, -1));

        textoEntidadCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUNOC", "TESORERIA USAC", "GUATECOMPRAS" }));
        getContentPane().add(textoEntidadCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 240, -1));

        botonProveedor.setText("?");
        botonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(botonProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 40, 20));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 700, -1, -1));

        textoValorBien.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        getContentPane().add(textoValorBien, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editarBien();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedorActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarProveedor aux = new AuxiliarProveedor(this.frame, true, resultado);
        aux.setVisible(true);
        this.textoProveedor.setText(resultado.getValor());
    }//GEN-LAST:event_botonProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoAnioIngreso;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoDivision;
    private javax.swing.JTextField textoEncargadoActual;
    private javax.swing.JComboBox<String> textoEntidadCompra;
    private javax.swing.JTextField textoEstadoActual;
    private com.toedter.calendar.JDateChooser textoFechaFactura;
    private javax.swing.JTextField textoFechaIngreso;
    private javax.swing.JTextField textoNoCur;
    private javax.swing.JTextField textoNoFactura;
    private javax.swing.JTextField textoNoInventario;
    private javax.swing.JTextField textoNoOrdenCompra;
    private javax.swing.JTextField textoNoSolicitudCompra;
    private javax.swing.JTextField textoProveedor;
    private javax.swing.JTextField textoTipoBien;
    private javax.swing.JTextField textoTipoIngreso;
    private javax.swing.JTextField textoUnidadAcademica;
    private javax.swing.JFormattedTextField textoValorBien;
    // End of variables declaration//GEN-END:variables
}
