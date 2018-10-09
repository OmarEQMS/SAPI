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
 * @author urieldiaz
 */
public interface AlergiaServicio {
    public Alergia mostrarAlergia(int idAlergia);
    public Alergia mostrarAlergia(String nombreAlergia);    
    public List<Alergia> mostrarAllAlergias();
    public boolean agregarAlergia(Alergia alergia);
    public boolean borradoLogicoAlergia(int idAlergia);
    public boolean borradoLogicoAlergia(String nombreAlergia);
    public boolean actualizarAlergia(Alergia alergia); 
}
