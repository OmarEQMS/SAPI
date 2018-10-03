/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionMedico;

import java.io.Serializable;

/**
 *
 * @author feror
 */
public class CitaEmpleado implements Serializable {
    
    private int idCitaEmpleado;
    private int idCita;
    private int idEmpleado;
    private int estatus;
    
    
    public CitaEmpleado(){}
    
    @Override
    public String toString(){
        return "CitaEmpleado[CitaEmpleado:".concat(String.valueOf(idCitaEmpleado))
                .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdCitaEmpleado() {
        return idCitaEmpleado;
    }

    public void setIdCitaEmpleado(int idCitaEmpleado) {
        this.idCitaEmpleado = idCitaEmpleado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
