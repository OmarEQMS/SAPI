/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ImportanciaCita;

/**
 *
 * @author urieldiaz
 */
public interface ImportanciaCitaService {
    public ImportanciaCita getImportanciaCita(int idImportanciaCita);
    public List<ImportanciaCita> getAllImportanciaCita();
    public boolean saveImportanciaCita(ImportanciaCita importanciaCita);
    public boolean updateImportanciaCita(ImportanciaCita importanciaCita);
    public boolean deleteImportanciaCita(int idImportanciaCita);
    
}
