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
 * @author urieldiaz
 */
public interface EstadoEstudioService {
    public EstadoEstudio mostrarEstadoEstudio(int idEstadoEstudio);
    public List<EstadoEstudio> mostrarAllEstadoEstudio();
    public boolean agregarEstadoEstudio(EstadoEstudio estadoEstudio);
    public boolean borrarEstadoEstudio (int idEstadoEstudio);
    public boolean actualizarEstadoEstudio(EstadoEstudio estadoEstudio);
}
