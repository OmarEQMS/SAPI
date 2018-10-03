/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Diego
 */
public class AuditoriaRegistroDiagnostico implements Serializable{
    private int idAuditoriaRegistroDiagnostico;
    private int idRegistroDiagnostico;
    private int idEmpleado;
    private Date fecha;
    private int estatus;

    public int getIdAuditoriaRegistroDiagnostico() {
        return idAuditoriaRegistroDiagnostico;
    }

    public void setIdAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico) {
        this.idAuditoriaRegistroDiagnostico = idAuditoriaRegistroDiagnostico;
    }

    public int getIdRegistroDiagnostico() {
        return idRegistroDiagnostico;
    }

    public void setIdRegistroDiagnostico(int idRegistroDiagnostico) {
        this.idRegistroDiagnostico = idRegistroDiagnostico;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
