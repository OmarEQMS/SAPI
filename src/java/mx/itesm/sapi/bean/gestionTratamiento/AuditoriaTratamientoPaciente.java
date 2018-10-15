/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class AuditoriaTratamientoPaciente implements Serializable{
   
    private int idAuditoriaTratamientoPaciente;
    private int idTratamientoPaciente;
    private int idEmpleado;
    private Timestamp fecha;
    private int estatus;

    public AuditoriaTratamientoPaciente() {
    }

    public int getIdAuditoriaTratamientoPaciente() {
        return idAuditoriaTratamientoPaciente;
    }

    public void setIdAuditoriaTratamientoPaciente(int idAuditoriaTratamientoPaciente) {
        this.idAuditoriaTratamientoPaciente = idAuditoriaTratamientoPaciente;
    }

    public int getIdTratamientoPaciente() {
        return idTratamientoPaciente;
    }

    public void setIdTratamientoPaciente(int idTratamientoPaciente) {
        this.idTratamientoPaciente = idTratamientoPaciente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

   
    
    @Override
    public String toString(){
        return "ID :".concat(Integer.toString(idAuditoriaTratamientoPaciente)).concat(", IdTratamientoPaciente: ").concat(Integer.toString(idTratamientoPaciente)).concat(", idEmpleado")
                .concat(Integer.toString(idEmpleado).concat(", fecha: ").concat(fecha.toString()).concat(" ,estatus: ").concat(Integer.toString(estatus)) );
    }
    
    
}
