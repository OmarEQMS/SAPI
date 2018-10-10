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
public class Departamento implements Serializable {
    private int idDepartamento;
    private String nombre;
    private int estatus;
    
    public Departamento(){}
    
     @Override
    public String toString(){
        return "Departamento [Departamento:".concat(String.valueOf(idDepartamento))
                .concat(",nombre:").concat(nombre).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
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
