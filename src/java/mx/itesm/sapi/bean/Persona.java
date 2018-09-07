package mx.itesm.sapi.bean;
import java.io.Serializable;

public class Persona implements Serializable{
    private int idPersona;
    private String nombre;
    private String apellidos;
    private String curp;
    private String correo;
    private String telefono;
    
    public Persona(){}
    
    @Override
    public String toString() {
        return "Persona [ nombre : ".concat(nombre).concat(" ]"); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdPersona() {return idPersona;}
    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public String getCurp() {return curp;}
    public String getCorreo() {return correo;}
    public String getTelefono() {return telefono;}

    public void setIdPersona(int idPersona) {this.idPersona = idPersona;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setCurp(String curp) {this.curp = curp;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setTelefono(String telefono) {this.telefono = telefono;}   

}
