/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Login;

/**
 *
 * @author Angel GTZ
 */
public interface LoginServicio {
    public PersonaServicio getLogin(int idLogin);
    List<Login> getLogin();
    public boolean agregarLogin(Login login);
    public boolean actualizarLogin(int idLogin);
    public boolean borradoLogicoLogin(int idLogin);
    
}
