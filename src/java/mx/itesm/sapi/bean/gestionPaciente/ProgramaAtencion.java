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
public class ProgramaAtencion {
    private int idProgramaAtencion;
    private int idPrograma;
    private int idAtencion;
    private int estatus;
    
    public ProgramaAtencion() {}
    @Override
    public String toString(){
        String str= "ProgramaAtencion [idProgramaAtencion:".concat(String.valueOf(idProgramaAtencion))
                .concat(",idPrograma:").concat(String.valueOf(idPrograma))
                .concat(",idAtencion:").concat(String.valueOf(idAtencion))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdProgramaAtencion() {
        return idProgramaAtencion;
    }

    public void setIdProgramaAtencion(int idProgramaAtencion) {
        this.idProgramaAtencion = idProgramaAtencion;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
