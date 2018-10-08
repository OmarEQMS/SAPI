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
public class PacienteNecesidadEspecial {
    private int idNecesidadPaciente;
    private int idPaciente;
    private int idNecesidadEspecial;
    private int estatus;
    
    public PacienteNecesidadEspecial() {}
    
    @Override
    public String toString(){
        String str= "PacienteNecesidadEspecialidad [idNecesidadPaciente: ".concat(String.valueOf(idNecesidadPaciente))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }
    
    public int getIdNecesidadPaciente() {
        return idNecesidadPaciente;
    }

    public void setIdNecesidadPaciente(int idNecesidadPaciente) {
        this.idNecesidadPaciente = idNecesidadPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdNecesidadEspecial(){
        return idNecesidadEspecial;
    }
    public void setIdNecesidadEspecial(int idNecesidadEspecial){
        this.idNecesidadEspecial = idNecesidadEspecial;

    }
    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
