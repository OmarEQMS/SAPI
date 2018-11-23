/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.formulario;

import java.sql.Date;

/**
 *
 * @author Alex
 */
public class ReporteNavegadora {
    private String prz;
    private String nombre;
    private String edad;
    private String fechaNacimiento;
    private String genero;
    private String ciudad;
    private String estado;
    private String telefono;
    private String Seguro;
    private String serieLaminillas;
    private Date ultrasonidoBiradsFecha;
    private int ultrasonidoBiradsNombre;
    private Date mastografiaBiradsFecha;
    private int mastografiaBiradsNombre;
    private int cantidadLaminillas;
    private String tipoPaciente;
    private Date quimioterapiaFecha;
    private String navegadora;
    private Date radioterapiaFecha;
    private String cirugiaTipo;
    private String resultadoPatologia;
    private String otroResultado;
    private boolean estadoHormonal; 
    private String resultado;
    private String fechaDecision;
    private String socioeconomico;
    private String decisionCosulta;
    private String llamada;
    private String comentarioIncidencia;
    private String comentarioMedico;
    private String serieParafina;
    private int cantidadParafina;
    private String cirugiaComentario;
    private String quimioterapiaComentario;
    private String radioterapiaComentario;
    private int quimioterapiaCiclo;
    private int radioterapiaCiclo;
    private boolean mastografiaPreINCAN;
    private Date fechaNavegacion;
    private Date fechaConsulta;
    private String medicoAdscrito;
    private String medicoRadiologo;
    private String medicoResidente;
    private boolean noAdscrito;
    private String noSeguro;
    private String fechaFin;
    private String etapaClinica;
    private String T;
    private String N;
    private String M;
    private String resultadoPatologiaPost;
    private String gradoH;
    private String her2;
    private String fish;
    private String re;
    private String rp;
    private String ki67;
    private String mastografiaBiradsNombrePost;
    private String ultrasonidoBiradsNombrePost;
    public ReporteNavegadora() {
    }
  

    @Override
    public String toString() {
        return "MFormularioGeneral{" + "prz=" + prz + ", fechaNavegacion=" + fechaNavegacion 
                + ", fechaConsulta=" + fechaConsulta + ", tipoPaciente=" + tipoPaciente 
                + ", medicoAdscrito=" + medicoAdscrito + ", medicoRadiologo=" + medicoRadiologo 
                + ", medicoResidente=" + medicoResidente + ", noAdscrito=" + noAdscrito 
                + ", estadoHormonal=" + estadoHormonal + ", Seguro=" + Seguro 
                + ", noSeguro=" + noSeguro + ", mastografiaPreINCAN=" + mastografiaPreINCAN 
                + ", cirugiaTipo=" + cirugiaTipo 
                + ", cirugiaComentario=" + cirugiaComentario + ", quimioterapiaFecha=" + quimioterapiaFecha 
                + ", quimioterapiaCiclo=" + quimioterapiaCiclo + ", quimioterapiaComentario=" + quimioterapiaComentario 
                + ", radioterapiaFecha=" + radioterapiaFecha + ", radioterapiaCiclo=" + radioterapiaCiclo 
                + ", radioterapiaComentario=" + radioterapiaComentario + ", mastografiaBiradsNombre=" + mastografiaBiradsNombre 
                + ", mastografiaBiradsFecha=" + mastografiaBiradsFecha + ", ultrasonidoBiradsNombre=" + ultrasonidoBiradsNombre 
                + ", ultrasonidoBiradsFecha=" + ultrasonidoBiradsFecha + ", resultadoPatologia=" + resultadoPatologia 
                + ", otroResultado=" + otroResultado + ", serieParafina=" + serieParafina + ", cantidadParafina=" + cantidadParafina 
                + ", serieLaminillas=" + serieLaminillas + ", cantidadLaminillas=" + cantidadLaminillas 
                + ", fechaFin=" + fechaFin + ", decisionCosulta=" + decisionCosulta + ", socioeconomico=" + socioeconomico  
                + ", comentarioIncidencia=" + comentarioIncidencia + ", comentarioMedico=" + comentarioMedico  
                + '}';
    }

    public String getPrz() {
        return prz;
    }

    public void setPrz(String prz) {
        this.prz = prz;
    }

    public Date getFechaNavegacion() {
        return fechaNavegacion;
    }

    public void setFechaNavegacion(Date fechaNavegacion) {
        this.fechaNavegacion = fechaNavegacion;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String isTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getMedicoAdscrito() {
        return medicoAdscrito;
    }

    public void setMedicoAdscrito(String medicoAdscrito) {
        this.medicoAdscrito = medicoAdscrito;
    }

    public String getMedicoRadiologo() {
        return medicoRadiologo;
    }

    public void setMedicoRadiologo(String medicoRadiologo) {
        this.medicoRadiologo = medicoRadiologo;
    }

    public String getMedicoResidente() {
        return medicoResidente;
    }

    public void setMedicoResidente(String medicoResidente) {
        this.medicoResidente = medicoResidente;
    }

    public boolean isNoAdscrito() {
        return noAdscrito;
    }

    public void setNoAdscrito(boolean noAdscrito) {
        this.noAdscrito = noAdscrito;
    }

    public boolean isEstadoHormonal() {
        return estadoHormonal;
    }

    public void setEstadoHormonal(boolean estadoHormonal) {
        this.estadoHormonal = estadoHormonal;
    }

    public String getSeguro() {
        return Seguro;
    }

    public void setSeguro(String Seguro) {
        this.Seguro = Seguro;
    }

    public String getNoSeguro() {
        return noSeguro;
    }

    public void setNoSeguro(String noSeguro) {
        this.noSeguro = noSeguro;
    }

    public boolean isMastografiaPreINCAN() {
        return mastografiaPreINCAN;
    }

    public void setMastografiaPreINCAN(boolean mastografiaPreINCAN) {
        this.mastografiaPreINCAN = mastografiaPreINCAN;
    }

    public String getCirugiaTipo() {
        return cirugiaTipo;
    }

    public void setCirugiaTipo(String cirugiaTipo) {
        this.cirugiaTipo = cirugiaTipo;
    }

    public String getCirugiaComentario() {
        return cirugiaComentario;
    }

    public void setCirugiaComentario(String cirugiaComentario) {
        this.cirugiaComentario = cirugiaComentario;
    }

    public Date getQuimioterapiaFecha() {
        return quimioterapiaFecha;
    }

    public void setQuimioterapiaFecha(Date quimioterapiaFecha) {
        this.quimioterapiaFecha = quimioterapiaFecha;
    }

    public int getQuimioterapiaCiclo() {
        return quimioterapiaCiclo;
    }

    public void setQuimioterapiaCiclo(int quimioterapiaCiclo) {
        this.quimioterapiaCiclo = quimioterapiaCiclo;
    }

    public String getQuimioterapiaComentario() {
        return quimioterapiaComentario;
    }

    public void setQuimioterapiaComentario(String quimioterapiaComentario) {
        this.quimioterapiaComentario = quimioterapiaComentario;
    }

    public Date getRadioterapiaFecha() {
        return radioterapiaFecha;
    }

    public void setRadioterapiaFecha(Date radioterapiaFecha) {
        this.radioterapiaFecha = radioterapiaFecha;
    }

    public int getRadioterapiaCiclo() {
        return radioterapiaCiclo;
    }

    public void setRadioterapiaCiclo(int radioterapiaCiclo) {
        this.radioterapiaCiclo = radioterapiaCiclo;
    }

    public String getRadioterapiaComentario() {
        return radioterapiaComentario;
    }

    public void setRadioterapiaComentario(String radioterapiaComentario) {
        this.radioterapiaComentario = radioterapiaComentario;
    }

    public int getMastografiaBiradsNombre() {
        return mastografiaBiradsNombre;
    }

    public void setMastografiaBiradsNombre(int mastografiaBiradsNombre) {
        this.mastografiaBiradsNombre = mastografiaBiradsNombre;
    }

    public Date getMastografiaBiradsFecha() {
        return mastografiaBiradsFecha;
    }

    public void setMastografiaBiradsFecha(Date mastografiaBiradsFecha) {
        this.mastografiaBiradsFecha = mastografiaBiradsFecha;
    }

    public int getUltrasonidoBiradsNombre() {
        return ultrasonidoBiradsNombre;
    }

    public void setUltrasonidoBiradsNombre(int ultrasonidoBiradsNombre) {
        this.ultrasonidoBiradsNombre = ultrasonidoBiradsNombre;
    }

    public Date getUltrasonidoBiradsFecha() {
        return ultrasonidoBiradsFecha;
    }

    public void setUltrasonidoBiradsFecha(Date ultrasonidoBiradsFecha) {
        this.ultrasonidoBiradsFecha = ultrasonidoBiradsFecha;
    }

    public String getResultadoPatologia() {
        return resultadoPatologia;
    }

    public void setResultadoPatologia(String resultadoPatologia) {
        this.resultadoPatologia = resultadoPatologia;
    }

    public String getOtroResultado() {
        return otroResultado;
    }

    public void setOtroResultado(String otroResultado) {
        this.otroResultado = otroResultado;
    }

    public String getSerieParafina() {
        return serieParafina;
    }

    public void setSerieParafina(String serieParafina) {
        this.serieParafina = serieParafina;
    }

    public int getCantidadParafina() {
        return cantidadParafina;
    }

    public void setCantidadParafina(int cantidadParafina) {
        this.cantidadParafina = cantidadParafina;
    }

    public String getSerieLaminillas() {
        return serieLaminillas;
    }

    public void setSerieLaminillas(String serieLaminillas) {
        this.serieLaminillas = serieLaminillas;
    }

    public int getCantidadLaminillas() {
        return cantidadLaminillas;
    }

    public void setCantidadLaminillas(int cantidadLaminillas) {
        this.cantidadLaminillas = cantidadLaminillas;
    }

    public String getDecisionCosulta() {
        return decisionCosulta;
    }

    public void setDecisionCosulta(String decisionCosulta) {
        this.decisionCosulta = decisionCosulta;
    }

    public String getSocioeconomico() {
        return socioeconomico;
    }

    public void setSocioeconomico(String socioeconomico) {
        this.socioeconomico = socioeconomico;
    }

    public String getComentarioIncidencia() {
        return comentarioIncidencia;
    }

    public void setComentarioIncidencia(String comentarioIncidencia) {
        this.comentarioIncidencia = comentarioIncidencia;
    }

    public String getComentarioMedico() {
        return comentarioMedico;
    }

    public void setComentarioMedico(String comentarioMedico) {
        this.comentarioMedico = comentarioMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFechaDecision() {
        return fechaDecision;
    }

    public void setFechaDecision(String fechaDecision) {
        this.fechaDecision = fechaDecision;
    }

    public String getLlamada() {
        return llamada;
    }

    public void setLlamada(String llamada) {
        this.llamada = llamada;
    }

    public String getNavegadora() {
        return navegadora;
    }

    public void setNavegadora(String navegadora) {
        this.navegadora = navegadora;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEtapaClinica() {
        return etapaClinica;
    }

    public void setEtapaClinica(String etapaClinica) {
        this.etapaClinica = etapaClinica;
    }

    public String getT() {
        return T;
    }

    public void setT(String T) {
        this.T = T;
    }

    public String getN() {
        return N;
    }

    public void setN(String N) {
        this.N = N;
    }

    public String getM() {
        return M;
    }

    public void setM(String M) {
        this.M = M;
    }

    public String getResultadoPatologiaPost() {
        return resultadoPatologiaPost;
    }

    public void setResultadoPatologiaPost(String resultadoPatologiaPost) {
        this.resultadoPatologiaPost = resultadoPatologiaPost;
    }

    public String getGradoH() {
        return gradoH;
    }

    public void setGradoH(String gradoH) {
        this.gradoH = gradoH;
    }

    public String getHer2() {
        return her2;
    }

    public void setHer2(String her2) {
        this.her2 = her2;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp;
    }

    public String getKi67() {
        return ki67;
    }

    public void setKi67(String ki67) {
        this.ki67 = ki67;
    }

    public String getMastografiaBiradsNombrePost() {
        return mastografiaBiradsNombrePost;
    }

    public void setMastografiaBiradsNombrePost(String mastografiaBiradsNombrePost) {
        this.mastografiaBiradsNombrePost = mastografiaBiradsNombrePost;
    }

    public String getUltrasonidoBiradsNombrePost() {
        return ultrasonidoBiradsNombrePost;
    }

    public void setUltrasonidoBiradsNombrePost(String ultrasonidoBiradsNombrePost) {
        this.ultrasonidoBiradsNombrePost = ultrasonidoBiradsNombrePost;
    }
}
