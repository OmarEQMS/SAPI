/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author A01422575
 */
public class Piso {
    private int idPiso;
    private int idTorreNueva;
    private int piso;
    private int estatus;
    
    public Piso() {}
    
    @Override 
    public String toString(){
        String str= "Piso [idPiso:".concat(String.valueOf(idPiso))
                .concat(",idTorreNueva:").concat(String.valueOf(idTorreNueva))
                .concat(",piso:").concat(String.valueOf(piso))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

    public int getIdTorreNueva() {
        return idTorreNueva;
    }

    public void setIdTorreNueva(int idTorreNueva) {
        this.idTorreNueva = idTorreNueva;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
