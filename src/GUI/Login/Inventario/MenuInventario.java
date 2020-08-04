package GUI.Login.Inventario;

import GUI.Login.Login;
import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import GUI.Login.VistasAuxiliares.AuxiliarProveedor;
import Logica.ManejadorTiposBien;
import Objetos.PasarString;

/**
 *
 * @author jpmazate
 */
public class MenuInventario extends javax.swing.JFrame {

    private String usuarioActual;
    private String codigoBuscar;
    private ManejadorTiposBien manejadorTiposBien;

    public MenuInventario(String usuarioActual) {
        initComponents();
        this.usuarioActual = usuarioActual;
        manejadorTiposBien = new ManejadorTiposBien();
        llenarFiltros();

    }

    public void llenarFiltros() {
        this.boxTiposBienes.insertItemAt("TODOS", 0);
        manejadorTiposBien.llenarCodigos(this.boxTiposBienes);

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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        filtroEncargadoActual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField6 = new javax.swing.JTextField();
        filtroProveedor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBienes = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        boxTiposBienes = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        desktopPane.add(jTextField1);
        jTextField1.setBounds(150, 130, 200, 35);
        desktopPane.add(jTextField2);
        jTextField2.setBounds(150, 170, 200, 35);
        desktopPane.add(jYearChooser1);
        jYearChooser1.setBounds(150, 210, 200, 18);
        desktopPane.add(jTextField4);
        jTextField4.setBounds(150, 270, 200, 35);
        desktopPane.add(jDateChooser1);
        jDateChooser1.setBounds(150, 360, 210, 36);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "COMPRA", "TRASLADO", "DONACION" }));
        desktopPane.add(jComboBox1);
        jComboBox1.setBounds(150, 410, 200, 35);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "DE BAJA", "ACTIVO", " " }));
        desktopPane.add(jComboBox2);
        jComboBox2.setBounds(150, 450, 200, 35);
        desktopPane.add(filtroEncargadoActual);
        filtroEncargadoActual.setBounds(150, 490, 150, 35);

        jLabel12.setText("Fecha Inicial:");
        desktopPane.add(jLabel12);
        jLabel12.setBounds(10, 320, 150, 18);
        desktopPane.add(jDateChooser2);
        jDateChooser2.setBounds(150, 310, 210, 36);
        desktopPane.add(jTextField6);
        jTextField6.setBounds(150, 530, 200, 35);
        desktopPane.add(filtroProveedor);
        filtroProveedor.setBounds(150, 580, 150, 35);

        jButton1.setText("BUSCAR");
        desktopPane.add(jButton1);
        jButton1.setBounds(150, 630, 200, 28);

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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        desktopPane.add(jComboBox3);
        jComboBox3.setBounds(510, 90, 180, 35);

        jTextField8.setText("jTextField8");
        desktopPane.add(jTextField8);
        jTextField8.setBounds(700, 90, 1110, 35);

        desktopPane.add(boxTiposBienes);
        boxTiposBienes.setBounds(150, 230, 200, 35);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTiposBienes;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField filtroEncargadoActual;
    private javax.swing.JTextField filtroProveedor;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTable tablaBienes;
    // End of variables declaration//GEN-END:variables

}
