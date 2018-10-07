/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.AuditoriaRegistroDiagnostico;

/**
 *
 * @author Diego
 */
public interface AuditoriaRegistroDiagnosticoService {
    public AuditoriaRegistroDiagnostico getAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico);
    List<AuditoriaRegistroDiagnostico> getAuditoriaRegistroDiagnostico();
    public boolean agregarAuditoriaRegistroDiagnostico(AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico);
    public boolean actualizarAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico);
    public boolean borradoLogicoAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico);
}
