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
    public Estudio mostrarEstudio(int idEstudio);
    public List<Estudio> mostrarAllEstudio();
    public boolean agregarEstudio (Estudio estudio);
    public boolean actualizarEstudio(Estudio estudio);
    public boolean borradoLogicoEstudio (int idEstudio);
}
