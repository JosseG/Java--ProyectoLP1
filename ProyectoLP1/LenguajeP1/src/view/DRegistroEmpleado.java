package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import modelDAO.ClienteDAO;
import modelDAO.CuentaDAO;
import modelDAO.EmpleadoDAO;
import modelDAO.LoginDAO;
import modelDAO.RolDAO;
import modelDTO.ClienteDTO;
import modelDTO.CuentaDTO;
import modelDTO.EmpleadoDTO;
import modelDTO.LoginDTO;
import modelDTO.RolDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

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
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasena;
	private JTextField txtContrasena;
	private JLabel lblDocIdentidad;
	
	private DefaultTableModel dtmTabla;
	String [] arreglos= {"ID","IDROL","DI","NOMBRE","APELLIDOS","TELEFONO","C0RREO"};
	
	JTableHeader header;
	private JScrollPane scrollPane;
	private JTable jtTabla;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JComboBox cboRol;
	private JLabel lblRol;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registro del empleado");
		setBounds(100, 100, 720, 530);
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
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblUsuario.setBounds(187, 186, 50, 16);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(new Color(206, 228, 190));
		txtUsuario.setBounds(335, 186, 170, 16);
		getContentPane().add(txtUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblContrasena.setBounds(187, 212, 74, 16);
		getContentPane().add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBackground(new Color(206, 228, 190));
		txtContrasena.setBounds(335, 212, 170, 16);
		getContentPane().add(txtContrasena);
		
		lblDocIdentidad = new JLabel("Doc. Identidad");
		lblDocIdentidad.setForeground(Color.WHITE);
		lblDocIdentidad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDocIdentidad.setBounds(187, 107, 94, 16);
		getContentPane().add(lblDocIdentidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 270, 626, 166);
		getContentPane().add(scrollPane);
		
		dtmTabla=new DefaultTableModel(null,arreglos);
		jtTabla = new JTable();
		jtTabla.setModel(dtmTabla);
		jtTabla.getTableHeader().setReorderingAllowed(false);
		jtTabla.getTableHeader().setResizingAllowed(false);
		jtTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		header=jtTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(200,160,30)));
		jtTabla.setTableHeader(header);
		scrollPane.setViewportView(jtTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(470, 466, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtBuscar = new JTextField();
		
		txtBuscar.setBounds(580, 467, 86, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblRol = new JLabel("Rol");
		lblRol.setForeground(Color.WHITE);
		lblRol.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblRol.setBounds(510, 31, 46, 14);
		getContentPane().add(lblRol);
		
		cboRol = new JComboBox(listarRoles());
		cboRol.setBounds(557, 23, 118, 22);
		cboRol.setBackground(new Color(206, 228, 190));
		getContentPane().add(cboRol);
		tamanoColumnas();
		activarBotones(true);
		listar();

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
		if(e.getSource()==btnanadir) {
			actionPerformedBtnAnadir(e);
		}
		
		if(e.getSource()==btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		
	}
	
	public void actionPerformedBtnBuscar(ActionEvent e) {
		
		activarBotones(false);
		System.out.println("se deshabilitaron");
		
	}
	
	public void actionPerformedBtnAnadir(ActionEvent e) {
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		CuentaDTO cuentadto=new CuentaDTO();
		CuentaDAO cuentadao=new CuentaDAO();
		try {
			
			
			empdto.setId(emp.generarCodigo());
			empdto.setIdRol(encontrarRol(cboRol.getSelectedItem().toString()));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
			
			cuentadto.setId(new CuentaDAO().generarCodigo());
			cuentadto.setUsername(txtUsuario.getText());
			cuentadto.setPassword(txtContrasena.getText());
			cuentadto.setIdEmp(empdto.getId());
			
			cuentadao.insertar(cuentadto);
			emp.insertar(empdto);
			
			System.out.println("Exitoso");
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Muestre nuevamente");
		}
		
		listar();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		
		try {
			
			
			//empdto.setId(txt.getText());
			empdto.setIdRol(encontrarRol(cboRol.getSelectedItem().toString()));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
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
	
	
	private void tamanoColumnas() {
		
		int [] tamanio= {20,20,80,80,80,80,80};
		
		for(int i=0;i<tamanio.length;i++) {
			jtTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jtTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
		
	}
	
	void listar() {
		dtmTabla.setRowCount(0);
		
		EmpleadoDAO empdao=new EmpleadoDAO();
		List<EmpleadoDTO> habit=empdao.listar();
		for(EmpleadoDTO a:habit) {
			Object[] o = a.toString().split(";");
			dtmTabla.addRow(o);
		}
	}
	
	public String encontrarRol(String a) {
		
		String idRol="";
		
		RolDAO rdao=new RolDAO();
		
		List<RolDTO> listR=rdao.listar();
		
		for(RolDTO c:listR) {
			if(a.equals(c.getNombre())) {
				idRol=c.getId();
			}
		}
		return idRol;
	}
	
	public void activarBotones(boolean a) {
		btnanadir.setEnabled(a);
		btnConsultar.setEnabled(a);
		btnBuscar.setEnabled(a);
	}
	
	
	public Object[] listarRoles() {
		
		
		RolDAO rdao=new RolDAO();
		
		List<RolDTO> listR=rdao.listar();
		String[] o=new String[listR.size()];
		for(int i=0;i<o.length;i++) {
			
			 o[i]= listR.get(i).getNombre();
		}
		return o; 
		
	}
	
	
	
}
