/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class EtapaClinica implements Serializable{
    private int idEtapaClinica;
    private String nombre;
    private int status;

    public int getIdEtapaClinica() {
        return idEtapaClinica;
    }

    public void setIdEtapaClinica(int idEtapaClinica) {
        this.idEtapaClinica = idEtapaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
