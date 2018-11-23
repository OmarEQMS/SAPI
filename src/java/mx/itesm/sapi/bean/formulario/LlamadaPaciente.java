/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.formulario;

/**
 *
 * @author Alex
 */
public class LlamadaPaciente {

    private String fechaLlamada;
    private String motivoLlamada;
    
    public LlamadaPaciente() {
    }

    public String getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(String fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    public String getMotivoLlamada() {
        return motivoLlamada;
    }

    public void setMotivoLlamada(String motivoLlamada) {
        this.motivoLlamada = motivoLlamada;
    }
    
}
