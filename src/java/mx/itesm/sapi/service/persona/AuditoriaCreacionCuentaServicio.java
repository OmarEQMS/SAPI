/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.AuditoriaCreacionCuenta;

/**
 *
 * @author Angel GTZ
 */
public interface AuditoriaCreacionCuentaServicio {
   
    public AuditoriaCreacionCuenta mostrarAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta);
    List<AuditoriaCreacionCuenta> mostrarAuditoriaCreacionCuenta();
    public int agregarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta);
    public boolean actualizarAuditoriaCreacionCuenta(AuditoriaCreacionCuenta auditoriaCreacionCuenta);
    public boolean borradoLogicoAuditoriaCreacionCuenta(int idAuditoriaCreacionCuenta);
    
}
