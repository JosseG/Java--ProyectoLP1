package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import modelDAO.EmpleadoDAO;
import modelDTO.EmpleadoDTO;
import modelDTO.LoginDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DRegistroEmpleado extends JInternalFrame implements ActionListener {
	private JButton btnanadir;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JTextField txtCorreoElectronico;
	private JTextField txtCelular;
	private JTextField txtDocIdentidad;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	private JLabel lblIdEmpleado;
	private JTextField txtIdEmpleado;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasena;
	private JTextField txtContrasena;
	private JTextPane txts;
	private JLabel lblDocIdentidad;

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
		btnanadir.addActionListener(this);
		getContentPane().add(btnanadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(39, 125, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(39, 171, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
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
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBackground(new Color(206, 228, 190));
		txtCorreoElectronico.setBounds(335, 159, 340, 16);
		getContentPane().add(txtCorreoElectronico);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBackground(new Color(206, 228, 190));
		txtCelular.setBounds(335, 133, 170, 16);
		getContentPane().add(txtCelular);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		txtDocIdentidad.setBackground(new Color(206, 228, 190));
		txtDocIdentidad.setBounds(335, 107, 170, 16);
		getContentPane().add(txtDocIdentidad);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(new Color(206, 228, 190));
		txtApellidos.setBounds(335, 81, 340, 16);
		getContentPane().add(txtApellidos);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBackground(new Color(206, 228, 190));
		txtNombres.setBounds(335, 56, 340, 16);
		getContentPane().add(txtNombres);
		
		lblIdEmpleado = new JLabel("ID empleado");
		lblIdEmpleado.setForeground(Color.WHITE);
		lblIdEmpleado.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdEmpleado.setBounds(187, 185, 133, 16);
		getContentPane().add(lblIdEmpleado);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setColumns(10);
		txtIdEmpleado.setBackground(new Color(206, 228, 190));
		txtIdEmpleado.setBounds(335, 185, 170, 16);
		txtIdEmpleado.setText(new EmpleadoDAO().generarCodigo());
		txtIdEmpleado.setEditable(false);
		getContentPane().add(txtIdEmpleado);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblUsuario.setBounds(187, 211, 50, 16);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(new Color(206, 228, 190));
		txtUsuario.setBounds(335, 211, 170, 16);
		getContentPane().add(txtUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblContrasena.setBounds(187, 237, 74, 16);
		getContentPane().add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBackground(new Color(206, 228, 190));
		txtContrasena.setBounds(335, 237, 170, 16);
		getContentPane().add(txtContrasena);
		
		txts = new JTextPane();
		txts.setContentType(TOOL_TIP_TEXT_KEY);
		txts.setBackground(new Color(239, 238, 208));
		
		txts.setBounds(25, 314, 650, 109);
		getContentPane().add(txts);
		
		lblDocIdentidad = new JLabel("Doc. Identidad");
		lblDocIdentidad.setForeground(Color.WHITE);
		lblDocIdentidad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDocIdentidad.setBounds(187, 107, 94, 16);
		getContentPane().add(lblDocIdentidad);

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if(e.getSource()==btnanadir)
			actionPerformedBtnAnadir(e);
		
	}
	
	public void actionPerformedBtnAnadir(ActionEvent e) {
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		LoginDTO login=new LoginDTO();
		try {
			
			
			empdto.setId(txtIdEmpleado.getText());
			empdto.setIdRol(JOptionPane.showInputDialog("Ingrese un dato"));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
			
			login.setUsername(txtUsuario.getText());
			login.setPassword(txtContrasena.getText());
			login.setIdEmp(empdto.getId());
			
			emp.insertar(empdto);
			
			System.out.println("Exitoso");
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Muestre nuevamente");
		}
		
		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		LoginDTO login=new LoginDTO();
		try {
			
			
			empdto.setId(txtIdEmpleado.getText());
			empdto.setIdRol(JOptionPane.showInputDialog("Ingrese un dato"));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
			
			login.setUsername(txtUsuario.getText());
			login.setPassword(txtContrasena.getText());
			login.setIdEmp(empdto.getId());
			
			emp.actualizar(empdto);
			
			System.out.println("Exitoso");
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Muestre nuevamente");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		
		
	}
}
