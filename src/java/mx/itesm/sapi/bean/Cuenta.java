package mx.itesm.sapi.bean;
import java.io.Serializable;

public class Cuenta implements Serializable{
    private int idCuenta;
    private int idPersona;
    private int idRol;
    private String usuario;
    private String contraseña;
    private String prueba
    
    public Cuenta(){}
    
    @Override
    public String toString() {
        return "Cuenta [ usuario : ".concat(usuario).concat(" ]"); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdCuenta() {return idCuenta;}
    public int getIdPersona() {return idPersona;}
    public int getIdRol() {return idRol;}
    public String getUsuario() {return usuario;}
    public String getContraseña() {return contraseña;}
    
    public void setIdCuenta(int idCuenta) {this.idCuenta = idCuenta;}
    public void setIdPersona(int idPersona) {this.idPersona = idPersona;}
    public void setIdRol(int idRol) {this.idRol = idRol;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    
}
