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
    public EstadoEstudio getEstadoEstudio(int idEstadoEstudio);
    public List<EstadoEstudio> getAllEstadoEstudio();
    public boolean saveEstadoEstudio(EstadoEstudio estadoEstudio);
    public boolean deleteEstadoEstudio (int idEstadoEstudio);
    public boolean updateEstadoEstudio(EstadoEstudio estadoEstudio);
}
