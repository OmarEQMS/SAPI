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
    public ReceptorProgesterona mostrarReceptorProgesterona(int idReceptorProgesterona);
    public List<ReceptorProgesterona> mostrarAllReceptorProgesterona();
    public int agregarReceptorProgesterona(ReceptorProgesterona receptorProgesterona);
    public boolean actualizarReceptorProgesterona(ReceptorProgesterona receptorProgesterona);
    public boolean borradoLogicoReceptorProgesterona(int idReceptorProgesterona);
}
