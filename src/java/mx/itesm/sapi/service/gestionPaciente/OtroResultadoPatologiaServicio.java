/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;

/**
 *
 * @author Angel GTZ
 */
public interface OtroResultadoPatologiaServicio {

    public OtroResultadoPatologia mostrarOtroResultadoPatologia(int idOtroResultadoPatologia);
    public OtroResultadoPatologia mostrarOtroResultadoPatologiaIdBiopsia(int idBiopsia);

    public List<OtroResultadoPatologia> mostrarOtroResultadoPatologia();

    public int agregarOtroResultadoPatologia(OtroResultadoPatologia otroResultadoPatologia);

    public boolean borradoLogicoOtroResultadoPatologia(int idOtroResultadoPatologia);

    public boolean actualizarOtroResultadoPatologia(OtroResultadoPatologia otroResultadoPatologia);

}
