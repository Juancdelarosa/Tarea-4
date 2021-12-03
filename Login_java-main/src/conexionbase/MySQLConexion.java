package conexionbase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String ur1= "jdbc:mysql://localhost/usuarios?characterEncoding=latin1";
			String usuario = "root";
			String contraseña = "ros08jua27";
			
			con = DriverManager.getConnection(ur1, usuario, contraseña);
			
			System.out.println("Conectado");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("Error --> con la BD");
			e.printStackTrace();
		}
		
		
		
		
		return con;
		
	}

}