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
 * @author urieldiaz
 */
public interface ProgramaAtencionService {
    public ProgramaPaciente mostrarProgramaAtencion(int idProgramaAtencion);
    public List<ProgramaPaciente> mostrarAllProgramaAtencion();
    public boolean agregarProgramaAtencion(ProgramaPaciente programaAtencion);
    public boolean borradoLogicoProgramaAtencion(int idProgramaAtencion);
    public boolean actualizarProgramaAtencion(ProgramaPaciente programaAtencion);
}
