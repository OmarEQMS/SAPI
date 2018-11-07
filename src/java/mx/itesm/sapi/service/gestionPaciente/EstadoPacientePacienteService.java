
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
 * @author Uriel Díaz
 */
public interface EstadoPacientePacienteService {

    public EstadoPacientePaciente mostrarEstadoPacientePaciente(int idEstadoPacientePaciente);
    public EstadoPacientePaciente mostrarEstadoPacientePacienteIdPaciente(int idPaciente);

    public List<EstadoPacientePaciente> mostrarEstadoPacientePaciente();

    public int agregarEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente);

    public int agregarEstadoPacientePacienteRegistro(int idPaciente);

    public boolean borradoLogicoEstadoPacientePaciente(int idEstadoPacientePaciente);

    public boolean actualizarEstadoPacientePaciente(EstadoPacientePaciente estadoPacientePaciente);

    public int estadoPrimeraSegundaVez(int idPaciente);       
}
