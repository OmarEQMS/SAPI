/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ReceptorProgesterona;

/**
 *
 * @author urieldiaz
 */
public interface ReceptorProgesteronaService {
    public ReceptorProgesterona getReceptorProgesterona(int idReceptorProgesterona);
    public List<ReceptorProgesterona> getAllReceptorProgesterona();
    public boolean saveReceptorProgesterona(ReceptorProgesterona receptorProgesterona);
    public boolean updateReceptorProgesterona(ReceptorProgesterona receptorProgesterona);
    public boolean deleteReceptorProgesterona(int idReceptorProgesterona);
}
