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
    public ImportanciaCita mostrarImportanciaCita(int idImportanciaCita);
    public List<ImportanciaCita> mostrarAllImportanciaCita();
    public boolean agregarImportanciaCita(ImportanciaCita importanciaCita);
    public boolean actualizarImportanciaCita(ImportanciaCita importanciaCita);
    public boolean borrarImportanciaCita(int idImportanciaCita);
    
}
