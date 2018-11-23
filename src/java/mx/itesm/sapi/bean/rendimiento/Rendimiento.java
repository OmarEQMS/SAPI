/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.rendimiento;

/**
 *
 * @author Raul Orihuela
 *
 */
/**
 * public class Rendimiento Clase para almacenar la cuenta de datos agrupados
 */
/**
 * Field summary private String decripcion: Contiene la descripcion del grupo de
 * datos private int cantidad: Contiene el total de datos dentro del grupo
 */
public class Rendimiento {

    private String decripcion;
    private int cantidad;

    @Override
    public String toString() {
        return "Archivo [ Descricion : ".concat(decripcion).
                concat(" Cantidad: ").concat(String.valueOf(cantidad)).concat(" ]");

    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
