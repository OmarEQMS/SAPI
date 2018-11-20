/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author urieldiaz
 */
public class SolicitudPreconsulta {
    private int idSexo;
    private int silla;
    private int camilla;
    private int baston;
    private int oxigeno;
    private String estudioPrevio;
    private String biopsiaPrevia;
    private String identificacion;
    private String comprobante;
    private String curp;
    private String referencia;
    private String mastografia;
    private String ultrasonido;
    private int motivoCosulta;

    public SolicitudPreconsulta()
    {
        
    }

    @Override
    public String toString() {
        String str = "SolicitudPreconsulta[idSexo:".concat(String.valueOf(idSexo))
        .concat(",silla:").concat(String.valueOf(silla))
        .concat(",camilla:").concat(String.valueOf(camilla))
        .concat(",baston:").concat(String.valueOf(baston))
        .concat(",oxigeno:").concat(String.valueOf(oxigeno))
        .concat(",estudioPrevio:").concat(estudioPrevio)
        .concat(",biopsiaPrevia:").concat(biopsiaPrevia)
        .concat(",identificacion:").concat(identificacion)
        .concat(",comprobante:").concat(comprobante)
        .concat(",curp:").concat(curp)
        .concat(",referencia:").concat(referencia)
        .concat(",mastografia:").concat(mastografia)
        .concat(",ultrasonido:").concat(ultrasonido)
        .concat("]");
        return str;
    }

/*
        return "SolicitudPreconsulta{" + "idSexo=" + idSexo + ", silla=" + silla + ", camilla=" + camilla + ", baston=" + baston + ", oxigeno=" + oxigeno + ", estudioPrevio=" + estudioPrevio + ", biopsiaPrevia=" + biopsiaPrevia + ", identificacion=" + identificacion + ", comprobante=" + comprobante + ", curp=" + curp + ", referencia=" + referencia + ", mastografia=" + mastografia + ", ultrasonido=" + ultrasonido + '}';
    }
 */   

    public int getMotivoCosulta() {
        return motivoCosulta;
    }

    public void setMotivoCosulta(int motivoCosulta) {
        this.motivoCosulta = motivoCosulta;
    }
    
    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getSilla() {
        return silla;
    }

    public void setSilla(int silla) {
        this.silla = silla;
    }

    public int getCamilla() {
        return camilla;
    }

    public void setCamilla(int camilla) {
        this.camilla = camilla;
    }

    public int getBaston() {
        return baston;
    }

    public void setBaston(int baston) {
        this.baston = baston;
    }

    public int getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(int oxigeno) {
        this.oxigeno = oxigeno;
    }

    public String getEstudioPrevio() {
        return estudioPrevio;
    }

    public void setEstudioPrevio(String estudioPrevio) {
        this.estudioPrevio = estudioPrevio;
    }

    public String getBiopsiaPrevia() {
        return biopsiaPrevia;
    }

    public void setBiopsiaPrevia(String biopsiaPrevia) {
        this.biopsiaPrevia = biopsiaPrevia;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMastografia() {
        return mastografia;
    }

    public void setMastografia(String mastografia) {
        this.mastografia = mastografia;
    }

    public String getUltrasonido() {
        return ultrasonido;
    }

    public void setUltrasonido(String ultrasonido) {
        this.ultrasonido = ultrasonido;
    }

    
               
}
