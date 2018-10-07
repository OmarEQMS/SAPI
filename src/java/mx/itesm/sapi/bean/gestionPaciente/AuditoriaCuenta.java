/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;
import java.sql.Timestamp;
/**
 *
 * @author Alex
 */
public class AuditoriaCuenta {
    private int idAuditoriaCuenta;
    private int idCuenta;
    private int idEmpleado;
    private Timestamp fecha;
    private int estatus;
    
    public AuditoriaCuenta() {}

    @Override
    public String toString(){
        String str= "AuditoriaCuenta [idAuditoriaCuenta".concat(String.valueOf(idAuditoriaCuenta))
                .concat(",idCuenta:").concat(String.valueOf(idCuenta))
                .concat(",idEmpleado:").concat(String.valueOf(idEmpleado))   
                .concat(",fecha:").concat(String.valueOf(fecha))
                .concat(",estatus:").concat(String.valueOf(estatus))
                .concat("]");
        return str;
    }

    public int getIdAuditoriaCuenta() {
        return idAuditoriaCuenta;
    }

    public void setIdAuditoriaCuenta(int idAuditoriaCuenta) {
        this.idAuditoriaCuenta = idAuditoriaCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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
