/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;

import java.io.Serializable;

/**
 *
 * @author Angel GTZ
 */
public class Sexo implements Serializable{
    private int idSexo;
    private String nombre;
    private int estatus;

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdSexo() {
        return idSexo;
    }

  
    
    public String getNombre() {
        return nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
