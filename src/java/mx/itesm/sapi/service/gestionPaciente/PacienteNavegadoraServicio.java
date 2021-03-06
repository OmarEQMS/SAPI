/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;

/**
 *
 * @author Uriel Díaz
 */
public interface PacienteNavegadoraServicio {
    public PacienteNavegadora mostrarPacienteNavegadora(int idPacienteNavegadora);
    public PacienteNavegadora mostrarPacienteNavegadoraIdPaciente(int idPaciente);
    public List<PacienteNavegadora> mostrarPacienteNavegadora();
    public int agregarPacienteNavegadora(PacienteNavegadora pacienteNavegadora);
    public boolean actualizarPacienteNavegadora(PacienteNavegadora pacienteNavegadora);
    public boolean borradoLogicoPacienteNavegadora(int idPacienteNavegadora);
}
