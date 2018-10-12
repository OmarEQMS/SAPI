/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;

/**
 *
 * @author Oscar Miranda
 */
interface AlergiaServicio {
    public Alergia mostrarAlergia(int idAlergia);
    public List<Alergia> mostrarAlergia();
    public int agregarAlergia(Alergia alergia);
    public boolean borradoLogicoAlergia(int idAlergia);
    public boolean actualizarAlergia(Alergia  alergia);
}
