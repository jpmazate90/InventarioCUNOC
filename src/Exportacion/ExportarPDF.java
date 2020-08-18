package Exportacion;

import Enumerados.EnumeradoReporte;
import Tablas.TablaModelo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ExportarPDF {
    // sirve para exportar la factura

    public static void exportarReportes(JTable modelo, double totalActivo, int totalRegistros, String usuarioAdministrador, String fechaReporte, ArrayList<String> filtrosPrimarios, ArrayList<String> filtrosSecundarios, File archivo) {
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(archivo));
            document.open();
            // craea un docuent
            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(9);
            Image imagen = Image.getInstance("src/Imagenes/logoUsac.png");
            imagen.setAlignment(Element.ALIGN_RIGHT);
            document.add(imagen);
            Paragraph nombreReporte = new Paragraph("REPORTE DE INVENTARIO \n\n", FontFactory.getFont("arial", 20, Font.BOLD));
            nombreReporte.setAlignment(Element.ALIGN_CENTER);
            document.add(nombreReporte);

            Paragraph fechaR = new Paragraph("FECHA Y HORA QUE SE REALIZO EL REPORTE: " + fechaReporte + "\n\n");
            document.add(fechaR);

            Paragraph usuarioAdmin = new Paragraph("USUARIO QUE REALIZO EL REPORTE: " + usuarioAdministrador + "\n\n");
            document.add(usuarioAdmin);

            String mensajeFiltrosPrimarios = "";
            for (int i = 0; i < filtrosPrimarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosPrimarios = mensajeFiltrosPrimarios + valor + ".- " + filtrosPrimarios.get(i) + "\n";
            }
            if (mensajeFiltrosPrimarios.equals("")) {
                mensajeFiltrosPrimarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltros = new Paragraph("FILTROS PRIMARIOS APLICADOS: \n" + mensajeFiltrosPrimarios + "\n");
            document.add(parrafoFiltros);

            String mensajeFiltrosSecundarios = "";
            for (int i = 0; i < filtrosSecundarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosSecundarios = mensajeFiltrosSecundarios + valor + ".- " + filtrosSecundarios.get(i) + "\n";
            }
            if (mensajeFiltrosSecundarios.equals("")) {
                mensajeFiltrosSecundarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltrosSecundarios = new Paragraph("FILTROS SECUNDARIOS APLICADOS: \n" + mensajeFiltrosSecundarios + "\n");
            document.add(parrafoFiltrosSecundarios);

            Paragraph parrafoTotalBienes = new Paragraph("TOTAL DE BIENES EN EL REPORTE: " + totalRegistros + "\n\n   ");
            document.add(parrafoTotalBienes);

            Paragraph parrafoTotalActivo = new Paragraph("TOTAL DE ACTIVO: " + totalActivo + "\n\n");
            document.add(parrafoTotalActivo);

//            PdfPCell celda3 = new PdfPCell(new Paragraph("TOTAL DE BIENES EN EL REPORTE: "+totalRegistros));
//            celda3.setColspan(12);
//            table.addCell(celda3);
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell(new Paragraph("NO\nINVENTARIO", FontFactory.getFont("arial", 6, Font.BOLD)));
            // table.addCell(new Paragraph("UNIDAD", FontFactory.getFont("arial", 6, Font.BOLD)));
            //table.addCell(new Paragraph("ANIO INGRESO", FontFactory.getFont("arial", 22, Font.BOLD)));
            table.addCell(new Paragraph("TIPO\nBIEN", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("INGRESO", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("TIPO\nINGRESO", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("ESTADO", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("ENCARGADO", FontFactory.getFont("arial", 6, Font.BOLD)));
            //table.addCell(new Paragraph("DIVISION", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("PROVEEDOR", FontFactory.getFont("arial", 6, Font.BOLD)));
            table.addCell(new Paragraph("VALOR", FontFactory.getFont("arial", 6, Font.BOLD)));

            for (int i = 0; i < modelo.getRowCount(); i++) {
                table.addCell(new Paragraph(modelo.getValueAt(i, 0).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                //table.addCell(new Paragraph(modelo.getValueAt(i, 1).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                //table.addCell(new Paragraph(modelo.getValueAt(i, 2).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 3).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                if (modelo.getValueAt(i, 4) == null) {
                    table.addCell(new Paragraph("NO APLICA", FontFactory.getFont("arial", 6, Font.ITALIC)));
                } else {
                    table.addCell(new Paragraph(modelo.getValueAt(i, 4).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                }
                table.addCell(new Paragraph(modelo.getValueAt(i, 5).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 6).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 7).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 8).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                // table.addCell(new Paragraph(modelo.getValueAt(i, 9).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 10).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 11).toString(), FontFactory.getFont("arial", 6, Font.ITALIC)));
            }

            document.add(table);
            document.add(finDePagina());
            document.close();
            JOptionPane.showMessageDialog(null, "Se genero el archivo pdf del reporte correctamente");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

            System.err.println("Ocurrio un error al crear el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportarReporteTraslado(JTable modelo, String noInventario, int totalRegistros, String usuarioAdministrador, String fechaReporte, ArrayList<String> filtrosPrimarios, ArrayList<String> filtrosSecundarios, File archivo) {
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(archivo));
            document.open();

            PdfPTable table = new PdfPTable(7);
            Image imagen = Image.getInstance("src/Imagenes/logoUsac.png");
            imagen.setAlignment(Element.ALIGN_RIGHT);
            document.add(imagen);
            Paragraph nombreReporte = new Paragraph("REPORTE DE TRASLADO DEL BIEN CON NUMERO DE INVENTARIO: " + noInventario + "\n\n", FontFactory.getFont("arial", 20, Font.BOLD));
            nombreReporte.setAlignment(Element.ALIGN_CENTER);
            document.add(nombreReporte);

            Paragraph fechaR = new Paragraph("FECHA Y HORA QUE SE REALIZO EL REPORTE: " + fechaReporte + "\n\n");
            document.add(fechaR);

            Paragraph usuarioAdmin = new Paragraph("USUARIO QUE REALIZO EL REPORTE: " + usuarioAdministrador + "\n\n");
            document.add(usuarioAdmin);

            String mensajeFiltrosPrimarios = "";
            for (int i = 0; i < filtrosPrimarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosPrimarios = mensajeFiltrosPrimarios + valor + ".- " + filtrosPrimarios.get(i) + "\n";
            }
            if (mensajeFiltrosPrimarios.equals("")) {
                mensajeFiltrosPrimarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltros = new Paragraph("FILTROS PRIMARIOS APLICADOS: \n" + mensajeFiltrosPrimarios + "\n");
            document.add(parrafoFiltros);

            String mensajeFiltrosSecundarios = "";
            for (int i = 0; i < filtrosSecundarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosSecundarios = mensajeFiltrosSecundarios + valor + ".- " + filtrosSecundarios.get(i) + "\n";
            }
            if (mensajeFiltrosSecundarios.equals("")) {
                mensajeFiltrosSecundarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltrosSecundarios = new Paragraph("FILTROS SECUNDARIOS APLICADOS: \n" + mensajeFiltrosSecundarios + "\n");
            document.add(parrafoFiltrosSecundarios);

            Paragraph parrafoTotalBienes = new Paragraph("TOTAL DE REGISTROS EN EL REPORTE: " + totalRegistros + "\n\n   ");
            document.add(parrafoTotalBienes);

//            PdfPCell celda3 = new PdfPCell(new Paragraph("TOTAL DE BIENES EN EL REPORTE: "+totalRegistros));
//            celda3.setColspan(12);
//            table.addCell(celda3);
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell(new Paragraph("ID", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("NO\nINVENTARIO", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("RESPONSABLE\n NUEVO", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("RESPONSABLE\n ANTERIOR", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("FECHA\nTRASLADO", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("MOTIVO\nTRASLADO", FontFactory.getFont("arial", 7, Font.BOLD)));
            table.addCell(new Paragraph("DIVISION", FontFactory.getFont("arial", 7, Font.BOLD)));

            for (int i = 0; i < modelo.getRowCount(); i++) {
                table.addCell(new Paragraph(modelo.getValueAt(i, 0).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 1).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 2).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 3).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 4).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 5).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 6).toString(), FontFactory.getFont("arial", 7, Font.ITALIC)));
            }

            document.add(table);
            document.add(finDePagina());
            document.close();
            JOptionPane.showMessageDialog(null, "Se genero el archivo pdf del reporte correctamente");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

            System.err.println("Ocurrio un error al crear el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportarReporteBaja(JTable modelo, int totalRegistros, String usuarioAdministrador, String fechaReporte, ArrayList<String> filtrosPrimarios, ArrayList<String> filtrosSecundarios, File archivo) {
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(archivo));
            document.open();
            PdfPTable table = new PdfPTable(5);
            Image imagen = Image.getInstance("src/Imagenes/logoUsac.png");
            imagen.setAlignment(Element.ALIGN_RIGHT);
            document.add(imagen);
            Paragraph nombreReporte = new Paragraph("REPORTE DE BAJA DE BIENES \n\n", FontFactory.getFont("arial", 20, Font.BOLD));
            nombreReporte.setAlignment(Element.ALIGN_CENTER);
            document.add(nombreReporte);

            Paragraph fechaR = new Paragraph("FECHA Y HORA QUE SE REALIZO EL REPORTE: " + fechaReporte + "\n\n");
            document.add(fechaR);

            Paragraph usuarioAdmin = new Paragraph("USUARIO QUE REALIZO EL REPORTE: " + usuarioAdministrador + "\n\n");
            document.add(usuarioAdmin);

            String mensajeFiltrosPrimarios = "";
            for (int i = 0; i < filtrosPrimarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosPrimarios = mensajeFiltrosPrimarios + valor + ".- " + filtrosPrimarios.get(i) + "\n";
            }
            if (mensajeFiltrosPrimarios.equals("")) {
                mensajeFiltrosPrimarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltros = new Paragraph("FILTROS PRIMARIOS APLICADOS: \n" + mensajeFiltrosPrimarios + "\n");
            document.add(parrafoFiltros);

            String mensajeFiltrosSecundarios = "";
            for (int i = 0; i < filtrosSecundarios.size(); i++) {
                int valor = i + 1;
                mensajeFiltrosSecundarios = mensajeFiltrosSecundarios + valor + ".- " + filtrosSecundarios.get(i) + "\n";
            }
            if (mensajeFiltrosSecundarios.equals("")) {
                mensajeFiltrosSecundarios = "1.- NO SE APLICARON FILTROS\n";
            }
            Paragraph parrafoFiltrosSecundarios = new Paragraph("FILTROS SECUNDARIOS APLICADOS: \n" + mensajeFiltrosSecundarios + "\n");
            document.add(parrafoFiltrosSecundarios);

            Paragraph parrafoTotalBienes = new Paragraph("TOTAL DE REGISTROS EN EL REPORTE: " + totalRegistros + "\n\n   ");
            document.add(parrafoTotalBienes);

            table.addCell(new Paragraph("ID", FontFactory.getFont("arial", 9, Font.BOLD)));
            table.addCell(new Paragraph("NO\nINVENTARIO", FontFactory.getFont("arial", 9, Font.BOLD)));
            table.addCell(new Paragraph("NO\nACUERDO\nCONSEJO", FontFactory.getFont("arial", 9, Font.BOLD)));
            table.addCell(new Paragraph("NO\nREFRENCIA\nAUDITORIA", FontFactory.getFont("arial", 9, Font.BOLD)));
            table.addCell(new Paragraph("FECHA\nBAJA", FontFactory.getFont("arial", 9, Font.BOLD)));

            for (int i = 0; i < modelo.getRowCount(); i++) {
                table.addCell(new Paragraph(modelo.getValueAt(i, 0).toString(), FontFactory.getFont("arial", 9, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 1).toString(), FontFactory.getFont("arial", 9, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 2).toString(), FontFactory.getFont("arial", 9, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 3).toString(), FontFactory.getFont("arial", 9, Font.ITALIC)));
                table.addCell(new Paragraph(modelo.getValueAt(i, 4).toString(), FontFactory.getFont("arial", 9, Font.ITALIC)));
            }

            document.add(table);
            document.add(finDePagina());

            document.close();
            JOptionPane.showMessageDialog(null, "Se genero el archivo pdf del reporte correctamente");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

            System.err.println("Ocurrio un error al crear el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Paragraph finDePagina() {
        Paragraph finalPagina = new Paragraph("\n\nDepartamento de Tesoreria CUNOC, Area de Manejo de Inventarios", FontFactory.getFont("arial", 10, Font.BOLD));
        return finalPagina;
    }

    // usa el file chooser
    public static File usarFileChooser(String extension) {
        JFileChooser guardarComo = new JFileChooser();
        guardarComo.setApproveButtonText("Guardar");
        guardarComo.showSaveDialog(null);
        File archivo = new File(guardarComo.getSelectedFile() + extension);
        return archivo;
    }

}
