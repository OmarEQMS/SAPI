/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.CategoriaEstudio;

/**
 *
 * @author urieldiaz
 */
public interface CategoriaEstudioService {
    public CategoriaEstudio getCategoriaEstudio(int idCategoriaEstudio);
    public List<CategoriaEstudio> getAllCategoriaEstudio();
    public boolean saveCategoriaEstudio(CategoriaEstudio categoriaEstudio);
    public boolean updateCategoriaEstudio(CategoriaEstudio categoriaEstudio);
    public boolean deleteCategoriaEstudio(int idCategoriaEstudio);    
}
