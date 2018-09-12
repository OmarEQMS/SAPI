package mx.itesm.sapi.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        String cadena = "jdbc:mysql://localhost:3306/usuarios?user=root";
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(cadena);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return connection;
    }
    
    public static void main(String[] args) {
        if(getConexion()!=null){
            System.out.println("Si sirvio");
        }else{
            System.out.println("No sirivio");
        }
    }

}
