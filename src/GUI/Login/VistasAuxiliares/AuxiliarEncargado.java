package GUI.Login.VistasAuxiliares;

import Logica.ManejadorPersonal;
import Objetos.PasarString;
import Tablas.GeneradorModelos;
import Tablas.TablaModelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jpmazate
 */
public class AuxiliarEncargado extends javax.swing.JDialog {

    private TableRowSorter tablaSorteada;
    private TablaModelo modelo;
    private ManejadorPersonal manejadorPersonal;
    private SimpleDateFormat formateador;
    
    private PasarString resultado;

    public AuxiliarEncargado(java.awt.Frame parent, boolean modal, PasarString resultado) {
        super(parent, modal);
        initComponents();
        modelo = new TablaModelo();
        manejadorPersonal = new ManejadorPersonal();
        this.resultado = resultado;
        asignarDatosPersonal();
    }
    
     public void asignarDatosPersonal() {
        GeneradorModelos.modeloAuxiliarEncargado(modelo);
        GeneradorModelos.asignarModeloTabla(modelo, tablaEncargado);
        manejadorPersonal.llenarAuxiliarEncaragdo(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEncargado = new javax.swing.JTable();
        textoFiltros = new javax.swing.JTextField();
        filtros = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoNo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SELECCIONAR ENCARGADO");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("SELECCIONA A ALGUIEN DEL PERSONAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel2.setText("FILTRA POR:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 98, -1, -1));

        tablaEncargado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEncargado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEncargadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEncargado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 131, 813, 239));

        textoFiltros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoFiltrosKeyTyped(evt);
            }
        });
        getContentPane().add(textoFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 90, 450, -1));

        filtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Personal", "Nombre Completo", "Dpi", "Area Trabajo" }));
        filtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtrosItemStateChanged(evt);
            }
        });
        getContentPane().add(filtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 90, 252, -1));

        jLabel3.setText("No Personal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 404, -1, -1));

        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 448, -1, -1));

        textoNo.setEditable(false);
        getContentPane().add(textoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 396, 162, -1));

        textoNombre.setEditable(false);
        getContentPane().add(textoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 162, -1));

        jButton1.setText("Escoger");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 399, 113, 76));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User2_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        tablaEncargado.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_textoFiltrosKeyTyped

    private void filtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtrosItemStateChanged
         int valor = this.filtros.getSelectedIndex();
// sortea la tabla
        tablaSorteada = new TableRowSorter(modelo);
        tablaSorteada.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltros.getText(), valor));
        tablaEncargado.setRowSorter(tablaSorteada);
    }//GEN-LAST:event_filtrosItemStateChanged

    private void tablaEncargadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEncargadoMouseClicked
         int seleccion = tablaEncargado.getSelectedRow();// recoge la selecion
        this.textoNo.setText((String) tablaEncargado.getValueAt(seleccion, 0));
        this.textoNombre.setText((String) tablaEncargado.getValueAt(seleccion, 1));
        
    }//GEN-LAST:event_tablaEncargadoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       devolverResultado();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void devolverResultado(){
        String nombre = this.textoNombre.getText();
        String no = this.textoNo.getText();
        if(!no.equals("")){
            this.resultado.setValor(no);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN ELEMENTO");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEncargado;
    private javax.swing.JTextField textoFiltros;
    private javax.swing.JTextField textoNo;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
