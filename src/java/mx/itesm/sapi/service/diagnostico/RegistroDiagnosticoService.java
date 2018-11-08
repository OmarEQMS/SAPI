/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;

/**
 *
 * @author Diego Montoya
 */
public interface RegistroDiagnosticoService {
    public int agregarRegistroDiagnostico(RegistroDiagnostico registroDiagnostico);
    public RegistroDiagnostico mostrarRegistroDiagnostico(int idRegistroDiagnostico);
    public RegistroDiagnostico mostrarRegistroDiagnosticoPaciente(int idPaciente);
    List<RegistroDiagnostico> mostrarRegistroDiagnostico();
    public boolean actualizarRegistroDiagnostico(RegistroDiagnostico registroDiagnostico);
    public boolean borradoLogicoRegistroDiagnostico(int idRegistroDiagnostico);
    
}
