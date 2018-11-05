/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * Datos para mostrar en la pantalla de documento inicial
 * @author urieldiaz
 */
public class DatosPacienteDocumentoInicial {
  
   private int idPaciente;
   private int idCuenta;
   private int idPersona;
   private String nombre;
   private String primerApellido;
   private String segundoApellido;

   public DatosPacienteDocumentoInicial()
   {
       
   }

    @Override
    public String toString() {
        return "DatosPacienteDocumentoInicial{" + "idPaciente=" + idPaciente + ", idCuenta=" + idCuenta + ", idPersona=" + idPersona + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + '}';
    }
            
   
   public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
             
}
