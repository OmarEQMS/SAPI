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
import java.sql.Timestamp;
public class AuditoriaAtencion {

    private int idAuditoriaAntencion;
    private int idAtencion;
    private int idEmpleado;
    private Timestamp fecha;
    private int estatus;
    public AuditoriaAtencion() {}
    
    @Override
    public String toString(){
        String str= "AuditoriaAtencion [idAuditoriaAntencion:".concat(String.valueOf(idAuditoriaAntencion))
                .concat(",idAtencion:").concat(String.valueOf(idAtencion))
                .concat(",idEmpleado").concat(String.valueOf(idEmpleado))
                .concat(",fecha:").concat(String.valueOf(fecha))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    
    }

    public int getIdAuditoriaAntencion() {
        return idAuditoriaAntencion;
    }

    public void setIdAuditoriaAntencion(int idAuditoriaAntencion) {
        this.idAuditoriaAntencion = idAuditoriaAntencion;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    
}
