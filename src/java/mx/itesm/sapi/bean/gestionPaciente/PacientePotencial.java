/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.sql.Date;

/**
 *
 * @author julioguzman
 */
public class PacientePotencial {
    
    private int idPaciente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String estadoPaciente;
    private String prz;
    private Date fechaRegistro;
    private String curp;
    private String telefono;
    private int tipoPaciente;
    private int tieneResultados;
    private Date fechaNavegacion;
    private int color;

    @Override
    public String toString() {
        return "PacientePotencial{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", estadoPaciente=" + estadoPaciente + ", prz=" + prz + ", fechaRegistro=" + fechaRegistro + ", curp=" + curp + ", telefono=" + telefono + ", tipoPaciente=" + tipoPaciente + ", tieneResultados=" + tieneResultados + ", fechaNavegacion=" + fechaNavegacion + ", color=" + color + '}';
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

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    public int getTieneResultados() {
        return tieneResultados;
    }

    public void setTieneResultados(int tieneResultados) {
        this.tieneResultados = tieneResultados;
    }

    public Date getFechaNavegacion() {
        return fechaNavegacion;
    }

    public void setFechaNavegacion(Date fechaNavegacion) {
        this.fechaNavegacion = fechaNavegacion;
    }

    public String getPrz() {
        return prz;
    }

    public void setPrz(String prz) {
        this.prz = prz;
    }

    public int getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(int tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    
    
    
}
