package GUI.Login.Inventario;

import GUI.Login.Login;
import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import GUI.Login.VistasAuxiliares.AuxiliarProveedor;
import Logica.ManejadorCreacionBien;
import Logica.ManejadorPersonal;
import Logica.ManejadorProveedores;
import Logica.ManejadorTiposBien;
import Objetos.PasarString;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class MenuInventario extends javax.swing.JFrame {

    private String usuarioActual;
    private String codigoBuscar;
    private ManejadorTiposBien manejadorTiposBien;

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorCreacionBien manejadorCreacionBienes;
    private SimpleDateFormat fechaCompleta;

    public MenuInventario(String usuarioActual) {
        initComponents();
        this.usuarioActual = usuarioActual;
        manejadorTiposBien = new ManejadorTiposBien();
        manejadorCreacionBienes = new ManejadorCreacionBien();
        fechaCompleta = new SimpleDateFormat("yyyy-MM-dd");
        llenarFiltros();
        iniciarDatosBienes();

    }

    public void iniciarDatosBienes() {
        try {
            modelo = new TablaModelo();
            GeneradorModelos.modeloBienes(modelo);
            GeneradorModelos.asignarModeloTabla(modelo, tablaBienes);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void recargarTabla() {
        modelo = new TablaModelo();
        this.textoFiltros.setText("");
        this.tablaBienes.setRowSorter(null);
        manejadorCreacionBienes = new ManejadorCreacionBien();
        manejadorTiposBien = new ManejadorTiposBien();
        iniciarDatosBienes();
    }

    public void llenarFiltros() {
        manejadorTiposBien.llenarCodigos(this.filtroTipoBien);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        filtroNoTarjeta = new javax.swing.JTextField();
        filtroUnidad = new javax.swing.JTextField();
        filtroAnio = new com.toedter.calendar.JYearChooser();
        filtroNoFactura = new javax.swing.JTextField();
        FiltroFechaFinal = new com.toedter.calendar.JDateChooser();
        filtroTipoIngreso = new javax.swing.JComboBox<>();
        filtroEstadoActual = new javax.swing.JComboBox<>();
        filtroEncargadoActual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        filtroFechaInicial = new com.toedter.calendar.JDateChooser();
        filtroDivision = new javax.swing.JTextField();
        filtroProveedor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        filtros = new javax.swing.JComboBox<>();
        textoFiltros = new javax.swing.JTextField();
        filtroTipoBien = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        filtroCheckBoxAnio = new javax.swing.JCheckBox();
        filtroValorFinal = new javax.swing.JFormattedTextField();
        filtroValorInicial = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        filtroCheckBoxFechaInicial = new javax.swing.JCheckBox();
        filtroCheckBoxFechaFinal = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario_opt.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(20, 10, 100, 70);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("AREA DE TRABAJO DE INVENTARIO");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(760, 30, 430, 18);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario2_opt.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        desktopPane.add(jLabel3);
        jLabel3.setBounds(1720, 10, 100, 60);

        jLabel6.setText("NoTarjeta:");
        desktopPane.add(jLabel6);
        jLabel6.setBounds(10, 140, 120, 18);

        jLabel7.setText("Unidad Academica:");
        desktopPane.add(jLabel7);
        jLabel7.setBounds(10, 180, 180, 18);

        jLabel8.setText("Año Ingreso:");
        desktopPane.add(jLabel8);
        jLabel8.setBounds(10, 210, 130, 18);

        jLabel9.setText("Tipo Bien:");
        desktopPane.add(jLabel9);
        jLabel9.setBounds(10, 240, 120, 18);

        jLabel10.setText("No Factura:");
        desktopPane.add(jLabel10);
        jLabel10.setBounds(10, 280, 140, 18);

        jLabel11.setText("Fecha Final:");
        desktopPane.add(jLabel11);
        jLabel11.setBounds(10, 370, 150, 18);

        jLabel13.setText("Tipo Ingreso:");
        desktopPane.add(jLabel13);
        jLabel13.setBounds(10, 420, 140, 18);

        jLabel14.setText("Estado Actual:");
        desktopPane.add(jLabel14);
        jLabel14.setBounds(10, 460, 140, 18);

        jLabel15.setText("Encargado Actual:");
        desktopPane.add(jLabel15);
        jLabel15.setBounds(10, 500, 130, 18);

        jLabel16.setText("Division:");
        desktopPane.add(jLabel16);
        jLabel16.setBounds(10, 540, 100, 18);

        jLabel17.setText("Proveedor:");
        desktopPane.add(jLabel17);
        jLabel17.setBounds(10, 590, 140, 18);
        desktopPane.add(filtroNoTarjeta);
        filtroNoTarjeta.setBounds(150, 130, 200, 35);
        desktopPane.add(filtroUnidad);
        filtroUnidad.setBounds(150, 170, 200, 35);
        desktopPane.add(filtroAnio);
        filtroAnio.setBounds(150, 210, 170, 18);
        desktopPane.add(filtroNoFactura);
        filtroNoFactura.setBounds(150, 270, 200, 35);
        desktopPane.add(FiltroFechaFinal);
        FiltroFechaFinal.setBounds(150, 360, 170, 36);

        filtroTipoIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "COMPRA", "TRASLADO", "DONACION" }));
        desktopPane.add(filtroTipoIngreso);
        filtroTipoIngreso.setBounds(150, 410, 200, 35);

        filtroEstadoActual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "DE BAJA", "ACTIVO" }));
        desktopPane.add(filtroEstadoActual);
        filtroEstadoActual.setBounds(150, 450, 200, 35);
        desktopPane.add(filtroEncargadoActual);
        filtroEncargadoActual.setBounds(150, 490, 150, 35);

        jLabel12.setText("Fecha Inicial:");
        desktopPane.add(jLabel12);
        jLabel12.setBounds(10, 320, 150, 18);
        desktopPane.add(filtroFechaInicial);
        filtroFechaInicial.setBounds(150, 310, 170, 36);
        desktopPane.add(filtroDivision);
        filtroDivision.setBounds(150, 530, 200, 35);
        desktopPane.add(filtroProveedor);
        filtroProveedor.setBounds(150, 580, 150, 35);

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton1);
        jButton1.setBounds(180, 710, 170, 28);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        jLabel4.setText("FILTROS DE BUSQUEDA");
        desktopPane.add(jLabel4);
        jLabel4.setBounds(30, 90, 300, 29);

        jLabel5.setText("Filtrar la tabla por:");
        desktopPane.add(jLabel5);
        jLabel5.setBounds(360, 100, 140, 18);

        tablaBienes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaBienes);

        desktopPane.add(jScrollPane1);
        jScrollPane1.setBounds(360, 130, 1450, 520);

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO TARJETA", "UNIDAD ACADEMICA", "AÑO INGRESO", "TIPO BIEN", "NO FACTURA", "FECHA INGRESO", "TIPO INGRESO", "ESTADO ACTUAL", "ENCARGADO ACTUAL", "DIVISION", "PROVEEDOR", "VALOR BIEN" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        desktopPane.add(filtros);
        filtros.setBounds(510, 90, 180, 35);

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });
        desktopPane.add(textoFiltros);
        textoFiltros.setBounds(700, 90, 1110, 35);

        filtroTipoBien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));
        desktopPane.add(filtroTipoBien);
        filtroTipoBien.setBounds(150, 230, 200, 35);

        jButton2.setText("?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton2);
        jButton2.setBounds(300, 490, 50, 30);

        jButton3.setText("?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton3);
        jButton3.setBounds(300, 580, 50, 30);
        desktopPane.add(filtroCheckBoxAnio);
        filtroCheckBoxAnio.setBounds(330, 210, 20, 23);

        filtroValorFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        desktopPane.add(filtroValorFinal);
        filtroValorFinal.setBounds(150, 670, 200, 35);

        filtroValorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        desktopPane.add(filtroValorInicial);
        filtroValorInicial.setBounds(150, 630, 200, 35);

        jLabel18.setText("Valor Inicial:");
        desktopPane.add(jLabel18);
        jLabel18.setBounds(10, 640, 100, 18);

        jLabel19.setText("Valor Final:");
        desktopPane.add(jLabel19);
        jLabel19.setBounds(10, 680, 90, 18);

        jButton4.setText("LIMPIAR FILTROS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton4);
        jButton4.setBounds(10, 710, 160, 28);
        desktopPane.add(filtroCheckBoxFechaInicial);
        filtroCheckBoxFechaInicial.setBounds(330, 320, 20, 23);
        desktopPane.add(filtroCheckBoxFechaFinal);
        filtroCheckBoxFechaFinal.setBounds(330, 370, 20, 23);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Crear Bien");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Ir a crear un bien");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Traslado de bien");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Trasladar un bien");
        editMenu.add(cutMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Baja de bien");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Dar de baja un bien");
        helpMenu.add(contentMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText("Cerrar Sesion");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1814, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarEncargado aux = new AuxiliarEncargado(this, true, resultado);
        aux.setVisible(true);
        this.filtroEncargadoActual.setText(resultado.getValor());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PasarString resultado = new PasarString("");
        AuxiliarProveedor aux = new AuxiliarProveedor(this, true, resultado);
        aux.setVisible(true);
        this.filtroProveedor.setText(resultado.getValor());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login ventana = new Login();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        CrearBien ventana = new CrearBien(this.usuarioActual);
        ventana.setVisible(true);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        recargarTabla();
        hacerFiltros();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        borrarDatosFiltros();
    }//GEN-LAST:event_jButton4ActionPerformed

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
        tablaBienes.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltrosKeyTyped

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
        int valor = this.filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
        tablaBienes.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    public void borrarDatosFiltros() {
        this.filtroAnio.setYear(2020);
        this.FiltroFechaFinal.setDate(new Date());
        this.filtroFechaInicial.setDate(new Date());
        this.filtroCheckBoxAnio.setSelected(false);
        this.filtroCheckBoxFechaFinal.setSelected(false);
        this.filtroCheckBoxFechaInicial.setSelected(false);
        this.filtroDivision.setText("");
        this.filtroEncargadoActual.setText("");
        this.filtroEstadoActual.setSelectedIndex(0);
        this.filtroNoFactura.setText("");
        this.filtroNoTarjeta.setText("");
        this.filtroValorFinal.setText("");
        this.filtroValorInicial.setText("");
        this.filtroProveedor.setText("");
        this.filtroTipoBien.setSelectedIndex(0);
        this.filtroTipoIngreso.setSelectedIndex(0);
        this.filtroUnidad.setText("");
    }

    public void hacerFiltros() {

        String notarjeta = this.filtroNoTarjeta.getText();
        String unidad = this.filtroUnidad.getText();
        String anio = "";
        if (this.filtroCheckBoxAnio.isSelected()) {
            anio = Integer.toString(this.filtroAnio.getYear());
        }
        String tipoBien = this.filtroTipoBien.getSelectedItem().toString();
        String noFactura = this.filtroNoFactura.getText();
        String fechaInicial = "";
        if (this.filtroCheckBoxFechaInicial.isSelected()) {
            fechaInicial = fechaCompleta.format(this.filtroFechaInicial.getDate());
        }
        String fechaFinal = "";
        if (this.filtroCheckBoxFechaFinal.isSelected()) {
            fechaFinal = fechaCompleta.format(this.FiltroFechaFinal.getDate());
        }

        String tipoIngreso = this.filtroTipoIngreso.getSelectedItem().toString();
        String estadoActual = this.filtroEstadoActual.getSelectedItem().toString();
        String encargadoActual = this.filtroEncargadoActual.getText();
        String division = this.filtroDivision.getText();
        String proveedor = this.filtroProveedor.getText();

        String valorInicial = this.filtroValorInicial.getText();
        String valorfinal = this.filtroValorFinal.getText();

        System.out.println("valor inicial: " + valorInicial);

        iniciarDatosBienes();
        manejadorCreacionBienes.buscarBien(notarjeta, unidad, anio, tipoBien, noFactura,
                fechaInicial, fechaFinal, tipoIngreso, estadoActual, encargadoActual,
                division, proveedor, valorInicial, valorfinal, modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FiltroFechaFinal;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private com.toedter.calendar.JYearChooser filtroAnio;
    private javax.swing.JCheckBox filtroCheckBoxAnio;
    private javax.swing.JCheckBox filtroCheckBoxFechaFinal;
    private javax.swing.JCheckBox filtroCheckBoxFechaInicial;
    private javax.swing.JTextField filtroDivision;
    private javax.swing.JTextField filtroEncargadoActual;
    private javax.swing.JComboBox<String> filtroEstadoActual;
    private com.toedter.calendar.JDateChooser filtroFechaInicial;
    private javax.swing.JTextField filtroNoFactura;
    private javax.swing.JTextField filtroNoTarjeta;
    private javax.swing.JTextField filtroProveedor;
    private javax.swing.JComboBox<String> filtroTipoBien;
    private javax.swing.JComboBox<String> filtroTipoIngreso;
    private javax.swing.JTextField filtroUnidad;
    private javax.swing.JFormattedTextField filtroValorFinal;
    private javax.swing.JFormattedTextField filtroValorInicial;
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JTextField textoFiltros;
    // End of variables declaration//GEN-END:variables

}
