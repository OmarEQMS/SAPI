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
    public Cita mostrarCitaIdPaciente(int idPaciente);
    public Cita mostrarCitaPreconsultaPacientePotencial(int idPaciente);
    public Cita mostrarCitaNavegacionPacientePotencial(int idPaciente);
    public List<Cita> mostrarCita();
    public List<Cita> mostrarCitaIdEspecifico(int idPaciente);
    public int agregarCita(Cita cita);    
    public boolean borradoLogicoCita(int idCita);
    public boolean actualizarCita(Cita  cita);
    public boolean cancelarCitaPreconsulta(int idPacientePotencial, String comentario);
    public int agregarPreconsulta(Cita cita);
    public String mostrarPreconsultaAceptada(int idPacientePotencaial);
    public boolean aprobarPaciente(int idPaciente, String fechaNav, String fechaCon, int segundaOpinion);
    public int citaPendiente(int idPaciente);
    public boolean actualizarCitaFecha(Cita  cita);


}
