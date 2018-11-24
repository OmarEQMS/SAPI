/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.formulario;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
/**
 * public class MFormularioGeneral Clase para mostrar los datos de formulario
 * que ya fueron llenados
 */
/**
 * Cada dato es una parte del Formulario dividida por el input
 */
public class MFormularioGeneral implements Serializable {

    private String prz;
    private Date fechaNavegacion;
    private Date fechaConsulta;
    private boolean tipoPaciente;
    private String medicoAdscrito;
    private String medicoRadiologo;
    private String medicoResidente;
    private boolean noAdscrito;
    private boolean noRadiologo;
    private String escolaridad;
    private String alergias;
    private boolean estadoHormonal;
    private String Seguro;
    private String noSeguro;
    private boolean mastografiaPreINCAN;
    private Date cirugiaFecha;
    private String cirugiaTipo;
    private String cirugiaComentario;
    private Date quimioterapiaFecha;
    private int quimioterapiaCiclo;
    private String quimioterapiaComentario;
    private Date radioterapiaFecha;
    private int radioterapiaCiclo;
    private String radioterapiaComentario;
    private String mastografiaBiradsNombre;
    private Date mastografiaBiradsFecha;
    private String ultrasonidoBiradsNombre;
    private Date ultrasonidoBiradsFecha;
    private String resultadoPatologia;
    private String otroResultado;
    private String serieParafina;
    private int cantidadParafina;
    private String serieLaminillas;
    private int cantidadLaminillas;
    private String T;
    private String N;
    private String M;
    private Date fechaFin;
    private String decisionCosulta;
    private String socioeconomico;
    private String comentarioLLamada;
    private Date fechaLlamada;
    private String comentarioIncidencia;
    private String comentarioMedico;
    private String etapaClinica;
    private String masto;
    private String ultra;
    private String rp;
    private String re;
    private String her2;
    private String fish;
    private String ki67;
    private String gradoH;
    private String resultadoPatologiaPost;


    private int idCita;
    private String nombreEstudio;
    private Date CitaProgramada;
    private String lugarCuerpo;

    public MFormularioGeneral() {

    }

    @Override
    public String toString() {
        return "MFormularioGeneral{" + "prz=" + prz + ", fechaNavegacion=" + fechaNavegacion + ", fechaConsulta=" + fechaConsulta + ", tipoPaciente=" + 
                tipoPaciente + ", medicoAdscrito=" + medicoAdscrito + ", medicoRadiologo=" + medicoRadiologo + ", medicoResidente=" + medicoResidente + ", noAdscrito=" +
                noAdscrito + ", noRadiologo=" + noRadiologo + ", escolaridad=" + escolaridad + ", alergias=" + alergias + ", estadoHormonal=" + estadoHormonal + ", Seguro=" + 
                Seguro + ", noSeguro=" + noSeguro + ", mastografiaPreINCAN=" + mastografiaPreINCAN + ", cirugiaFecha=" + cirugiaFecha + ", cirugiaTipo=" + 
                cirugiaTipo + ", cirugiaComentario=" + cirugiaComentario + ", quimioterapiaFecha=" + quimioterapiaFecha + ", quimioterapiaCiclo=" + 
                quimioterapiaCiclo + ", quimioterapiaComentario=" + quimioterapiaComentario + ", radioterapiaFecha=" + radioterapiaFecha + ", radioterapiaCiclo=" + 
                radioterapiaCiclo + ", radioterapiaComentario=" + radioterapiaComentario + ", mastografiaBiradsNombre=" + mastografiaBiradsNombre + ", mastografiaBiradsFecha=" + 
                mastografiaBiradsFecha + ", ultrasonidoBiradsNombre=" + ultrasonidoBiradsNombre + ", ultrasonidoBiradsFecha=" + ultrasonidoBiradsFecha + ", resultadoPatologia=" + 
                resultadoPatologia + ", otroResultado=" + otroResultado + ", serieParafina=" + serieParafina + ", cantidadParafina=" + cantidadParafina + ", serieLaminillas=" + 
                serieLaminillas + ", cantidadLaminillas=" + cantidadLaminillas + ", T=" + T + ", N=" + N + ", M=" + M + ", fechaFin=" + fechaFin + ", decisionCosulta=" + 
                decisionCosulta + ", socioeconomico=" + socioeconomico + ", comentarioLLamada=" + comentarioLLamada + ", fechaLlamada=" + fechaLlamada + ", comentarioIncidencia=" + 
                comentarioIncidencia + ", comentarioMedico=" + comentarioMedico + ", etapaClinica=" + etapaClinica + ", masto=" + masto + ", ultra=" + ultra + ", rp=" + rp + ", re=" + 
                re + ", her2=" + her2 + ", fish=" + fish + ", ki67=" + ki67 + ", gradoH=" + gradoH + ", resultadoPatologiaPost=" + resultadoPatologiaPost + idCita + ", idCita " +
                ", nombreEstudio=" + nombreEstudio + ", CitaProgramada=" + CitaProgramada + ", lugarCuerpo=" + lugarCuerpo + '}';
    }

    
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public boolean isTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(boolean tipoPaciente) {
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

    public boolean isNoRadiologo() {
        return noRadiologo;
    }

    public void setNoRadiologo(boolean noRadiologo) {
        this.noRadiologo = noRadiologo;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
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

    public Date getCirugiaFecha() {
        return cirugiaFecha;
    }

    public void setCirugiaFecha(Date cirugiaFecha) {
        this.cirugiaFecha = cirugiaFecha;
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

    public String getMastografiaBiradsNombre() {
        return mastografiaBiradsNombre;
    }

    public void setMastografiaBiradsNombre(String mastografiaBiradsNombre) {
        this.mastografiaBiradsNombre = mastografiaBiradsNombre;
    }

    public Date getMastografiaBiradsFecha() {
        return mastografiaBiradsFecha;
    }

    public void setMastografiaBiradsFecha(Date mastografiaBiradsFecha) {
        this.mastografiaBiradsFecha = mastografiaBiradsFecha;
    }

    public String getUltrasonidoBiradsNombre() {
        return ultrasonidoBiradsNombre;
    }

    public void setUltrasonidoBiradsNombre(String ultrasonidoBiradsNombre) {
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public String getComentarioLLamada() {
        return comentarioLLamada;
    }

    public void setComentarioLLamada(String comentarioLLamada) {
        this.comentarioLLamada = comentarioLLamada;
    }

    public Date getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(Date fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
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

    public String getEtapaClinica() {
        return etapaClinica;
    }

    public void setEtapaClinica(String etapaClinica) {
        this.etapaClinica = etapaClinica;
    }

    public String getMasto() {
        return masto;
    }

    public void setMasto(String masto) {
        this.masto = masto;
    }

    public String getUltra() {
        return ultra;
    }

    public void setUltra(String ultra) {
        this.ultra = ultra;
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
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

    public String getKi67() {
        return ki67;
    }

    public void setKi67(String ki67) {
        this.ki67 = ki67;
    }

    public String getGradoH() {
        return gradoH;
    }

    public void setGradoH(String gradoH) {
        this.gradoH = gradoH;
    }

    public String getResultadoPatologiaPost() {
        return resultadoPatologiaPost;
    }

    public void setResultadoPatologiaPost(String resultadoPatologiaPost) {
        this.resultadoPatologiaPost = resultadoPatologiaPost;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public Date getCitaProgramada() {
        return CitaProgramada;
    }

    public void setCitaProgramada(Date CitaProgramada) {
        this.CitaProgramada = CitaProgramada;
    }

    public String getLugarCuerpo() {
        return lugarCuerpo;
    }

    public void setLugarCuerpo(String lugarCuerpo) {
        this.lugarCuerpo = lugarCuerpo;
    }

}
