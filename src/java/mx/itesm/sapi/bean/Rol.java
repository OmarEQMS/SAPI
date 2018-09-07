package mx.itesm.sapi.bean;
import java.io.Serializable;

public class Rol implements Serializable{
    private int idRol;
    private String nombre;
    
    public Rol(){}

    @Override
    public String toString() {
        return "Rol [ nombre : ".concat(nombre).concat(" ]"); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdRol() {return idRol;}
    public String getNombre() {return nombre;}

    public void setIdRol(int idRol) {this.idRol = idRol;}
    public void setNombre(String nombre) {this.nombre = nombre;}    
    
}
