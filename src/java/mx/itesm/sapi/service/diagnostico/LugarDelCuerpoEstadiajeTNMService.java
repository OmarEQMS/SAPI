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
    public LugarDelCuerpoEstadiajeTNM getLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM);
    List<LugarDelCuerpoEstadiajeTNM> getLugarDelCuerpoEstadiajeTNM();
    public boolean agregarLugarDelCuerpoEstadiajeTNM(LugarDelCuerpoEstadiajeTNM lugarDelCuerpoEstadiajeTNM);
    public boolean actualizarLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM);
    public boolean borradoLogicoLugarDelCuerpoEstadiajeTNM(int idLugarDelCuerpoEstadiajeTNM);
}
