/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.AuditoriaEstadoPaciente;

/**
 *
 * @author urieldiaz
 */
public interface AuditoriaEstadoPacienteService {
    
    public AuditoriaEstadoPaciente mostrarAuditoriaEstadoPaciente(int idAuditoriaEstadoPaciente);
    public List<AuditoriaEstadoPaciente> mostrarAllAuditoriaEstadoPaciente();
    public boolean agregarAuditoriaEstadoPaciente(AuditoriaEstadoPaciente auditoriaEstadoPaciente);
    public boolean borrarAuditoriaEstadoPaciente(int idAuditoriaEstadoPaciente);
    public boolean actualizarAuditoriaEstadoPaciente(AuditoriaEstadoPaciente auditoriaEstadoPaciente);        
    
}
