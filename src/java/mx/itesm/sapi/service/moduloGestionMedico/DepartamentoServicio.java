/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.Departamento;

/**
 *
 * @author feror
 */
public interface DepartamentoServicio {
    public Departamento mostrarDepartamento(int idDepartamento);
    public List<Departamento> mostrarDepartamento();
    
}
