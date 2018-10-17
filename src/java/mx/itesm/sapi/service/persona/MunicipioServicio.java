/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Municipio;

/**
 *
 * @author Angel GTZ
 */
public interface MunicipioServicio {
    public Municipio mostrarMunicipio(int idMunicipio);
    List<Municipio> mostrarMunicipio();
    public int agregarMunicipio(Municipio municipio);
    public boolean actualizarMunicipio(Municipio municipio);
    public boolean borradoLogicoMunicipio(int idMunicipio);
    
}
