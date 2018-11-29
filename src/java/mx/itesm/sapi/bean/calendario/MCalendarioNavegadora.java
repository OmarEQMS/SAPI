/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.calendario;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Angel GTZ
 */
/**
 * El bean MCalendarioNavegadora se encarga de crear un objeto con valores necesarios para 
 * crear mostrar y agregar una cita en el calendario navegadora
 * 
 */
public class MCalendarioNavegadora implements Serializable {

    private int idPaciente;
    private String nombre;
    private String title;
    private String start;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaCita;

    public MCalendarioNavegadora() {

    }

    @Override
    public String toString() {
        return "MCalendarioNavegadora [idPaciente: ".concat(String.valueOf(idPaciente)).concat(",nombre: ").concat(nombre).concat(",primer Apellido: ").
                concat(primerApellido).concat(",segundo Apellido: ").concat(segundoApellido)
                .concat(",fechaCita:").concat(fechaCita.toString()).concat("]");

    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    
    
    

}
