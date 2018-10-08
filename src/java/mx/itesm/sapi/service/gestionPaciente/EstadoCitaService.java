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
    public EstadoCita getEstadoCita(int idEstadoCita);
    public List<EstadoCita> getAllEstadoCita();
    public boolean saveEstadoCita(EstadoCita estadoCita);
    public boolean deleteEstadoCita(int idEstadoCita);
    public boolean updateEstadoCita(EstadoCita estadoCita);
}
