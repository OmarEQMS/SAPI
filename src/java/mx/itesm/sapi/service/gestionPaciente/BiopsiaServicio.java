/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;

/**
 *
 * @author urieldiaz
 */
public interface BiopsiaServicio {
    public Biopsia mostrarBiopsia(int idBiopsia);
    public List<Biopsia> mostrarAllBiopsia();
    public int agregarBiopsia(Biopsia biopsia);
    public boolean borradoLogicoBiopsia (int idBiopsia);
    public boolean actualizarBiopsia(Biopsia biopsia);        
}
