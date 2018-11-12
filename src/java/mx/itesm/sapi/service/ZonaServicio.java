/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.persona.CodigoPostal;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public interface ZonaServicio {
    
    public List<Estado> getEstados();
    
    public List<Municipio> getMunicipios(Estado estado);
    
    public List<EstadoCivil> getEstadoCivil();
    
    public List<String> getEstadoyMunicipio(CodigoPostal codigoPostal);
}
