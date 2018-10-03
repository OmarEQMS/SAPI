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
public class SuperDepartamento implements Serializable{
    
    private int idSuperDepartamento;
    private int idSuperDepartamentoPadre;
    private String nombre;
    private int estatus;
    
    public SuperDepartamento(){}
    
    @Override
    public String toString(){
        return "SuperDepartamento [SuperDepartamento:".concat(String.valueOf(idSuperDepartamento)).concat(",nombre:").concat(nombre).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    }

    public int getIdSuperDepartamento() {
        return idSuperDepartamento;
    }

    public void setIdSuperDepartamento(int idSuperDepartamento) {
        this.idSuperDepartamento = idSuperDepartamento;
    }

    public int getIdSuperDepartamentoPadre() {
        return idSuperDepartamentoPadre;
    }

    public void setIdSuperDepartamentoPadre(int idSuperDepartamentoPadre) {
        this.idSuperDepartamentoPadre = idSuperDepartamentoPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
