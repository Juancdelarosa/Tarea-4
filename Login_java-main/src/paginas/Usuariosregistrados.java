package paginas;

import java.awt.EventQueue;

import conexionbase.MySQLConexion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import fasesusuarios.Actualizados;
import fasesusuarios.Registrados;
import funciones.Actualizar;
import funciones.Eliminar;
import funciones.Registrar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Toolkit;

public class Usuariosregistrados {

	JFrame frmRegistrados;
	private JTable table;
	private JTextField txtUsuario;
	private JLabel lblBuscar1;
	private JLabel lblBuscar2;
	private JLabel lblBuscar3;
	private JLabel lblBuscar4;
	private JLabel lblBuscar5;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtNumero;
	private JTextField txtNombre;
	private JLabel lblConfirmar;
	private JLabel lblClave;
	private JPasswordField txtClave;
	private JPasswordField txtConfirmar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnEliminar1;
	private JButton btnEliminar;
	private JButton btnCerrarSeccion;
	private JButton btnActualizar;
	private JButton btnNuevo;
	private JButton btnActualizar1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuariosregistrados window = new Usuariosregistrados();
					window.frmRegistrados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Usuariosregistrados() {
		initialize();
	}

	
	private void initialize() {
		frmRegistrados = new JFrame();
		frmRegistrados.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frmRegistrados.getContentPane().setBackground(new Color(218, 165, 32));
		frmRegistrados.setTitle("Registrados");
		frmRegistrados.setBounds(100, 100, 923, 583);
		frmRegistrados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 660, 311);

		JLabel lblNewLabel = new JLabel("Lista de Usuarios");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(9, 12, 312, 41);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				btnCerrarSeccion.setVisible(false);
				btnEliminar.setVisible(false);
				btnNuevo.setVisible(false);
				btnBuscar.setVisible(false);
				btnActualizar1.setVisible(true);
				
			}
		});
		btnActualizar.setBounds(719, 134, 119, 34);

		btnNuevo = new JButton("Crear Nuevo");
		btnNuevo.setForeground(Color.BLACK);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBounds(719, 86, 119, 34);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				btnCerrarSeccion.setVisible(false);
				btnEliminar.setVisible(false);
				btnActualizar.setVisible(false);
				btnGuardar.setVisible(true);
				btnBuscar.setVisible(false);
				lblClave.setVisible(true);
				lblConfirmar.setVisible(true);
				txtClave.setVisible(true);
				txtConfirmar.setVisible(true);

			}
		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");
				lblBuscar2.setVisible(false);
				lblBuscar3.setVisible(false);
				lblBuscar4.setVisible(false);
				lblBuscar5.setVisible(false);
				txtApellido.setVisible(false);
				txtCorreo.setVisible(false);
				txtNumero.setVisible(false);
				txtNombre.setVisible(false);
				btnBuscar.setVisible(false);
				btnEliminar1.setVisible(true);
				btnNuevo.setVisible(false);
				btnCerrarSeccion.setVisible(false);
				btnActualizar.setVisible(false);
				
				
			}
		});
		btnEliminar.setBounds(719, 187, 119, 34);

		btnCerrarSeccion = new JButton("Cerrar Sesion");
		btnCerrarSeccion.setForeground(Color.BLACK);
		btnCerrarSeccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrarSeccion.setBounds(719, 379, 153, 41);
		btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrados.dispose();
				Paginalogin window = new Paginalogin();
				window.frmLogin.setVisible(true);
			}
		});

		txtUsuario = new JTextField();
		txtUsuario.setBounds(27, 447, 132, 20);
		txtUsuario.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				try {

					con = MySQLConexion.getConexion();
					pst = con.prepareStatement("SELECT * FROM resgistro WHERE usuario = ?");
					pst.setString(1, txtUsuario.getText());
					System.out.println(rs);
					rs = pst.executeQuery();
					if (rs.next()) {
						txtUsuario.setText(rs.getString("usuario"));
						txtNombre.setText(rs.getString("nombre"));
						txtApellido.setText(rs.getString("apellido"));
						txtCorreo.setText(rs.getString("correo"));
						txtNumero.setText(rs.getString("numero"));

					} else {
						JOptionPane.showMessageDialog(null, "Usuario innexistente.");
					}
				} catch (Exception e1) {
					
				}
				

			}
		});
		btnBuscar.setBounds(719, 244, 119, 34);

		MySQLConexion con = new MySQLConexion();
		Connection conexion = con.getConexion();

		String sql = "SELECT * FROM resgistro";
		Statement st;
		String nombreColumnas[] = { "usuario", "nombre", "apellido", "correo", "numero" };

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, nombreColumnas));

		// creacion de la tabla
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("usuario");
		model.addColumn("nombre");
		model.addColumn("apellido");
		model.addColumn("correo");
		model.addColumn("numero");
		table.setModel(model);

		Object[] dato = new Object[5];
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				dato[0] = result.getString("usuario");
				dato[1] = result.getString("nombre");
				dato[2] = result.getString("apellido");
				dato[3] = result.getString("correo");
				dato[4] = result.getString("numero");
				model.addRow(dato);
			}

		} catch (Exception e) {
			
		}

		scrollPane.setViewportView(table);
		frmRegistrados.getContentPane().setLayout(null);
		frmRegistrados.getContentPane().add(btnNuevo);
		frmRegistrados.getContentPane().add(btnActualizar);
		frmRegistrados.getContentPane().add(txtUsuario);
		frmRegistrados.getContentPane().add(btnBuscar);
		frmRegistrados.getContentPane().add(btnEliminar);
		frmRegistrados.getContentPane().add(btnCerrarSeccion);
		frmRegistrados.getContentPane().add(scrollPane);
		frmRegistrados.getContentPane().add(lblNewLabel);

		lblBuscar1 = new JLabel("Usuario:");
		lblBuscar1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar1.setBounds(27, 422, 57, 14);
		frmRegistrados.getContentPane().add(lblBuscar1);

		lblBuscar2 = new JLabel("Nombre:");
		lblBuscar2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar2.setBounds(193, 422, 68, 14);
		frmRegistrados.getContentPane().add(lblBuscar2);

		lblBuscar3 = new JLabel("Apellido:");
		lblBuscar3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar3.setBounds(365, 422, 68, 14);
		frmRegistrados.getContentPane().add(lblBuscar3);

		lblBuscar4 = new JLabel("Correo Electr\u00F3nico:");
		lblBuscar4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar4.setBounds(538, 422, 132, 14);
		frmRegistrados.getContentPane().add(lblBuscar4);

		lblBuscar5 = new JLabel("N\u00FAmero de Tel\u00E9fono:");
		lblBuscar5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar5.setBounds(27, 488, 145, 14);
		frmRegistrados.getContentPane().add(lblBuscar5);

		txtApellido = new JTextField();
		txtApellido.setBounds(365, 447, 132, 20);
		frmRegistrados.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(538, 447, 153, 20);
		frmRegistrados.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(27, 513, 132, 20);
		frmRegistrados.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(193, 447, 132, 20);
		frmRegistrados.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClave.setBounds(193, 488, 104, 14);
		frmRegistrados.getContentPane().add(lblClave);
		lblClave.setVisible(false);

		lblConfirmar = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmar.setBounds(365, 488, 145, 14);
		frmRegistrados.getContentPane().add(lblConfirmar);
		lblConfirmar.setVisible(false);

		txtClave = new JPasswordField();
		txtClave.setBounds(193, 513, 132, 20);
		frmRegistrados.getContentPane().add(txtClave);
		txtClave.setVisible(false);

		txtConfirmar = new JPasswordField();
		txtConfirmar.setBounds(365, 513, 159, 20);
		frmRegistrados.getContentPane().add(txtConfirmar);
		txtConfirmar.setVisible(false);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setVisible(false);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = txtUsuario.getText().toString();
				String clave = txtClave.getText().toString();
				String nombre = txtNombre.getText().toString();
				String apellido = txtApellido.getText().toString();
				String correo = txtCorreo.getText().toString();
				int numero =  (int) Long.parseLong(txtNumero.getText().toString());

				Registrados registrado = new Registrados();
				registrado.setUsuario(usuario);
				registrado.setClave(clave);
				registrado.setNombre(nombre);
				registrado.setApellido(apellido);
				registrado.setCorreo(correo);
				registrado.setNumero(numero);

				String pass = new String(txtClave.getPassword());
				String pass2 = new String(txtConfirmar.getPassword());

				if (pass.equals(pass2)) {
					Registrar gestionRegistrado = new Registrar();
					int ok = gestionRegistrado.registrar(registrado);
					System.out.println(ok);
					if (ok > 0) {
						JOptionPane.showMessageDialog(frmRegistrados, "Usuario Registrado");
						btnGuardar.setVisible(false);
						btnBuscar.setVisible(true);
						lblClave.setVisible(false);
						lblConfirmar.setVisible(false);
						txtClave.setVisible(false);
						txtConfirmar.setVisible(false);
						btnActualizar.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						btnNuevo.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						btnEliminar.setVisible(true);
						MySQLConexion con = new MySQLConexion();
						Connection conexion = con.getConexion();

						String sql = "SELECT * FROM resgistro";
						Statement st;
						String nombreColumnas[] = { "usuario", "nombre", "apellido", "correo", "numero" };
						
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("usuario");
						model.addColumn("nombre");
						model.addColumn("apellido");
						model.addColumn("correo");
						model.addColumn("numero");
						table.setModel(model);

						Object[] dato = new Object[5];
						try {
							st = conexion.createStatement();
							ResultSet result = st.executeQuery(sql);

							while (result.next()) {

								dato[0] = result.getString("usuario");
								dato[1] = result.getString("nombre");
								dato[2] = result.getString("apellido");
								dato[3] = result.getString("correo");
								dato[4] = result.getString("numero");
								model.addRow(dato);
							}

						} catch (Exception e3) {
							
						}
						txtUsuario.setText("");
						txtNombre.setText("");
						txtApellido.setText("");
						txtCorreo.setText("");
						txtNumero.setText("");
						txtClave.setText("");
						txtConfirmar.setText("");
					} else {
						JOptionPane.showMessageDialog(frmRegistrados, "No se Registro el usuario", "aviso",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "Las contraseñas no coinciden", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnGuardar.setBounds(577, 488, 104, 34);
		frmRegistrados.getContentPane().add(btnGuardar);
		
		btnEliminar1 = new JButton("Eliminar");
		btnEliminar1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar1.setForeground(Color.BLACK);
		btnEliminar1.setVisible(false);
		btnEliminar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				String usuario = txtUsuario.getText().toString();

				Actualizados actualizados = new Actualizados();
				actualizados.setUsuario(usuario);

				int ok = Eliminar.eliminar(actualizados);
				System.out.println(ok);
				txtUsuario.setText("");
				
				if (ok > 0) {

					MySQLConexion con1 = new MySQLConexion();
					@SuppressWarnings("static-access")
					Connection conexion = con1.getConexion();

					String sql = "SELECT * FROM resgistro";
					Statement st1;
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("usuario");
					model.addColumn("nombre");
					model.addColumn("apellido");
					model.addColumn("correo");
					model.addColumn("numero");
					table.setModel(model);

					Object[] dato = new Object[5];
					try {

						st1 = conexion.createStatement();
						ResultSet result = st1.executeQuery(sql);

						while (result.next()) {

							dato[0] = result.getString("usuario");
							dato[1] = result.getString("nombre");
							dato[2] = result.getString("apellido");
							dato[3] = result.getString("correo");
							dato[4] = result.getString("numero");
							model.addRow(dato);
						}
						lblBuscar2.setVisible(true);
						lblBuscar3.setVisible(true);
						lblBuscar4.setVisible(true);
						lblBuscar5.setVisible(true);
						txtApellido.setVisible(true);
						txtCorreo.setVisible(true);
						txtNumero.setVisible(true);
						txtNombre.setVisible(true);
						btnBuscar.setVisible(true);
						btnEliminar1.setVisible(false);
						btnActualizar.setVisible(true);
						btnNuevo.setVisible(true);
						btnCerrarSeccion.setVisible(true);
						

					} catch (Exception e2) {
						
					}
					JOptionPane.showMessageDialog(frmRegistrados, "Usuario Eliminado");

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "No se elimino el usuario", "aviso",
							JOptionPane.WARNING_MESSAGE);
				}
	

			}
				

				
			
		});
		btnEliminar1.setBounds(578, 488, 104, 34);
		frmRegistrados.getContentPane().add(btnEliminar1);
		
		btnActualizar1 = new JButton("Actualizar");
		btnActualizar1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar1.setForeground(Color.BLACK);
		btnActualizar1.setVisible(false);
		btnActualizar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				String usuario = txtUsuario.getText().toString();
				String nombre = txtNombre.getText().toString();
				String apellido = txtApellido.getText().toString();
				String correo = txtCorreo.getText().toString();
				int numero =  (int) Long.parseLong(txtNumero.getText().toString());

				Actualizados actualizados = new Actualizados();
				actualizados.setUsuario(usuario);
				actualizados.setNombre(nombre);
				actualizados.setApellido(apellido);
				actualizados.setCorreo(correo);
				actualizados.setNumero(numero);

				int ok = Actualizar.actualizar(actualizados);
				System.out.println(ok);
				btnNuevo.setVisible(true);
				btnCerrarSeccion.setVisible(true);
				btnEliminar.setVisible(true);
				btnActualizar1.setVisible(false);
				btnBuscar.setVisible(true);
				if (ok > 0) {

					MySQLConexion con1 = new MySQLConexion();
					@SuppressWarnings("static-access")
					Connection conexion = con1.getConexion();

					String sql = "SELECT * FROM resgistro";
					Statement st1;
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("usuario");
					model.addColumn("nombre");
					model.addColumn("apellido");
					model.addColumn("correo");
					model.addColumn("numero");
					table.setModel(model);

					Object[] dato = new Object[5];
					try {

						st1 = conexion.createStatement();
						ResultSet result = st1.executeQuery(sql);

						while (result.next()) {

							dato[0] = result.getString("usuario");
							dato[1] = result.getString("nombre");
							dato[2] = result.getString("apellido");
							dato[3] = result.getString("correo");
							dato[4] = result.getString("numero");
							model.addRow(dato);
						}

					} catch (Exception e2) {
						
					}
					JOptionPane.showMessageDialog(frmRegistrados, "Usuario Actualizado");

				} else {
					JOptionPane.showMessageDialog(frmRegistrados, "No se Actualizo el usuario", "aviso",
							JOptionPane.WARNING_MESSAGE);
				}
				txtUsuario.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtCorreo.setText("");
				txtNumero.setText("");

			}
			
		});
		btnActualizar1.setBounds(577, 488, 103, 34);
		frmRegistrados.getContentPane().add(btnActualizar1);

	}

}
