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
public interface LugarDelCuerpoServicio {
    public LugarDelCuerpo mostrarLugarDelCuerpo(int idLugarDelCuerpo);
    public LugarDelCuerpo mostrarLugarDelCuerpo(String nombreLugarDelCuerpo);
    public List<LugarDelCuerpo> mostrarLugarDelCuerpo();
    
}
