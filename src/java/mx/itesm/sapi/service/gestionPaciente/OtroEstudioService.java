/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.OtroEstudio;

/**
 *
 * @author Alex
 */
public interface OtroEstudioService {
    public OtroEstudio mostrarOtroEstudio(int idOtroEstudio);
    public List<OtroEstudio> mostrarOtroEstudio();
    public int agregarOtroEstudio(OtroEstudio otroEstudio);
    public boolean actualizarOtroEstudio(OtroEstudio otroEstudio);
    public boolean borradoLogicoOtroEstudio(int idOtroEstudio);
}
