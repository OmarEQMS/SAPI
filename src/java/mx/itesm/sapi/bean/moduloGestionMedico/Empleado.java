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
public class Empleado implements Serializable{
    
    private int idEmpleado;
    private int idDepartamentoDepartamentoInterno;
    private String noEmpleado;
    private int estatus;
    private int idCuenta; 
    
    public Empleado(){}
    
    @Override
    public String toString(){
        return "Empleado[Empleado:".concat(String.valueOf(idEmpleado))
               .concat(",estatus:").concat(String.valueOf(estatus)).concat(",NoEmpleado:").concat(noEmpleado).concat("]");

    } 

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdDepartamentoDepartamentoInterno() {
        return idDepartamentoDepartamentoInterno;
    }

    public void setIdDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno) {
        this.idDepartamentoDepartamentoInterno = idDepartamentoDepartamentoInterno;
    }

    public String getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(String noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    
   
}