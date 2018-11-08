/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

/**
 *
 * @author shannon
 */
public class NivelSocioeconomico {

    private int idNivelSocioEconomico;
    private String nombre;
    private int estatus;
    
    public NivelSocioeconomico(){}

    @Override
    public String toString() {
        return "NivelSocioeconomico{" + "idNivelSocioEconomico=" + idNivelSocioEconomico + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }

    public int getIdNivelSocioEconomico() {
        return idNivelSocioEconomico;
    }

    public void setIdNivelSocioEconomico(int idNivelSocioEconomico) {
        this.idNivelSocioEconomico = idNivelSocioEconomico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }


}
