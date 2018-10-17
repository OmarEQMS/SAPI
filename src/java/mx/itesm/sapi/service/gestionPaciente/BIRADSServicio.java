/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.BIRADS;

/**
 *
 * @author Oscar Miranda
 */
public interface BIRADSServicio {
    public BIRADS mostrarBIRADS(int idBIRADS);
    public List<BIRADS> mostrarBIRADS();
    public int agregarBIRADS(BIRADS birads);
    public boolean borradoLogicoBIRADS(int idBIRADS);
    public boolean actualizarBIRADS(BIRADS  birads);
}
