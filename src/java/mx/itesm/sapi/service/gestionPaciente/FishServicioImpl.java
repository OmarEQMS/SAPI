/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Fish;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Alexis España 
 */
public class FishServicioImpl implements FishServicio {

    @Override
    public Fish mostrarFish(int idFish) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Fish fish = new Fish();

        String stProcedure = "";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            fish.setIdFish(rs.getInt("idFish"));
            fish.setNombre(rs.getString("nombre"));
            fish.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            fish = null;
        }
        return fish;
    }

    @Override
    public List<Fish> mostrarFish() {
        Connection conn;
        List<Fish> fishes = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Fish fish;

            while (rs.next()) {
                fish = new Fish();
                fish.setIdFish(rs.getInt("idFish"));
                fish.setNombre(rs.getString("nombre"));
                fish.setEstatus(rs.getInt("estatus"));

                fishes.add(fish);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            fishes = null;
        }
        return fishes;

    }

}
