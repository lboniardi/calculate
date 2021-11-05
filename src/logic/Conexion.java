package logic;

import modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String base="calculate";
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/" + base;
    private Connection  conexion=null;
    
    public Connection getConexion() {
        try{
            
//            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/calculate", "root", "");
            System.out.println("conexion correcta");
            return conexion;
        }catch(SQLException e){
            System.err.println(e);
        }
//         catch(ClassNotFoundException ex){
//            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }
}

