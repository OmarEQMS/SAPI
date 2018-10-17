/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionTratamiento;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class FarmacoTipoTratamiento implements Serializable {
    
    private int idFarmacoTipoTratamiento;
    private int idFarmaco;
    private int idTipoTratamiento;
    private int estatus;

    public FarmacoTipoTratamiento() {
    }

    public int getIdFarmacoTipoTratamiento() {
        return idFarmacoTipoTratamiento;
    }

    public void setIdFarmacoTipoTratamiento(int idFarmacoTipoTratamiento) {
        this.idFarmacoTipoTratamiento = idFarmacoTipoTratamiento;
    }

    public int getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(int idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public int getIdTipoTratamiento() {
        return idTipoTratamiento;
    }

    public void setIdTipoTratamiento(int idTipoTratamiento) {
        this.idTipoTratamiento = idTipoTratamiento;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
    
    @Override
    public String toString(){
        return "ID: ".concat(Integer.toString(idFarmacoTipoTratamiento)).concat(", IdFarmaco: ").concat(Integer.toString(idFarmaco)).
                concat(", IdTipoTratamiento: ").concat(Integer.toString(idTipoTratamiento)).concat(", status: ").concat(Integer.toString(estatus));
    }
    
}
