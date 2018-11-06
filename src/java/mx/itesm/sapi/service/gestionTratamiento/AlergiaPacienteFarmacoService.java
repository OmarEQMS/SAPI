/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.AlergiaPacienteFarmaco;

/**
 *
 * @author Diego
 */
public interface AlergiaPacienteFarmacoService {
    
    public int agregarAlergiaPacienteFarmaco(AlergiaPacienteFarmaco alergiaPacienteFarmaco); 
    public AlergiaPacienteFarmaco mostrarAlergiaPacienteFarmaco(int idAlergiaPacienteFarmaco);
    public List<AlergiaPacienteFarmaco> mostrarAlergiaPacienteFarmaco();
     public AlergiaPacienteFarmaco mostrarAlergiaPacienteFarmacoIdPaciente(int idPaciente);
    public List<AlergiaPacienteFarmaco> mostrarAlergiaPacienteFarmacoIdEspecifico(int idPaciente);
    public boolean actualizarAlergiaPacienteFarmaco(AlergiaPacienteFarmaco alergiaPacienteFarmaco);
    public boolean borradoLogicoAlergiaPacienteFarmaco(int idAlergiaPacienteFarmaco);
    
}
