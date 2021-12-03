package funciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fasesusuarios.Usuario;
import conexionbase.MySQLConexion;


public class Login {
	
	public Usuario obtenerUsuario (Usuario usu) {
		
		Usuario usuario= null;
		
		Connection con = null;
		
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		try {
			
			con = MySQLConexion.getConexion();
		
			String sql = ("SELECT * FROM  resgistro  where usuario = ? and clave = ?");
			
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getUsuario().trim());
			pst.setString(2, usu.getClave());
			System.out.println(pst);
			
			rs = pst.executeQuery();
			while (rs.next()) {
				
				usuario = new 	Usuario(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
				
			}
			
		} catch (Exception e) {
					System.out.println("Error en obtener usuario");

		}
		return usuario;
				
	}

}
