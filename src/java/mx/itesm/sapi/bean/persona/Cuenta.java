/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Angel GTZ
 */
public class Cuenta implements Serializable {
    private int idCuenta;
    private int idPersona;
    private int idRol;
    private int idEstadoCuenta;
    private String usuario;
    private String password;
    private String token;
    private int estatus;
    private int condiciones;
    private Timestamp fecha;
    private int idEmpleado;    
    
    
    
    public Cuenta(){}
    
    @Override
    public String toString(){
        return "Cuenta [idCuenta:".concat(String.valueOf(idCuenta)).concat(",usuario:").concat(usuario).concat(",password:").concat(password).concat(",token:").concat(token)
        .concat(",idPersona:").concat(String.valueOf(idPersona)).concat(",idEstadoCuenta:").concat(String.valueOf(idEstadoCuenta))
        .concat(",estatus:").concat(String.valueOf(estatus)).concat("]");

    } 

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(int idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(int condiciones) {
        this.condiciones = condiciones;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
      
    
}
