/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Programa;

/**
 *
 * @author urieldiaz
 */
public interface ProgramaService {
    public Programa getPrograma(int idPrograma);
    public List<Programa> getAllPrograma();
    public boolean savePrograma(Programa programa);
    public boolean deletePrograma(int idPrograma);
    public boolean updatePrograma(Programa programa);
}
