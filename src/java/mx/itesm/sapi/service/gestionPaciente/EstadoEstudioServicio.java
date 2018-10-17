/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.EstadoEstudio;

/**
 *
 * @author Oscar Miranda
 */
public interface EstadoEstudioServicio {
    public EstadoEstudio mostrarEstadoEstudio(int idEstadoEstudio);
    public List<EstadoEstudio> mostrarEstadoEstudio();
    public int agregarEstadoEstudio(EstadoEstudio estadoEstudio);
    public boolean borradoLogicoEstadoEstudio(int idEstadoEstudio);
    public boolean actualizarEstadoEstudio(EstadoEstudio  estadoEstudio);
}
