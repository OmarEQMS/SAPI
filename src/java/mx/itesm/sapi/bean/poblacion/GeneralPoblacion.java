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
    private Date programaINCanMamaEnMovimiento;
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

    
    public static String StringNa (String myString){
        if (myString == null) return "NA";
        else return myString;
    }
    public static String DateNa (Date myDate){
        if (myDate == null || myDate.toString().equals("1900-01-01")) return "NA";
        else return myDate.toString();
    }
    public static String IntNa (Integer myInt){
        if (myInt == null || myInt.toString().equals("-1")) return "NA";
        else return myInt.toString();
    }
    
    public ArrayList<String> toStringRStudio() {
        ArrayList<String> Atributos = new ArrayList<>();
        Atributos.add(StringNa(nombrePersona).concat(" ").concat(StringNa(primerApellido)).
                concat(" ").concat(StringNa(segundoApellido)));
        Atributos.add(StringNa(curp));
        Atributos.add(StringNa(telefono));
        Atributos.add(StringNa(correo));
        Atributos.add(StringNa(tipoSangre));
        Atributos.add(StringNa(estado));
        Atributos.add(StringNa(municipio));
        Atributos.add(DateNa(fechaNacimiento));
        Atributos.add(StringNa(estadoCivil));
        Atributos.add(StringNa(sexo));
        Atributos.add(StringNa(escolaridad));
        Atributos.add(StringNa(nivelSocioeconomico));
        Atributos.add(StringNa(seguro));
        Atributos.add(StringNa(noSeguroPopular));
        Atributos.add(StringNa(prz));
        Atributos.add(StringNa(noExpediente));
        Atributos.add(StringNa(Alergias));
        Atributos.add(StringNa(sillaRuedas));
        Atributos.add(StringNa(oxigeno));
        Atributos.add(StringNa(camilla));
        Atributos.add(StringNa(bastón));
        Atributos.add(StringNa(consultaTipo));
        Atributos.add(StringNa(consultaEstado));
        Atributos.add(StringNa(consultaMotivo));
        Atributos.add(StringNa(consultaComentario));
        Atributos.add(DateNa(consultaFecha));
        Atributos.add(DateNa(consultaDiagnosticoFecha));
        Atributos.add(StringNa(consultaAdscritoNombre));
        Atributos.add(StringNa(consultaAdscritoPresente));
        Atributos.add(StringNa(consultaRadiologoNombre));
        Atributos.add(StringNa(consultaRadiologoPresente));
        Atributos.add(DateNa(estudioPrevioQuimioFecha));
        Atributos.add(IntNa(estudioPrevioQuimioCiclos));
        Atributos.add(DateNa(estudioPrevioRadioFecha));
        Atributos.add(IntNa(estudioPrevioRadioCiclos));
        Atributos.add(DateNa(estudioPrevioCirugiaFecha));
        Atributos.add(StringNa(estudioPrevioCirugiaTipo));
        Atributos.add(DateNa(estudioPrevioMastografiaFecha));
        Atributos.add(StringNa(estudioPrevioMastografia));
        Atributos.add(DateNa(estudioPrevioUSGFecha));
        Atributos.add(StringNa(estudioPrevioUSG));
        Atributos.add(StringNa(biopsiaPreviaLaminillas));
        Atributos.add(StringNa(biopsiaPreviaBloques));
        Atributos.add(StringNa(biopsiaPreviaTipo));
        Atributos.add(DateNa(biopsiaPreviaFecha));
        Atributos.add(StringNa(biopsiaPreviaLugarCuerpo));
        Atributos.add(StringNa(estudioINCanMastografia));
        Atributos.add(DateNa(estudioINCanMastografiaFecha));
        Atributos.add(StringNa(estudioINCanUSG));
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
        Atributos.add(DateNa(programaINCanMamaEnMovimiento));
        Atributos.add(StringNa(preconsultaSegundaOpcion));
        Atributos.add(DateNa(preconsultaFechaDecision));
        Atributos.add(StringNa(preconsultaDecision));
        Atributos.add(StringNa(biopsiaINCanEtapa));
        Atributos.add(StringNa(biopsiaINCanT));
        Atributos.add(StringNa(biopsiaINCanN));
        Atributos.add(StringNa(biopsiaINCanM));
        Atributos.add(StringNa(biopsiaINCanGradoHistologico));
        Atributos.add(StringNa(biopsiaINCanHer2));
        Atributos.add(StringNa(biopsiaINCanFish));
        Atributos.add(StringNa(biopsiaINCanKi67));
        Atributos.add(StringNa(biopsiaINCanRe));
        Atributos.add(StringNa(biopsiaINCanRp));
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
        Encabezados.add("Programa INCan - [Fecha] Mama en movimiento");
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

    public void setNivelSocioeconomico(String nivelSocioeconomico) {
        this.nivelSocioeconomico = nivelSocioeconomico;
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

    public void setBiopsiaPreviaLaminillas(String biopsiaPreviaLaminillas) {
        this.biopsiaPreviaLaminillas = biopsiaPreviaLaminillas;
    }

    public void setBiopsiaPreviaBloques(String biopsiaPreviaBloques) {
        this.biopsiaPreviaBloques = biopsiaPreviaBloques;
    }

    public void setBiopsiaPreviaTipo(String biopsiaPreviaTipo) {
        this.biopsiaPreviaTipo = biopsiaPreviaTipo;
    }

    public void setBiopsiaPreviaFecha(Date biopsiaPreviaFecha) {
        this.biopsiaPreviaFecha = biopsiaPreviaFecha;
    }

    public void setBiopsiaPreviaLugarCuerpo(String biopsiaPreviaLugarCuerpo) {
        this.biopsiaPreviaLugarCuerpo = biopsiaPreviaLugarCuerpo;
    }

    public void setBiopsiaINCanGradoHistologico(String biopsiaINCanGradoHistologico) {
        this.biopsiaINCanGradoHistologico = biopsiaINCanGradoHistologico;
    }

    public void setBiopsiaINCanHer2(String biopsiaINCanHer2) {
        this.biopsiaINCanHer2 = biopsiaINCanHer2;
    }

    public void setBiopsiaINCanFish(String biopsiaINCanFish) {
        this.biopsiaINCanFish = biopsiaINCanFish;
    }

    public void setBiopsiaINCanKi67(String biopsiaINCanKi67) {
        this.biopsiaINCanKi67 = biopsiaINCanKi67;
    }

    public void setBiopsiaINCanRe(String biopsiaINCanRe) {
        this.biopsiaINCanRe = biopsiaINCanRe;
    }

    public void setBiopsiaINCanRp(String biopsiaINCanRp) {
        this.biopsiaINCanRp = biopsiaINCanRp;
    }

    public void setEstudioINCanMastografia(String estudioINCanMastografia) {
        this.estudioINCanMastografia = estudioINCanMastografia;
    }

    public void setEstudioINCanMastografiaFecha(Date estudioINCanMastografiaFecha) {
        this.estudioINCanMastografiaFecha = estudioINCanMastografiaFecha;
    }

    public void setEstudioINCanUSG(String estudioINCanUSG) {
        this.estudioINCanUSG = estudioINCanUSG;
    }

    public void setEstudioINCanUSGFecha(Date estudioINCanUSGFecha) {
        this.estudioINCanUSGFecha = estudioINCanUSGFecha;
    }

    public void setEstudioINCanRadiografia(Date estudioINCanRadiografia) {
        this.estudioINCanRadiografia = estudioINCanRadiografia;
    }

    public void setEstudioINCanTomografia(Date estudioINCanTomografia) {
        this.estudioINCanTomografia = estudioINCanTomografia;
    }

    public void setEstudioINCanMr(Date estudioINCanMr) {
        this.estudioINCanMr = estudioINCanMr;
    }

    public void setEstudioINCanTransvaginal(Date estudioINCanTransvaginal) {
        this.estudioINCanTransvaginal = estudioINCanTransvaginal;
    }

    public void setEstudioINCanAbdominal(Date estudioINCanAbdominal) {
        this.estudioINCanAbdominal = estudioINCanAbdominal;
    }

    public void setEstudioINCanTiroides(Date estudioINCanTiroides) {
        this.estudioINCanTiroides = estudioINCanTiroides;
    }

    public void setEstudioINCanPelvico(Date estudioINCanPelvico) {
        this.estudioINCanPelvico = estudioINCanPelvico;
    }

    public void setEstudioINCanHepatico(Date estudioINCanHepatico) {
        this.estudioINCanHepatico = estudioINCanHepatico;
    }

    public void setEstudioINCanPet(Date estudioINCanPet) {
        this.estudioINCanPet = estudioINCanPet;
    }

    public void setEstudioINCanMuga(Date estudioINCanMuga) {
        this.estudioINCanMuga = estudioINCanMuga;
    }

    public void setEstudioINCanGamma(Date estudioINCanGamma) {
        this.estudioINCanGamma = estudioINCanGamma;
    }

    public void setEstudioINCanLaboratorio(Date estudioINCanLaboratorio) {
        this.estudioINCanLaboratorio = estudioINCanLaboratorio;
    }

    public void setEstudioINCanCardio(Date estudioINCanCardio) {
        this.estudioINCanCardio = estudioINCanCardio;
    }

    public void setEstudioINCanAnestesica(Date estudioINCanAnestesica) {
        this.estudioINCanAnestesica = estudioINCanAnestesica;
    }

    public void setEstudioINCanInhaloterapia(Date estudioINCanInhaloterapia) {
        this.estudioINCanInhaloterapia = estudioINCanInhaloterapia;
    }

    public void setEstudioINCanElectro(Date estudioINCanElectro) {
        this.estudioINCanElectro = estudioINCanElectro;
    }

    public void setEstudioINCanEco(Date estudioINCanEco) {
        this.estudioINCanEco = estudioINCanEco;
    }

    public void setProgramaINCanTrabajoSocial(Date programaINCanTrabajoSocial) {
        this.programaINCanTrabajoSocial = programaINCanTrabajoSocial;
    }

    public void setProgramaINCanMujeresJovenes(Date programaINCanMujeresJovenes) {
        this.programaINCanMujeresJovenes = programaINCanMujeresJovenes;
    }

    public void setProgramaINCanNutricion(Date programaINCanNutricion) {
        this.programaINCanNutricion = programaINCanNutricion;
    }

    public void setProgramaINCanGenetica(Date programaINCanGenetica) {
        this.programaINCanGenetica = programaINCanGenetica;
    }
    public void setProgramaINCanMamaEnMovimiento(Date programaINCanMamaEnMovimiento) {
        this.programaINCanMamaEnMovimiento = programaINCanMamaEnMovimiento;
    }

    public void setPreconsultaSegundaOpcion(String preconsultaSegundaOpcion) {
        this.preconsultaSegundaOpcion = preconsultaSegundaOpcion;
    }

    public void setPreconsultaFechaDecision(Date preconsultaFechaDecision) {
        this.preconsultaFechaDecision = preconsultaFechaDecision;
    }

    public void setPreconsultaDecision(String preconsultaDecision) {
        this.preconsultaDecision = preconsultaDecision;
    }

    public void setBiopsiaINCanEtapa(String biopsiaINCanEtapa) {
        this.biopsiaINCanEtapa = biopsiaINCanEtapa;
    }

    public void setBiopsiaINCanT(String biopsiaINCanT) {
        this.biopsiaINCanT = biopsiaINCanT;
    }

    public void setBiopsiaINCanN(String biopsiaINCanN) {
        this.biopsiaINCanN = biopsiaINCanN;
    }

    public void setBiopsiaINCanM(String biopsiaINCanM) {
        this.biopsiaINCanM = biopsiaINCanM;
    }

    public void setEstudioPrevioQuimioFecha(Date estudioPrevioQuimioFecha) {
        this.estudioPrevioQuimioFecha = estudioPrevioQuimioFecha;
    }

    public void setEstudioPrevioQuimioCiclos(Integer estudioPrevioQuimioCiclos) {
        this.estudioPrevioQuimioCiclos = estudioPrevioQuimioCiclos;
    }

    public void setEstudioPrevioRadioFecha(Date estudioPrevioRadioFecha) {
        this.estudioPrevioRadioFecha = estudioPrevioRadioFecha;
    }

    public void setEstudioPrevioRadioCiclos(Integer estudioPrevioRadioCiclos) {
        this.estudioPrevioRadioCiclos = estudioPrevioRadioCiclos;
    }

    public void setEstudioPrevioCirugiaFecha(Date estudioPrevioCirugiaFecha) {
        this.estudioPrevioCirugiaFecha = estudioPrevioCirugiaFecha;
    }

    public void setEstudioPrevioCirugiaTipo(String estudioPrevioCirugiaTipo) {
        this.estudioPrevioCirugiaTipo = estudioPrevioCirugiaTipo;
    }

    public void setEstudioPrevioMastografiaFecha(Date estudioPrevioMastografiaFecha) {
        this.estudioPrevioMastografiaFecha = estudioPrevioMastografiaFecha;
    }

    public void setEstudioPrevioMastografia(String estudioPrevioMastografia) {
        this.estudioPrevioMastografia = estudioPrevioMastografia;
    }

    public void setEstudioPrevioUSGFecha(Date estudioPrevioUSGFecha) {
        this.estudioPrevioUSGFecha = estudioPrevioUSGFecha;
    }

    public void setEstudioPrevioUSG(String estudioPrevioUSG) {
        this.estudioPrevioUSG = estudioPrevioUSG;
    }

    public void setCirugiasINCanMasectomiaFecha(Date cirugiasINCanMasectomiaFecha) {
        this.cirugiasINCanMasectomiaFecha = cirugiasINCanMasectomiaFecha;
    }

    public void setCirugiasINCanConservadoraFecha(Date cirugiasINCanConservadoraFecha) {
        this.cirugiasINCanConservadoraFecha = cirugiasINCanConservadoraFecha;
    }

    public void setCirugiasINCanReconstruccionFecha(Date cirugiasINCanReconstruccionFecha) {
        this.cirugiasINCanReconstruccionFecha = cirugiasINCanReconstruccionFecha;
    }

    public void setConsultaTipo(String consultaTipo) {
        this.consultaTipo = consultaTipo;
    }

    public void setConsultaEstado(String consultaEstado) {
        this.consultaEstado = consultaEstado;
    }

    public void setConsultaMotivo(String consultaMotivo) {
        this.consultaMotivo = consultaMotivo;
    }

    public void setConsultaComentario(String consultaComentario) {
        this.consultaComentario = consultaComentario;
    }

    public void setConsultaFecha(Date consultaFecha) {
        this.consultaFecha = consultaFecha;
    }

    public void setConsultaDiagnosticoFecha(Date consultaDiagnosticoFecha) {
        this.consultaDiagnosticoFecha = consultaDiagnosticoFecha;
    }

    public void setConsultaAdscritoNombre(String consultaAdscritoNombre) {
        this.consultaAdscritoNombre = consultaAdscritoNombre;
    }

    public void setConsultaAdscritoPresente(String consultaAdscritoPresente) {
        this.consultaAdscritoPresente = consultaAdscritoPresente;
    }

    public void setConsultaRadiologoNombre(String consultaRadiologoNombre) {
        this.consultaRadiologoNombre = consultaRadiologoNombre;
    }

    public void setConsultaRadiologoPresente(String consultaRadiologoPresente) {
        this.consultaRadiologoPresente = consultaRadiologoPresente;
    }
    
}
