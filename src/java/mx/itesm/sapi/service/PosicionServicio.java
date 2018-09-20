/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.Posicion;

/**
 *
 * @author Admin
 */
public interface PosicionServicio {
    
    public int savePosicion(Posicion posicion);
    public List<Posicion> getPosiciones();
    public boolean deletePosicion(int id);
    public boolean existePosicion(String nombre);
}
