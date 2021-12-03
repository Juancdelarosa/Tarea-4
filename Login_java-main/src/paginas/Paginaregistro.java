package paginas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fasesusuarios.Registrados;
import funciones.Registrar;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Paginaregistro {

	JFrame frmRegistro;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JPasswordField txtClave;
	private JTextField txtNumero;
	private JTextField txtCorreo;
	private JPasswordField txtConfirmar;
	private JLabel lblValidacion;
	private JLabel lblValidacion1;
	private JLabel lblValidacion2;
	private JLabel lblValidacion3;
	private JLabel lblValidacion4;
	private JLabel lblValidacion5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paginaregistro window = new Paginaregistro();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Paginaregistro() {
		initialize();
	}

	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.getContentPane().setBackground(new Color(218, 165, 32));
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 609, 597);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese sus Datos.");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 351, 41);
		frmRegistro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(55, 140, 74, 14);
		frmRegistro.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(55, 196, 74, 14);
		frmRegistro.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombre de Usuario:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(55, 83, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(55, 364, 91, 14);
		frmRegistro.getContentPane().add(lblNewLabel_4);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(177, 81, 185, 20);
		frmRegistro.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 138, 242, 20);
		frmRegistro.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(120, 194, 242, 20);
		frmRegistro.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar!!");
		btnRegistrar.setForeground(Color.DARK_GRAY);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
				registrarUsuarios();

			}

		});
		btnRegistrar.setBounds(192, 493, 208, 35);
		frmRegistro.getContentPane().add(btnRegistrar);

		txtClave = new JPasswordField();
		txtClave.setBounds(140, 362, 222, 20);
		frmRegistro.getContentPane().add(txtClave);

		JLabel lblNewLabel_5 = new JLabel("N\u00FAmero de Tel\u00E9fono:");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(55, 252, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Correo Electronico:");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(55, 308, 144, 14);
		frmRegistro.getContentPane().add(lblNewLabel_6);

		txtNumero = new JTextField();
		txtNumero.setBounds(191, 250, 171, 20);
		frmRegistro.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(177, 306, 185, 20);
		frmRegistro.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("<html>Confirmar Contrase\u00F1a: </html>");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(55, 420, 102, 27);
		frmRegistro.getContentPane().add(lblNewLabel_7);

		txtConfirmar = new JPasswordField();
		txtConfirmar.setBounds(140, 427, 222, 20);
		frmRegistro.getContentPane().add(txtConfirmar);

		lblValidacion = new JLabel("Campo Obligatorio");
		lblValidacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion.setForeground(new Color(128, 0, 0));
		lblValidacion.setLabelFor(txtUsuario);
		lblValidacion.setBounds(411, 84, 112, 14);
		frmRegistro.getContentPane().add(lblValidacion);
		lblValidacion.setVisible(false);

		lblValidacion1 = new JLabel("Campo Obligatorio");
		lblValidacion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion1.setForeground(new Color(128, 0, 0));
		lblValidacion1.setBounds(411, 141, 172, 17);
		frmRegistro.getContentPane().add(lblValidacion1);
		lblValidacion1.setVisible(false);

		lblValidacion2 = new JLabel("Campo Obligatorio");
		lblValidacion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion2.setForeground(new Color(128, 0, 0));
		lblValidacion2.setBounds(411, 197, 107, 20);
		frmRegistro.getContentPane().add(lblValidacion2);
		lblValidacion2.setVisible(false);

		lblValidacion3 = new JLabel("Campo Obligatorio");
		lblValidacion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion3.setForeground(new Color(128, 0, 0));
		lblValidacion3.setBounds(411, 253, 112, 17);
		frmRegistro.getContentPane().add(lblValidacion3);
		lblValidacion3.setVisible(false);

		lblValidacion4 = new JLabel("Campo Obligatorio");
		lblValidacion4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion4.setForeground(new Color(128, 0, 0));
		lblValidacion4.setBounds(411, 308, 112, 18);
		frmRegistro.getContentPane().add(lblValidacion4);
		lblValidacion4.setVisible(false);

		lblValidacion5 = new JLabel("Campo Obligatorio");
		lblValidacion5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidacion5.setForeground(new Color(128, 0, 0));
		lblValidacion5.setBounds(411, 365, 112, 17);
		frmRegistro.getContentPane().add(lblValidacion5);
		lblValidacion5.setVisible(false);
	}

	@SuppressWarnings({ "deprecation", "unlikely-arg-type" }) void registrarUsuarios() {
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
				JOptionPane.showMessageDialog(frmRegistro, "Usuario Registrado Exitosamente.");
				frmRegistro.dispose();
				Paginalogin window = new Paginalogin();
				window.frmLogin.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(frmRegistro, "No se ha podido Registrar el Usuario", "Aviso", JOptionPane.WARNING_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(frmRegistro, "Las Contraseñas no Coinciden", "Error", JOptionPane.ERROR_MESSAGE);
		}


	}

	@SuppressWarnings({ "deprecation" })
	private void validar() {
		if (txtUsuario.getText().equals("")) {
			lblValidacion.setVisible(true);

		} else {
			lblValidacion.setVisible(false);
		}
		if (txtNombre.getText().equals("")) {
			lblValidacion1.setVisible(true);

		} else {
			lblValidacion1.setVisible(false);
		}
		if (txtApellido.getText().equals("")) {
			lblValidacion2.setVisible(true);

		} else {
			lblValidacion2.setVisible(false);
		}
		if (txtNumero.getText().equals("")) {
			lblValidacion3.setVisible(true);

		} else {
			lblValidacion3.setVisible(false);
		}
		if (txtCorreo.getText().equals("")) {
			lblValidacion4.setVisible(true);

		} else {
			lblValidacion4.setVisible(false);
		}
		if (txtClave.getText().equals("")) {
			lblValidacion5.setVisible(true);

		} else {
			lblValidacion5.setVisible(false);
		}

	}

}
