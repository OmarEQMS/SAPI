/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Seguro;

/**
 *
 * @author Uriel Díaz & Alexis España
 */
public interface SeguroServicio {
    public Seguro mostrarSeguro(int idSeguro);
    public List<Seguro> mostrarAllSeguro();
    public int agregarSeguro(Seguro seguro);
    public boolean actualizarSeguro(Seguro seguro);
    public boolean borradoLogicoSeguro(int idSeguro);
}
