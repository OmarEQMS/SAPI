/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.TipoHistologico;

/**
 *
 * @author urieldiaz
 */
public interface TipoHistologicoService {
    public TipoHistologico getTipoHistologico(int idTipoHistologico);
    public List<TipoHistologico> getAllTipoHistologico();
    public boolean saveTipoHistologico(TipoHistologico tipoHistologico);
    public boolean updateTipoHistologico(TipoHistologico tipoHistologico);
    public boolean deleteTipoHistologico(int idTipoHistologico);
}
