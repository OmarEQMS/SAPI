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
    public CategoriaEstudio mostrarCategoriaEstudio(int idCategoriaEstudio);
    public List<CategoriaEstudio> mostrarCategoriaEstudio();
    public int agregarCategoriaEstudio(CategoriaEstudio categoriaEstudio);
    public boolean actualizarCategoriaEstudio(CategoriaEstudio categoriaEstudio);
    public boolean borradoLogicoCategoriaEstudio(int idCategoriaEstudio);    
}
