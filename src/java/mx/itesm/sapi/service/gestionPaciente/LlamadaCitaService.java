/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;

/**
 *
 * @author urieldiaz
 */
public interface LlamadaCitaService {
    public LlamadaCita getLlamadaCita(int idLlamadaCita);
    public List<LlamadaCita> getAllLlamadaCita();
    public boolean saveLlamadaCita(LlamadaCita llamadaCita);
    public boolean updateLlamadaCita(LlamadaCita llamadaCita);
    public boolean deleteLlamadaCita(int idLlamadaCita);    
}
