/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.MotivoConsulta;

/**
 *
 * @author Uriel Díaz
 */
public interface MotivoConsultaServicio {
    public MotivoConsulta mostrarMotivoConsulta(int idMotivoConsulta);
    public MotivoConsulta mostrarMotivoConsulta(String nombreMotivoConsulta);
    public List<MotivoConsulta> mostrarMotivoConsulta();
    
}
