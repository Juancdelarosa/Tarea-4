package funciones;

import com.mysql.jdbc.PreparedStatement;

import fasesusuarios.Registrados;
import conexionbase.MySQLConexion;

public class Registrar {
	
	public int registrar(Registrados registrado) {
		int rs = 0;
		
		String sql = "INSERT INTO resgistro values (?,?,?,?,?,?)";

		try (PreparedStatement ps = (PreparedStatement) MySQLConexion.getConexion().prepareStatement(sql)){
			ps.setString(1, registrado.getUsuario().trim());
			ps.setString(2, registrado.getClave());
			ps.setString(3, registrado.getNombre());
			ps.setString(4, registrado.getApellido());
			ps.setString(5, registrado.getCorreo());
			ps.setInt(6, registrado.getNumero());
			
			rs = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
		return rs;
	}

}
