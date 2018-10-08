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
    public OtroMotivo getOtroMotivo(int idOtroMotivo);
    public List<OtroMotivo> getAllOtroMotivo();
    public boolean saveOtroMotivo(OtroMotivo otroMotivo);
    public boolean deleteOtroMotivo(int idOtroMotivo);
    public boolean updateOtroMotivo(OtroMotivo otroMotivo);
}
