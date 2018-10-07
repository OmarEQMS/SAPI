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
 * @author Diego
 */
public interface RegistroDiagnosticoService {
    public RegistroDiagnostico getRegistroDiagnostico(int idRegistroDiagnostico);
    List<RegistroDiagnostico> getRegistroDiagnostico();
    public boolean agregarRegistroDiagnostico(RegistroDiagnostico registroDiagnostico);
    public boolean actualizarRegistroDiagnostico(int idRegistroDiagnostico);
    public boolean borradoLogicoRegistroDiagnostico(int idRegistroDiagnostico);
}
