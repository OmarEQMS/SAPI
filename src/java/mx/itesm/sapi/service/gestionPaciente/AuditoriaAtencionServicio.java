/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.AuditoriaAtencion;

/**
 *
 * @author urieldiaz
 */
public interface AuditoriaAtencionServicio {
    public AuditoriaAtencion mostrarAuditoriaAtencion(int idAuditoriaAtencion);
    public List<AuditoriaAtencion> mostrarAllAuditoriaAtencion();
    public boolean agregarAuditoriaAtencion(AuditoriaAtencion auditoriaAtencion);
    public boolean borradoLogicoAuditoriaAtencion(int idAuditoriaAtencion);    
    public boolean actualizarAuditoriaAtencion(AuditoriaAtencion auditoriaAtencion);
}
