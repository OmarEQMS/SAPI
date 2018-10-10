/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import mx.itesm.sapi.bean.persona.Direccion;

/**
 *
 * @author feror
 */
public interface DireccionServicio {
    public Direccion getPersona(int idDireccion);
    public boolean saveDireccion(Direccion direccion);
    public boolean deleteDireccion(int idDireccion);
    public boolean updatePersona(Direccion direccion);
    
}
