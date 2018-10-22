/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.calendario.FullCalendar;

/**
 *
 * @author julioguzman
 */
public interface CalendarioServicio {
    
    List<FullCalendar> mostrarEventos(int idPaciente);
    public int agregarEvento(FullCalendar calendario);
    
}
