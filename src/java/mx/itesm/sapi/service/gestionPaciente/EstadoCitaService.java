/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoCita;

/**
 *
 * @author urieldiaz
 */
public interface EstadoCitaService {
    
    public EstadoCita mostrarEstadoCita(int idEstadoCita);
    public List<EstadoCita> mostrarAllEstadoCita();
    public boolean agregarEstadoCita(EstadoCita estadoCita);
   
    public boolean borradoLogicoEstadoCita(int idEstadoCita);
    public boolean actualizarEstadoCita(EstadoCita estadoCita);
}
