/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean;

import java.io.Serializable;

/**
 *
 * @author Angel GTZ
 */
public class Cuenta implements Serializable {
    private int idCuenta;
    private String usuario;
    private String password;
    private String token;
    private int idPersona;
    private int idRol;
    private long loginDateTime; //@Autor: Alexis: Nos permite saber la fecha de login
    public Cuenta(){}
    
    @Override
    public String toString(){
        return "Cuenta [idCuenta:".concat(String.valueOf(idCuenta)).concat(",usuario:").concat(usuario).concat(",password:").concat(password).concat(",token:").concat(token)
       .concat(",idPersona:").concat(String.valueOf(idPersona)).concat("]");

    } 
    public int getIdCuenta(){
        return idCuenta;
    }
       
    public void setIdCuenta(int idCuenta){
        this.idCuenta=idCuenta;
    }
    
    public String getUsuario() {
       return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token){
        this.token=token;
    }
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona){
        this.idPersona=idPersona;
    }
    
    public int getIdRol(){
        return idRol;
    }
    
    public void setIdRol(int idRol){
        this.idRol=idRol;
    }
    //@ Autor: Alexis: Regresa la ùltima fecha de login
    public long getLoginDateTime(){
        return loginDateTime;
    }
    //@ Autor: Alexis: Guarda la ùltima fecha de login
    public void  setLoginDateTime(long ldateTime){
            this.loginDateTime=ldateTime;
    }
    
}
