/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.ArrayList;

/**
 *
 * @author Raul Orihuela
 */
public interface GeneralPoblacionServicio {
    public ArrayList<ArrayList<String>> mostrarPoblacionGeneral();
    public boolean actualizarPoblacionGeneral();
}
