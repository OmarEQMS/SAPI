/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;


import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
public class AuditoriaCreacionCuenta implements Serializable{
    
    private int idAuditoriaCreacionCuenta;
    private int idCuenta;
    private Date fecha;
    private String nombre;
    private int condiciones;
    private int estatus;
    
      public AuditoriaCreacionCuenta(){}
    
    @Override
    public String toString(){
        return "Auditoria creación de cuenta [idAuditoriaCreacionCuenta:".concat(String.valueOf(idAuditoriaCreacionCuenta)).concat(",idCuenta:").concat(String.valueOf(idCuenta))
       .concat(",fecha:").concat(fecha.toString()).concat(",nombre:").concat(nombre).concat(",condiciones:").concat(String.valueOf(condiciones))
       .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    }

    public int getIdAuditoriaCreacionCuenta() {
        return idAuditoriaCreacionCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCondiciones() {
        return condiciones;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setIdAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta) {
        this.idAuditoriaCreacionCuenta = idAuditoriaCreacionCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCondiciones(int condiciones) {
        this.condiciones = condiciones;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
