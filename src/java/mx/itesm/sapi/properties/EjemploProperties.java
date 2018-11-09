/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.properties;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Pablo Lugo
 */
public class EjemploProperties {
    
    /* El ejemplo muestra dos atributo: uno de tipo int y un ResourceBundle.
        El sapiProperties toma los valores de un archivo .properties en los cuáles 
        están escritas los valores de los catálogos de la base datos.
    
        Cada vez que se utilica un valor de catálogo se deben definir y dar valor 
        en el archivo .properties para evitar hardcoding.
        
    */
    
    private static int estadoPaciente;
    private static ResourceBundle sapiProperties;
   
    public static void main(String[] args){
      
         if (sapiProperties == null)
        {
            sapiProperties = ResourceBundle.getBundle("mxitesm.sapi.catalogos");
            estadoPaciente = Integer.parseInt(sapiProperties.getString("pacientePotencial"));
            
            /* Después de éste punto se utiliza estadoPaciente como una variable normal*/
        }
                 
    }
          
    
}
