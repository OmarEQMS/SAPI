/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.calendario.FullCalendar;
import mx.itesm.sapi.bean.gestionPaciente.Cita;

/**
 *
 * @author Julio Badillo
 */
public interface CalendarioServicio {
    
    List<FullCalendar> mostrarEventos(int idPaciente);
    public int agregarEvento(Cita cita, String edificio);
    
}
