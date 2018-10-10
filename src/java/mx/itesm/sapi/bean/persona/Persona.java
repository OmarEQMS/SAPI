/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.persona;

import java.io.InputStream;
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
    private Date fechaNacimiento;
    private int idSexo;
    private int idTipoSangre;
    private int idMunicipio;
    private int idEstadoCivil;
    private int idDireccion;
    private InputStream imagen;
    private int  edad;
    private int estatus;
    
   public Persona(){}
   
   
   @Override
   public String toString(){
       
       String str ="Persona [idPersona:".concat(String.valueOf(idPersona)).concat(",nombre:").concat(nombre).concat(",apellido1:").concat(apellido1).concat(",apellido2:").concat(apellido2).concat(",curp:")
       .concat(curp).concat(",telefono:").concat(telefono).concat(",correo:").concat(correo).concat(",fechaNacimiento:").concat(fechaNacimiento.toString())
       .concat(",idSexo:").concat(String.valueOf(idSexo)).concat(",idTipoDeSangre:").concat(String.valueOf(idTipoSangre)).concat(",idMunicipio:")
       .concat(String.valueOf(idMunicipio)).concat(",idEstadoCivil:")
       .concat(String.valueOf(idEstadoCivil)).concat(",idDireccion:").concat(String.valueOf(idDireccion))
       .concat(",edad:").concat(String.valueOf(edad)).concat(",estatus:").concat(String.valueOf(estatus)).concat("]");
       
     return str;

    } 

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

 

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setIdTipoSangre(int idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdTipoSangre() {
        return idTipoSangre;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public int getEstatus() {
        return estatus;
    }

   

    

}
