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
 * @author Diego Montoya
 */
public interface AuditoriaRegistroDiagnosticoService {
    public int agregarAuditoriaRegistroDiagnostico(AuditoriaRegistroDiagnostico auditoriaRegistroDiagnostico);
    public AuditoriaRegistroDiagnostico mostrarAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico);
    List<AuditoriaRegistroDiagnostico> mostrarAuditoriaRegistroDiagnostico();
    public AuditoriaRegistroDiagnostico mostrarAuditoriaRegistroDiagnosticoIdRegistro(int idRegistro);
    public boolean actualizarAuditoriaRegistroDiagnostico(AuditoriaRegistroDiagnostico AuditoriaRegistroDiagnostico);
    public boolean borradoLogicoAuditoriaRegistroDiagnostico(int idAuditoriaRegistroDiagnostico);
}
