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
 * @author Oscar Miranda
 */
public interface EstadoCitaServicio {
    public EstadoCita mostrarEstadoCita(int idEstadoCita);
    public List<EstadoCita> mostrarEstadoCita();
    public int agregarEstadoCita(EstadoCita estadoCita);
    public boolean borradoLogicoEstadoCita(int idEstadoCita);
    public boolean actualizarEstadoCita(EstadoCita estadoCita);
}
