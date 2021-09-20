package lp1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class RegistroCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JTextPane txts;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JLabel lblCiudadDondeReside;
	private JLabel lblIdDeCliente;
	private JTextField txtCelular;
	private JTextField txtCorreo;
	private JTextField txrCiudadDondeReside;
	private JTextField txtIdDeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente frame = new RegistroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroCliente() {
		setBackground(new Color(128, 128, 128));
		setTitle("Registro del cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 491);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color( 32, 18, 58 ));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombres = new JTextField();
		txtNombres.setBackground(new Color(206, 228, 190));
		txtNombres.setColumns(10);
		txtNombres.setBounds(178, 64, 340, 16);
		contentPane.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setBackground(new Color(206, 228, 190));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(178, 89, 340, 16);
		contentPane.add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setBackground(new Color(206, 228, 190));
		txtDni.setColumns(10);
		txtDni.setBounds(178, 115, 170, 16);
		contentPane.add(txtDni);
		
		JButton btnanadir = new JButton("A\u00F1adir");
		btnanadir.setForeground(new Color(255, 255, 255));
		btnanadir.setBackground(new Color(130, 73, 229));
		btnanadir.setBounds(577, 62, 89, 23);
		contentPane.add(btnanadir);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setForeground(new Color(255, 255, 255));
		lblNombres.setBounds(30, 63, 58, 16);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(30, 89, 60, 16);
		contentPane.add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDni.setBounds(30, 115, 23, 16);
		contentPane.add(lblDni);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(577, 115, 89, 23);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(577, 168, 89, 23);
		contentPane.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(577, 221, 89, 23);
		contentPane.add(btnEliminar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(28, 296, 650, 109);
		contentPane.add(txts);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(30, 141, 46, 16);
		contentPane.add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(30, 167, 118, 16);
		contentPane.add(lblCorreo);
		
		lblCiudadDondeReside = new JLabel("Ciudad donde reside");
		lblCiudadDondeReside.setForeground(Color.WHITE);
		lblCiudadDondeReside.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCiudadDondeReside.setBounds(30, 193, 133, 16);
		contentPane.add(lblCiudadDondeReside);
		
		lblIdDeCliente = new JLabel("ID de cliente");
		lblIdDeCliente.setForeground(Color.WHITE);
		lblIdDeCliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdDeCliente.setBounds(30, 219, 82, 16);
		contentPane.add(lblIdDeCliente);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBackground(new Color(206, 228, 190));
		txtCelular.setBounds(178, 141, 170, 16);
		contentPane.add(txtCelular);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBackground(new Color(206, 228, 190));
		txtCorreo.setBounds(178, 167, 340, 16);
		contentPane.add(txtCorreo);
		
		txrCiudadDondeReside = new JTextField();
		txrCiudadDondeReside.setColumns(10);
		txrCiudadDondeReside.setBackground(new Color(206, 228, 190));
		txrCiudadDondeReside.setBounds(178, 193, 340, 16);
		contentPane.add(txrCiudadDondeReside);
		
		txtIdDeCliente = new JTextField();
		txtIdDeCliente.setColumns(10);
		txtIdDeCliente.setBackground(new Color(206, 228, 190));
		txtIdDeCliente.setBounds(178, 219, 170, 16);
		contentPane.add(txtIdDeCliente);
	}
}
