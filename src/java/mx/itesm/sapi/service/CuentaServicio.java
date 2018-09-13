 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service;

import java.util.List;
import mx.itesm.sapi.bean.Cuenta;


/**
 *
 * @author Admin
 */
public interface CuentaServicio {
    public Cuenta getCuenta(int idCuenta);
    public List<Cuenta> getCuenta();
    public boolean saveCuenta(Cuenta cuenta);
    public boolean deleteCuenta(int idCuenta);
    public boolean updateCuenta(Cuenta cuenta);
    public boolean existsUsuario(String usuario);
    
    
    
}
