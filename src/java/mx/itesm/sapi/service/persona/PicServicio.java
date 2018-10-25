/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.util.List;
import mx.itesm.sapi.bean.persona.Pic;

/**
 *
 * @author Diego
 */
public interface PicServicio {
    public Pic mostrarPic(int idPic);
    List<Pic> mostrarPic();
    public int agregarPic(Pic pic);
    public boolean actualizarPic(Pic pic);
    public boolean borradoLogicoPic(int idPic);
}
