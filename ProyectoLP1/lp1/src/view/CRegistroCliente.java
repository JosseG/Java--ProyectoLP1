package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class CRegistroCliente extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnanadir;
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
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRegistroCliente frame = new CRegistroCliente();
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
	public CRegistroCliente() {
		setTitle("Registro del Cliente");
		setClosable(true);
		setBackground(new Color(128, 128, 128));
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(206, 228, 190));
		textField.setBounds(178, 68, 340, 16);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(206, 228, 190));
		textField_1.setBounds(178, 93, 340, 16);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(206, 228, 190));
		textField_2.setBounds(178, 119, 170, 16);
		getContentPane().add(textField_2);
		
		btnanadir = new JButton("A\u00F1adir");
		btnanadir.setForeground(Color.WHITE);
		btnanadir.setBackground(new Color(130, 73, 229));
		btnanadir.setBounds(577, 66, 89, 23);
		getContentPane().add(btnanadir);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setBounds(30, 67, 58, 16);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(30, 93, 60, 16);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDni.setBounds(30, 119, 23, 16);
		getContentPane().add(lblDni);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(577, 119, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(577, 172, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(577, 225, 89, 23);
		getContentPane().add(btnEliminar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(28, 300, 650, 109);
		getContentPane().add(txts);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(30, 145, 46, 16);
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(30, 171, 118, 16);
		getContentPane().add(lblCorreo);
		
		lblCiudadDondeReside = new JLabel("Ciudad donde reside");
		lblCiudadDondeReside.setForeground(Color.WHITE);
		lblCiudadDondeReside.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCiudadDondeReside.setBounds(30, 197, 133, 16);
		getContentPane().add(lblCiudadDondeReside);
		
		lblIdDeCliente = new JLabel("ID de cliente");
		lblIdDeCliente.setForeground(Color.WHITE);
		lblIdDeCliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdDeCliente.setBounds(30, 223, 82, 16);
		getContentPane().add(lblIdDeCliente);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(206, 228, 190));
		textField_3.setBounds(178, 145, 170, 16);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(206, 228, 190));
		textField_4.setBounds(178, 171, 340, 16);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(206, 228, 190));
		textField_5.setBounds(178, 197, 340, 16);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(206, 228, 190));
		textField_6.setBounds(178, 223, 170, 16);
		getContentPane().add(textField_6);

	}
}
