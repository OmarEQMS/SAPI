/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Oscar Miranda
 */
public class BiopsiaServiceImpl implements BiopsiaService{

    @Override
    public Biopsia mostrarBiopsia(int idBiopsia) {
         Connection conn;
         CallableStatement cstmt;
         ResultSet rs;
         String stProcedure = "---";
         Biopsia biopsia = null;
     
        try {
            conn = Conexion.getConnection();
            biopsia = new Biopsia();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idBiopsia);
                  
            rs = cstmt.executeQuery();
            rs.next();
            biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
            biopsia.setIdPaciente(rs.getInt("idPaciente"));
            biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
            biopsia.setIdHer2(rs.getInt("idHer2"));
            biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
            biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
            biopsia.setIdFish(rs.getInt("idFish"));
            biopsia.setIdKi67(rs.getInt("idKi67"));
            biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
            biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
            biopsia.setLaminillas(rs.getInt("laminillas"));
            biopsia.setBloques(rs.getInt("bloques"));
            biopsia.setPrevia(rs.getInt("previa"));
            
            conn.close();
            cstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
           System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                   .concat(ex.getMessage()));
           biopsia = null;
        }   
        return biopsia;
    }

    @Override
    public List<Biopsia> mostrarAllBiopsia() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "---";
        List<Biopsia> biopsias = null;
        Biopsia biopsia;

	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            biopsias =  new ArrayList<>();
            
            while(rs.next()){
                biopsia = new Biopsia();
                biopsia.setIdBiopsia(rs.getInt("idBiopsia"));
                biopsia.setIdPaciente(rs.getInt("idPaciente"));
                biopsia.setIdLugarDelCuerpo(rs.getInt("idLugarDelCuerpo"));
                biopsia.setIdHer2(rs.getInt("idHer2"));
                biopsia.setIdReceptorProgesterona(rs.getInt("idReceptorProgesterona"));
                biopsia.setIdReceptorEstrogeno(rs.getInt("idReceptorEstrogeno"));
                biopsia.setIdFish(rs.getInt("idFish"));
                biopsia.setIdKi67(rs.getInt("idKi67"));
                biopsia.setIdTipoHistologico(rs.getInt("idTipoHistologico"));
                biopsia.setIdGradoHistologico(rs.getInt("idGradoHistologico"));
                biopsia.setLaminillas(rs.getInt("laminillas"));
                biopsia.setBloques(rs.getInt("bloques"));
                biopsia.setPrevia(rs.getInt("previa"));

                biopsias.add(biopsia);
            }
		
		conn.close();
		cstmt.close();
		rs.close();
                
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            biopsias = null;
	}
        return biopsias;
    }

    @Override
    public int agregarBiopsia(Biopsia biopsia) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;
        String stProcedure = "";
        int id = -1;
        
	try{
            conn  = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            
            cstmt.setInt(1,biopsia.getIdPaciente());
            cstmt.setInt(1,biopsia.getIdLugarDelCuerpo());
            cstmt.setInt(1,biopsia.getIdHer2());
            cstmt.setInt(1,biopsia.getIdReceptorProgesterona());
            cstmt.setInt(1,biopsia.getIdReceptorEstrogeno());
            cstmt.setInt(1,biopsia.getIdFish());
            cstmt.setInt(1,biopsia.getIdKi67());
            cstmt.setInt(1,biopsia.getIdTipoHistologico());
            cstmt.setInt(1,biopsia.getIdGradoHistologico());
            cstmt.setInt(1,biopsia.getLaminillas());
            cstmt.setInt(1,biopsia.getBloques());
            cstmt.setInt(1,biopsia.getPrevia());
            
            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);
                
            conn.close();
            cstmt.close();
            rs.close();
	}catch(SQLException ex){
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
	}
        return id;
    }

    @Override
    public boolean borradoLogicoBiopsia(int idBiopsia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarBiopsia(Biopsia biopsia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
