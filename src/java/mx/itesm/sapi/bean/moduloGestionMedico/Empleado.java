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
    private int idCuenta;
    private String noEmpleado;
    private int estatus;
    private int adscrito;
    
    public Empleado(){}
    
    @Override
    public String toString(){
        return "Empleado[Empleado:".concat(String.valueOf(idEmpleado))
               .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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

    public int getAdscrito() {
        return adscrito;
    }

    public void setAdscrito(int adscrito) {
        this.adscrito = adscrito;
    }
}
