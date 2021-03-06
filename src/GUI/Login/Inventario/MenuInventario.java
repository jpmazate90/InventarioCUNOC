package GUI.Login.Inventario;

import Exportacion.ExportarPDF;
import GUI.Login.Administracion.MenuAdministracion;
import GUI.Login.Administracion.VerBajaBienes;
import GUI.Login.Administracion.VerTrasladosBien;
import GUI.Login.Login;
import GUI.Login.VistasAuxiliares.AuxiliarEncargado;
import GUI.Login.VistasAuxiliares.AuxiliarProveedor;
import Logica.ManejadorBajaBien;
import Logica.ManejadorCreacionBien;
import Logica.ManejadorPersonal;
import Logica.ManejadorProveedores;
import Logica.ManejadorTiposBien;
import Objetos.EstructuraBien;
import Objetos.PasarString;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    private ManejadorBajaBien manejadorBajaBien;
    private SimpleDateFormat fechaCompleta;
    private SimpleDateFormat fechaTimestamp;
    private boolean esAmbasAreas;

    public MenuInventario(String usuarioActual, boolean esAmbos) {
        initComponents();
        this.usuarioActual = usuarioActual;
        this.esAmbasAreas = esAmbos;
        manejadorTiposBien = new ManejadorTiposBien();
        manejadorCreacionBienes = new ManejadorCreacionBien();
        manejadorBajaBien = new ManejadorBajaBien();
        fechaCompleta = new SimpleDateFormat("yyyy-MM-dd");
        fechaTimestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        llenarFiltros();
        iniciarDatosBienes();
        FiltroFechaFinal.updateUI();
        validarTipoUsuario();

    }

    public void validarTipoUsuario() {
        if (this.esAmbasAreas) {
            this.menuAdministracion.setVisible(true);
        } else {
            this.menuAdministracion.setVisible(false);
        }
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
        jLabel20 = new javax.swing.JLabel();
        textoNoTarjeta = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        textoEncargado = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        textoTipoIngreso = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        textoValor = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        textoProveedor = new javax.swing.JTextField();
        textoDivision = new javax.swing.JTextField();
        botonBaja = new javax.swing.JButton();
        botonTraslado = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonEliminarDatos = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        textoFecha = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        textoEstado = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuAdministracion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AREA DE INVENTARIO");
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
        tablaBienes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBienesMouseClicked(evt);
            }
        });
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

        jLabel20.setText("No Tarjeta");
        desktopPane.add(jLabel20);
        jLabel20.setBounds(430, 680, 100, 18);

        textoNoTarjeta.setEditable(false);
        textoNoTarjeta.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        textoNoTarjeta.setOpaque(false);
        desktopPane.add(textoNoTarjeta);
        textoNoTarjeta.setBounds(530, 670, 200, 35);

        jLabel21.setText("Encargado:");
        desktopPane.add(jLabel21);
        jLabel21.setBounds(430, 730, 90, 18);

        textoEncargado.setEditable(false);
        textoEncargado.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        textoEncargado.setOpaque(false);
        desktopPane.add(textoEncargado);
        textoEncargado.setBounds(530, 720, 200, 35);

        jLabel22.setText("Tipo Ingreso:");
        desktopPane.add(jLabel22);
        jLabel22.setBounds(800, 680, 100, 18);

        textoTipoIngreso.setEditable(false);
        textoTipoIngreso.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        desktopPane.add(textoTipoIngreso);
        textoTipoIngreso.setBounds(910, 670, 180, 35);

        jLabel23.setText("Valor:");
        desktopPane.add(jLabel23);
        jLabel23.setBounds(800, 730, 70, 18);

        textoValor.setEditable(false);
        textoValor.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        desktopPane.add(textoValor);
        textoValor.setBounds(910, 720, 180, 35);

        jLabel24.setText("Fecha Ingreso:");
        desktopPane.add(jLabel24);
        jLabel24.setBounds(1140, 680, 110, 18);

        jLabel25.setText("Proveedor:");
        desktopPane.add(jLabel25);
        jLabel25.setBounds(1140, 730, 100, 18);

        textoProveedor.setEditable(false);
        textoProveedor.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        desktopPane.add(textoProveedor);
        textoProveedor.setBounds(1270, 720, 210, 35);

        textoDivision.setEditable(false);
        textoDivision.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        desktopPane.add(textoDivision);
        textoDivision.setBounds(1600, 670, 210, 35);

        botonBaja.setBackground(new java.awt.Color(92, 138, 184));
        botonBaja.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botonBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha_opt.jpg"))); // NOI18N
        botonBaja.setText("Dar de Baja/Alta");
        botonBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonBajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonBajaMouseExited(evt);
            }
        });
        botonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBajaActionPerformed(evt);
            }
        });
        desktopPane.add(botonBaja);
        botonBaja.setBounds(450, 770, 300, 120);

        botonTraslado.setBackground(new java.awt.Color(92, 138, 184));
        botonTraslado.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botonTraslado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito_opt.jpg"))); // NOI18N
        botonTraslado.setText("Generar Traslado");
        botonTraslado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonTrasladoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonTrasladoMouseExited(evt);
            }
        });
        botonTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTrasladoActionPerformed(evt);
            }
        });
        desktopPane.add(botonTraslado);
        botonTraslado.setBounds(800, 770, 300, 120);

        botonEditar.setBackground(new java.awt.Color(92, 138, 184));
        botonEditar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar_opt.png"))); // NOI18N
        botonEditar.setText("Editar Bien");
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEditarMouseExited(evt);
            }
        });
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        desktopPane.add(botonEditar);
        botonEditar.setBounds(1140, 770, 340, 120);

        botonEliminarDatos.setBackground(new java.awt.Color(135, 146, 158));
        botonEliminarDatos.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botonEliminarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basurero_opt.jpg"))); // NOI18N
        botonEliminarDatos.setMnemonic('E');
        botonEliminarDatos.setText("Eliminar Campos");
        botonEliminarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEliminarDatosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEliminarDatosMouseExited(evt);
            }
        });
        botonEliminarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarDatosActionPerformed(evt);
            }
        });
        desktopPane.add(botonEliminarDatos);
        botonEliminarDatos.setBounds(1510, 770, 280, 120);

        jLabel26.setText("Division:");
        desktopPane.add(jLabel26);
        jLabel26.setBounds(1510, 680, 70, 18);

        textoFecha.setEditable(false);
        textoFecha.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        desktopPane.add(textoFecha);
        textoFecha.setBounds(1270, 670, 210, 35);

        jLabel27.setText("Estado:");
        desktopPane.add(jLabel27);
        jLabel27.setBounds(1510, 730, 80, 18);

        textoEstado.setEditable(false);
        desktopPane.add(textoEstado);
        textoEstado.setBounds(1600, 720, 210, 35);

        botonEliminar.setBackground(new java.awt.Color(98, 138, 184));
        botonEliminar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/papelera_opt.png"))); // NOI18N
        botonEliminar.setText("Eliminar el bien");
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEliminarMouseExited(evt);
            }
        });
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        desktopPane.add(botonEliminar);
        botonEliminar.setBounds(140, 770, 270, 120);

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

        jMenu3.setText("Reportes");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Ver Baja de Bienes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Ver Traslados del bien");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Imprimir Reporte");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        menuBar.add(jMenu3);

        menuAdministracion.setText("Menu de Administracion");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Ir al Menu Administracion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuAdministracion.add(jMenuItem2);

        menuBar.add(menuAdministracion);

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
        recargarTabla();
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

    private void botonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBajaActionPerformed

        bajaBien();
    }//GEN-LAST:event_botonBajaActionPerformed

    private void botonBajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajaMouseExited

        botonBaja.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonBajaMouseExited

    private void botonBajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajaMouseEntered

        botonBaja.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonBajaMouseEntered

    private void botonTrasladoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTrasladoMouseEntered
        botonTraslado.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonTrasladoMouseEntered

    private void botonTrasladoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTrasladoMouseExited
        botonTraslado.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonTrasladoMouseExited

    private void botonEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseEntered
        botonEditar.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonEditarMouseEntered

    private void botonEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseExited
        botonEditar.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonEditarMouseExited

    private void tablaBienesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBienesMouseClicked

        int seleccion = tablaBienes.getSelectedRow();// recoge la selecion

        this.textoNoTarjeta.setText((String) tablaBienes.getValueAt(seleccion, 0));
        this.textoEncargado.setText((String) tablaBienes.getValueAt(seleccion, 8));
        this.textoTipoIngreso.setText((String) tablaBienes.getValueAt(seleccion, 6));
        this.textoValor.setText((String) tablaBienes.getValueAt(seleccion, 11));
        this.textoFecha.setText((String) tablaBienes.getValueAt(seleccion, 5));
        this.textoProveedor.setText((String) tablaBienes.getValueAt(seleccion, 10));
        this.textoDivision.setText((String) tablaBienes.getValueAt(seleccion, 9));
        this.textoEstado.setText((String) tablaBienes.getValueAt(seleccion, 7));


    }//GEN-LAST:event_tablaBienesMouseClicked

    private void botonEliminarDatosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarDatosMouseEntered
        botonEliminarDatos.setBackground(Color.WHITE);
    }//GEN-LAST:event_botonEliminarDatosMouseEntered

    private void botonEliminarDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarDatosMouseExited
        botonEliminarDatos.setBackground(new java.awt.Color(135, 146, 158));

    }//GEN-LAST:event_botonEliminarDatosMouseExited

    private void botonTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTrasladoActionPerformed
        trasladoBien();
    }//GEN-LAST:event_botonTrasladoActionPerformed

    private void botonEliminarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarDatosActionPerformed
        eliminarDatos();
    }//GEN-LAST:event_botonEliminarDatosActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        editarBien();

    }//GEN-LAST:event_botonEditarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MenuAdministracion menu = new MenuAdministracion(this.usuarioActual, esAmbasAreas);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        verBajasBienes();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        verTrasladosBien();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        generarReporte();

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void botonEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseEntered
        botonEliminar.setBackground(Color.WHITE);    }//GEN-LAST:event_botonEliminarMouseEntered

    private void botonEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseExited
        botonEliminar.setBackground(new java.awt.Color(92, 138, 184));
    }//GEN-LAST:event_botonEliminarMouseExited

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarBien();
    }//GEN-LAST:event_botonEliminarActionPerformed

    public void verBajasBienes() {
        VerBajaBienes ver = new VerBajaBienes(this, true, usuarioActual);
        ver.setVisible(true);
    }

    public void verTrasladosBien() {
        String noInventario = this.textoNoTarjeta.getText();
        if (!noInventario.equals("")) {
            VerTrasladosBien ver = new VerTrasladosBien(this, true, this, noInventario, this.usuarioActual);
            ver.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA VER SUS TRASLADOS, SELECCIONA UNO DE LA TABLA DE BIENES");
        }
    }

    public void eliminarBien() {
        String noInventario = this.textoNoTarjeta.getText();
        if (!noInventario.equals("")) {
            int opcion = JOptionPane.showConfirmDialog(null, "SEGURO QUE QUIERES ELIMINAR EL BIEN CON NO DE INVENTARIO: " + noInventario + " ?");
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultado = manejadorBajaBien.eliminarBien(noInventario);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "EL BIEN CON NO DE TARJETA: " + noInventario + " HA SIDO ELIMINADO CORRECTAMENTE");
                    recargarTabla();
                    eliminarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR EL BIEN CON NO DE TARJETA: " + noInventario + ", \n YA SE LE HAN REALIZADO ACCIONES COMO TRASLADOS O BAJAS");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA VER ELIMINARLO, SELECCIONA UNO DE LA TABLA DE BIENES");
        }
    }

    public void generarReporte() {

        if (existenElementosParaImprimir()) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            File archivo = ExportarPDF.usarFileChooser(".pdf");
            if (archivo.getName().equals("null.pdf") == false) {// exporta a html segun el reporte
                double totalActivo = totalActivo();
                int totalRegistros = totalRegistros();
                ArrayList<String> filtrosPrimarios = filtrosPrimarios();
                ArrayList<String> filtrosSecundarios = filtrosSecundarios();
                ExportarPDF.exportarReportes(tablaBienes, totalActivo, totalRegistros, usuarioActual, this.fechaTimestamp.format(new Date()), filtrosPrimarios, filtrosSecundarios, archivo);

            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUNA RUTA PARA GUARDAR EL ARCHIVO, NO SE REALIZARA NINGUNA ACCION");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTEN ELEMENTOS EN LA TABLA PARA REALIZAR UN ARCHIVO DEL REPORTE");
        }
    }

    public double totalActivo() {
        double valor = 0;
        for (int i = 0; i < tablaBienes.getRowCount(); i++) {
            valor += Float.parseFloat((String) tablaBienes.getValueAt(i, 11));
        }
        return valor;
    }

    public int totalRegistros() {
        return this.tablaBienes.getRowCount();
    }

    public boolean existenElementosParaImprimir() {
        return this.tablaBienes.getRowCount() != 0;
    }

    public ArrayList<String> filtrosPrimarios() {
        ArrayList<String> mandar = new ArrayList<>();
        if (!this.filtroNoTarjeta.getText().equals("")) {
            mandar.add("Numero de Tarjeta: " + this.filtroNoTarjeta.getText());
        }
        if (!this.filtroUnidad.getText().equals("")) {
            mandar.add("Unidad Academica+ " + this.filtroUnidad.getText());
        }
        if (this.filtroCheckBoxAnio.isSelected()) {
            mandar.add("Año de Ingreso: " + this.filtroAnio.getYear());
        }
        if (this.filtroTipoBien.getSelectedIndex() != 0) {
            mandar.add("Tipo de Bien: " + this.filtroTipoBien.getSelectedItem().toString());
        }
        if (this.filtroCheckBoxFechaInicial.isSelected()) {
            mandar.add("Fecha Inicial: " + fechaCompleta.format(this.filtroFechaInicial.getDate()));
        }
        if (this.filtroCheckBoxFechaFinal.isSelected()) {
            mandar.add("Fecha Final: " + fechaCompleta.format(this.FiltroFechaFinal.getDate()));
        }
        if (this.filtroTipoIngreso.getSelectedIndex() != 0) {
            mandar.add("Tipo de Ingreso: " + this.filtroTipoIngreso.getSelectedItem().toString());
        }
        if (this.filtroEstadoActual.getSelectedIndex() != 0) {
            mandar.add("Estado Actual: " + this.filtroEstadoActual.getSelectedItem().toString());
        }
        if (!this.filtroEncargadoActual.getText().equals("")) {
            mandar.add("Encargado Actual: " + this.filtroEncargadoActual.getText());
        }
        if (!this.filtroDivision.getText().equals("")) {
            mandar.add("Division: " + this.filtroDivision.getText());
        }
        if (!this.filtroProveedor.getText().equals("")) {
            mandar.add("Proveedor: " + this.filtroProveedor.getText());
        }
        if (!this.filtroValorInicial.getText().equals("")) {
            mandar.add("Valor Inicial: " + this.filtroValorInicial.getText());
        }
        if (!this.filtroValorFinal.getText().equals("")) {
            mandar.add("Valor Final: " + this.filtroValorFinal.getText());
        }
        return mandar;
    }

    public ArrayList<String> filtrosSecundarios() {
        ArrayList<String> mandar = new ArrayList<>();
        if (!textoFiltros.getText().equals("")) {
            mandar.add(filtros.getSelectedItem().toString() + ": " + textoFiltros.getText());
        }
        return mandar;
    }

    public void editarBien() {
        String noTarjeta = this.textoNoTarjeta.getText();
        String estado = this.textoEstado.getText();
        if (estado.equals("1")) {
            if (!noTarjeta.equals("")) {
                EditarBien editar = new EditarBien(this, true, noTarjeta);
                editar.setVisible(true);
                recargarTabla();
                eliminarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA EDITARLO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EL BIEN CON NO DE TARJETA: " + noTarjeta + " ESTA DADO DE BAJA, NO SE PUEDE EDITAR SU INFORMACION");
        }
    }

    public void bajaBien() {
        String noTarjeta = this.textoNoTarjeta.getText();
        String estado = this.textoEstado.getText();
        String division = this.textoDivision.getText();
        String encargado = this.textoEncargado.getText();
        String fecha = this.textoFecha.getText();
        String proveedor = this.textoProveedor.getText();
        String tipoIngreso = this.textoTipoIngreso.getText();
        String valor = this.textoValor.getText();

        if (estado.equals("1")) {
            if (!noTarjeta.equals("")) {
                EstructuraBien bien = new EstructuraBien(noTarjeta, fecha, valor, division, encargado, estado, proveedor, tipoIngreso);
                BajaBien baja = new BajaBien(this, true, bien);
                baja.setVisible(true);
                recargarTabla();
                eliminarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA DARLO DE BAJA");
            }
        } else if(!estado.equals("")){
            int opcion = JOptionPane.showConfirmDialog(null, "QUIERES DAR DE ALTA EL BIEN CON NO DE INVENTARIO: " + noTarjeta + " ?");
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultado = manejadorBajaBien.darDeAltaUnBien(noTarjeta);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "EL BIEN CON NO DE TARJETA: " + noTarjeta + " HA SIDO DADO DE ALTA");
                    recargarTabla();
                    eliminarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO DAR DE ALTA EL BIEN CON NO DE TARJETA: " + noTarjeta + ", PROBLEMAS EN LA BASE DE DATOS");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA REALIZARLE UNA ACCION DE ALTA O BAJA");
        }
    }

    public void trasladoBien() {
        String noTarjeta = this.textoNoTarjeta.getText();
        String encargado = this.textoEncargado.getText();
        String division = this.textoDivision.getText();
        String estado = this.textoEstado.getText();
        if (estado.equals("1")) {

            if (!noTarjeta.equals("")) {
                TrasladoBien traslado = new TrasladoBien(this, true, noTarjeta, encargado, division);
                traslado.setVisible(true);
                recargarTabla();
                eliminarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN BIEN PARA HACERLE UN TRASLADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EL BIEN CON NO DE TARJETA: " + noTarjeta + " ESTA DADO DE BAJA, NO SE LE PUEDE REALIZAR UN TRASLADO");
        }
    }

    public void eliminarDatos() {
        this.textoEncargado.setText("");
        this.textoDivision.setText("");
        this.textoNoTarjeta.setText("");
        this.textoProveedor.setText("");
        this.textoTipoIngreso.setText("");
        this.textoValor.setText("");
        this.textoFecha.setText("");
        this.textoEstado.setText("");
    }

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

        iniciarDatosBienes();
        manejadorCreacionBienes.buscarBien(notarjeta, unidad, anio, tipoBien, noFactura,
                fechaInicial, fechaFinal, tipoIngreso, estadoActual, encargadoActual,
                division, proveedor, valorInicial, valorfinal, modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FiltroFechaFinal;
    private javax.swing.JButton botonBaja;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarDatos;
    private javax.swing.JButton botonTraslado;
    private javax.swing.JDesktopPane desktopPane;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JTable tablaBienes;
    private javax.swing.JTextField textoDivision;
    private javax.swing.JTextField textoEncargado;
    private javax.swing.JTextField textoEstado;
    private javax.swing.JTextField textoFecha;
    private javax.swing.JTextField textoFiltros;
    private javax.swing.JTextField textoNoTarjeta;
    private javax.swing.JTextField textoProveedor;
    private javax.swing.JTextField textoTipoIngreso;
    private javax.swing.JTextField textoValor;
    // End of variables declaration//GEN-END:variables

}
