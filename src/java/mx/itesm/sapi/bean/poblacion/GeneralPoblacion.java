/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.poblacion;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

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
    private Date estudioPrevioQuimioFecha;
    private Integer estudioPrevioQuimioCiclos;
    private Date estudioPrevioRadioFecha;
    private Integer estudioPrevioRadioCiclos;
    private Date estudioPrevioCirugiaFecha;
    private String estudioPrevioCirugiaTipo;
    private Date estudioPrevioMastografiaFecha;
    private String estudioPrevioMastografia;
    private Date estudioPrevioUSGFecha;
    private String estudioPrevioUSG;
    private Date cirugiasINCanMasectomiaFecha;
    private Date cirugiasINCanConservadoraFecha;
    private Date cirugiasINCanReconstruccionFecha;
    private String consultaTipo;
    private String consultaEstado;
    private String consultaMotivo;
    private String consultaComentario;
    private Date consultaFecha;
    private Date consultaDiagnosticoFecha;
    private String consultaAdscritoNombre;
    private String consultaAdscritoPresente;
    private String consultaRadiologoNombre;
    private String consultaRadiologoPresente;

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
                concat("\tConsulta - Tipo: ").concat(consultaTipo).
                concat("\tConsulta - Estado: ").concat(consultaEstado).
                concat("\tConsulta - Motivo: ").concat(consultaMotivo).
                concat("\tConsulta - Comentario: ").concat(consultaComentario).
                concat("\tConsulta - Fecha: ").concat(consultaFecha.toString()).
                concat("\tConsulta - Fecha de diagnostico: ").concat(consultaDiagnosticoFecha.toString()).
                concat("\tConsulta - Nombre de adscrito: ").concat(consultaAdscritoNombre).
                concat("\tConsulta - Adscrito presente: ").concat(consultaAdscritoPresente).
                concat("\tConsulta - Nombre de radiologo: ").concat(consultaRadiologoNombre).
                concat("\tConsulta - Radiologo presente: ").concat(consultaRadiologoPresente).
                concat("\tQuimioterapia previa - Fecha: ").concat(estudioPrevioQuimioFecha.toString()).
                concat("\tQuimioterapia previa - Ciclos: ").concat(estudioPrevioQuimioCiclos.toString()).
                concat("\tRadioterapia previa - Fecha: ").concat(estudioPrevioRadioFecha.toString()).
                concat("\tRadioterapia previa - Ciclos: ").concat(estudioPrevioRadioCiclos.toString()).
                concat("\tCirugía previa - Fecha: ").concat(estudioPrevioCirugiaFecha.toString()).
                concat("\tCirugía previa - Tipo: ").concat(estudioPrevioCirugiaTipo).
                concat("\tMastografía previa - Fecha: ").concat(estudioPrevioMastografiaFecha.toString()).
                concat("\tMastografía previa - Resultado: ").concat(estudioPrevioMastografia).
                concat("\tMastografía previa - Fecha: ").concat(estudioPrevioUSGFecha.toString()).
                concat("\tMastografía previa - Resultado: ").concat(estudioPrevioUSG).
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
                concat("\tCirugia INCan - [Fecha] Masectomia: ").concat(cirugiasINCanMasectomiaFecha.toString()).
                concat("\tCirugia INCan - [Fecha] Conservadora: ").concat(cirugiasINCanConservadoraFecha.toString()).
                concat("\tCirugia INCan - [Fecha] Reconstruccion: ").concat(cirugiasINCanReconstruccionFecha.toString()).
                
                concat(" ]");

    }
    public static String DateNa (Date myDate){
        if (myDate.toString().equals("1900-01-01")) return "NA";
        else return myDate.toString();
    }
    public static String IntNa (Integer myInt){
        if (myInt.toString().equals("-1")) return "NA";
        else return myInt.toString();
    }
    
    public ArrayList<String> toStringRStudio() {
        ArrayList<String> Atributos = new ArrayList<>();
        Atributos.add(nombrePersona.concat(" ").concat(primerApellido).
                concat(" ").concat(segundoApellido));
        Atributos.add(curp);
        Atributos.add(telefono);
        Atributos.add(correo);
        Atributos.add(tipoSangre);
        Atributos.add(estado);
        Atributos.add(municipio);
        Atributos.add(DateNa(fechaNacimiento));
        Atributos.add(estadoCivil);
        Atributos.add(sexo);
        Atributos.add(escolaridad);
        Atributos.add(nivelSocioeconomico);
        Atributos.add(seguro);
        Atributos.add(noSeguroPopular);
        Atributos.add(prz);
        Atributos.add(noExpediente);
        Atributos.add(Alergias);
        Atributos.add(sillaRuedas);
        Atributos.add(oxigeno);
        Atributos.add(camilla);
        Atributos.add(bastón);
        Atributos.add(consultaTipo);
        Atributos.add(consultaEstado);
        Atributos.add(consultaMotivo);
        Atributos.add(consultaComentario);
        Atributos.add(DateNa(consultaFecha));
        Atributos.add(DateNa(consultaDiagnosticoFecha));
        Atributos.add(consultaAdscritoNombre);
        Atributos.add(consultaAdscritoPresente);
        Atributos.add(consultaRadiologoNombre);
        Atributos.add(consultaRadiologoPresente);
        Atributos.add(DateNa(estudioPrevioQuimioFecha));
        Atributos.add(IntNa(estudioPrevioQuimioCiclos));
        Atributos.add(DateNa(estudioPrevioRadioFecha));
        Atributos.add(IntNa(estudioPrevioRadioCiclos));
        Atributos.add(DateNa(estudioPrevioCirugiaFecha));
        Atributos.add(estudioPrevioCirugiaTipo);
        Atributos.add(DateNa(estudioPrevioMastografiaFecha));
        Atributos.add(estudioPrevioMastografia);
        Atributos.add(DateNa(estudioPrevioUSGFecha));
        Atributos.add(estudioPrevioUSG);
        Atributos.add(biopsiaPreviaLaminillas);
        Atributos.add(biopsiaPreviaBloques);
        Atributos.add(biopsiaPreviaTipo);
        Atributos.add(DateNa(biopsiaPreviaFecha));
        Atributos.add(biopsiaPreviaLugarCuerpo);
        Atributos.add(estudioINCanMastografia);
        Atributos.add(DateNa(estudioINCanMastografiaFecha));
        Atributos.add(estudioINCanUSG);
        Atributos.add(DateNa(estudioINCanUSGFecha));
        Atributos.add(DateNa(estudioINCanRadiografia));
        Atributos.add(DateNa(estudioINCanTomografia));
        Atributos.add(DateNa(estudioINCanMr));
        Atributos.add(DateNa(estudioINCanTransvaginal));
        Atributos.add(DateNa(estudioINCanAbdominal));
        Atributos.add(DateNa(estudioINCanTiroides));
        Atributos.add(DateNa(estudioINCanPelvico));
        Atributos.add(DateNa(estudioINCanHepatico));
        Atributos.add(DateNa(estudioINCanPet));
        Atributos.add(DateNa(estudioINCanMuga));
        Atributos.add(DateNa(estudioINCanGamma));
        Atributos.add(DateNa(estudioINCanLaboratorio));
        Atributos.add(DateNa(estudioINCanCardio));
        Atributos.add(DateNa(estudioINCanAnestesica));
        Atributos.add(DateNa(estudioINCanInhaloterapia));
        Atributos.add(DateNa(estudioINCanElectro));
        Atributos.add(DateNa(estudioINCanEco));
        Atributos.add(DateNa(programaINCanTrabajoSocial));
        Atributos.add(DateNa(programaINCanMujeresJovenes));
        Atributos.add(DateNa(programaINCanNutricion));
        Atributos.add(DateNa(programaINCanGenetica));
        Atributos.add(preconsultaSegundaOpcion);
        Atributos.add(DateNa(preconsultaFechaDecision));
        Atributos.add(preconsultaDecision);
        Atributos.add(biopsiaINCanEtapa);
        Atributos.add(biopsiaINCanT);
        Atributos.add(biopsiaINCanN);
        Atributos.add(biopsiaINCanM);
        Atributos.add(biopsiaINCanGradoHistologico);
        Atributos.add(biopsiaINCanHer2);
        Atributos.add(biopsiaINCanFish);
        Atributos.add(biopsiaINCanKi67);
        Atributos.add(biopsiaINCanRe);
        Atributos.add(biopsiaINCanRp);
        Atributos.add(DateNa(cirugiasINCanMasectomiaFecha));
        Atributos.add(DateNa(cirugiasINCanConservadoraFecha));
        Atributos.add(DateNa(cirugiasINCanReconstruccionFecha));
        return Atributos;
    }
    public static ArrayList<String> tableHeaderRStudio(){
        ArrayList<String> Encabezados = new ArrayList<>();
        Encabezados.add("Nombre");
        Encabezados.add("Curp");
        Encabezados.add("Telefono");
        Encabezados.add("Correo");
        Encabezados.add("Tipo de sangre");
        Encabezados.add("Estado");
        Encabezados.add("Municipio");
        Encabezados.add("Fecha de nacimiento");
        Encabezados.add("Estado civil");
        Encabezados.add("Sexo");
        Encabezados.add("Nivel educativo");
        Encabezados.add("Nivel Socioeconomico");
        Encabezados.add("Seguro");
        Encabezados.add("Número de Seguro popular");
        Encabezados.add("PRZ");
        Encabezados.add("Número de expediente");
        Encabezados.add("Alergias");
        Encabezados.add("Silla de ruedas");
        Encabezados.add("Oxígeno");
        Encabezados.add("Camilla");
        Encabezados.add("Bastón");
        Encabezados.add("Consulta - Tipo");
        Encabezados.add("Consulta - Estado");
        Encabezados.add("Consulta - Motivo");
        Encabezados.add("Consulta - Comentario");
        Encabezados.add("Consulta - Fecha");
        Encabezados.add("Consulta - Fecha de diagnostico");
        Encabezados.add("Consulta - Nombre de adscrito");
        Encabezados.add("Consulta - Adscrito presente");
        Encabezados.add("Consulta - Nombre de radiologo");
        Encabezados.add("Consulta - Radiologo presente");
        Encabezados.add("Quimioterapia previa - Fecha");
        Encabezados.add("Quimioterapia previa - Ciclos");
        Encabezados.add("Radioterapia previa - Fecha");
        Encabezados.add("Radioterapia previa - Ciclos");
        Encabezados.add("Cirugía previa - Fecha");
        Encabezados.add("Cirugía previa - Tipo");
        Encabezados.add("Mastografía previa - Fecha");
        Encabezados.add("Mastografía previa - Resultado");
        Encabezados.add("Mastografía previa - Fecha");
        Encabezados.add("Mastografía previa - Resultado");
        Encabezados.add("Biopsia Previa - Laminillas");
        Encabezados.add("Biopsia Previa - Bloques");
        Encabezados.add("Biopsia Previa - Tipo");
        Encabezados.add("Biopsia Previa - Fecha");
        Encabezados.add("Biopsia Previa - Lugar Cuerpo");
        Encabezados.add("Estudio INCan - [Resultado] Mastografía Resultado");
        Encabezados.add("Estudio INCan - [Fecha] Mastografía Fecha");
        Encabezados.add("Estudio INCan - [Resultado] Guiada por ultrasonido");
        Encabezados.add("Estudio INCan - [Fecha] Guiada por ultrasonido");
        Encabezados.add("Estudio INCan - [Fecha] Radiografía");
        Encabezados.add("Estudio INCan - [Fecha] Tomografía");
        Encabezados.add("Estudio INCan - [Fecha] Resonancia Magentica");
        Encabezados.add("Estudio INCan - [Fecha] Transvaginal");
        Encabezados.add("Estudio INCan - [Fecha] Abdominal");
        Encabezados.add("Estudio INCan - [Fecha] Tiroides");
        Encabezados.add("Estudio INCan - [Fecha] Pélvico");
        Encabezados.add("Estudio INCan - [Fecha] Hepático");
        Encabezados.add("Estudio INCan - [Fecha] PET-CT");
        Encabezados.add("Estudio INCan - [Fecha] MUGA");
        Encabezados.add("Estudio INCan - [Fecha] Gammagrama óseo");
        Encabezados.add("Estudio INCan - [Fecha] Laboratorio");
        Encabezados.add("Estudio INCan - [Fecha] Cardiovascular");
        Encabezados.add("Estudio INCan - [Fecha] Por anestesia");
        Encabezados.add("Estudio INCan - [Fecha] Espirometría / Inhaloterapia");
        Encabezados.add("Estudio INCan - [Fecha] Electrocardiograma");
        Encabezados.add("Estudio INCan - [Fecha] Ecoardiograma");
        Encabezados.add("Programa INCan - [Fecha] Trabajo social");
        Encabezados.add("Programa INCan - [Fecha] Mujeres jóvenes");
        Encabezados.add("Programa INCan - [Fecha] Nutrición");
        Encabezados.add("Programa INCan - [Fecha] Genética");
        Encabezados.add("Preconsulta - Primera vez / Segunda opción");
        Encabezados.add("Preconsulta - Fecha decision");
        Encabezados.add("Preconsulta - Decision");
        Encabezados.add("Biopsia INCan - Etapa");
        Encabezados.add("Biopsia INCan - T");
        Encabezados.add("Biopsia INCan - N");
        Encabezados.add("Biopsia INCan - M");
        Encabezados.add("Biopsia INCan - Grado Histologico");
        Encabezados.add("Biopsia INCan - Her2");
        Encabezados.add("Biopsia INCan - Fish");
        Encabezados.add("Biopsia INCan - Ki67");
        Encabezados.add("Biopsia INCan - Re");
        Encabezados.add("Biopsia INCan - Rp");
        Encabezados.add("Cirugia INCan - [Fecha] Masectomia");
        Encabezados.add("Cirugia INCan - [Fecha] Conservadora");
        Encabezados.add("Cirugia INCan - [Fecha] Reconstruccion");
        return Encabezados;
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

    public Date getEstudioPrevioQuimioFecha() {
        return estudioPrevioQuimioFecha;
    }

    public void setEstudioPrevioQuimioFecha(Date estudioPrevioQuimioFecha) {
        this.estudioPrevioQuimioFecha = estudioPrevioQuimioFecha;
    }

    public Integer getEstudioPrevioQuimioCiclos() {
        return estudioPrevioQuimioCiclos;
    }

    public void setEstudioPrevioQuimioCiclos(Integer estudioPrevioQuimioCiclos) {
        this.estudioPrevioQuimioCiclos = estudioPrevioQuimioCiclos;
    }

    public Date getEstudioPrevioRadioFecha() {
        return estudioPrevioRadioFecha;
    }

    public void setEstudioPrevioRadioFecha(Date estudioPrevioRadioFecha) {
        this.estudioPrevioRadioFecha = estudioPrevioRadioFecha;
    }

    public Integer getEstudioPrevioRadioCiclos() {
        return estudioPrevioRadioCiclos;
    }

    public void setEstudioPrevioRadioCiclos(Integer estudioPrevioRadioCiclos) {
        this.estudioPrevioRadioCiclos = estudioPrevioRadioCiclos;
    }

    public Date getEstudioPrevioCirugiaFecha() {
        return estudioPrevioCirugiaFecha;
    }

    public void setEstudioPrevioCirugiaFecha(Date estudioPrevioCirugiaFecha) {
        this.estudioPrevioCirugiaFecha = estudioPrevioCirugiaFecha;
    }

    public String getEstudioPrevioCirugiaTipo() {
        return estudioPrevioCirugiaTipo;
    }

    public void setEstudioPrevioCirugiaTipo(String estudioPrevioCirugiaTipo) {
        this.estudioPrevioCirugiaTipo = estudioPrevioCirugiaTipo;
    }

    public Date getEstudioPrevioMastografiaFecha() {
        return estudioPrevioMastografiaFecha;
    }

    public void setEstudioPrevioMastografiaFecha(Date estudioPrevioMastografiaFecha) {
        this.estudioPrevioMastografiaFecha = estudioPrevioMastografiaFecha;
    }

    public String getEstudioPrevioMastografia() {
        return estudioPrevioMastografia;
    }

    public void setEstudioPrevioMastografia(String estudioPrevioMastografia) {
        this.estudioPrevioMastografia = estudioPrevioMastografia;
    }

    public Date getEstudioPrevioUSGFecha() {
        return estudioPrevioUSGFecha;
    }

    public void setEstudioPrevioUSGFecha(Date estudioPrevioUSGFecha) {
        this.estudioPrevioUSGFecha = estudioPrevioUSGFecha;
    }

    public String getEstudioPrevioUSG() {
        return estudioPrevioUSG;
    }

    public void setEstudioPrevioUSG(String estudioPrevioUSG) {
        this.estudioPrevioUSG = estudioPrevioUSG;
    }

    public Date getCirugiasINCanMasectomiaFecha() {
        return cirugiasINCanMasectomiaFecha;
    }

    public void setCirugiasINCanMasectomiaFecha(Date cirugiasINCanMasectomiaFecha) {
        this.cirugiasINCanMasectomiaFecha = cirugiasINCanMasectomiaFecha;
    }

    public Date getCirugiasINCanConservadoraFecha() {
        return cirugiasINCanConservadoraFecha;
    }

    public void setCirugiasINCanConservadoraFecha(Date cirugiasINCanConservadoraFecha) {
        this.cirugiasINCanConservadoraFecha = cirugiasINCanConservadoraFecha;
    }

    public Date getCirugiasINCanReconstruccionFecha() {
        return cirugiasINCanReconstruccionFecha;
    }

    public void setCirugiasINCanReconstruccionFecha(Date cirugiasINCanReconstruccionFecha) {
        this.cirugiasINCanReconstruccionFecha = cirugiasINCanReconstruccionFecha;
    }

    public String getConsultaTipo() {
        return consultaTipo;
    }

    public void setConsultaTipo(String consultaTipo) {
        this.consultaTipo = consultaTipo;
    }

    public String getConsultaEstado() {
        return consultaEstado;
    }

    public void setConsultaEstado(String consultaEstado) {
        this.consultaEstado = consultaEstado;
    }

    public String getConsultaMotivo() {
        return consultaMotivo;
    }

    public void setConsultaMotivo(String consultaMotivo) {
        this.consultaMotivo = consultaMotivo;
    }

    public String getConsultaComentario() {
        return consultaComentario;
    }

    public void setConsultaComentario(String consultaComentario) {
        this.consultaComentario = consultaComentario;
    }

    public Date getConsultaFecha() {
        return consultaFecha;
    }

    public void setConsultaFecha(Date consultaFecha) {
        this.consultaFecha = consultaFecha;
    }

    public Date getConsultaDiagnosticoFecha() {
        return consultaDiagnosticoFecha;
    }

    public void setConsultaDiagnosticoFecha(Date consultaDiagnosticoFecha) {
        this.consultaDiagnosticoFecha = consultaDiagnosticoFecha;
    }

    public String getConsultaAdscritoNombre() {
        return consultaAdscritoNombre;
    }

    public void setConsultaAdscritoNombre(String consultaAdscritoNombre) {
        this.consultaAdscritoNombre = consultaAdscritoNombre;
    }

    public String getConsultaAdscritoPresente() {
        return consultaAdscritoPresente;
    }

    public void setConsultaAdscritoPresente(String consultaAdscritoPresente) {
        this.consultaAdscritoPresente = consultaAdscritoPresente;
    }

    public String getConsultaRadiologoNombre() {
        return consultaRadiologoNombre;
    }

    public void setConsultaRadiologoNombre(String consultaRadiologoNombre) {
        this.consultaRadiologoNombre = consultaRadiologoNombre;
    }

    public String getConsultaRadiologoPresente() {
        return consultaRadiologoPresente;
    }

    public void setConsultaRadiologoPresente(String consultaRadiologoPresente) {
        this.consultaRadiologoPresente = consultaRadiologoPresente;
    }
        
}
