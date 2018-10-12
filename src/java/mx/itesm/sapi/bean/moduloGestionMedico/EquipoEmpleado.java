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
public class EquipoEmpleado implements Serializable{
    
   private int idEquipoEmpleado;
   private int idEquipo;
   private int idEmpleado;
   private String estatus;
   
   public EquipoEmpleado(){}
   
    @Override
    public String toString(){
        return "EquipoEmpleado[idEquipoEmpleado:".concat(String.valueOf(idEquipoEmpleado))
                .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdEquipoEmpleado() {
        return idEquipoEmpleado;
    }

    public void setIdEquipoEmpleado(int idEquipoEmpleado) {
        this.idEquipoEmpleado = idEquipoEmpleado;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
   
    
}
