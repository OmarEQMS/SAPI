/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Her2;
/**
 *
 * @author Alexis España
 */
public interface Her2Servicio {
    public Her2 mostrarHer2(int idTipoHistologico);
    public List<Her2> mostrarHer2();
}
