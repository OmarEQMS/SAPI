/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionTratamiento;

import java.util.List;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;

/**
 *
 * @author Admin
 */
public interface PacienteTratamientoPrevioService {
    
    public int agregarPacienteTratamientoPrevio(PacienteTratamientoPrevio pacienteTratamientoPrevio);
    public PacienteTratamientoPrevio mostrarPacienteTratamientoPrevio(int idPacienteTratamientoPrevio);
    public List<PacienteTratamientoPrevio> mostrarPacienteTratamientoPrevio();
    public boolean actualizarPacienteTratamientoPrevio(PacienteTratamientoPrevio pacienteTratamientoPrevio);
    public boolean borradoLogicoPacienteTratamientoPrevio(int idPacienteTratamientoPrevio);

    
}
