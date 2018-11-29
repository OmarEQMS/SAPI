/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.calendario.MCalendarioNavegadora;

/**
 *
 * @author Angel GTZ
 *
 * Se crean 3 servicios: Se muestra la lista de paciente que se les puede crear
 * una cita Se crea una cita al paciente seleccionado Muestra tods los pacintes
 * con citas activas
 */
public interface MCalendarioNavegadoraServicio {

    public int agregarCitaPaciente(MCalendarioNavegadora mCalendarioNavegadora);

     List<MCalendarioNavegadora> mostrarPcientesParaCita();

     List<MCalendarioNavegadora> mostrarCitasDePacientes();
}
