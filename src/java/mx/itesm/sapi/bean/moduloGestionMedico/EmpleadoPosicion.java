<<<<<<< HEAD
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
 * @author feror
 */
public class EmpleadoPosicion implements Serializable {
    private int idEmpleadoPosicion;
    private int idEmpleado;
    private int idPosicion;
    private Timestamp inicio;
    private int estatus;
    
    public EmpleadoPosicion(){}
    
    @Override
    public String toString(){
        return "EmpleadoPosicion [idEmpleadoPosicion:".concat(String.valueOf(idEmpleadoPosicion))
                .concat(",inicio:").concat(String.valueOf(inicio)).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
=======
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
 * @author feror
 */
public class EmpleadoPosicion implements Serializable {
    private int idEmpleadoPosicion;
    private int idEmpleado;
    private int idPosicion;
    private Timestamp inicio;
    private int estatus;
    
    public EmpleadoPosicion(){}
    
    @Override
    public String toString(){
        return "EmpleadoPosicion [idEmpleadoPosicion:".concat(String.valueOf(idEmpleadoPosicion))
                .concat(",inicio:").concat(String.valueOf(inicio)).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
>>>>>>> Login
