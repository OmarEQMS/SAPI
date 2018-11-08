/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.moduloGestionMedico;

import java.util.List;
import mx.itesm.sapi.bean.moduloGestionMedico.DepartamentoDepartamentoInterno;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
public interface DepartamentoDepartamentoInternoServicio {

    public int agregarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno);

    public DepartamentoDepartamentoInterno mostrarDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno);

    public List<DepartamentoDepartamentoInterno> mostrarDepartamentoDepartamentoInterno();

    public boolean borradoLogicoDepartamentoDepartamentoInterno(int idDepartamentoDepartamentoInterno);

    public boolean actualizarDepartamentoDepartamentoInterno(DepartamentoDepartamentoInterno departamentoDepartamentoInterno);

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */