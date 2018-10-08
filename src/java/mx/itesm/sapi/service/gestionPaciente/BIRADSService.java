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
 * @author urieldiaz
 */
public interface BIRADSService {
    public BIRADS getBIRADS(int idBIRADS);
    public List<BIRADS> getAllBIRADS();
    public boolean saveBIRADS(BIRADS birads);
    public boolean deleteBIRADS(int idBIRADS);
    public boolean updateBIRADS(BIRADS birads);
}
