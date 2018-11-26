/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionMedico;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author shannonrosas
 */
public class MedicoPosicion implements Serializable {
    
    private int idEmpleadoPosicion;
    private int idEmpleado;
    private int idPosicion;
    private Timestamp inicio;
    private Timestamp termino;
    private int estatus;
    
    public MedicoPosicion(){}

    @Override
    public String toString() {
        return "MedicoPosicion{" + "idEmpleadoPosicion=" + idEmpleadoPosicion + ", idEmpleado=" + idEmpleado + ", idPosicion=" + idPosicion + ", inicio=" + inicio + ", termino=" + termino + ", estatus=" + estatus + '}';
    }

    public int getIdEmpleadoPosicion() {
        return idEmpleadoPosicion;
    }

    public void setIdEmpleadoPosicion(int idEmpleadoPosicion) {
        this.idEmpleadoPosicion = idEmpleadoPosicion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getTermino() {
        return termino;
    }

    public void setTermino(Timestamp termino) {
        this.termino = termino;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
