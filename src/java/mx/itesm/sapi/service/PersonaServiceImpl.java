package mx.itesm.sapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import mx.itesm.sapi.bean.Persona;
import mx.itesm.sapi.util.Conexion;

public class PersonaServiceImpl implements PersonaService{

    @Override
    public Persona getPersona(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> getPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean savePersona(Persona persona) {
        Connection conn = Conexion.getConexion();
        String sql = "INSERT INTO Persona(nombre, apellidos, curp, telefono, correo) VALUE(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getCurp());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getCorreo());
            return !ps.execute();
        }catch(Exception ex){
            return false;
        }
        
    }

    @Override
    public boolean deltePersona(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
