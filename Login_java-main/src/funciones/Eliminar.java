package funciones;

import com.mysql.jdbc.PreparedStatement;

import fasesusuarios.Actualizados;
import conexionbase.MySQLConexion;

public class Eliminar {
	public static int eliminar(Actualizados actualizar) {
		int rs = 0;
		
		String sql = "DELETE FROM resgistro  Where usuario=?";

		try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
			ps.setString(1, actualizar.getUsuario());
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
		return rs;
	}

}


