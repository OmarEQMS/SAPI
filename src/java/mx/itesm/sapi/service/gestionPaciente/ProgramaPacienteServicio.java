/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;


import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;

/**
 *
 * @author Uriel Díaz
 */
public interface ProgramaPacienteServicio {

    public ProgramaPaciente mostrarProgramaPaciente(int idProgramaAtencion);
     public ProgramaPaciente mostrarProgramaPacienteIdPaciente(int idPaciente);
    public List<ProgramaPaciente> mostrarProgramaPaciente();
      public List<ProgramaPaciente> mostrarProgramaPacienteSeguroIdEspecifico(int idPaciente);
    public int agregarProgramaPaciente(ProgramaPaciente programaAtencion);
    public boolean borradoLogicoProgramaPaciente(int idProgramaAtencion);
    public boolean actualizarProgramaPaciente(ProgramaPaciente programaAtencion);
}
