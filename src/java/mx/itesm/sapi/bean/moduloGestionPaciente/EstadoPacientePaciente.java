/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionPaciente;

import java.sql.Timestamp;

/**
 *
 * @author Alex
 */
public class EstadoPacientePaciente {
    
    private int idEstadoPacientePaciente;
    private int idEstadoPaciente;
    private int idPaciente;
    private Timestamp fecha;
    private int segundaOpinion;
    private int estatus;
    private int resultados;
    private int idEmpleado;
    
    
    
    @Override 
    public String toString(){
        String str="EstadoPacientePaciente [idEstadoPacientePaciente:".concat(String.valueOf(idEstadoPacientePaciente))
                .concat(",idEstadoPaciente:").concat(String.valueOf(idEstadoPaciente))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",fecha:").concat(String.valueOf(fecha))
                .concat(",segundaOpinion:").concat(String.valueOf(segundaOpinion))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat(",resultados:").concat(String.valueOf(resultados))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                .concat("]");
        
        return str;
    }

    public int getResultados() {
        return resultados;
    }

    public void setResultados(int resultados) {
        this.resultados = resultados;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEstadoPacientePaciente() {
        return idEstadoPacientePaciente;
    }

    public void setIdEstadoPacientePaciente(int idEstadoPacientePaciente) {
        this.idEstadoPacientePaciente = idEstadoPacientePaciente;
    }

    public int getIdEstadoPaciente() {
        return idEstadoPaciente;
    }

    public void setIdEstadoPaciente(int idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getSegundaOpinion() {
        return segundaOpinion;
    }

    public void setSegundaOpinion(int segundaOpinion) {
        this.segundaOpinion = segundaOpinion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
