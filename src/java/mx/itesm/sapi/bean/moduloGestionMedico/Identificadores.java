/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.moduloGestionMedico;

/**
 *
 * @author urieldiaz
 */
public class Identificadores {
 private int idPersona;
 private int idCuenta;
 private int Empleado;

 
    public Identificadores(){};
    
    @Override
    public String toString() {
        return "Identificadores{" + "idPersona=" + idPersona + ", idCuenta=" + idCuenta + ", Empleado=" + Empleado + '}';
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(int Empleado) {
        this.Empleado = Empleado;
    }
 
 
}
