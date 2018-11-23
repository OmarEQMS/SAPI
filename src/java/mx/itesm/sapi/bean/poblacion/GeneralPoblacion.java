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
    private String nivelSocioeconomico;
    private String seguro;
    private String noSeguroPopular;
    private String prz;
    private String noExpediente;
    private String Alergias;
    private String sillaRuedas;
    private String oxigeno;
    private String camilla;
    private String bastón;
    private String biopsiaPreviaLaminillas;
    private String biopsiaPreviaBloques;
    private String biopsiaPreviaTipo;
    private Date biopsiaPreviaFecha;
    private String biopsiaPreviaLugarCuerpo;
    private String biopsiaINCanGradoHistologico;
    private String biopsiaINCanHer2;
    private String biopsiaINCanFish;
    private String biopsiaINCanKi67;
    private String biopsiaINCanRe;
    private String biopsiaINCanRp;

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
                concat("\tNivel Socioeconomico: ").concat(nivelSocioeconomico).
                concat("\tSeguro: ").concat(seguro).
                concat("\tNoSeguroPopular: ").concat(noSeguroPopular).
                concat("\tPrz: ").concat(prz).
                concat("\tNoExpediente: ").concat(noExpediente).
                concat("\tAlergias: ").concat(Alergias).
                concat("\tSilla de ruedas: ").concat(sillaRuedas).
                concat("\tOxigeno: ").concat(oxigeno).
                concat("\tCamilla: ").concat(camilla).
                concat("\tBastón: ").concat(bastón).
                concat("\tBiopsia Previa - Laminillas: ").concat(biopsiaPreviaLaminillas).
                concat("\tBiopsia Previa - Bloques: ").concat(biopsiaPreviaBloques).
                concat("\tBiopsia Previa - Tipo: ").concat(biopsiaPreviaTipo).
                concat("\tBiopsia Previa - Fecha: ").concat(biopsiaPreviaFecha.toString()).
                concat("\tBiopsia Previa - Lugar Cuerpo: ").concat(biopsiaPreviaLugarCuerpo).
                concat("\tBiopsia INCan - Grado Histologico: ").concat(biopsiaINCanGradoHistologico).
                concat("\tBiopsia INCan - Her2: ").concat(biopsiaINCanHer2).
                concat("\tBiopsia INCan - Fish: ").concat(biopsiaINCanFish).
                concat("\tBiopsia INCan - Ki67: ").concat(biopsiaINCanKi67).
                concat("\tBiopsia INCan - Re: ").concat(biopsiaINCanRe).
                concat("\tBiopsia INCan - Rp: ").concat(biopsiaINCanRp).
                concat(" ]");

    }
    
    public String toStringRStudio() {
        return nombrePersona.
                concat(" ").concat(primerApellido).
                concat(" ").concat(segundoApellido).
                concat("\t").concat(curp).
                concat("\t").concat(telefono).
                concat("\t").concat(correo).
                concat("\t").concat(tipoSangre).
                concat("\t").concat(estado).
                concat("\t").concat(municipio).
                concat("\t").concat(fechaNacimiento.toString()).
                concat("\t").concat(estadoCivil).
                concat("\t").concat(sexo).
                concat("\t").concat(escolaridad).
                concat("\t").concat(nivelSocioeconomico).
                concat("\t").concat(seguro).
                concat("\t").concat(noSeguroPopular).
                concat("\t").concat(prz).
                concat("\t").concat(noExpediente).
                concat("\t").concat(Alergias).
                concat("\t").concat(sillaRuedas).
                concat("\t").concat(oxigeno).
                concat("\t").concat(camilla).
                concat("\t").concat(bastón).
                concat("\t").concat(biopsiaPreviaLaminillas).
                concat("\t").concat(biopsiaPreviaBloques).
                concat("\t").concat(biopsiaPreviaTipo).
                concat("\t").concat(biopsiaPreviaFecha.toString()).
                concat("\t").concat(biopsiaPreviaLugarCuerpo).
                concat("\t").concat(biopsiaINCanGradoHistologico).
                concat("\t").concat(biopsiaINCanHer2).
                concat("\t").concat(biopsiaINCanFish).
                concat("\t").concat(biopsiaINCanKi67).
                concat("\t").concat(biopsiaINCanRe).
                concat("\t").concat(biopsiaINCanRp);

    }
    public static String tableHeaderRStudio(){
        return "Nombre\t".
                concat("Curp\t").
                concat("Telefono\t").
                concat("Correo\t").
                concat("Tipo de sangre\t").
                concat("Estado\t").
                concat("Municipio\t").
                concat("Fecha de nacimiento\t").
                concat("Estado civil\t").
                concat("Sexo\t").
                concat("Nivel educativo\t").
                concat("Nivel Socioeconomico\t").
                concat("Seguro\t").
                concat("Número de Seguro popular\t").
                concat("PRZ\t").
                concat("Número de expediente\t").
                concat("Alergias\t").
                concat("Silla de ruedas\t").
                concat("Oxígeno\t").
                concat("Camilla\t").
                concat("Bastón\t").
                concat("Biopsia Previa - Laminillas\t").
                concat("Biopsia Previa - Bloques\t").
                concat("Biopsia Previa - Tipo\t").
                concat("Biopsia Previa - Fecha\t").
                concat("Biopsia Previa - Lugar Cuerpo\t").
                concat("Biopsia INCan - Grado Histologico\t").
                concat("Biopsia INCan - Her2\t").
                concat("Biopsia INCan - Fish\t").
                concat("Biopsia INCan - Ki67\t").
                concat("Biopsia INCan - Re\t").
                concat("Biopsia INCan - Rp\t");
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

    public String getNivelSocioeconomico() {
        return nivelSocioeconomico;
    }

    public void setNivelSocioeconomico(String nivelSocioeconomico) {
        this.nivelSocioeconomico = nivelSocioeconomico;
    }

    public String getBiopsiaINCanGradoHistologico() {
        return biopsiaINCanGradoHistologico;
    }

    public void setBiopsiaINCanGradoHistologico(String biopsiaINCanGradoHistologico) {
        this.biopsiaINCanGradoHistologico = biopsiaINCanGradoHistologico;
    }

    public String getBiopsiaINCanHer2() {
        return biopsiaINCanHer2;
    }

    public void setBiopsiaINCanHer2(String biopsiaINCanHer2) {
        this.biopsiaINCanHer2 = biopsiaINCanHer2;
    }

    public String getBiopsiaINCanFish() {
        return biopsiaINCanFish;
    }

    public void setBiopsiaINCanFish(String biopsiaINCanFish) {
        this.biopsiaINCanFish = biopsiaINCanFish;
    }

    public String getBiopsiaINCanKi67() {
        return biopsiaINCanKi67;
    }

    public void setBiopsiaINCanKi67(String biopsiaINCanKi67) {
        this.biopsiaINCanKi67 = biopsiaINCanKi67;
    }

    public String getBiopsiaINCanRe() {
        return biopsiaINCanRe;
    }

    public void setBiopsiaINCanRe(String biopsiaINCanRe) {
        this.biopsiaINCanRe = biopsiaINCanRe;
    }

    public String getBiopsiaINCanRp() {
        return biopsiaINCanRp;
    }

    public void setBiopsiaINCanRp(String biopsiaINCanRp) {
        this.biopsiaINCanRp = biopsiaINCanRp;
    }

    public String getBiopsiaPreviaLaminillas() {
        return biopsiaPreviaLaminillas;
    }

    public void setBiopsiaPreviaLaminillas(String biopsiaPreviaLaminillas) {
        this.biopsiaPreviaLaminillas = biopsiaPreviaLaminillas;
    }

    public String getBiopsiaPreviaBloques() {
        return biopsiaPreviaBloques;
    }

    public void setBiopsiaPreviaBloques(String biopsiaPreviaBloques) {
        this.biopsiaPreviaBloques = biopsiaPreviaBloques;
    }

    public String getBiopsiaPreviaTipo() {
        return biopsiaPreviaTipo;
    }

    public void setBiopsiaPreviaTipo(String biopsiaPreviaTipo) {
        this.biopsiaPreviaTipo = biopsiaPreviaTipo;
    }

    public Date getBiopsiaPreviaFecha() {
        return biopsiaPreviaFecha;
    }

    public void setBiopsiaPreviaFecha(Date biopsiaPreviaFecha) {
        this.biopsiaPreviaFecha = biopsiaPreviaFecha;
    }

    public String getBiopsiaPreviaLugarCuerpo() {
        return biopsiaPreviaLugarCuerpo;
    }

    public void setBiopsiaPreviaLugarCuerpo(String biopsiaPreviaLugarCuerpo) {
        this.biopsiaPreviaLugarCuerpo = biopsiaPreviaLugarCuerpo;
    }
    
    
}
