/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;

/**
 *
 * @author urieldiaz
 */
public interface EstadoPacientePacienteService {
    public EstadoPacientePaciente mostrarEstadoPacientePaciente(int idEstadoPacientePaciente);
    public List<EstadoPacientePaciente> mostrarEstadoPacientePaciente();
    public int agregarEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente);
    public boolean borradoLogicoEstadoPacientePaciente(int idEstadoPacientePaciente);
    public boolean actualizarEstadoPacientePaciente(EstadoPacientePaciente EstadoPacientePaciente);
}
