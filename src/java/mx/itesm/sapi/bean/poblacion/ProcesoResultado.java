/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.poblacion;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author urieldiaz
 */
public class ProcesoResultado extends Thread {
    
    ArrayList<ArrayList<String>> PoblacionGeneral;
    ResultSet rs;
    
    public ProcesoResultado()
    {
        
    }
    
    @Override
    public void run()
    {
       PoblacionGeneral = new ArrayList<>();
      
    }
    
    
}
