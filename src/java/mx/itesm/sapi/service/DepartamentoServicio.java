/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.Departamento;

/**
 *
 * @author Admin
 */
public interface DepartamentoServicio {
    
   public int saveDepartamento(Departamento deparatemento);
   public List<Departamento> getDepartamentos();
   public boolean existeDepartamento(String nombre);
   public boolean deleteDepartamento(int id);
   
    
}
