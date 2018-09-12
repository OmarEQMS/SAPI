package mx.itesm.sapi.service;
import java.util.List;
import mx.itesm.sapi.bean.Persona;

public interface PersonaService {
    public Persona getPersona(int idPersona);
    public List<Persona> getPersonas();
    public int savePersona(Persona persona);
    public boolean deltePersona(int idPersona);
    public boolean updatePersona(Persona persona);
}
