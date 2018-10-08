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
 * @author urieldiaz
 */
public interface MotivoConsultaService {
    public MotivoConsulta getMotivoConsulta(int idMotivoConsulta);
    public MotivoConsulta getMotivoConsulta(String nombreMotivoConsulta);
    public List<MotivoConsulta> getAllMotivoConsulta();
    public boolean saveMotivoConsulta(MotivoConsulta motivoConsulta);
    public boolean updateMotivoConsulta(MotivoConsulta motivoConsulta);
    public boolean deleteMotivoConsulta(int idMotivoConsulta);
}
