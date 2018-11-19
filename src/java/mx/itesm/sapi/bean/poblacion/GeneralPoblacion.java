/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.poblacion;

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
public class GeneralPoblacion {

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
    private String noSeguroPopular;
    private String prz;
    private String noExpediente;
    private String Alergias;
    private String sillaRuedas;
    private String oxigeno;
    private String camilla;
    private String bastón;

    @Override
    public String toString() {
        return "GeneralPoblacion [ Nombre: ".concat(nombrePersona).
                concat("\t").concat(primerApellido).
                concat("\t").concat(segundoApellido).
                concat("\tCurp: ").concat(curp).
                concat("\tTelefono: ").concat(telefono).
                concat("\tCorreo: ").concat(correo).
                concat("\tSangre: ").concat(tipoSangre).
                concat("\tEstado: ").concat(estado).
                concat("\tMunicipio: ").concat(municipio).
                concat("\tNacimiento: ").concat(fechaNacimiento.toString()).
                concat("\tEstado Civil: ").concat(estadoCivil).
                concat("\tSexo: ").concat(sexo).
                concat("\tEscolaridad: ").concat(escolaridad).
                concat("\tSeguro: ").concat(seguro).
                concat("\tNoSeguroPopular: ").concat(noSeguroPopular).
                concat("\tPrz: ").concat(prz).
                concat("\tNoExpediente: ").concat(noExpediente).
                concat("\tAlergias: ").concat(Alergias).
                concat("\tSilla de ruedas: ").concat(sillaRuedas).
                concat("\tOxigeno: ").concat(oxigeno).
                concat("\tCamilla: ").concat(camilla).
                concat("\tBastón: ").concat(bastón).
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

    public void setNoSeguroPopular(String noSeguroPopular) {
        this.noSeguroPopular = noSeguroPopular;
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

    public String getNoSeguroPopular() {
        return noSeguroPopular;
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
