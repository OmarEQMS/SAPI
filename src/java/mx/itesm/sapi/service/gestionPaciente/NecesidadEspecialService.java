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
    public NecesidadEspecial mostrarNecesidadEspecial(int idNecesidadEspecial);
    public NecesidadEspecial mostrarNecesidadEspecial(String nombreNecesidadEspecial);
    public List<NecesidadEspecial> mostrarNecesidadEspecial();
    public int agregarNecesidadEspecial(NecesidadEspecial necesidadEspecial);
    public boolean actualizarNecesidadEspecial(NecesidadEspecial necesidadEspecial);
    public boolean borradoLogicoNecesidadEspecial(int idNecesidadEspecial);
}
