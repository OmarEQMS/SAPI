/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacientePotencial;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;

/**
 *
 * @author Uriel Díaz
 */
public interface PacienteService {
    public Paciente mostrarPaciente(int idPaciente);
    //public Paciente mostrarPaciente(String przPaciente);
    public List<Paciente> mostrarPaciente();
    public int agregarPaciente(Paciente paciente);
    public int agregarPacienteRegistro(int idCuenta);
    public boolean actualizarPaciente(Paciente paciente);
    public boolean borradoLogicoPaciente(int idPaciente);
    public List<PacientePotencial> mostrarPacientesPotenciales();
    public List<PacientePotencial> mostrarPacientesPotencialesAprobados();
    public int mostrarColor(int idPaciente);
    public int obtenerCuenta(int idPaciente);
    public int obtenerPersona(int idCuenta);

}
