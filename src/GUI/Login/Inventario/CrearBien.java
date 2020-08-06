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
                JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE EL BIEN CON CODIGO " + noInventario);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "EXISTIERON ERRORES AL INTENTAR CREAR EL BIEN DENTRO DE LA BASE DE DATOS " + noInventario);
            }
        } else {
            boolean resultado = manejadorCreacionBien.crearBien(noInventario, this.usuario, noInventario, unidad, tipoBien, valor, fechaActual, tipoBien, descripcion, "---", "---",
                    "---", "---", noCUR, valorBien, division, encargado, encargado, tipoIngreso, "---", "---", "---", "---", "---", "---");
            if (resultado) {
                JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE EL BIEN CON CODIGO " + noInventario);
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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("CREACION DE BIENES");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2_opt.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2_opt.jpg"))); // NOI18N

        jLabel4.setText("No Unidad Academica:");

        Jlabel.setText("Tipo de Bien:");

        boxTipoBien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoBienItemStateChanged(evt);
            }
        });

        textoUnidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        textoUnidad.setText("12");
        textoUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoUnidadKeyTyped(evt);
            }
        });

        jLabel5.setText("Descripcion:");

        textoDescripcion.setColumns(20);
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

        labelNoFactura.setText("No Factura:");

        labelFechaFactura.setText("Fecha Factura:");

        labelNoSolicitudCompra.setText("No Solicitud Compra:");

        labelNoOrdenCompra.setText("No Orden Compra:");

        jLabel10.setText("No CUR:");

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Valor del bien:");

        jLabel12.setText("Division:");

        jLabel13.setText("Encargado:");

        jLabel14.setText("Tipo Ingreso:");

        boxTipoIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPRA", "TRASLADO", "DONACION" }));
        boxTipoIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoIngresoItemStateChanged(evt);
            }
        });

        labelEntidad.setText("Entidad Compra:");

        boxEntidadCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CUNOC", "TESORERIA USAC", "GUATECOMPRAS" }));

        textoEncargado.setEnabled(false);

        labelProveedor.setText("Proveedor:");

        textoProveedor.setEnabled(false);

        botonProveedor.setText("?");
        botonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedorActionPerformed(evt);
            }
        });

        jButton3.setText("CREAR BIEN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNoFactura)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNoOrdenCompra)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelNoSolicitudCompra)
                                                    .addComponent(jLabel10))
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textoNoOrdenCompra)
                                                    .addComponent(textoNoSolicitudCompra)
                                                    .addComponent(textoNoCur, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(Jlabel)
                                                .addComponent(jLabel14))
                                            .addGap(29, 29, 29)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(boxTipoIngreso, javax.swing.GroupLayout.Alignment.LEADING, 0, 262, Short.MAX_VALUE)
                                                    .addComponent(boxTipoBien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(textoUnidad, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textoNoFactura, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addComponent(fechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(labelFechaFactura))
                                .addGap(127, 127, 127)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(labelEntidad)
                                    .addComponent(labelProveedor)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textoEncargado, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textoDivision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoValor, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(boxEntidadCompra, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textoProveedor, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                        .addComponent(botonProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(textoDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel)
                    .addComponent(boxTipoBien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(textoEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(boxTipoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEntidad)
                        .addComponent(boxEntidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoNoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNoFactura)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelProveedor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFechaFactura)
                                    .addComponent(fechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNoSolicitudCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelNoSolicitudCompra)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNoOrdenCompra)
                                    .addComponent(textoNoOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(textoNoCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonProveedor))))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
