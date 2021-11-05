
package logic;

import modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserLogic extends Conexion {
    
    Connection conexion;
    
    public UserLogic(){
        this.conexion=getConexion();
    }
    
    public boolean RegisterUser( User user){
        
        PreparedStatement ps=null;
        String sql="INSERT INTO user (name, password) VALUES ('lara','lara')";
        
        try{
            ps=this.conexion.prepareStatement(sql);
            System.out.println("aca Logic");
//            ps.setString(1, user.getUser_name());
//            ps.setString(2, user.getPassword());
//            System.out.println("conexion");
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
               System.err.println(e);
            }
        }
    }
}
