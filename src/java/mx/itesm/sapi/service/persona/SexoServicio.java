/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Sexo;

/**
 *
 * @author Angel GTZ
 */
public interface SexoServicio {
    public Sexo mostrarSexo(int idSexo);
    List<Sexo> mostrarSexo();
    public int agregarSexo(Sexo sexo);
    public boolean actualizarSexo(Sexo sexo);
    public boolean borrarLogicoSexo(int idSexo);
    
}
