package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas extends Conexion {
    
    public boolean buscar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "SELECT * FROM `usuarios` WHERE `nombre`=? ";
        ResultSet rs=null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            rs=ps.executeQuery();
            if(rs.next()){
                usuario.setId(Integer.parseInt(rs.getString("idUsuario")));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                return true;
            }
            System.out.print("aqui" + sql);
            return false;
        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

        public boolean editar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "UPDATE `usuarios` SET nombre=?, apellido=?, usuario=?, contraseña=? WHERE idusuario=? ";
        ResultSet rs=null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContraseña());
            ps.setInt(5, usuario.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

        
    public boolean registrarse(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConection();
        String sql = "INSERT INTO usuarios(nombre, apellido,usuario, contraseña) VALUES(?,?,?,?)";
                
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContraseña());
            ps.execute();
            System.out.print("aqui" + sql);
            return true;

        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

    
   

}
