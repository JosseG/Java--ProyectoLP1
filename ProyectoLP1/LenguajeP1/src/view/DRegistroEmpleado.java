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

import modelDAO.BoletaDAO;
import modelDAO.ClienteDAO;
import modelDAO.CuentaDAO;
import modelDAO.EmpleadoDAO;
import modelDAO.LoginDAO;
import modelDAO.RolDAO;

import modelDTO.CuentaDTO;
import modelDTO.EmpleadoDTO;

import modelDTO.RolDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class DRegistroEmpleado extends JInternalFrame implements ActionListener,MouseListener {
	private JButton btnanadir;
	private JButton btnModificar;
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
	private JButton btnCancelar;

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
		btnanadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnanadir.addActionListener(this);
		getContentPane().add(btnanadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(39, 125, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(39, 168, 89, 23);
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
		jtTabla.addMouseListener(this);
		jtTabla.getTableHeader().setReorderingAllowed(false);
		jtTabla.getTableHeader().setResizingAllowed(false);
		jtTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		header=jtTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(200,160,30)));
		jtTabla.setTableHeader(header);
		scrollPane.setViewportView(jtTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(339, 466, 89, 23);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnCancelar);
		tamanoColumnas();
		limpiar();
		listar();
		setEnabledBtn(false);

	}

	
	public void actionPerformed(ActionEvent e) {
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
		
		if(e.getSource()==btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		
	}
	
	public void actionPerformedBtnBuscar(ActionEvent e) {
		
		
		System.out.println("se deshabilitaron");
		
	}
	
	public void actionPerformedBtnAnadir(ActionEvent e) {
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		CuentaDTO cuentadto=new CuentaDTO();
		CuentaDAO cuentadao=new CuentaDAO();
		try {
			
			
			empdto.setId(emp.generarCodigo());
			empdto.setIdRol(encontrarIdRol(cboRol.getSelectedItem().toString()));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
			
			cuentadto.setId(cuentadao.generarCodigo());
			cuentadto.setUsername(txtUsuario.getText());
			cuentadto.setPassword(txtContrasena.getText());
			cuentadto.setIdEmp(empdto.getId());
			
			emp.insertar(empdto);
			cuentadao.insertar(cuentadto);
			
			
			System.out.println("Exitoso");
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Muestre nuevamente");
		}
		
		listar();
		limpiar();
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		EmpleadoDAO emp=new EmpleadoDAO();
		EmpleadoDTO empdto=new EmpleadoDTO();
		CuentaDTO cuentadto=new CuentaDTO();
		CuentaDAO cuentadao=new CuentaDAO();
		
		
		try {
			System.out.println(jtTabla.getSelectedRow());
			empdto.setId(dtmTabla.getValueAt(jtTabla.getSelectedRow(),0).toString());
			empdto.setIdRol(encontrarIdRol(cboRol.getSelectedItem().toString()));
			empdto.setDi(txtDocIdentidad.getText());
			empdto.setNombre(txtNombres.getText());
			empdto.setApellidos(txtApellidos.getText());
			empdto.setCorreo(txtCorreoElectronico.getText());
			empdto.setTelefono(txtCelular.getText());
			emp.actualizar(empdto);
			
			cuentadto.setId(obtenerIdCuenta(dtmTabla.getValueAt(jtTabla.getSelectedRow(),0).toString()));
			cuentadto.setIdEmp(empdto.getId());
			cuentadto.setUsername(txtUsuario.getText());
			cuentadto.setPassword(txtContrasena.getText());
			cuentadao.actualizar(cuentadto);
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Muestre nuevamente");
		}
		listar();
		limpiar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int row = jtTabla.getSelectedRow();
		int rpta=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?");
		if(rpta==JOptionPane.OK_OPTION) {
			LoginDAO logindao=new LoginDAO();
			CuentaDAO cuentadao=new CuentaDAO();
			EmpleadoDAO cldao=new EmpleadoDAO();
			BoletaDAO boletadao=new BoletaDAO();
			logindao.eliminarPorCuenta(obtenerIdCuenta(dtmTabla.getValueAt(jtTabla.getSelectedRow(),0).toString()));
			cuentadao.eliminar(obtenerIdCuenta(dtmTabla.getValueAt(jtTabla.getSelectedRow(),0).toString()));
			boletadao.eliminarPorEmp(dtmTabla.getValueAt(row, 0).toString());
			cldao.eliminar(dtmTabla.getValueAt(row, 0).toString());
			JOptionPane.showMessageDialog(null, "Correcto");
		}else {
			JOptionPane.showMessageDialog(null, "No elimino");
		}
		limpiar();
		listar();
		
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setEnabledBtn(false);
		limpiar();
		jtTabla.getSelectedRow();
		jtTabla.setRowSelectionAllowed(false);
		listar();
	}
	
	
	private void tamanoColumnas() {
		
		int [] tamanio= {20,20,80,80,80,80,80};
		
		for(int i=0;i<tamanio.length;i++) {
			jtTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jtTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
		
	}
	
	String obtenerIdCuenta(String a) {
		String idCuenta="";
		
		CuentaDAO rdao=new CuentaDAO();
		
		List<CuentaDTO> listR=rdao.listar();
		
		for(CuentaDTO c:listR) {
			if(a.equals(c.getIdEmp())) {
				idCuenta=c.getId();
			}
		}
		return idCuenta;
	}
	
	void limpiar() {
		txtApellidos.setText("");
		txtNombres.setText("");
		txtCelular.setText("");
		txtCorreoElectronico.setText("");
		txtDocIdentidad.setText("");
		txtUsuario.setText("");
		txtContrasena.setText("");
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
	
	public String encontrarIdRol(String a) {
		
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
	
	public String encontrarItemRol(String a) {
		
		String itRol="";
		
		RolDAO rdao=new RolDAO();
		
		List<RolDTO> listR=rdao.listar();
		
		for(RolDTO c:listR) {
			if(a.equals(c.getId())) {
				itRol=c.getNombre();
			}
		}
		return itRol;
	}
	
	private void setEnabledBtn(boolean a) {
		btnEliminar.setEnabled(a);
		btnModificar.setEnabled(a);
		btnanadir.setEnabled(!a);
		btnCancelar.setVisible(a);
		
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
	
	public void mousePressed(MouseEvent e) {
		
		// TODO Auto-generated method stub
		int row = jtTabla.rowAtPoint(e.getPoint());
		cboRol.setSelectedItem(encontrarItemRol(dtmTabla.getValueAt(row, 1).toString()));
		txtNombres.setText(dtmTabla.getValueAt(row, 3).toString());
		txtApellidos.setText(dtmTabla.getValueAt(row, 4).toString());
		txtDocIdentidad.setText(dtmTabla.getValueAt(row, 2).toString());
		txtCelular.setText(dtmTabla.getValueAt(row, 5).toString());
		txtCorreoElectronico.setText(dtmTabla.getValueAt(row, 6).toString());
		
		txtUsuario.setText(devolverCuenta(dtmTabla.getValueAt(row, 0).toString())[0]);
		txtContrasena.setText(devolverCuenta(dtmTabla.getValueAt(row, 0).toString())[1]);
		
		setEnabledBtn(true);
		jtTabla.setRowSelectionAllowed(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	String[] devolverCuenta(String codigo) {
		
		String [] b=new String[2];
		CuentaDAO a =new CuentaDAO();
		List<CuentaDTO> cuenta=a.listar();
		
		for(int i=0;i<cuenta.size();i++) {
			if(cuenta.get(i).getIdEmp().equals(codigo)) {
				b[0]=cuenta.get(i).getUsername();
				b[1]=cuenta.get(i).getPassword();
				return b;
			}
		}
		
		return null;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
