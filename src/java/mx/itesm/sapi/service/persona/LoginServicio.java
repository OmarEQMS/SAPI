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
    public Login mostrarLogin(int idLogin);
    List<Login> mostrarLogin();
    public int agregarLogin(Login login);
    public boolean actualizarLogin(Login login);
    public boolean borradoLogicoLogin(int idLogin);
    
}
