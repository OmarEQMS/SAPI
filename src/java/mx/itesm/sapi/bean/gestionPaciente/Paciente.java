/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author Alex
 */
public class Paciente {
    private int idPaciente;
    private int idCuenta;
    private int idEscolaridad;
    private String prz;
    private String expediente;
    private double peso;
    private double altura;
    private int posMenopausia;
    private int estatus;
    
    public Paciente() {}

    @Override
    public String toString(){
        String str ="Paciente [idPaciente:".concat(String.valueOf(idPaciente))
                .concat(",idCuenta:").concat(String.valueOf(idCuenta))
                .concat(",idEscolaridad:").concat(String.valueOf(idEscolaridad))
                .concat(",prz:").concat(prz)
                .concat(",expediente:").concat(expediente)
                .concat(",peso:").concat(String.valueOf(peso))
                .concat(",altura:").concat(String.valueOf(altura))
                .concat(",posMenopausia:").concat(String.valueOf(posMenopausia))
                .concat(",estatus:").concat(String.valueOf(estatus))         
                .concat("]");
        return str;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getPosMenopausia() {
        return posMenopausia;
    }

    public void setPosMenopausia(int posMenopausia) {
        this.posMenopausia = posMenopausia;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(int idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public String getPrz() {
        return prz;
    }

    public void setPrz(String prz) {
        this.prz = prz;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
}
