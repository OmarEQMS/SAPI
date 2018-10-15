/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.diagnostico;

import java.util.List;
import mx.itesm.sapi.bean.diagnostico.LugarDelCuerpoEstadiajeTNM;

/**
 *
 * @author Diego
 */
public interface LugarDelCuerpoEstadiajeTNMService {
    public int agregarLugarDelCuerpoEstadiajeTNM(LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM);    
    public LugarDelCuerpoEstadiajeTNM mostrarLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM);
    List<LugarDelCuerpoEstadiajeTNM> mostrarLugarDelCuerpoEstadiajeTNM();
    public boolean actualizarLugarDelCuerpoEstadiajeTNM(LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM);
    public boolean borradoLogicoLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM);
}
