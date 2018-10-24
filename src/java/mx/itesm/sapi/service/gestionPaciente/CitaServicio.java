/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Cita;

/**
 *
 * @author Oscar Miranda
 */
public interface CitaServicio {
    public Cita mostrarCita(int idCita);
    public List<Cita> mostrarCita();
    public int agregarCita(Cita cita);    
    public boolean borradoLogicoCita(int idCita);
    public boolean actualizarCita(Cita  cita);
    public int agregarPreconsulta(Cita cita);
    
}
