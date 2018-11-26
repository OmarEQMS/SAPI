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
    private String estudioINCanMastografia;
    private Date estudioINCanMastografiaFecha;
    private String estudioINCanUSG;
    private Date estudioINCanUSGFecha;
    private Date estudioINCanRadiografia;
    private Date estudioINCanTomografia;
    private Date estudioINCanMr;
    private Date estudioINCanTransvaginal;
    private Date estudioINCanAbdominal;
    private Date estudioINCanTiroides;
    private Date estudioINCanPelvico;
    private Date estudioINCanHepatico;
    private Date estudioINCanPet;
    private Date estudioINCanMuga;
    private Date estudioINCanGamma;
    private Date estudioINCanLaboratorio;
    private Date estudioINCanCardio;
    private Date estudioINCanAnestesica;
    private Date estudioINCanInhaloterapia;
    private Date estudioINCanElectro;
    private Date estudioINCanEco;
    private Date programaINCanTrabajoSocial;
    private Date programaINCanMujeresJovenes;
    private Date programaINCanNutricion;
    private Date programaINCanGenetica;
    private String preconsultaSegundaOpcion;
    private Date preconsultaFechaDecision;
    private String preconsultaDecision;
    private String biopsiaINCanEtapa;
    private String biopsiaINCanT;
    private String biopsiaINCanN;
    private String biopsiaINCanM;

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
                concat("\tEstudio INCan - [Resultado] Mastografía Resultado: ").concat(estudioINCanMastografia).
                concat("\tEstudio INCan - [Fecha] Mastografía Fecha: ").concat(estudioINCanMastografiaFecha.toString()).
                concat("\tEstudio INCan - [Resultado] Guiada por ultrasonido: ").concat(estudioINCanUSG).
                concat("\tEstudio INCan - [Fecha] Guiada por ultrasonido: ").concat(estudioINCanUSGFecha.toString()).
                concat("\tEstudio INCan - [Fecha] Radiografía: ").concat(estudioINCanRadiografia.toString()).
                concat("\tEstudio INCan - [Fecha] Tomografía: ").concat(estudioINCanTomografia.toString()).
                concat("\tEstudio INCan - [Fecha] Resonancia Magentica: ").concat(estudioINCanMr.toString()).
                concat("\tEstudio INCan - [Fecha] Transvaginal: ").concat(estudioINCanTransvaginal.toString()).
                concat("\tEstudio INCan - [Fecha] Abdominal: ").concat(estudioINCanAbdominal.toString()).
                concat("\tEstudio INCan - [Fecha] Tiroides: ").concat(estudioINCanTiroides.toString()).
                concat("\tEstudio INCan - [Fecha] Pélvico: ").concat(estudioINCanPelvico.toString()).
                concat("\tEstudio INCan - [Fecha] Hepático: ").concat(estudioINCanHepatico.toString()).
                concat("\tEstudio INCan - [Fecha] PET-CT: ").concat(estudioINCanPet.toString()).
                concat("\tEstudio INCan - [Fecha] MUGA: ").concat(estudioINCanMuga.toString()).
                concat("\tEstudio INCan - [Fecha] Gammagrama óseo: ").concat(estudioINCanGamma.toString()).
                concat("\tEstudio INCan - [Fecha] Laboratorio: ").concat(estudioINCanLaboratorio.toString()).
                concat("\tEstudio INCan - [Fecha] Cardiovascular: ").concat(estudioINCanCardio.toString()).
                concat("\tEstudio INCan - [Fecha] Por anestesia: ").concat(estudioINCanAnestesica.toString()).
                concat("\tEstudio INCan - [Fecha] Espirometría / Inhaloterapia: ").concat(estudioINCanInhaloterapia.toString()).
                concat("\tEstudio INCan - [Fecha] Electrocardiograma: ").concat(estudioINCanElectro.toString()).
                concat("\tEstudio INCan - [Fecha] Ecoardiograma: ").concat(estudioINCanEco.toString()).
                concat("\tPrograma INCan - [Fecha] Trabajo social: ").concat(programaINCanTrabajoSocial.toString()).
                concat("\tPrograma INCan - [Fecha] Mujeres jóvenes: ").concat(programaINCanMujeresJovenes.toString()).
                concat("\tPrograma INCan - [Fecha] Nutrición: ").concat(programaINCanNutricion.toString()).
                concat("\tPrograma INCan - [Fecha] Genética: ").concat(programaINCanGenetica.toString()).
                concat("\tPreconsulta - Primera vez / Segunda opción: ").concat(preconsultaSegundaOpcion).
                concat("\tPreconsulta - Fecha decision: ").concat(preconsultaFechaDecision.toString()).
                concat("\tPreconsulta - Decision: ").concat(preconsultaDecision).
                concat("\tBiopsia INCan - Etapa: ").concat(biopsiaINCanEtapa).
                concat("\tBiopsia INCan - T: ").concat(biopsiaINCanT).
                concat("\tBiopsia INCan - N: ").concat(biopsiaINCanN).
                concat("\tBiopsia INCan - M: ").concat(biopsiaINCanM).
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
                concat("\t").concat(estudioINCanMastografia).
                concat("\t").concat(estudioINCanMastografiaFecha.toString()).
                concat("\t").concat(estudioINCanUSG).
                concat("\t").concat(estudioINCanUSGFecha.toString()).
                concat("\t").concat(estudioINCanRadiografia.toString()).
                concat("\t").concat(estudioINCanTomografia.toString()).
                concat("\t").concat(estudioINCanMr.toString()).
                concat("\t").concat(estudioINCanTransvaginal.toString()).
                concat("\t").concat(estudioINCanAbdominal.toString()).
                concat("\t").concat(estudioINCanTiroides.toString()).
                concat("\t").concat(estudioINCanPelvico.toString()).
                concat("\t").concat(estudioINCanHepatico.toString()).
                concat("\t").concat(estudioINCanPet.toString()).
                concat("\t").concat(estudioINCanMuga.toString()).
                concat("\t").concat(estudioINCanGamma.toString()).
                concat("\t").concat(estudioINCanLaboratorio.toString()).
                concat("\t").concat(estudioINCanCardio.toString()).
                concat("\t").concat(estudioINCanAnestesica.toString()).
                concat("\t").concat(estudioINCanInhaloterapia.toString()).
                concat("\t").concat(estudioINCanElectro.toString()).
                concat("\t").concat(estudioINCanEco.toString()).
                concat("\t").concat(programaINCanTrabajoSocial.toString()).
                concat("\t").concat(programaINCanMujeresJovenes.toString()).
                concat("\t").concat(programaINCanNutricion.toString()).
                concat("\t").concat(programaINCanGenetica.toString()).
                concat("\t").concat(preconsultaSegundaOpcion).
                concat("\t").concat(preconsultaFechaDecision.toString()).
                concat("\t").concat(preconsultaDecision).
                concat("\t").concat(biopsiaINCanEtapa).
                concat("\t").concat(biopsiaINCanT).
                concat("\t").concat(biopsiaINCanN).
                concat("\t").concat(biopsiaINCanM).
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
                concat("Estudio INCan - [Resultado] Mastografía Resultado\t").
                concat("Estudio INCan - [Fecha] Mastografía Fecha\t").
                concat("Estudio INCan - [Resultado] Guiada por ultrasonido\t").
                concat("Estudio INCan - [Fecha] Guiada por ultrasonido\t").
                concat("Estudio INCan - [Fecha] Radiografía\t").
                concat("Estudio INCan - [Fecha] Tomografía\t").
                concat("Estudio INCan - [Fecha] Resonancia Magentica\t").
                concat("Estudio INCan - [Fecha] Transvaginal\t").
                concat("Estudio INCan - [Fecha] Abdominal\t").
                concat("Estudio INCan - [Fecha] Tiroides\t").
                concat("Estudio INCan - [Fecha] Pélvico\t").
                concat("Estudio INCan - [Fecha] Hepático\t").
                concat("Estudio INCan - [Fecha] PET-CT\t").
                concat("Estudio INCan - [Fecha] MUGA\t").
                concat("Estudio INCan - [Fecha] Gammagrama óseo\t").
                concat("Estudio INCan - [Fecha] Laboratorio\t").
                concat("Estudio INCan - [Fecha] Cardiovascular\t").
                concat("Estudio INCan - [Fecha] Por anestesia\t").
                concat("Estudio INCan - [Fecha] Espirometría / Inhaloterapia\t").
                concat("Estudio INCan - [Fecha] Electrocardiograma\t").
                concat("Estudio INCan - [Fecha] Ecoardiograma\t").
                concat("Programa INCan - [Fecha] Trabajo social\t").
                concat("Programa INCan - [Fecha] Mujeres jóvenes\t").
                concat("Programa INCan - [Fecha] Nutrición\t").
                concat("Programa INCan - [Fecha] Genética\t").
                concat("Preconsulta - Primera vez / Segunda opción\t").
                concat("Preconsulta - Fecha decision\t").
                concat("Preconsulta - Decision\t").
                concat("Biopsia INCan - Etapa\t").
                concat("Biopsia INCan - T\t").
                concat("Biopsia INCan - N\t").
                concat("Biopsia INCan - M\t").
                concat("Biopsia INCan - Grado Histologico\t").
                concat("Biopsia INCan - Her2\t").
                concat("Biopsia INCan - Fish\t").
                concat("Biopsia INCan - Ki67\t").
                concat("Biopsia INCan - Re\t").
                concat("Biopsia INCan - Rp\t")
                ;
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

    public String getEstudioINCanMastografia() {
        return estudioINCanMastografia;
    }

    public void setEstudioINCanMastografia(String estudioINCanMastografia) {
        this.estudioINCanMastografia = estudioINCanMastografia;
    }

    public Date getEstudioINCanMastografiaFecha() {
        return estudioINCanMastografiaFecha;
    }

    public void setEstudioINCanMastografiaFecha(Date estudioINCanMastografiaFecha) {
        this.estudioINCanMastografiaFecha = estudioINCanMastografiaFecha;
    }

    public String getEstudioINCanUSG() {
        return estudioINCanUSG;
    }

    public void setEstudioINCanUSG(String estudioINCanUSG) {
        this.estudioINCanUSG = estudioINCanUSG;
    }

    public Date getEstudioINCanUSGFecha() {
        return estudioINCanUSGFecha;
    }

    public void setEstudioINCanUSGFecha(Date estudioINCanUSGFecha) {
        this.estudioINCanUSGFecha = estudioINCanUSGFecha;
    }

    public Date getEstudioINCanRadiografia() {
        return estudioINCanRadiografia;
    }

    public void setEstudioINCanRadiografia(Date estudioINCanRadiografia) {
        this.estudioINCanRadiografia = estudioINCanRadiografia;
    }

    public Date getEstudioINCanTomografia() {
        return estudioINCanTomografia;
    }

    public void setEstudioINCanTomografia(Date estudioINCanTomografia) {
        this.estudioINCanTomografia = estudioINCanTomografia;
    }

    public Date getEstudioINCanMr() {
        return estudioINCanMr;
    }

    public void setEstudioINCanMr(Date estudioINCanMr) {
        this.estudioINCanMr = estudioINCanMr;
    }

    public Date getEstudioINCanTransvaginal() {
        return estudioINCanTransvaginal;
    }

    public void setEstudioINCanTransvaginal(Date estudioINCanTransvaginal) {
        this.estudioINCanTransvaginal = estudioINCanTransvaginal;
    }

    public Date getEstudioINCanAbdominal() {
        return estudioINCanAbdominal;
    }

    public void setEstudioINCanAbdominal(Date estudioINCanAbdominal) {
        this.estudioINCanAbdominal = estudioINCanAbdominal;
    }

    public Date getEstudioINCanTiroides() {
        return estudioINCanTiroides;
    }

    public void setEstudioINCanTiroides(Date estudioINCanTiroides) {
        this.estudioINCanTiroides = estudioINCanTiroides;
    }

    public Date getEstudioINCanPelvico() {
        return estudioINCanPelvico;
    }

    public void setEstudioINCanPelvico(Date estudioINCanPelvico) {
        this.estudioINCanPelvico = estudioINCanPelvico;
    }

    public Date getEstudioINCanHepatico() {
        return estudioINCanHepatico;
    }

    public void setEstudioINCanHepatico(Date estudioINCanHepatico) {
        this.estudioINCanHepatico = estudioINCanHepatico;
    }

    public Date getEstudioINCanPet() {
        return estudioINCanPet;
    }

    public void setEstudioINCanPet(Date estudioINCanPet) {
        this.estudioINCanPet = estudioINCanPet;
    }

    public Date getEstudioINCanMuga() {
        return estudioINCanMuga;
    }

    public void setEstudioINCanMuga(Date estudioINCanMuga) {
        this.estudioINCanMuga = estudioINCanMuga;
    }

    public Date getEstudioINCanGamma() {
        return estudioINCanGamma;
    }

    public void setEstudioINCanGamma(Date estudioINCanGamma) {
        this.estudioINCanGamma = estudioINCanGamma;
    }

    public Date getEstudioINCanLaboratorio() {
        return estudioINCanLaboratorio;
    }

    public void setEstudioINCanLaboratorio(Date estudioINCanLaboratorio) {
        this.estudioINCanLaboratorio = estudioINCanLaboratorio;
    }

    public Date getEstudioINCanCardio() {
        return estudioINCanCardio;
    }

    public void setEstudioINCanCardio(Date estudioINCanCardio) {
        this.estudioINCanCardio = estudioINCanCardio;
    }

    public Date getEstudioINCanAnestesica() {
        return estudioINCanAnestesica;
    }

    public void setEstudioINCanAnestesica(Date estudioINCanAnestesica) {
        this.estudioINCanAnestesica = estudioINCanAnestesica;
    }

    public Date getEstudioINCanInhaloterapia() {
        return estudioINCanInhaloterapia;
    }

    public void setEstudioINCanInhaloterapia(Date estudioINCanInhaloterapia) {
        this.estudioINCanInhaloterapia = estudioINCanInhaloterapia;
    }

    public Date getEstudioINCanElectro() {
        return estudioINCanElectro;
    }

    public void setEstudioINCanElectro(Date estudioINCanElectro) {
        this.estudioINCanElectro = estudioINCanElectro;
    }

    public Date getEstudioINCanEco() {
        return estudioINCanEco;
    }

    public void setEstudioINCanEco(Date estudioINCanEco) {
        this.estudioINCanEco = estudioINCanEco;
    }

    public Date getProgramaINCanTrabajoSocial() {
        return programaINCanTrabajoSocial;
    }

    public void setProgramaINCanTrabajoSocial(Date programaINCanTrabajoSocial) {
        this.programaINCanTrabajoSocial = programaINCanTrabajoSocial;
    }

    public Date getProgramaINCanMujeresJovenes() {
        return programaINCanMujeresJovenes;
    }

    public void setProgramaINCanMujeresJovenes(Date programaINCanMujeresJovenes) {
        this.programaINCanMujeresJovenes = programaINCanMujeresJovenes;
    }

    public Date getProgramaINCanNutricion() {
        return programaINCanNutricion;
    }

    public void setProgramaINCanNutricion(Date programaINCanNutricion) {
        this.programaINCanNutricion = programaINCanNutricion;
    }

    public Date getProgramaINCanGenetica() {
        return programaINCanGenetica;
    }

    public void setProgramaINCanGenetica(Date programaINCanGenetica) {
        this.programaINCanGenetica = programaINCanGenetica;
    }

    public String getPreconsultaSegundaOpcion() {
        return preconsultaSegundaOpcion;
    }

    public void setPreconsultaSegundaOpcion(String preconsultaSegundaOpcion) {
        this.preconsultaSegundaOpcion = preconsultaSegundaOpcion;
    }

    public Date getPreconsultaFechaDecision() {
        return preconsultaFechaDecision;
    }

    public void setPreconsultaFechaDecision(Date preconsultaFechaDecision) {
        this.preconsultaFechaDecision = preconsultaFechaDecision;
    }

    public String getPreconsultaDecision() {
        return preconsultaDecision;
    }

    public void setPreconsultaDecision(String preconsultaDecision) {
        this.preconsultaDecision = preconsultaDecision;
    }

    public String getBiopsiaINCanEtapa() {
        return biopsiaINCanEtapa;
    }

    public void setBiopsiaINCanEtapa(String biopsiaINCanEtapa) {
        this.biopsiaINCanEtapa = biopsiaINCanEtapa;
    }

    public String getBiopsiaINCanT() {
        return biopsiaINCanT;
    }

    public void setBiopsiaINCanT(String biopsiaINCanT) {
        this.biopsiaINCanT = biopsiaINCanT;
    }

    public String getBiopsiaINCanN() {
        return biopsiaINCanN;
    }

    public void setBiopsiaINCanN(String biopsiaINCanN) {
        this.biopsiaINCanN = biopsiaINCanN;
    }

    public String getBiopsiaINCanM() {
        return biopsiaINCanM;
    }

    public void setBiopsiaINCanM(String biopsiaINCanM) {
        this.biopsiaINCanM = biopsiaINCanM;
    }
    
    
}
