/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.formulario;

/**
 *
 * @author Oscar Miranda
 */
public class EstudioFormulario {
    private String tipo;
    private String fecha;
    private String lugarDelCuerpo;

    @Override
    public String toString() {
        return "EstudisFormulario{" + "tipo=" + tipo + ", fecha=" + fecha + ", lugarDelCuerpo=" + lugarDelCuerpo + '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugarDelCuerpo() {
        return lugarDelCuerpo;
    }

    public void setLugarDelCuerpo(String lugarDelCuerpo) {
        this.lugarDelCuerpo = lugarDelCuerpo;
    }
    
    
    
}
