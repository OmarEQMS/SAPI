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
public class PacienteNavegadora {
    private int idPacienteNavegadora;
    private int idPaciente;
    private int idEmpleado;
    private int estatus;
    
    public PacienteNavegadora() {}
    
    @Override
    public String toString(){
        
        String str= "PacienteNavegadora [iPacienteNavegadora:".concat(String.valueOf(idPacienteNavegadora))
                .concat(",idPaciente:").concat(String.valueOf(idPaciente))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdPacienteNavegadora() {
        return idPacienteNavegadora;
    }

    public void setIdPacienteNavegadora(int idPacienteNavegadora) {
        this.idPacienteNavegadora = idPacienteNavegadora;
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

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
