/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Ki67;
/**
 *
 * @author Alexis España
 */
public interface Ki67Servicio {
    public Ki67 mostrarKi67(int idKi67);
    public List<Ki67> mostrarKi67();
    public Ki67 mostrarKi67Nombre(int nombre);
    
}
