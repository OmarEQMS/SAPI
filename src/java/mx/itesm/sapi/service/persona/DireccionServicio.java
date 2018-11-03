/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Direccion;

/**
 *
 * @author Angel GTZ
 */
public interface DireccionServicio {
    public Direccion mostrarDireccion(int idDireccion);
  
    List<Direccion> mostrarDireccion();
    public int agregarDireccion(Direccion direccion);
    public boolean actualizarDireccion(Direccion direccion);
    public boolean borradoLogicoDireccion(int idDireccion);
    
}
