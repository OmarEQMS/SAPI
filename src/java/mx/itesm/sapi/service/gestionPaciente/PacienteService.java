/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;

/**
 *
 * @author urieldiaz
 */
public interface PacienteService {
    public Paciente getPaciente(int idPaciente);
    public Paciente getPaciente(String przPaciente);
    public List<Paciente> getAllPaciente();
    public boolean savePaciente(Paciente paciente);
    public boolean updatePaciente(Paciente paciente);
    public boolean deletePaciente(int idPaciente);
}
