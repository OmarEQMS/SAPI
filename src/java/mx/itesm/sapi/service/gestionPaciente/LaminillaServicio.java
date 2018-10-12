/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Laminilla;



/**
 *
 * @author Alex
 */
public interface LaminillaServicio {
    public Laminilla mostrarLaminilla(int idLaminilla);
    public List<Laminilla> mostrarLaminilla();
    public int agregarLaminilla(Laminilla laminilla);
    public boolean actualizarLaminilla(Laminilla laminilla);
    public boolean borradoLogicoLaminilla(int idLaminilla);
}
