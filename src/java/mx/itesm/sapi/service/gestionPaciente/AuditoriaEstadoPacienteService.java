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
    
    public AuditoriaEstadoPaciente getAuditoriaEstadoPaciente(int idAuditoriaEstadoPaciente);
    public List<AuditoriaEstadoPaciente> getAllAuditoriaEstadoPaciente();
    public boolean saveAuditoriaEstadoPaciente(AuditoriaEstadoPaciente auditoriaEstadoPaciente);
    public boolean deleteAuditoriaEstadoPaciente(int idAuditoriaEstadoPaciente);
    public boolean updateAuditoriaEstadoPaciente(AuditoriaEstadoPaciente auditoriaEstadoPaciente);        
    
}
