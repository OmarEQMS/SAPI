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
 * @author urieldiaz
 */
public interface SeguroService {
    public Seguro mostrarSeguro(int idSeguro);
    public List<Seguro> mostrarAllSeguro();
    public boolean agregarSeguro(Seguro seguro);
    public boolean actualizarSeguro(Seguro seguro);
    public boolean borradoLogicoSeguro(int idSeguro);
}
