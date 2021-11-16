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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CRegistroCliente extends JInternalFrame implements ActionListener {
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocIdentidad;
	private JButton btnanadir;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDocIdentidad;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JTextPane txts;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JLabel lblIdDireccion;
	private JLabel lblIdDeCliente;
	private JTextField txtCelular;
	private JTextField txtCorreoElectronico;
	private JTextField txtIdDireccion;
	private JTextField txtIdCliente;
	private JLabel lblDireccion;
	private JLabel lblPais;
	private JTextField txtDireccion;
	private JTextField txtPais;

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
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBackground(new Color(206, 228, 190));
		txtNombres.setBounds(177, 51, 340, 16);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(new Color(206, 228, 190));
		txtApellidos.setBounds(177, 76, 340, 16);
		getContentPane().add(txtApellidos);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		txtDocIdentidad.setBackground(new Color(206, 228, 190));
		txtDocIdentidad.setBounds(177, 102, 170, 16);
		getContentPane().add(txtDocIdentidad);
		
		btnanadir = new JButton("A\u00F1adir");
		btnanadir.addActionListener(this);
		btnanadir.setForeground(Color.WHITE);
		btnanadir.setBackground(new Color(130, 73, 229));
		btnanadir.setBounds(576, 49, 89, 23);
		getContentPane().add(btnanadir);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setBounds(29, 50, 58, 16);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(29, 76, 60, 16);
		getContentPane().add(lblApellidos);
		
		lblDocIdentidad = new JLabel("Doc. Identidad");
		lblDocIdentidad.setForeground(Color.WHITE);
		lblDocIdentidad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDocIdentidad.setBounds(29, 102, 94, 16);
		getContentPane().add(lblDocIdentidad);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(576, 102, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(576, 155, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(576, 208, 89, 23);
		getContentPane().add(btnEliminar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(29, 311, 650, 109);
		getContentPane().add(txts);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(29, 128, 46, 16);
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(29, 154, 118, 16);
		getContentPane().add(lblCorreo);
		
		lblIdDireccion = new JLabel("ID direcci\u00F3n");
		lblIdDireccion.setForeground(Color.WHITE);
		lblIdDireccion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdDireccion.setBounds(29, 180, 133, 16);
		getContentPane().add(lblIdDireccion);
		
		lblIdDeCliente = new JLabel("ID de cliente");
		lblIdDeCliente.setForeground(Color.WHITE);
		lblIdDeCliente.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdDeCliente.setBounds(29, 206, 82, 16);
		getContentPane().add(lblIdDeCliente);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBackground(new Color(206, 228, 190));
		txtCelular.setBounds(177, 128, 170, 16);
		getContentPane().add(txtCelular);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBackground(new Color(206, 228, 190));
		txtCorreoElectronico.setBounds(177, 154, 340, 16);
		getContentPane().add(txtCorreoElectronico);
		
		txtIdDireccion = new JTextField();
		txtIdDireccion.setColumns(10);
		txtIdDireccion.setBackground(new Color(206, 228, 190));
		txtIdDireccion.setBounds(177, 180, 340, 16);
		getContentPane().add(txtIdDireccion);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBackground(new Color(206, 228, 190));
		txtIdCliente.setBounds(177, 206, 170, 16);
		getContentPane().add(txtIdCliente);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(29, 232, 61, 16);
		getContentPane().add(lblDireccion);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblPais.setForeground(Color.WHITE);
		lblPais.setBounds(27, 255, 28, 16);
		getContentPane().add(lblPais);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(new Color(206, 228, 190));
		txtDireccion.setBounds(177, 229, 170, 16);
		getContentPane().add(txtDireccion);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBackground(new Color(206, 228, 190));
		txtPais.setBounds(177, 252, 170, 16);
		getContentPane().add(txtPais);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnanadir) {
			actionPerformedBtnanadir(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnanadir(ActionEvent e) {
	}
}
