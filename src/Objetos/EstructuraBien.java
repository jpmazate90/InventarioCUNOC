/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author jpmazate
 */
public class EstructuraBien {
    
    private String noInventario;
    private String unidadAcademica;
    private String anioIngreso;
    private String tipoBien;
    private String noFactura;
    private String fechaFactura;
    private String fechaIngreso;
    private String noSolicitudCompra;
    private String noOrdenCompra;
    private String noCUR;
    private String valorBien;
    private String division;
    private String encargadoActual;
    private String entidadCompra;
    private String estadoActual;
    private String proveedor;
    private String tipoIngreso;
    private String descripcion;

    public EstructuraBien(String noInventario) {
        this.noInventario = noInventario;
    }

    public EstructuraBien(String noInventario, String fechaIngreso, String valorBien, String division, String encargadoActual, String estadoActual, String proveedor, String tipoIngreso) {
        this.noInventario = noInventario;
        this.fechaIngreso = fechaIngreso;
        this.valorBien = valorBien;
        this.division = division;
        this.encargadoActual = encargadoActual;
        this.estadoActual = estadoActual;
        this.proveedor = proveedor;
        this.tipoIngreso = tipoIngreso;
    }

    
    
    
//    noTarjeta = this.textoNoTarjeta.getText();
//        String estado = this.textoEstado.getText();
//        String division = this.textoDivision.getText();
//        String encargado = this.textoEncargado.getText();
//        String fecha = this.textoFecha.getText();
//        String proveedor = this.textoProveedor.getText();
//        String tipoIngreso = this.textoTipoIngreso.getText();
//        String valor

    public EstructuraBien(String noInventario, String unidadAcademica, String anioIngreso, String tipoBien, String noFactura, String fechaFactura, String fechaIngreso, String noSolicitudCompra, String noOrdenCompra, String noCUR, String valorBien, String division, String encargadoActual, String entidadCompra, String estadoActual, String proveedor, String tipoIngreso, String descripcion) {
        this.noInventario = noInventario;
        this.unidadAcademica = unidadAcademica;
        this.anioIngreso = anioIngreso;
        this.tipoBien = tipoBien;
        this.noFactura = noFactura;
        this.fechaFactura = fechaFactura;
        this.fechaIngreso = fechaIngreso;
        this.noSolicitudCompra = noSolicitudCompra;
        this.noOrdenCompra = noOrdenCompra;
        this.noCUR = noCUR;
        this.valorBien = valorBien;
        this.division = division;
        this.encargadoActual = encargadoActual;
        this.entidadCompra = entidadCompra;
        this.estadoActual = estadoActual;
        this.proveedor = proveedor;
        this.tipoIngreso = tipoIngreso;
        this.descripcion = descripcion;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(String unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public String getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(String anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(String tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNoSolicitudCompra() {
        return noSolicitudCompra;
    }

    public void setNoSolicitudCompra(String noSolicitudCompra) {
        this.noSolicitudCompra = noSolicitudCompra;
    }

    public String getNoOrdenCompra() {
        return noOrdenCompra;
    }

    public void setNoOrdenCompra(String noOrdenCompra) {
        this.noOrdenCompra = noOrdenCompra;
    }

    public String getNoCUR() {
        return noCUR;
    }

    public void setNoCUR(String noCUR) {
        this.noCUR = noCUR;
    }

    public String getValorBien() {
        return valorBien;
    }

    public void setValorBien(String valorBien) {
        this.valorBien = valorBien;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEncargadoActual() {
        return encargadoActual;
    }

    public void setEncargadoActual(String encargadoActual) {
        this.encargadoActual = encargadoActual;
    }

    public String getEntidadCompra() {
        return entidadCompra;
    }

    public void setEntidadCompra(String entidadCompra) {
        this.entidadCompra = entidadCompra;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
