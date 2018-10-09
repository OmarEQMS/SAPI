/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.AuditoriaCuenta;

/**
 *
 * @author urieldiaz
 */
public interface AuditoriaCuentaServicio {
    public AuditoriaCuenta mostrarAuditoriaCuenta(int idAuditoriaCuenta);
    public List<AuditoriaCuenta> mostrarAllAuditoriaCuenta();
    public boolean agregarAuditoriaCuenta(AuditoriaCuenta auditoriaCuenta);
    public boolean borradoLogicoAuditoriaCuenta(int idAuditoriaCuenta);
    public boolean actualizarAuditoriaCuenta(AuditoriaCuenta auditoriaCuenta);
    
}
