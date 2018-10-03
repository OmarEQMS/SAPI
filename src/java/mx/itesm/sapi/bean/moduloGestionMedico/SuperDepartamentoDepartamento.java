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
public class SuperDepartamentoDepartamento implements Serializable{
    private int idSuperDepartamentoDepartamento;
    private int idSuperDepartamento;
    private int idDepartamento;
    private int estatus;

    public int getIdSuperDepartamentoDepartamento() {
        return idSuperDepartamentoDepartamento;
    }

    public void setIdSuperDepartamentoDepartamento(int idSuperDepartamentoDepartamento) {
        this.idSuperDepartamentoDepartamento = idSuperDepartamentoDepartamento;
    }

    public int getIdSuperDepartamento() {
        return idSuperDepartamento;
    }

    public void setIdSuperDepartamento(int idSuperDepartamento) {
        this.idSuperDepartamento = idSuperDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    public SuperDepartamentoDepartamento(){}
    
    @Override
    public String toString(){
        return "idSuperDepartamentoDepartamento [SuperDepartamentoDepartamento:".concat(String.valueOf(idSuperDepartamentoDepartamento)).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    }
    
}
