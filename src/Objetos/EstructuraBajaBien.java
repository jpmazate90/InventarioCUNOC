/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;
import java.sql.Timestamp;


/**
 *
 * @author jpmazate
 */
public class EstructuraBajaBien {
    
    private String noInventario;
    private String noAcuerdoConsejo;
    private String noReferenciaAuditoria;
    private Timestamp fechaBaja;

    public EstructuraBajaBien(String noInventario, String noAcuerdoConsejo, String noReferenciaAuditoria, Timestamp fechaBaja) {
        this.noInventario = noInventario;
        this.noAcuerdoConsejo = noAcuerdoConsejo;
        this.noReferenciaAuditoria = noReferenciaAuditoria;
        this.fechaBaja = fechaBaja;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public String getNoAcuerdoConsejo() {
        return noAcuerdoConsejo;
    }

    public void setNoAcuerdoConsejo(String noAcuerdoConsejo) {
        this.noAcuerdoConsejo = noAcuerdoConsejo;
    }

    public String getNoReferenciaAuditoria() {
        return noReferenciaAuditoria;
    }

    public void setNoReferenciaAuditoria(String noReferenciaAuditoria) {
        this.noReferenciaAuditoria = noReferenciaAuditoria;
    }

    public Timestamp getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Timestamp fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

   
    
    
    
    
}
