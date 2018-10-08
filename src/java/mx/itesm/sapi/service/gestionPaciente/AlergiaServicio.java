/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;

/**
 *
 * @author urieldiaz
 */
public interface AlergiaServicio {
    public Alergia getAlergia(int idAlergia);
    public Alergia getAlergia(String nombreAlergia);    
    public List<Alergia> getAllAlergias();
    public boolean saveAlergia(Alergia alergia);
    public boolean deleteAlergia(int idAlergia);
    public boolean deleteAlergia(String nombreAlergia);
    public boolean updateAlergia(Alergia alergia);        
}
