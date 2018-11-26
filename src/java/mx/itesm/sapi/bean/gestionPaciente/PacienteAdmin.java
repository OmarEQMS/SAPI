/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Diego
 */
public class PacienteAdmin {
    private int idPaciente;
    private String prz;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String tratamiento;
    private String etapaClinica;
    private String telefono;
    private String estado;
    private String medNombre;
    private String medPrimerApellido;
    private String medSegundoApellido;

    @Override
    public String toString() {
        return "PacienteAdmin{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", tratamiento=" + tratamiento + ", etapaClinica=" + etapaClinica + ", telefono=" + telefono + ", estado=" + estado + ", medNombre=" + medNombre + ", medPrimerApellido=" + medPrimerApellido + ", medSegundoApellido=" + medSegundoApellido + '}';
    }

    public String getPrz() {
        return prz;
    }

    public void setPrz(String prz) {
        this.prz = prz;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getEtapaClinica() {
        return etapaClinica;
    }

    public void setEtapaClinica(String etapaClinica) {
        this.etapaClinica = etapaClinica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMedNombre() {
        return medNombre;
    }

    public void setMedNombre(String medNombre) {
        this.medNombre = medNombre;
    }

    public String getMedPrimerApellido() {
        return medPrimerApellido;
    }

    public void setMedPrimerApellido(String medPrimerApellido) {
        this.medPrimerApellido = medPrimerApellido;
    }

    public String getMedSegundoApellido() {
        return medSegundoApellido;
    }

    public void setMedSegundoApellido(String medSegundoApellido) {
        this.medSegundoApellido = medSegundoApellido;
    }
    
    
}
