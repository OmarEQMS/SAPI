package mx.itesm.sapi.service;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        Connection conn = Conexion.getConexion();
        String sql = "SELECT * FROM Persona";
        List<Persona> personas = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Persona persona;
            while(rs.next()){
                persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellidos(rs.getString("apPaterno"));
                personas.add(persona);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(Exception ex){
            System.out.println("PersonaServicioImpl.getPersonas(): ".concat(ex.getMessage()));
        }
        return personas;
    }

    @Override
    public int savePersona(Persona persona) {
        Connection conn = Conexion.getConexion();
        String sql = "INSERT INTO Persona(nombre, apellidos, curp, telefono, correo) VALUE(?,?,?,?,?)";
        try{
            // CallableStatement -- para procedimientos almacenados
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getCurp());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getCorreo());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            ps.close();
            conn.close();
            return id;
        }catch(Exception ex){
            return -1;
        }
    }

    @Override
    public boolean deltePersona(int idPersona) {
        Connection conn = Conexion.getConexion();
        String sql = "DELETE FROM Persona WHERE(idPersona=?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPersona);
            boolean ready = !ps.execute();
            ps.close();
            conn.close();
            return ready;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean updatePersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
