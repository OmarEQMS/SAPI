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
public class Atencion {
    
    private int idAtencion;
    private int idPaciente;
    private int idEmpleado;
    private int medicoSustituto;
    private int estatus;
    private int medicoPresente;
    private int adscrito;
    
    //Constructor
    public Atencion() {}
    
    @Override
    public String toString(){
        String str="Atencion [idAtencion:".concat(String.valueOf(idAtencion))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                .concat(",medicoSustituto:").concat(String.valueOf(medicoSustituto))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",medicoPresente:").concat(String.valueOf(medicoPresente))
                .concat(",adscrito:").concat(String.valueOf(adscrito))
                .concat("]");
        return str;
        
    }
    
    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getMedicoSustituto() {
        return medicoSustituto;
    }

    public void setMedicoSustituto(int medicoSustituto) {
        this.medicoSustituto = medicoSustituto;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getMedicoPresente() {
        return medicoPresente;
    }

    public void setMedicoPresente(int medicoPresente) {
        this.medicoPresente = medicoPresente;
    }
    
    public int getAdscrito() {
        return adscrito;
    }

    public void setAdscrito(int adscrito) {
        this.adscrito = adscrito;
    }
    
}
