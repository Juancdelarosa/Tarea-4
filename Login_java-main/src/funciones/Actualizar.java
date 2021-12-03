package funciones;

import com.mysql.jdbc.PreparedStatement;

import fasesusuarios.Actualizados;
import conexionbase.MySQLConexion;

public class Actualizar {
	public static int actualizar(Actualizados actualizar) {
		int rs = 0;
		
		String sql = "UPDATE resgistro  SET nombre=?,apellido=?, correo=?,numero=?  WHERE usuario=?";

		try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
			ps.setString(1, actualizar.getNombre());
			ps.setString(2, actualizar.getApellido());
			ps.setString(3, actualizar.getCorreo());
			ps.setInt(4, actualizar.getNumero());
			ps.setString(5, actualizar.getUsuario());
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
		return rs;
	}

}
