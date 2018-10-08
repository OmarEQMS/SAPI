/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.LugarDelCuerpo;

/**
 *
 * @author urieldiaz
 */
public interface LugarDelCuerpoService {
    public LugarDelCuerpo getLugarDelCuerpo(int idLugarDelCuerpo);
    public LugarDelCuerpo getLugarDelCuerpo(String nombreLugarDelCuerpo);
    public List<LugarDelCuerpo> getAllLugarDelCuerpo();
    public boolean saveLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo);
    public boolean updateLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo);
    public boolean deleteLugarDelCuerpo(int idLugarDelCuerpo);
}
