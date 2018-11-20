/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.poblacion;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
/**
 * public class GeneralPoblacion Clase para almacenar los datos generales de poblacion
 */
/**
 * Aqui se guardan los datos que son unicos por persona para el despliegue de reporte de poblacion
 */
public class GeneralPoblacion  implements Serializable{

    private String nombrePersona;
    private String primerApellido;
    private String segundoApellido;
    private String curp;
    private String telefono;
    private String correo;
    private String tipoSangre;
    private String estado;
    private String municipio;
    private Date fechaNacimiento;
    private String estadoCivil;
    private String sexo;
    private String escolaridad;
    private String seguro;
    private String noSegurooPopular;
    private String prz;
    private String noExpediente;
    private String Alergias;
    private String sillaRuedas;
    private String oxigeno;
    private String camilla;
    private String bastón;

    @Override
    public String toString() {
        return "GeneralPoblacion [ nombre de persona: ".concat(nombrePersona).concat(", primer apellido: ").concat(primerApellido).
                concat(", segundo apellido: ").concat(segundoApellido).concat(", curp: ").concat(curp).concat(", telefono: ").concat(telefono).
                concat(", correo: ").concat(correo).concat(", tipo de sangre: ").concat(tipoSangre).concat(", estado: ").concat(estado).
                concat(", municipio: ").concat(municipio).concat(", fecha de nacimiento").concat(fechaNacimiento.toString()).
                concat(", estadoCivil: ").concat(estadoCivil).concat(", sexo: ").concat(sexo).concat(", escolaridad: ").concat(escolaridad).
                concat(", seguro: ").concat(seguro).concat(", noSegurooPopular: ").concat(noSegurooPopular).concat(", prz: ").concat(prz).
                concat(", noExpediente: ").concat(noExpediente).concat(", Alergias: ").concat(Alergias).concat(", silla de ruedas: ").concat(sillaRuedas).
                concat(", oxigeno: ").concat(oxigeno).concat(", camilla: ").concat(camilla).concat(", bastón: ").concat(bastón).
                concat(" ]");

    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public void setNoSegurooPopular(String noSegurooPopular) {
        this.noSegurooPopular = noSegurooPopular;
    }

    public void setPrz(String prz) {
        this.prz = prz;
    }

    public void setNoExpediente(String noExpediente) {
        this.noExpediente = noExpediente;
    }

    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }

    public void setSillaRuedas(String sillaRuedas) {
        this.sillaRuedas = sillaRuedas;
    }

    public void setOxigeno(String oxigeno) {
        this.oxigeno = oxigeno;
    }

    public void setCamilla(String camilla) {
        this.camilla = camilla;
    }

    public void setBastón(String bastón) {
        this.bastón = bastón;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCurp() {
        return curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public String getSeguro() {
        return seguro;
    }

    public String getNoSegurooPopular() {
        return noSegurooPopular;
    }

    public String getPrz() {
        return prz;
    }

    public String getNoExpediente() {
        return noExpediente;
    }

    public String getAlergias() {
        return Alergias;
    }

    public String getSillaRuedas() {
        return sillaRuedas;
    }

    public String getOxigeno() {
        return oxigeno;
    }

    public String getCamilla() {
        return camilla;
    }

    public String getBastón() {
        return bastón;
    }

    
}
