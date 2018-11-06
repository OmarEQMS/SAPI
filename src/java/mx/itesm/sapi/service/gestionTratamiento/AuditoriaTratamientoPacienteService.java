/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.AuditoriaTratamientoPaciente;

/**
 *
 * @author Admin
 */
public interface AuditoriaTratamientoPacienteService {

    public int agregarAuditoriaTratamientoPaciente(AuditoriaTratamientoPaciente auditoriaTratamientoPaciente); 
    public AuditoriaTratamientoPaciente mostrarAuditoriaTratamientoPaciente(int idAuditoriaTratamientoPaciente);
    public AuditoriaTratamientoPaciente mostrarAuditoriaTratamientoPacienteIdTratamiento(int idTratamiento);
    public List<AuditoriaTratamientoPaciente> mostrarAuditoriaTratamientoPaciente();
    public boolean actualizarAuditoriaTratamientoPaciente(AuditoriaTratamientoPaciente auditoriaTratamientoPaciente);
    public boolean borradoLogicoAuditoriaTratamientoPaciente(int idAuditoriaTratamientoPaciente);
    
}
