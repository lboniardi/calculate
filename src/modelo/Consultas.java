package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas extends Conexion {

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
