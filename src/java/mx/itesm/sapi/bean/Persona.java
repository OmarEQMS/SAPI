/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
public class Persona implements Serializable {
    private int idPersona;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String curp;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private int idEstado;
    private int idMunicipio;
    private int idEstadoCivil;
    private int idRol;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private int  edad;
    
   public Persona(){}
   
   
   @Override
   public String toString(){
       
       String str ="Persona [idPersona:".concat(",nombre:").concat(nombre).concat(",apellido1:").concat(apellido1).concat(",apellido2:").concat(apellido2).concat(",curp:")
       .concat(curp).concat(",telefono:").concat(telefono).concat(",correo:").concat(correo).concat(",fechaNacimiento:").concat(fechaNacimiento.toString())
       .concat(",idCiudad:").concat(String.valueOf(idMunicipio)).concat(",idEstadoCivil:").concat(String.valueOf(idEstadoCivil)).concat(",idRol:").concat(String.valueOf(idRol))
       .concat("]");
       
     return str;

    } 

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    

}
