package paginas;
import java.awt.EventQueue;
import funciones.Login;
import fasesusuarios.Usuario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Paginalogin {

	JFrame frmLogin;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paginalogin window = new Paginalogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Paginalogin() {
		initialize();
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(218, 165, 32));
		frmLogin.setBackground(Color.ORANGE);
		frmLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frmLogin.setForeground(Color.BLACK);
		frmLogin.getContentPane().setForeground(Color.BLACK);
		frmLogin.setTitle("Tarea 4");
		frmLogin.setBounds(100, 100, 462, 403);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setBounds(0, 0, 434, 0);
		frmLogin.getContentPane().add(lblNewLabel);

		JLabel Titulo = new JLabel("Iniciar Sesion.");
		Titulo.setForeground(Color.BLACK);
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 34));
		Titulo.setBounds(26, 30, 279, 47);
		frmLogin.getContentPane().add(Titulo);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("");
		txtUsuario.setBounds(26, 113, 187, 22);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrar();
			}
		});
		btnNewButton.setBounds(247, 140, 187, 33);
		frmLogin.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registrarse!!");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();

			}
		});
		btnNewButton_1.setBounds(126, 302, 187, 33);
		frmLogin.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(26, 88, 136, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(26, 149, 100, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);

		txtClave = new JPasswordField();
		txtClave.setBounds(26, 174, 187, 20);
		frmLogin.getContentPane().add(txtClave);
		
		JLabel Subtitulo = new JLabel("Aún no te registras? Hazlo ahora!");
		Subtitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		Subtitulo.setHorizontalAlignment(SwingConstants.LEFT);
		Subtitulo.setBounds(76, 246, 293, 33);
		frmLogin.getContentPane().add(Subtitulo);
	}

	protected void registrar() {
		
		frmLogin.dispose();
		Paginaregistro window = new Paginaregistro();
		window.frmRegistro.setVisible(true);
		
	}


	protected void entrar() {
		
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtClave.getPassword());
		
		Login gestionUsuario = new Login();
		
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if(usu  != null) {
			JOptionPane.showMessageDialog(frmLogin, "Bienvenido!!");
			frmLogin.dispose();
			Usuariosregistrados window = new Usuariosregistrados();
			window.frmRegistrados.setVisible(true);
		}
		
			else {
				JOptionPane.showMessageDialog(frmLogin, "Es necesario ingresar sus credenciales para ingresar. Si no tiene una cuenta puede crearla pulsando el boton de abajo.", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		
	}
}
