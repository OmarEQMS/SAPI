/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.CodigoPostal;

/**
 *
 * @author Angel GTZ
 */
public interface CodigoPostalServicio {
    public CodigoPostal mostrarCodigoPostal(int idCodigoPostal);
    List<CodigoPostal> mostrarCodigoPostal();
    public int agregarCodigoPostal(CodigoPostal codigoPostal);
    public boolean actualizarCodigoPostal(CodigoPostal codigoPostal);
    public boolean borradoLogicoCodigoPostal(int idCodigoPostal);
    
}
