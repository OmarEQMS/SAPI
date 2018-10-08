/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.NecesidadEspecial;

/**
 *
 * @author urieldiaz
 */
public interface NecesidadEspecialService {
    public NecesidadEspecial getNecesidadEspecial(int idNecesidadEspecial);
    public NecesidadEspecial getNecesidadEspecial(String nombreNecesidadEspecial);
    public List<NecesidadEspecial> getNecesidadEspecial();
    public boolean saveNecesidadEspecial(NecesidadEspecial necesidadEspecial);
    public boolean updateNecesidadEspecial(NecesidadEspecial necesidadEspecial);
    public boolean deleteNecesidadEspecial(int idNecesidadEspecial);
}
