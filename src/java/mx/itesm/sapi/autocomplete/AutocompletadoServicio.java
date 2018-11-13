/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.autocomplete;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;

/**
 *
 * @author feror
 */
public interface AutocompletadoServicio {

    List<Estudio> mostrarEstudioRayosX();
    List<Estudio> mostrarEstudioUltrasonido();
    List<Estudio> mostrarEstudioProgramas();
    List<Estudio> mostrarEstudioMedicinaNuclear();
    List<Estudio> mostrarEstudioValoracion();
    List<Estudio> mostrarEstudioSinCategoria();

}
