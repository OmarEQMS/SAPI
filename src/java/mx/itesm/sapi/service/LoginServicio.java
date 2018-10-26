/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;

/**
 *
 * @author julioguzman
 */
public interface LoginServicio {
    
    public Cuenta verificaCredenciales(Cuenta cuenta);
    public void InsertLoginDateTime(Cuenta cuenta);      
}
