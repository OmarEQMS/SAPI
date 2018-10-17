/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Alex
 */
public class PacienteAlergia {

    private int idPacienteAlergia;
    private int idPaciente;
    private int idAlergia;
    private int estatus;
    
    public PacienteAlergia() {}

    @Override
    public String toString(){
        String str= "PacienteAlergia [idPacienteAlergia:".concat(String.valueOf(idPacienteAlergia))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idAlergia:").concat(String.valueOf(idAlergia))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    } 
    
    public int getIdPacienteAlergia() {
        return idPacienteAlergia;
    }

    public void setIdPacienteAlergia(int idPacienteAlergia) {
        this.idPacienteAlergia = idPacienteAlergia;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
    
}
