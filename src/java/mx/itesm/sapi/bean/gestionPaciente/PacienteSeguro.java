/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Oscar Miranda
 */
public class PacienteSeguro {
    
    private int idPacienteSeguro;
    private int idPaciente;
    private int idSeguro;
    private String noSeguro;
    private int estatus;
    
    public PacienteSeguro() {}

    @Override 
    public String toString(){
        String str= "PacienteSeguro [idPacienteSeguro:".concat(String.valueOf(idPacienteSeguro))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idSeguro:").concat(String.valueOf(idSeguro))
                .concat(",noSeguro:").concat(noSeguro)
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdPacienteSeguro() {
        return idPacienteSeguro;
    }

    public void setIdPacienteSeguro(int idPacienteSeguro) {
        this.idPacienteSeguro = idPacienteSeguro;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNoSeguro() {
        return noSeguro;
    }

    public void setNoSeguro(String noSeguro) {
        this.noSeguro = noSeguro;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
