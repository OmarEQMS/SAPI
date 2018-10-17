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
public class RegistroDiagnostico implements Serializable{
    private int idRegistroDiagnostico;
    private Date fecha;
    private int previoDiagnostico;
    private int idPaciente;
    private int idEtapaClinica;
    private int idRegistroTNM;
    private int estatus;

    @Override
    public String toString() {
        return "RegistroDiagnostico{" + "idRegistroDiagnostico=" + idRegistroDiagnostico + ", fecha=" + fecha + ", previoDiagnostico=" + previoDiagnostico + ", idPaciente=" + idPaciente + ", idEtapaClinica=" + idEtapaClinica + ", idRegistroTNM=" + idRegistroTNM + ", estatus=" + estatus + '}';
    }

    public int getIdRegistroDiagnostico() {
        return idRegistroDiagnostico;
    }

    public void setIdRegistroDiagnostico(int idRegistroDiagnostico) {
        this.idRegistroDiagnostico = idRegistroDiagnostico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPrevioDiagnostico() {
        return previoDiagnostico;
    }

    public void setPrevioDiagnostico(int previoDiagnostico) {
        this.previoDiagnostico = previoDiagnostico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEtapaClinica() {
        return idEtapaClinica;
    }

    public void setIdEtapaClinica(int idEtapaClinica) {
        this.idEtapaClinica = idEtapaClinica;
    }

    public int getIdRegistroTNM() {
        return idRegistroTNM;
    }

    public void setIdRegistroTNM(int idRegistroTNM) {
        this.idRegistroTNM = idRegistroTNM;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
