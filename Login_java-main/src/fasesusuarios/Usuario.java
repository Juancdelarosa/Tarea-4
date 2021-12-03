package fasesusuarios;

public class Usuario {
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String correo;
	private int numero;

	public Usuario(String usuario, String clave, String nombre, String apellido, String correo, int numero) {

		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numero = numero;
		this.correo = correo;
		this.clave = clave;

	}

	public Usuario() {
	
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
