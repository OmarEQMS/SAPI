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
public class CitaEmpleado {
    private int idCitaEmpleado;
    private int idCita;
    private int idEmpleado;
    private int medicoSustituto;
    private int adscritoPresente;
    private int idEmpleadoSustituto;
    private int estatus;
    
    public CitaEmpleado() {}
    
    @Override
    public String toString(){
            String str="CitaEmpleado [idCitaEmpleado:".concat(String.valueOf(idCitaEmpleado))
                    .concat(",idCita:").concat(String.valueOf(idCita))
                    .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                    .concat(",medicoSustituto:").concat(String.valueOf(medicoSustituto))
                    .concat(",adscritoPresente:").concat(String.valueOf(adscritoPresente))
                    .concat(",idEmpleadoSustituto:").concat(String.valueOf(idEmpleadoSustituto))
                    .concat(",estatus:").concat(String.valueOf(estatus))
                    .concat("]");
            return str;
    }

    public int getIdCitaEmpleado() {
        return idCitaEmpleado;
    }

    public void setIdCitaEmpleado(int idCitaEmpleado) {
        this.idCitaEmpleado = idCitaEmpleado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public int getAdscritoPresente() {
        return adscritoPresente;
    }

    public void setAdscritoPresente(int adscritoPresente) {
        this.adscritoPresente = adscritoPresente;
    }

    public int getIdEmpleadoSustituto() {
        return idEmpleadoSustituto;
    }

    public void setIdEmpleadoSustituto(int idEmpleadoSustituto) {
        this.idEmpleadoSustituto = idEmpleadoSustituto;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
}
