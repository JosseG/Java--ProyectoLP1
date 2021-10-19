package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DRegistroEmpleado extends JInternalFrame {
	private JButton btnanadir;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblCodigoDeEmpleado;
	private JTextField textField_5;
	private JLabel lblUsuario;
	private JTextField textField_6;
	private JLabel lblContrasea;
	private JTextField textField_7;
	private JTextPane txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DRegistroEmpleado frame = new DRegistroEmpleado();
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
	public DRegistroEmpleado() {
		setClosable(true);
		setTitle("Registro del empleado");
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		btnanadir = new JButton("A\u00F1adir");
		btnanadir.setForeground(Color.WHITE);
		btnanadir.setBackground(new Color(130, 73, 229));
		btnanadir.setBounds(39, 81, 89, 23);
		getContentPane().add(btnanadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(39, 125, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(39, 171, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(39, 219, 89, 23);
		getContentPane().add(btnEliminar);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setBounds(187, 55, 58, 16);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(187, 81, 60, 16);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDni.setBounds(187, 107, 23, 16);
		getContentPane().add(lblDni);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(187, 133, 46, 16);
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(187, 159, 118, 16);
		getContentPane().add(lblCorreo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(206, 228, 190));
		textField.setBounds(335, 159, 340, 16);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(206, 228, 190));
		textField_1.setBounds(335, 133, 170, 16);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(206, 228, 190));
		textField_2.setBounds(335, 107, 170, 16);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(206, 228, 190));
		textField_3.setBounds(335, 81, 340, 16);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(206, 228, 190));
		textField_4.setBounds(335, 56, 340, 16);
		getContentPane().add(textField_4);
		
		lblCodigoDeEmpleado = new JLabel("Codigo de empleado");
		lblCodigoDeEmpleado.setForeground(Color.WHITE);
		lblCodigoDeEmpleado.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCodigoDeEmpleado.setBounds(187, 185, 133, 16);
		getContentPane().add(lblCodigoDeEmpleado);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(206, 228, 190));
		textField_5.setBounds(335, 185, 170, 16);
		getContentPane().add(textField_5);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblUsuario.setBounds(187, 211, 50, 16);
		getContentPane().add(lblUsuario);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(206, 228, 190));
		textField_6.setBounds(335, 211, 170, 16);
		getContentPane().add(textField_6);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblContrasea.setBounds(187, 237, 74, 16);
		getContentPane().add(lblContrasea);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(206, 228, 190));
		textField_7.setBounds(335, 237, 170, 16);
		getContentPane().add(textField_7);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(25, 314, 650, 109);
		getContentPane().add(txts);

	}
}
