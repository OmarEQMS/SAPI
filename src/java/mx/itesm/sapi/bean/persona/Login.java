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
public class Login implements Serializable {
    private int idLogin;
    private Date fecha;
    private int exitoso;
    private int idCuenta;
    private int estatus;
    
    public Login(){}
    
    @Override
    public String toString(){
        return "Login [idLogin:".concat(String.valueOf(idLogin)).concat(",fecha:").concat(fecha.toString())
       .concat(",exitoso:").concat(String.valueOf(exitoso)).concat(",idCuenta:").concat(String.valueOf(idCuenta))
       .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdLogin(){
        return idLogin;
    }
    
    public void setIdLogin(int idLogin){
        this.idLogin=idLogin;
    }
   
    public Date getFecha() {
       return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public int getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(int idCuenta){
        this.idCuenta=idCuenta;
    }

    public int getExitoso() {
        return exitoso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setExitoso(int exitoso) {
        this.exitoso = exitoso;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
