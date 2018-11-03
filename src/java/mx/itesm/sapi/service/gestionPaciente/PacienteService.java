/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DatosPacienteDocumentoInicial;
import mx.itesm.sapi.bean.moduloGestionPaciente.Paciente;

/**
 *
 * @author urieldiaz
 */
public interface PacienteService {
    public Paciente mostrarPaciente(int idPaciente);
    public Paciente mostrarPaciente(String przPaciente);
    public List<Paciente> mostrarPaciente();
    public int agregarPaciente(Paciente paciente);
    public int agregarPacienteRegistro(int idCuenta);
    public boolean actualizarPaciente(Paciente paciente);
    public boolean borradoLogicoPaciente(int idPaciente);
    
}
