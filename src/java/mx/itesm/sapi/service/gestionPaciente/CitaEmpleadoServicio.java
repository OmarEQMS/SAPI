/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;

/**
 *
 * @author Oscar Miranda
 */
public interface CitaEmpleadoServicio {
    public CitaEmpleado mostrarCitaEmpleado(int idCitaEmpleado);    
    public CitaEmpleado mostrarCitaEmpleadoIdCita(int idCita);
    public List<CitaEmpleado> mostrarCitaEmpleado();
    public int agregarCitaEmpleado(CitaEmpleado citaEmpleado);
    public boolean borradoLogicoCitaEmpleado(int idCitaEmpleado);
    public boolean actualizarCitaEmpleado(CitaEmpleado  citaEmpleado);
}
