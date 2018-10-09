/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.OtroMotivo;

/**
 *
 * @author urieldiaz
 */
public interface OtroMotivoService {
    public OtroMotivo mostrarOtroMotivo(int idOtroMotivo);
    public List<OtroMotivo> mostrarAllOtroMotivo();
    public boolean agregarOtroMotivo(OtroMotivo otroMotivo);
    public boolean borradoLogicoOtroMotivo(int idOtroMotivo);
    public boolean actualizarOtroMotivo(OtroMotivo otroMotivo);
}
