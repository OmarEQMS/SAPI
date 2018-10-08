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
    public LugarDelCuerpo mostrarLugarDelCuerpo(int idLugarDelCuerpo);
    public LugarDelCuerpo mostrarLugarDelCuerpo(String nombreLugarDelCuerpo);
    public List<LugarDelCuerpo> mostrarAllLugarDelCuerpo();
    public boolean agregarLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo);
    public boolean actualizarLugarDelCuerpo(LugarDelCuerpo lugarDelCuerpo);
    public boolean borrarLugarDelCuerpo(int idLugarDelCuerpo);
}
