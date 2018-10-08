/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;

/**
 *
 * @author urieldiaz
 */
public interface EstudioService {
    public Estudio getEstudio(int idEstudio);
    public List<Estudio> getAllEstudio();
    public boolean saveEstudio (Estudio estudio);
    public boolean updateEstudio(Estudio estudio);
    public boolean deleteEstudio (int idEstudio);
}
